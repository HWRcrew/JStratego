package jstratego.logic.game;

import jstratego.logic.pieces.Color;

/**
 * Game is representing a Game between two Players.
 *
 * @author sebastiangrosse
 */
public class Game {

	public Player playerWithMove;
	public Player otherPlayer;
	public Gamephase gamephase;
	public PlayBoard playBoard;

	public Game() {
		this.playerWithMove = new Player(null, Color.RED);
		this.otherPlayer = new Player(null, Color.BLUE);
		this.gamephase = Gamephase.SETUPred;
	}
	//TODO noch nicht fertig

	/**
	 * Prepares everything for the next Gamephase
	 *
	 * @param gamephase
	 */
	public void switchGamephase(Gamephase gamephase) {
		switch (gamephase) {
			case SETUPred:
				this.playBoard.uncoverPiecesForPlayer(playerWithMove);
				this.gamephase = gamephase;
				this.playBoard.blockFieldsForSetup();
				break;
			case SETUPblue:
				this.playBoard.uncoverPiecesForPlayer(playerWithMove);
				this.gamephase = gamephase;
				this.playBoard.blockFieldsForSetup();
				break;
			case CHANGE:
				this.playBoard.coverPiecesForPlayer(playerWithMove);
				switchPlayer();
				this.gamephase = gamephase;
				break;
			case MOVEred:
				this.playBoard.uncoverPiecesForPlayer(playerWithMove);
				this.gamephase = gamephase;
				this.playBoard.unblockFieldsForSetup();
				break;
			case MOVEblue:
				this.playBoard.uncoverPiecesForPlayer(playerWithMove);
				this.gamephase = gamephase;
				this.playBoard.unblockFieldsForSetup();
				break;
			case END:
				break;
			default:
				break;
		}
	}
	public void switchPlayer() {
		Player tmpPlayer = otherPlayer;
		otherPlayer = playerWithMove;
		playerWithMove = tmpPlayer;
	}
}
