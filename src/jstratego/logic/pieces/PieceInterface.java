/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jstratego.logic.pieces;

import jstratego.logic.game.GameState;

/**
 * Inferface for all pieces and their methods.
 *
 * @author sebastiangrosse
 */
public interface PieceInterface {

	/**
	 * proofs if one piece is beaten by another one.
	 *
	 * @param challenger
	 * @return
	 */
	public boolean isBeatenBy(Piece challenger);

	/**
	 * lets two pieces fight against each other and is setting their alive-Value
	 * to false if they "die".
	 *
	 * @param defender
	 * @param gameState
	 * @throws NullPointerException
	 */
	public void fightAgainst(Piece defender, GameState gameState) throws NullPointerException;

	/**
	 * returns the german name of a piece.
	 *
	 * @return
	 */
	public String getNAME();

	/**
	 * returns the germen description of a piece.
	 *
	 * @return
	 */
	public String getDESCRIPTION();

	/**
	 * returns the movability of a piece.
	 *
	 * @return
	 */
	public Motion getMOTION();

	/**
	 * returns the color of a piece.
	 *
	 * @return
	 */
	public Color getColor();

	/**
	 * returns true if a piece is alive.
	 *
	 * @return
	 */
	public boolean isAlive();

	/**
	 * sets a piece alive(true) or dead(false).
	 *
	 * @param alive
	 */
	public void setAlive(boolean alive);

	/**
	 * sets a piece covered.
	 *
	 * @param covered
	 */
	public void setCovered(boolean covered);

	/**
	 * returns if a piece is covered.
	 *
	 * @return
	 */
	public boolean isCovered();

	/**
	 * adds the name of a piece to the list of Strings, the piece is beaten by.
	 *
	 * @param pieceName
	 */
	public void addToBeatenByPiece(String pieceName);
}
