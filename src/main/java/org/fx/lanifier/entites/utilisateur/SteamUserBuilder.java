package org.fx.lanifier.entites.utilisateur;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

/**
 * 
 * @author fx
 *
 *         in charge of recovering informations from the internet
 */
public class SteamUserBuilder {

	@Autowired
	private Environment env;

	public SteamUser build(String steamID) {

		SteamUser user = new SteamUser();
		return user;
	}

	private String buildUrl(String id) {
		StringBuilder sb = new StringBuilder(
				"http://api.steampowered.com/IPlayerService/GetOwnedGames/v0001/?key=");
		sb.append(env.getProperty("steamKey"));
		sb.append("&steamid=");
		sb.append(id);
		sb.append("&format=json");
		return sb.toString();
	}
}
