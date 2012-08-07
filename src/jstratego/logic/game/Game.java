package jstratego.logic.game;

import jstratego.logic.pieces.ColorEnum;
import jstratego.logic.pieces.Piece;

/**
 * Game is representing a Game between two Players.
 *
 * @author sebastiangrosse
 */
public class Game implements GameInterface{

	public PlayBoard playBoard;
	public GameState gameState;
	//TODO offenbar kennt er gameState nicht...

	public Game(String namePlayerRed, String namePlayerBlue) {
		gameState = new GameState();
		playBoard = new PlayBoard();
		gameState.setPlayerWithMove(new Player(namePlayerRed, ColorEnum.RED));
		gameState.setOtherPlayer(new Player(namePlayerBlue, ColorEnum.BLUE));
		gameState.setCurrentGamephase(GamephaseEnum.SETUPred);
		playBoard.blockFieldsForSetup(gameState.getPlayerWithMove());
	}
	Exception NotAllPiecesSetException = new Exception("Some pieces are left to set!");

	/**
	 * finishing a gamephase and preparing everything for the next player.
	 *
	 * @throws Exception
	 */
	public void endPhase() throws Exception {
		Player plwm = this.gameState.getPlayerWithMove();
		switch (this.gameState.getCurrentGamephase()) {
			case CHANGE:
				switchPlayer();
				this.gameState.setChallenger(null);
				this.gameState.setDefender(null);
				plwm = this.gameState.getPlayerWithMove();
				this.playBoard.uncoverPiecesForPlayer(plwm);
				switch (this.gameState.getLastGamephase()) {
					case SETUPred:
						this.gameState.setCurrentGamephase(GamephaseEnum.SETUPblue);
						this.playBoard.blockFieldsForSetup(plwm);
						this.playBoard.uncoverPiecesForPlayer(plwm);
						break;
					case SETUPblue:
						this.gameState.setCurrentGamephase(GamephaseEnum.MOVEred);
						this.playBoard.uncoverPiecesForPlayer(plwm);
						break;
					case MOVEred:
						this.gameState.setCurrentGamephase(GamephaseEnum.MOVEblue);
						this.playBoard.uncoverPiecesForPlayer(plwm);
						break;
					case MOVEblue:
						this.gameState.setCurrentGamephase(GamephaseEnum.MOVEred);
						this.playBoard.uncoverPiecesForPlayer(plwm);
						break;
					default:
						break;
				}
				break;
			case SETUPred:
				if (!this.gameState.getPlayerWithMove().getPieces().isEmpty()) {
					throw NotAllPiecesSetException;
				}
				this.playBoard.unblockFieldsForSetup(plwm);
				this.playBoard.coverPiecesForPlayer(plwm);
				this.gameState.setLastGamephase(GamephaseEnum.SETUPred);
				this.gameState.setCurrentGamephase(GamephaseEnum.CHANGE);
				break;
			case SETUPblue:
				if (!this.gameState.getPlayerWithMove().getPieces().isEmpty()) {
					throw NotAllPiecesSetException;
				}
				this.playBoard.unblockFieldsForSetup(plwm);
				this.playBoard.coverPiecesForPlayer(plwm);
				this.gameState.setLastGamephase(GamephaseEnum.SETUPblue);
				this.gameState.setCurrentGamephase(GamephaseEnum.CHANGE);
				break;
			case MOVEred:
				this.gameState.setLastGamephase(GamephaseEnum.MOVEred);
				this.playBoard.coverPiecesForPlayer(plwm);
				this.gameState.setCurrentGamephase(GamephaseEnum.CHANGE);
				if (this.playBoard.onlyBombsAndFlagsLeft()) {
					this.gameState.setGameResult(GameResultEnum.INDIFFERENT);
					this.gameState.setCurrentGamephase(GamephaseEnum.END);
					break;
				}
				if(this.gameState.getDefender().getClass().getSimpleName().toString().equals("Flag")){
				}
				if(flagIsBeaten()){
					this.gameState.setCurrentGamephase(GamephaseEnum.END);
					if(plwm.getColor().equals(ColorEnum.BLUE)){
						this.gameState.setGameResult(GameResultEnum.BLUEISWINNER);
						break;
					}
					if(plwm.getColor().equals(ColorEnum.RED)){
						this.gameState.setGameResult(GameResultEnum.REDISWINNER);
						break;
					}
				}
				break;
			case MOVEblue:
				this.gameState.setLastGamephase(GamephaseEnum.MOVEblue);
				this.playBoard.coverPiecesForPlayer(plwm);
				this.gameState.setCurrentGamephase(GamephaseEnum.CHANGE);
				if (this.playBoard.onlyBombsAndFlagsLeft()) {
					this.gameState.setGameResult(GameResultEnum.INDIFFERENT);
					this.gameState.setCurrentGamephase(GamephaseEnum.END);
				}
				if(flagIsBeaten()){
					this.gameState.setCurrentGamephase(GamephaseEnum.END);
					if(plwm.getColor().equals(ColorEnum.BLUE)){
						this.gameState.setGameResult(GameResultEnum.BLUEISWINNER);
					}
					if(plwm.getColor().equals(ColorEnum.RED)){
						this.gameState.setGameResult(GameResultEnum.REDISWINNER);
					}
				}
				break;
			default:
				break;

		}
	}

	/**
	 * switches the player with move.
	 */
	private void switchPlayer() {
		Player tmpPlayer = gameState.getOtherPlayer();
		gameState.setOtherPlayer(gameState.getPlayerWithMove());
		gameState.setPlayerWithMove(tmpPlayer);
	}
	private boolean flagIsBeaten(){
		Piece defender = this.gameState.getDefender();
		if(defender.getClass().getSimpleName().toString().equals("Flag")){
			if(!defender.isAlive()){
				return true;
			}
		}
		return false;
	}
}
