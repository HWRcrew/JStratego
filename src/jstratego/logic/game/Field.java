package jstratego.logic.game;

import jstratego.logic.pieces.*;

/**
 * Field is representing a Field on the Playboard. Pieces are referenced here.
 *
 * @author sebastiangrosse
 */
public class Field implements FieldInterface{

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
	Exception FieldIsBlockedException = new Exception("This field is blocked!");

	/**
	 * setting a Piece to a Field
	 *
	 * @param piece
	 */
	public void setPiece(Piece piece, GameState gameState) throws Exception {
		if (!this.isBlocked()) {
			Player player = gameState.getPlayerWithMove();
			GamephaseEnum currentGamephase = gameState.getCurrentGamephase();
			if (this.piece == null) {
				this.piece = piece;
				player.getPieces().remove(piece);

			} else {
				if (this.piece.getColor().equals(player.getColor()) && (currentGamephase.equals(GamephaseEnum.SETUPblue) || currentGamephase.equals(GamephaseEnum.SETUPred))) {
					player.getPieces().add(this.piece);
					this.piece = piece;
					player.getPieces().remove(piece);
				}
				piece.fightAgainst(this.piece, gameState);
				if (piece.isAlive()) {
					this.piece = piece;
				}
				if (!this.piece.isAlive() && !piece.isAlive()) {
					this.piece = null;
				}
			}
			gameState.setLastField(this);
		} else {
			throw FieldIsBlockedException;
		}
	}

	public Piece getPiece() {
		return this.piece;
	}

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
