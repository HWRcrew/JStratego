/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jstratego.logic.game;

import java.util.ArrayList;

/**
 *
 * @author sebastiangrosse
 */
public interface PlayBoardInterface {

	/**
	 * returns if the playboard has only bombs or/and flags left.
	 *
	 * @return
	 */
	public boolean onlyBombsAndFlagsLeft();

	/**
	 * blocks the fields on the playboard, where the current player is not
	 * allowed to setup pieces.
	 */
	public void blockFieldsForSetup(Player player);

	/**
	 * unblocks the fields on the playboard, where the current player is not
	 * allowed to setup pieces.
	 *
	 * @param player
	 */
	public void unblockFieldsForSetup(Player player);

	/**
	 * covers the pieces on the playboard, that belong to the choosen player.
	 *
	 * @param player
	 * @throws NullPointerException
	 */
	public void coverPiecesForPlayer(Player player) throws NullPointerException;

	/**
	 * uncovers the pieces on the playboard, that belong to the choosen player.
	 *
	 * @param player
	 * @throws NullPointerException
	 */
	public void uncoverPiecesForPlayer(Player player) throws NullPointerException;

	/**
	 * returns a list of reachable fields from one field of a playboard.
	 *
	 * @param field
	 * @return
	 */
	public ArrayList<Field> listOfReachableFields(Field field, GamephaseEnum gamePhase);
	
	/**
	 * moves a piece from one field to another
	 * @param pieceField
	 * @param destinationField 
	 */
	public void movePiece(Field pieceField, Field destinationField, GameState gameState);
}
