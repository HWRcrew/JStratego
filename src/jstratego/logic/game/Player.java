package jstratego.logic.game;

import jstratego.logic.pieces.Color;
import jstratego.logic.pieces.Piece;

/**
 * Representation a Stratego-Player.
 * @author sebastiangrosse
 */
public class Player {

	public String name;
	public Color playerColor;
	Piece[] pieces = new Piece[40];
}