package jstratego.logic.game;

import jstratego.logic.pieces.*;

/**
 * Field is representing a Field on the Playboard. Pieces are referenced here.
 *
 * @author sebastiangrosse
 */
public class Field {

	private Piece piece;
	private boolean blocked;
	private int x;
	private int y;

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
	public void setPiece(Piece piece, GameState gameState) {
		if (!this.isBlocked()) {
			if (this.piece != null) {
				piece.fightAgainst(this.piece, gameState);
			} else {
				this.piece = piece;
			}
			if (piece.alive) {
				this.piece = piece;
			}
			if (!this.piece.alive && !piece.alive) {
				this.piece = null;
			}
			gameState.setLastField(this);
		}
	}
	public Piece getPiece(){
		return this.piece;
	}
	
	//TODO Piece aus Liste des Spielers entfernen, wenn auf Feld platziert?
	//TODO Wie erhalte ich eine Piece aus der Liste des Spielers?

	/**
	 * @return the blocked
	 */
	public boolean isBlocked() {
		return blocked;
	}

	/**
	 * @param blocked the blocked to set
	 */
	public void setBlocked(boolean blocked) {
		this.blocked = blocked;
	}

	/**
	 * @return the x
	 */
	public int getX() {
		return x;
	}

	/**
	 * @param x the x to set
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * @return the y
	 */
	public int getY() {
		return y;
	}

	/**
	 * @param y the y to set
	 */
	public void setY(int y) {
		this.y = y;
	}
}
