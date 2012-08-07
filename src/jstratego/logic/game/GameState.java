/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jstratego.logic.game;

import jstratego.logic.pieces.Piece;

/**
 * stores important status information for a game.
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
		currentGamephase = GamephaseEnum.SETUPred;
	}

	@Override
	public Player getPlayerWithMove() {
		return playerWithMove;
	}

	@Override
	public void setPlayerWithMove(Player playerWithMove) {
		this.playerWithMove = playerWithMove;
	}

	@Override
	public Player getOtherPlayer() {
		return otherPlayer;
	}

	@Override
	public void setOtherPlayer(Player otherPlayer) {
		this.otherPlayer = otherPlayer;
	}

	@Override
	public GamephaseEnum getCurrentGamephase() {
		return currentGamephase;
	}

	@Override
	public void setCurrentGamephase(GamephaseEnum currentGamephase) {
		this.currentGamephase = currentGamephase;
	}

	@Override
	public GamephaseEnum getLastGamephase() {
		return lastGamephase;
	}

	@Override
	public void setLastGamephase(GamephaseEnum lastGamephase) {
		this.lastGamephase = lastGamephase;
	}

	@Override
	public Piece getChallenger() {
		return challenger;
	}

	@Override
	public void setChallenger(Piece challenger) {
		this.challenger = challenger;
	}

	@Override
	public Piece getDefender() {
		return defender;
	}

	@Override
	public void setDefender(Piece defender) {
		this.defender = defender;
	}

	@Override
	public GameResultEnum getGameResult() {
		return gameResult;
	}

	@Override
	public void setGameResult(GameResultEnum gameResult) {
		this.gameResult = gameResult;
	}

	@Override
	public Field getLastField() {
		return lastField;
	}

	@Override
	public void setLastField(Field lastField) {
		this.lastField = lastField;
	}
}