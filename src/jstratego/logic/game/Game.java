package jstratego.logic.game;

import jstratego.logic.pieces.Color;

/**
 * Game is representing a Game between two Players.
 *
 * @author sebastiangrosse
 */
public class Game {

	public Player playerWithMove;
	public Gamephase gamephase;

	public Game() {
		this.playerWithMove = new Player(null, Color.RED);
		this.gamephase = Gamephase.SETUPred;
	}
}