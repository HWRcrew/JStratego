package jstratego.logic.game;

import jstratego.logic.pieces.*;

/**
 * Field is representing a Field on the Playboard. Pieces are referenced here.
 *
 * @author sebastiangrosse
 */
public class Field {

	public Piece piece;
	public boolean blocked;
	public int x;
	public int y;

	public Field(Piece piece, boolean blocked, int x, int y) {
		this.piece = piece;
		this.blocked = blocked;
		this.x = x;
		this.y = y;
	}

	/**
	 * set a Piece-Reference to the Field, if the Field already has a Piece
	 * fightAgainst is used.
	 *
	 * @param piece
	 */
	public void setPiece(Piece piece) {
		if (!this.blocked) {
			if (this.piece != null) {
				piece.fightAgainst(this.piece);
			} else {
				this.piece = piece;
			}
			if (piece.alive) {
				this.piece = piece;
			}
			if (!this.piece.alive && !piece.alive) {
				this.piece = null;
			}
		}
	}
	public Piece getPiece(){
		return this.piece;
	}
	//TODO Piece aus Liste des Spielers entfernen, wenn auf Feld platziert?
	//TODO Wie erhalte ich eine Piece aus der Liste des Spielers?
}