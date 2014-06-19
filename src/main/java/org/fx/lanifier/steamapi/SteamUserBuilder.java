package org.fx.lanifier.steamapi;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.fx.lanifier.entites.jeux.pojoRest.GetGamesQueryResponse;
import org.fx.lanifier.entites.settings.ManagementProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 
 * @author fx
 *
 *         in charge of recovering informations from the internet
 */
@Component
public class SteamUserBuilder {

	@Autowired
	private ManagementProperty mp;

	public SteamUser build(String steamID) {
		SteamUser user = new SteamUser();

		// Json parsing

		ObjectMapper mapper = new ObjectMapper();
		try {
			GetGamesQueryResponse value = (GetGamesQueryResponse) mapper.readValue(new URL(
					buildGamesUrl(steamID)), GetGamesQueryResponse.class);
			user.setPseudo(value.toString());
			user.setJeux(value.getResponse().getPrettyList());
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}

	private String buildGamesUrl(String steamUserId) {
		StringBuilder sb = new StringBuilder(
				"http://api.steampowered.com/IPlayerService/GetOwnedGames/v0001/?key=");
		sb.append(mp.getSteamKey());
		sb.append("&steamid=");
		sb.append(steamUserId);
		sb.append("&format=json");
		sb.append("&include_appinfo=1");
		sb.append("&include_played_free_games=1");
		return sb.toString();
	}
}
