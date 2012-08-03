package jstratego.logic.pieces;

import java.util.ArrayList;
import jstratego.logic.game.GameState;

/**
 * Abstract baseclass for pieces of the Stratego boardgame
 *
 * @author sebastiangrosse
 */
public abstract class Piece {

	public static String name;
	public static String description;
	public ArrayList<String> beatenby;
	public Motion motion;
	public Color color;
	public boolean alive;
	public boolean covered;

	public Piece(Color color, boolean alive, boolean covered) {
		this.color = color;
		this.alive = alive;
		this.covered = covered;
	}

	/**
	 * Method to prove if a piece loses against another piece. This is only
	 * a one-way solution. it doesn't prove that the other piece will lose
	 * in the other direction
	 *
	 * @param challenger
	 * @return true if the piece wins the fight against the challenging the
	 * piece
	 */
	public boolean isBeatenBy(Piece challenger) {
		String c = challenger.getClass().getSimpleName().toString();
		return beatenby.contains(c);
	}

	/**
	 * Method to let pieces fight against each other and set the loser
	 * !alive
	 * @param defender
	 * @throws NullPointerException
	 */
	public void fightAgainst(Piece defender, GameState gameState) throws NullPointerException{
		if (this.getClass() == defender.getClass()) {
			this.alive = false;
			defender.alive = false;
		}
		if (defender.isBeatenBy(this)) {
			defender.alive = false;
		}
		if (!defender.isBeatenBy(this)) {
			this.alive = false;
		}
		gameState.setChallenger(this);
		gameState.setDefender(defender);
		//TODO Fighters to GameState
	}
}