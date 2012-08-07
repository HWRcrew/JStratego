/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jstratego.logic.game;

import jstratego.logic.pieces.Piece;

/**
 *
 * @author sebastiangrosse
 */
public interface GameStateInterface {

	/**
	 * @return the playerWithMove
	 */
	public Player getPlayerWithMove();

	/**
	 * @param playerWithMove the playerWithMove to set
	 */
	public void setPlayerWithMove(Player playerWithMove);

	/**
	 * @return the otherPlayer
	 */
	public Player getOtherPlayer();

	/**
	 * @param otherPlayer the otherPlayer to set
	 */
	public void setOtherPlayer(Player otherPlayer);

	/**
	 * @return the currentGamephase
	 */
	public GamephaseEnum getCurrentGamephase();

	/**
	 * @param currentGamephase the currentGamephase to set
	 */
	public void setCurrentGamephase(GamephaseEnum currentGamephase);

	/**
	 * @return the lastGamephase
	 */
	public GamephaseEnum getLastGamephase();

	/**
	 * @param lastGamephase the lastGamephase to set
	 */
	public void setLastGamephase(GamephaseEnum lastGamephase);

	/**
	 * @return the challenger
	 */
	public Piece getChallenger();

	/**
	 * @param challenger the challenger to set
	 */
	public void setChallenger(Piece challenger);

	/**
	 * @return the defender
	 */
	public Piece getDefender();

	/**
	 * @param defender the defender to set
	 */
	public void setDefender(Piece defender);

	/**
	 * @return the gameResult
	 */
	public GameResultEnum getGameResult();

	/**
	 * @param gameResult the gameResult to set
	 */
	public void setGameResult(GameResultEnum gameResult);

	/**
	 * @return the lastField
	 */
	public Field getLastField();

	/**
	 * @param lastField the lastMovedField to set
	 */
	public void setLastField(Field lastField);
}
