package jstratego.logic.game;

import jstratego.logic.pieces.Piece;

/**
 *
 * @author sebastiangrosse
 */
public interface PlayerInterface {

	/**
	 * gets the first piece-object from a list with the same classname.
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
