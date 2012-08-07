package jstratego.logic.game;

import jstratego.logic.pieces.Color;
import jstratego.logic.pieces.Piece;

/**
 * Game is representing a Game between two Players.
 *
 * @author sebastiangrosse
 */
public class Game {

	public PlayBoard playBoard;
	public GameState gameState;
	//TODO offenbar kennt er gameState nicht...

	public Game(String namePlayerRed, String namePlayerBlue) {
		gameState = new GameState();
		playBoard = new PlayBoard();
		gameState.setPlayerWithMove(new Player(namePlayerRed, Color.RED));
		gameState.setOtherPlayer(new Player(namePlayerBlue, Color.BLUE));
		gameState.setCurrentGamephase(Gamephase.SETUPred);
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
						this.gameState.setCurrentGamephase(Gamephase.SETUPblue);
						this.playBoard.blockFieldsForSetup(plwm);
						this.playBoard.uncoverPiecesForPlayer(plwm);
						break;
					case SETUPblue:
						this.gameState.setCurrentGamephase(Gamephase.MOVEred);
						this.playBoard.uncoverPiecesForPlayer(plwm);
						break;
					case MOVEred:
						this.gameState.setCurrentGamephase(Gamephase.MOVEblue);
						this.playBoard.uncoverPiecesForPlayer(plwm);
						break;
					case MOVEblue:
						this.gameState.setCurrentGamephase(Gamephase.MOVEred);
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
				this.gameState.setLastGamephase(Gamephase.SETUPred);
				this.gameState.setCurrentGamephase(Gamephase.CHANGE);
				break;
			case SETUPblue:
				if (!this.gameState.getPlayerWithMove().getPieces().isEmpty()) {
					throw NotAllPiecesSetException;
				}
				this.playBoard.unblockFieldsForSetup(plwm);
				this.playBoard.coverPiecesForPlayer(plwm);
				this.gameState.setLastGamephase(Gamephase.SETUPblue);
				this.gameState.setCurrentGamephase(Gamephase.CHANGE);
				break;
			case MOVEred:
				this.gameState.setLastGamephase(Gamephase.MOVEred);
				this.playBoard.coverPiecesForPlayer(plwm);
				this.gameState.setCurrentGamephase(Gamephase.CHANGE);
				if (this.playBoard.onlyBombsAndFlagsLeft()) {
					this.gameState.setGameResult(GameResult.INDIFFERENT);
					this.gameState.setCurrentGamephase(Gamephase.END);
					break;
				}
				if(this.gameState.getDefender().getClass().getSimpleName().toString().equals("Flag")){
				}
				if(flagIsBeaten()){
					this.gameState.setCurrentGamephase(Gamephase.END);
					if(plwm.getPlayerColor().equals(Color.BLUE)){
						this.gameState.setGameResult(GameResult.BLUEISWINNER);
						break;
					}
					if(plwm.getPlayerColor().equals(Color.RED)){
						this.gameState.setGameResult(GameResult.REDISWINNER);
						break;
					}
				}
				break;
			case MOVEblue:
				this.gameState.setLastGamephase(Gamephase.MOVEblue);
				this.playBoard.coverPiecesForPlayer(plwm);
				this.gameState.setCurrentGamephase(Gamephase.CHANGE);
				if (this.playBoard.onlyBombsAndFlagsLeft()) {
					this.gameState.setGameResult(GameResult.INDIFFERENT);
					this.gameState.setCurrentGamephase(Gamephase.END);
				}
				if(flagIsBeaten()){
					this.gameState.setCurrentGamephase(Gamephase.END);
					if(plwm.getPlayerColor().equals(Color.BLUE)){
						this.gameState.setGameResult(GameResult.BLUEISWINNER);
					}
					if(plwm.getPlayerColor().equals(Color.RED)){
						this.gameState.setGameResult(GameResult.REDISWINNER);
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
