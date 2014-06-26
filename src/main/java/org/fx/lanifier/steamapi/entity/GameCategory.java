package org.fx.lanifier.steamapi.entity;

public enum GameCategory {
	SP(1), 
	MP(2), 
	COOP(9), 
	LEVEL_EDITOR(17), 
	STEAM_SUCCESS(22), 
	STEAM_CLOUD(23), 
	COOP_LOC(24),
	STEAM_RANK(25), 
	MP_CP(27),  
	CONTROLLER_SUPPORT(28), 
	TRADING_CARD(29), 
	WORKSHOP(30);

	@SuppressWarnings("unused")
	private int id;

	private GameCategory(int id) {
		this.id = id;
	}
}
