package org.fx.lanifier.steamapi;

import java.util.List;

public class SteamUser {
	
	private String id;
	private String pseudo;
	private List<String> jeux;
	
	public String getPseudo() {
		return pseudo;
	}
	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}
	public List<String> getJeux() {
		return jeux;
	}
	public void setJeux(List<String> jeux) {
		this.jeux = jeux;
	}

}
