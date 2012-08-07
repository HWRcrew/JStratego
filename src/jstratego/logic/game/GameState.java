/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jstratego.logic.game;

import jstratego.logic.pieces.Piece;

/**
 * stores important status information of a game.
 *
 * @author sebastiangrosse
 */
public class GameState implements GameStateInterface {

	private Player playerWithMove;
	private Player otherPlayer;
	private GamephaseEnum currentGamephase;
	private GamephaseEnum lastGamephase;
	private Piece challenger;
	private Piece defender;
	private GameResultEnum gameResult;
	private Field lastField;

	public GameState() {
		setCurrentGamephase(GamephaseEnum.SETUPred);
	}

	/**
	 * @return the playerWithMove
	 */
	public Player getPlayerWithMove() {
		return playerWithMove;
	}

	/**
	 * @param playerWithMove the playerWithMove to set
	 */
	public void setPlayerWithMove(Player playerWithMove) {
		this.playerWithMove = playerWithMove;
	}

	/**
	 * @return the otherPlayer
	 */
	public Player getOtherPlayer() {
		return otherPlayer;
	}

	/**
	 * @param otherPlayer the otherPlayer to set
	 */
	public void setOtherPlayer(Player otherPlayer) {
		this.otherPlayer = otherPlayer;
	}

	/**
	 * @return the currentGamephase
	 */
	public GamephaseEnum getCurrentGamephase() {
		return currentGamephase;
	}

	/**
	 * @param currentGamephase the currentGamephase to set
	 */
	public void setCurrentGamephase(GamephaseEnum currentGamephase) {
		this.currentGamephase = currentGamephase;
	}

	/**
	 * @return the lastGamephase
	 */
	public GamephaseEnum getLastGamephase() {
		return lastGamephase;
	}

	/**
	 * @param lastGamephase the lastGamephase to set
	 */
	public void setLastGamephase(GamephaseEnum lastGamephase) {
		this.lastGamephase = lastGamephase;
	}

	/**
	 * @return the challenger
	 */
	public Piece getChallenger() {
		return challenger;
	}

	/**
	 * @param challenger the challenger to set
	 */
	public void setChallenger(Piece challenger) {
		this.challenger = challenger;
	}

	/**
	 * @return the defender
	 */
	public Piece getDefender() {
		return defender;
	}

	/**
	 * @param defender the defender to set
	 */
	public void setDefender(Piece defender) {
		this.defender = defender;
	}

	/**
	 * @return the gameResult
	 */
	public GameResultEnum getGameResult() {
		return gameResult;
	}

	/**
	 * @param gameResult the gameResult to set
	 */
	public void setGameResult(GameResultEnum gameResult) {
		this.gameResult = gameResult;
	}

	/**
	 * @return the lastField
	 */
	public Field getLastField() {
		return lastField;
	}

	/**
	 * @param lastField the lastMovedField to set
	 */
	public void setLastField(Field lastField) {
		this.lastField = lastField;
	}
}
