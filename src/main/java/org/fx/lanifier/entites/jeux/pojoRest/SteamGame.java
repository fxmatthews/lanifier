package org.fx.lanifier.entites.jeux.pojoRest;

public class SteamGame {
	private String appid;
	private int playtime_forever; // on suppose que personne ne joue
									// plus de
									// 2^32 heures à un jeu
	private int playtime_2weeks;
	private String name;
	private String img_icon_url;
	private String img_logo_url;
	private String has_community_visible_stats;

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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImg_icon_url() {
		return img_icon_url;
	}

	public void setImg_icon_url(String img_icon_url) {
		this.img_icon_url = img_icon_url;
	}

	public String getImg_logo_url() {
		return img_logo_url;
	}

	public void setImg_logo_url(String img_logo_url) {
		this.img_logo_url = img_logo_url;
	}

	public String getHas_community_visible_stats() {
		return has_community_visible_stats;
	}

	public void setHas_community_visible_stats(String has_community_visible_stats) {
		this.has_community_visible_stats = has_community_visible_stats;
	}

	public String toString() {
		return name;
	}
}
