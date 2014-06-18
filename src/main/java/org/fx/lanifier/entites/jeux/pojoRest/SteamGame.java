package org.fx.lanifier.entites.jeux.pojoRest;

public class SteamGame {
	private String appid;
	private int playtime_forever; // on suppose que personne ne joue
									// plus de
									// 2^32 heures à un jeu

	private int playtime_2weeks;

	public SteamGame() {
	}

	public String getAppid() {
		return appid;
	}

	public void setAppid(String appid) {
		this.appid = appid;
	}

	public int getPlaytime_forever() {
		return playtime_forever;
	}

	public void setPlaytime_forever(int playtime_forever) {
		this.playtime_forever = playtime_forever;
	}

	public int getPlaytime_2weeks() {
		return playtime_2weeks;
	}

	public void setPlaytime_2weeks(int playtime_2weeks) {
		this.playtime_2weeks = playtime_2weeks;
	}

	public String toString() {
		return new StringBuilder(appid).append(String.valueOf(playtime_2weeks))
				.append(String.valueOf(playtime_forever)).toString();
	}
}
