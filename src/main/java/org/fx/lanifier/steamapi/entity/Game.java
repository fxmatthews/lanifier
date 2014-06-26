package org.fx.lanifier.steamapi.entity;

public class Game {

	private String id;
	private String gameName;
	private boolean singlePlayer = false;
	private boolean multi = false;
	private boolean multiCrossPF = false;
	private boolean coop = false;
	private boolean coopLocal = false;
	private boolean mapEditor = false;
	private boolean workshop = false;

	public String getGameName() {
		return gameName;
	}

	public void setGameName(String gameName) {
		this.gameName = gameName;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public boolean isSinglePlayer() {
		return singlePlayer;
	}

	public void singlePlayer(boolean onePlayer) {
		this.singlePlayer = onePlayer;
	}

	public boolean isMulti() {
		return multi;
	}

	public void multi(boolean multi) {
		this.multi = multi;
	}

	public boolean isMultiCrossPF() {
		return multiCrossPF;
	}

	public void multiCrossPF(boolean multiCrossPF) {
		this.multiCrossPF = multiCrossPF;
	}

	public boolean isCoop() {
		return coop;
	}

	public void coop(boolean coop) {
		this.coop = coop;
	}

	public boolean isCoopLocal() {
		return coopLocal;
	}

	public void coopLocal(boolean coopLocal) {
		this.coopLocal = coopLocal;
	}

	public boolean isMapEditor() {
		return mapEditor;
	}

	public void mapEditor(boolean mapEditor) {
		this.mapEditor = mapEditor;
	}

	public boolean isWorkshop() {
		return workshop;
	}

	public void workshop(boolean workshop) {
		this.workshop = workshop;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.gameName);
		sb.append("Solo : ");
		sb.append(singlePlayer);
		sb.append("Multi : ");
		sb.append(multi);
		sb.append("Multi CP: ");
		sb.append(multiCrossPF);
		sb.append("Coop: ");
		sb.append(coop);
		sb.append("Cool locale : ");
		sb.append(coopLocal);
		return sb.toString();
	}
}
