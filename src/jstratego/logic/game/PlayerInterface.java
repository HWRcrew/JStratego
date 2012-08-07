package jstratego.logic.game;

import java.util.ArrayList;
import jstratego.logic.pieces.ColorEnum;
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

	/**
	 * adds a piece to a player.
	 *
	 * @param piece
	 */
	public void addPieceToPlayer(Piece piece);

	/**
	 * removes a piece from the player.
	 *
	 * @param piece
	 */
	public void removePieceFromPlayer(Piece piece);

	/**
	 * get the name of a player
	 *
	 * @return
	 */
	public String getName();

	/**
	 * get the color of a player.
	 *
	 * @return
	 */
	public ColorEnum getColor();

	/**
	 * get the list of pieces the player has left in his hand.
	 *
	 * @return
	 */
	public ArrayList<Piece> getPieces();

	/**
	 * returns if a player has no more pieces in its list.
	 *
	 * @return
	 */
	public boolean isListOfPiecesEmpty();
}
