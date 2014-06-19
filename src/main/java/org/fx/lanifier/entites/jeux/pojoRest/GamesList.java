package org.fx.lanifier.entites.jeux.pojoRest;

import java.util.ArrayList;
import java.util.List;

public class GamesList {
	private int game_count;
	private List<SteamGame> games;

	public GamesList() {
	} // empty constructor for jackson

	public int getGame_count() {
		return game_count;
	}

	public void setGame_count(int game_count) {
		this.game_count = game_count;
	}

	public List<SteamGame> getGames() {
		return games;
	}

	public void setGames(List<SteamGame> games) {
		this.games = games;
	}
	
	public List<String> getPrettyList(){
		List<String> result = new ArrayList<String>();
		for(SteamGame game : games)
			result.add(game.getName());
		return result;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder(String.valueOf(game_count));
		for (SteamGame game : games) {
			sb.append(game.toString());
			sb.append("\n");
		}
		return sb.toString();
	}

}
