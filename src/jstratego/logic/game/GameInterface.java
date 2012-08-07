/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jstratego.logic.game;

/**
 *
 * @author sebastiangrosse
 */
public interface GameInterface {

	/**
	 * end a gamephase and preparing everything for the next player.
	 *
	 * @throws Exception
	 */
	public void endPhase() throws Exception;
	
	
}
