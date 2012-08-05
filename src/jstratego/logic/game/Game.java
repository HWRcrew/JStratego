package jstratego.logic.game;

import jstratego.logic.pieces.Color;

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
		gameState.setPlayerWithMove(new Player(namePlayerRed, Color.RED));
		gameState.setOtherPlayer(new Player(namePlayerBlue, Color.BLUE));
		gameState.setCurrentGamephase(Gamephase.SETUPred);
		playBoard = new PlayBoard();
	}
	Exception NotAllPiecesSetException = new Exception("Some pieces are left to set!");

	/**
	 * finishing a phase & editing the gamestate
	 *
	 * @throws Exception
	 */
	public void endPhase() throws Exception {
		switch (this.gameState.getCurrentGamephase()) {
			case CHANGE:
				switchPlayer();
				this.gameState.setChallenger(null);
				this.gameState.setDefender(null);
				switch (this.gameState.getLastGamephase()) {
					case SETUPred:
						this.gameState.setCurrentGamephase(Gamephase.SETUPblue);
						break;
					case SETUPblue:
						this.gameState.setCurrentGamephase(Gamephase.MOVEred);
						break;
					case MOVEred:
						this.gameState.setCurrentGamephase(Gamephase.MOVEblue);
						break;
					case MOVEblue:
						this.gameState.setCurrentGamephase(Gamephase.MOVEred);
						break;
					default:
						break;
				}
				break;
			case SETUPred:
				if (!this.gameState.getPlayerWithMove().pieces.isEmpty()) {
					throw NotAllPiecesSetException;
				}
				this.gameState.setLastGamephase(Gamephase.SETUPred);
				this.gameState.setCurrentGamephase(Gamephase.CHANGE);
				break;
			case SETUPblue:
				if (!this.gameState.getPlayerWithMove().pieces.isEmpty()) {
					throw NotAllPiecesSetException;
				}
				this.gameState.setLastGamephase(Gamephase.SETUPblue);
				this.gameState.setCurrentGamephase(Gamephase.CHANGE);
				break;
			case MOVEred:
				this.gameState.setLastGamephase(Gamephase.MOVEred);
				if (this.playBoard.onlyBombsAndFlags()) {
					this.gameState.setGameResult(GameResult.INDIFFERENT);
					this.gameState.setCurrentGamephase(Gamephase.END);
					break;
				}
				//TODO add other cases
				break;
			case MOVEblue:
				this.gameState.setLastGamephase(Gamephase.MOVEblue);
				if (this.playBoard.onlyBombsAndFlags()) {
					this.gameState.setGameResult(GameResult.INDIFFERENT);
					this.gameState.setCurrentGamephase(Gamephase.END);
				}
				this.gameState.setCurrentGamephase(Gamephase.CHANGE);
				//TODO add other cases
				break;
			default:
				break;
			
		}
	}

	/**
	 * switches the player with move
	 */
	private void switchPlayer() {
		Player tmpPlayer = gameState.getOtherPlayer();
		gameState.setOtherPlayer(gameState.getPlayerWithMove());
		gameState.setPlayerWithMove(tmpPlayer);
	}
	/**
	 * Prepares everything for the next Gamephase and includes the check for
	 * an indifferent ending.
	 *
	 * @param gamephase
	 */
//    public void switchGamephase(Gamephase gamephase) {
//        switch (gamephase) {
//            case SETUPred:
//                this.playBoard.uncoverPiecesForPlayer(gameState.getPlayerWithMove());
//                this.gameState.setLastGamephase(gameState.getCurrentGamephase());
//                this.gameState.setCurrentGamephase(gamephase);
//                this.playBoard.blockFieldsForSetup();
//                break;
//            case SETUPblue:
//                this.playBoard.uncoverPiecesForPlayer(gameState.getPlayerWithMove());
//                this.gameState.setCurrentGamephase(gamephase);
//                this.playBoard.blockFieldsForSetup();
//                break;
//            case CHANGE:
//                this.playBoard.coverPiecesForPlayer(gameState.getPlayerWithMove());
//                //TODO Abfrage nach Spielende
//                //TODO Flags für fighters setzen 
//                if (this.playBoard.onlyBombsAndFlags() == true) {
//                    this.gameState.setLastGamephase(gameState.getCurrentGamephase());
//                    this.gameState.setCurrentGamephase(Gamephase.END);
//                    this.gameState.setGameResult(GameResult.INDIFFERENT);
//                    break;
//                }
//                switchPlayer();
//                this.gameState.setLastGamephase(this.gameState.getCurrentGamephase());
//                this.gameState.setCurrentGamephase(gamephase);
//                break;
//            case MOVEred:
//                this.playBoard.uncoverPiecesForPlayer(this.gameState.getPlayerWithMove());
//                this.gameState.setCurrentGamephase(gamephase);
//                this.playBoard.unblockFieldsForSetup();
//                break;
//            case MOVEblue:
//                this.playBoard.uncoverPiecesForPlayer(this.gameState.getPlayerWithMove());
//                this.gameState.setCurrentGamephase(gamephase);
//                this.playBoard.unblockFieldsForSetup();
//                break;
//            case END:
//                this.gameState.setCurrentGamephase(gamephase);
//                break;
//            default:
//                break;
//        }
//    }
}
