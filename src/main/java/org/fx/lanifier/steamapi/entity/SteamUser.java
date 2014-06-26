package org.fx.lanifier.steamapi.entity;

import org.fx.lanifier.entites.jeux.pojoRest.GamesList;

public class SteamUser {

	private String id;
	private String pseudo;
	private GamesList gamesList;

	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public GamesList getGamesList() {
		return gamesList;
	}

	public void setGamesList(GamesList gamesList) {
		this.gamesList = gamesList;
	}


}
