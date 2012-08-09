package jstratego.logic.game;

import jstratego.logic.pieces.Piece;

/**
 *
 * @author sebastiangrosse
 */
public interface FieldInterface {

	/**
	 * returns the piece on a field.
	 *
	 * @return
	 */
	public Piece getPiece();

	/**
	 * setting a Piece to a Field
	 *
	 * @param piece the piece to set
	 */
	public void setPiece(Piece piece, GameState gameState);

	public boolean isBlocked();

	public void setBlocked(boolean blocked);

	/**
	 * @return the x
	 */
	public int getX();

	/**
	 * @param x the x to set
	 */
	public void setX(int x);

	/**
	 * @return the y
	 */
	public int getY();

	/**
	 * @param y the y to set
	 */
	public void setY(int y);
}
