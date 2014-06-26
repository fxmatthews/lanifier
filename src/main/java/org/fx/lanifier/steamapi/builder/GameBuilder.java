package org.fx.lanifier.steamapi.builder;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.fx.lanifier.steamapi.entity.Game;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class GameBuilder {

	public static Game build(String gameID) {
		Game game = new Game();
		try {
			String gameUrl = "http://store.steampowered.com/app/" + gameID;
			Document doc = Jsoup.connect(gameUrl).get();

			Elements features = doc
					.getElementsByClass("game_area_details_specs");
			for (Element feature : features) {
				String embeddedLink = feature.getElementsByClass("name").get(0)
						.getElementsByTag("a").attr("href"); // link embedded in
																// the class
																// found

				String[] splittedUrl = embeddedLink.split("=");
				int category = Integer.valueOf(splittedUrl[1]);
				switch (category) {
				case 1:
					game.singlePlayer(true);
					break;
				case 2:
					game.multi(true);
					break;
				case 9:
					game.coop(true);
					break;
				case 24:
					game.coopLocal(true);
					break;

				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(game.toString());
		return game;
	}
}
