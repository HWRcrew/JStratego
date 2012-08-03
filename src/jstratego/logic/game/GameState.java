/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jstratego.logic.game;

import jstratego.logic.pieces.Piece;

/**
 * Alle Infos die die GUI braucht. alles was man benötigt um quasi in den
 * nächsten zustand zu kommen und alles was den Zustand beschreibt.
 *
 * @author sebastiangrosse
 */
//TODO versuchen zwischen Datenspeicherung und Datenverarbeitung zu trennen.
public class GameState {

	private Player playerWithMove;
	private Player otherPlayer;
	private Gamephase currentGamephase;
	private Gamephase lastGamephase;
	private Piece challenger;
	private Piece defender;
	private GameResult gameResult;
	private Field lastField;

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
	public Gamephase getCurrentGamephase() {
		return currentGamephase;
	}

	/**
	 * @param currentGamephase the currentGamephase to set
	 */
	public void setCurrentGamephase(Gamephase currentGamephase) {
		this.currentGamephase = currentGamephase;
	}

	/**
	 * @return the lastGamephase
	 */
	public Gamephase getLastGamephase() {
		return lastGamephase;
	}

	/**
	 * @param lastGamephase the lastGamephase to set
	 */
	public void setLastGamephase(Gamephase lastGamephase) {
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
	public GameResult getGameResult() {
		return gameResult;
	}

	/**
	 * @param gameResult the gameResult to set
	 */
	public void setGameResult(GameResult gameResult) {
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
