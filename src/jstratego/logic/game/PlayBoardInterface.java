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
	 * blocks the fields on the playboard, where the player is not allowed to
	 * set Pieces.
	 */
	public void blockFieldsForSetup(Player player);
	
	public void unblockFieldsForSetup(Player player);
	
	public void coverPiecesForPlayer(Player player) throws NullPointerException;
	
	public void uncoverPiecesForPlayer(Player player) throws NullPointerException;
	
	/**
	 * returns a list of reachable fields from one field of a playboard.
	 * @param field
	 * @return 
	 */
	public ArrayList<Field> listOfReachableFields(Field field);
}
