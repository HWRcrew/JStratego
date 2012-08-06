package jstratego.logic.game;

import jstratego.logic.pieces.Piece;

/**
 *
 * @author sebastiangrosse
 */
public interface PlayerInterface {

	/**
	 * gets a piece-object from a list.
	 *
	 * @param className
	 * @return
	 */
	public Piece getPiece(String className);

	/**
	 * get the number of a piece in a list.
	 *
	 * @param piece
	 * @return
	 */
	public int getLeftNumberOfPieceInList(Piece piece);
}
