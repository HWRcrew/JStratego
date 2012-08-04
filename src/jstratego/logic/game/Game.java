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

	public Game(String namePlayerRed, String namePlayerBlue) {
		this.gameState.setPlayerWithMove(new Player(namePlayerRed, Color.RED));
		this.gameState.setOtherPlayer(new Player(namePlayerBlue, Color.BLUE));
		this.gameState.setCurrentGamephase(Gamephase.SETUPred);
	}
	Exception NotAllPiecesSetException = new Exception("Some pieces are left to set!");

	public void endPhase() throws Exception {
		switch (gameState.getCurrentGamephase()) {
			case CHANGE:

				break;
			case SETUPred:
				//TODO noch nicht sicher ob die abfrage so sein wird, oder lieber eigene Liste der pieces auf spielfeld?
				if (!gameState.getPlayerWithMove().pieces.isEmpty()) {
					throw NotAllPiecesSetException;
				}
				gameState.setLastGamephase(Gamephase.SETUPred);
				gameState.setCurrentGamephase(Gamephase.CHANGE);
				break;
			case SETUPblue:
				//TODO noch nicht sicher ob die abfrage so sein wird, oder lieber eigene Liste der pieces auf spielfeld?
				if (!gameState.getPlayerWithMove().pieces.isEmpty()) {
					throw NotAllPiecesSetException;
				}
				gameState.setLastGamephase(Gamephase.SETUPblue);
				gameState.setCurrentGamephase(Gamephase.CHANGE);
				break;
			case MOVEred:
				gameState.setLastGamephase(Gamephase.MOVEred);
				if (this.playBoard.onlyBombsAndFlags()) {
					gameState.setGameResult(GameResult.INDIFFERENT);
					gameState.setCurrentGamephase(Gamephase.END);
				}
				//TODO add other cases
				break;
			case MOVEblue:
				gameState.setLastGamephase(Gamephase.MOVEblue);
				if (this.playBoard.onlyBombsAndFlags()) {
					gameState.setGameResult(GameResult.INDIFFERENT);
					gameState.setCurrentGamephase(Gamephase.END);
				}
				//TODO add other cases
				break;
			default:
				break;

		}
	}
	//TODO Wo findet fightAgainst statt? bei setPiece letzte kämpfer merken!
	//TODO nextgamestate ist nicht erforderlich brauche extra switchmethode die entscheidet welche die nächste phase ist!

	/**
	 * Prepares everything for the next Gamephase and includes the check for
	 * an indifferent ending.
	 *
	 * @param gamephase
	 */
	//TODO die GUI muss entsprechend auf die Gamephase reagieren
	//TODO set last gamephase
	//TODO gamephase die nach dem change kommen soll setzen
	public void switchGamephase(Gamephase gamephase) {
		switch (gamephase) {
			case SETUPred:
				this.playBoard.uncoverPiecesForPlayer(gameState.getPlayerWithMove());
				this.gameState.setLastGamephase(gameState.getCurrentGamephase());
				this.gameState.setCurrentGamephase(gamephase);
				this.playBoard.blockFieldsForSetup();
				break;
			case SETUPblue:
				this.playBoard.uncoverPiecesForPlayer(gameState.getPlayerWithMove());
				this.gameState.setCurrentGamephase(gamephase);
				this.playBoard.blockFieldsForSetup();
				break;
			case CHANGE:
				this.playBoard.coverPiecesForPlayer(gameState.getPlayerWithMove());
				//TODO Abfrage nach Spielende
				//TODO Flags für fighters setzen 
				if (this.playBoard.onlyBombsAndFlags() == true) {
					this.gameState.setLastGamephase(gameState.getCurrentGamephase());
					this.gameState.setCurrentGamephase(Gamephase.END);
					this.gameState.setGameResult(GameResult.INDIFFERENT);
					break;
				}
				switchPlayer();
				this.gameState.setLastGamephase(this.gameState.getCurrentGamephase());
				this.gameState.setCurrentGamephase(gamephase);
				break;
			case MOVEred:
				this.playBoard.uncoverPiecesForPlayer(this.gameState.getPlayerWithMove());
				this.gameState.setCurrentGamephase(gamephase);
				this.playBoard.unblockFieldsForSetup();
				break;
			case MOVEblue:
				this.playBoard.uncoverPiecesForPlayer(this.gameState.getPlayerWithMove());
				this.gameState.setCurrentGamephase(gamephase);
				this.playBoard.unblockFieldsForSetup();
				break;
			case END:
				this.gameState.setCurrentGamephase(gamephase);
				break;
			default:
				break;
		}
	}

	public void switchPlayer() {
		Player tmpPlayer = gameState.getOtherPlayer();
		gameState.setOtherPlayer(gameState.getPlayerWithMove());
		gameState.setPlayerWithMove(tmpPlayer);
	}
}
