/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pieces;

import java.util.ArrayList;

/**
 * Abstract baseclass for pieces of the Stratego boardgame
 *
 * @author sebastiangrosse
 */
public abstract class Piece {

	public static String name;
	public static String description;
	public static ArrayList<String> beatenby;
	public static Motion motion;
	public static String imgurl;
	public Color color;
	public boolean alive;
	public boolean covered;

	public Piece(Color color, boolean alive, boolean covered) {
		this.color = color;
		this.alive = alive;
		this.covered = covered;
	}

	/**
	 * Method to give back the Winner of a Conflict between two pieces
	 *
	 * @param attacker
	 * @return true if attacked Piece wins the fight
	 */
	public abstract boolean isWinner(Object attacker);

	/**
	 * Enumeration for Color-Attribute Choose between RED and BLUE
	 *
	 * @author sebastiangrosse
	 */
	enum Color {

		RED, BLUE;
	}

	/**
	 * Enumeration for Motion-Attribute Choose between MOVABLE,
	 * UNMOVABLE(Flags and Bombs) and SUPERMOVABLE(for the Scout)
	 *
	 * @author sebastiangrosse
	 */
	enum Motion {

		MOVABLE, UNMOVABLE, SUPERMOVABLE
	}
}