package org.fx.lanifier.entites.jeux.pojoRest;


/**
 * 
 * @author fx
 *
 *         used for json parsing
 */

public class GetGamesQueryResponse {

	private GamesList response;

	public GamesList getResponse() {
		return response;
	}

	public void setResponse(GamesList response) {
		this.response = response;
	}

	public String toString() {
		return response.toString();
	}
}
