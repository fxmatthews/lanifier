package org.fx.lanifier.entites.settings;

import org.springframework.stereotype.Component;

@Component
public class ManagementProperty {

	private String steamKey;

	public String getSteamKey() {
		return steamKey;
	}

	public void setSteamKey(String steamKey) {
		this.steamKey = steamKey;
	}
	
}
