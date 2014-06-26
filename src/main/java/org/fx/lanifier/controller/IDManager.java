package org.fx.lanifier.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.fx.lanifier.entites.SteamIDList;
import org.fx.lanifier.entites.jeux.pojoRest.SteamGame;
import org.fx.lanifier.steamapi.builder.GameBuilder;
import org.fx.lanifier.steamapi.builder.SteamUserBuilder;
import org.fx.lanifier.steamapi.entity.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IDManager {

	@Autowired
	private SteamUserBuilder sUB;

	@RequestMapping(value = "manageID", method = RequestMethod.GET)
	public ModelAndView manageID(
			@ModelAttribute("steamIDList") SteamIDList idList) {
		return new ModelAndView("formulairesID");
	}

	// TODO : récupérer les infos des jeux
	@RequestMapping(value = "manageID", method = RequestMethod.POST)
	public ModelAndView displayID(
			@ModelAttribute("steamIDList") SteamIDList idList) {

		Map<String, String> sharedGames = getSharedGamesID(idList);

		// we get games info after, since we don't need to check every game

		List<String> maListe = new ArrayList<String>();
		System.out.println(String.valueOf(sharedGames.size()));
		for (Map.Entry<String, String> entrySet : sharedGames.entrySet()) {
			Game game = GameBuilder.build(entrySet.getKey());
			game.setGameName(entrySet.getValue());
			if (game.isCoop())
				maListe.add(entrySet.getValue());
		}

		ModelAndView mav = new ModelAndView("gamesList");
		mav.addObject("gamesList", maListe);
		return mav;
	}

	/**
	 * 
	 * @param idList
	 * 
	 * @return
	 */
	private Map<String, String> getSharedGamesID(SteamIDList idList) {
		// récupération des jeux de l'utilisateur
		List<String> ids = idList.getIds();
		Map<String, String> sharedGames = new HashMap<String, String>();
		int iterNumber = 0;
		for (String id : ids) {
			List<SteamGame> userGamesList = sUB.build(id).getGamesList()
					.getGames();
			Map<String, String> userGames = new HashMap<>();
			for (SteamGame ug : userGamesList)
				userGames.put(ug.getAppid(), ug.getName());

			if (iterNumber == 0) {
				sharedGames = userGames;
				iterNumber++;
			} else {
				Map<String, String> tmp = new HashMap<String, String>();
				for (Map.Entry<String, String> entrySet : sharedGames
						.entrySet()) {
					if (userGames.containsKey(entrySet.getKey()))
						tmp.put(entrySet.getKey(), entrySet.getValue());
				}
				sharedGames = tmp;
			}
		}

		return sharedGames;
	}
}
