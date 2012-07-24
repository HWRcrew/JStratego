package jstratego.logic.game;

import jstratego.logic.pieces.Piece;

/**
 * Field is representing a Field on the Playboard. Pieces are referenced here.
 *
 * @author sebastiangrosse
 */
public class Field {

	Piece piece;
	boolean blocked;

	public Field(Piece piece, boolean blocked) {
		this.piece = piece;
		this.blocked = blocked;
	}

	/**
	 * set a Piece-Reference to the Field, if the Field already has a Piece
	 * fightAgainst is used.
	 *
	 * @param piece
	 */
	public void setPiece(Piece piece) {
		if (this != null) {
			this.piece.fightAgainst(piece);
		}
		this.piece = piece;
	}
}
