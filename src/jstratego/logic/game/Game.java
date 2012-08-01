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
	public GameResult gameResult;

	public Game(String namePlayerRed, String namePlayerBlue) {
		this.playerWithMove = new Player(namePlayerRed, Color.RED);
		this.otherPlayer = new Player(namePlayerBlue, Color.BLUE);
		this.gamephase = Gamephase.SETUPred;
	}
	//TODO Wo findet fightAgainst statt? bei setPiece
	/*
	 * Ich muss mir irgendwo merken, was gemacht wird und beim Ausführen die
	 * Schritte auswerten - GUI - Übergang zu Change-phase
	 */

	/**
	 * Prepares everything for the next Gamephase and includes the check for
	 * an indifferent ending.
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
				//TODO Abfrage nach Spielende
				if (this.playBoard.onlyBombsAndFlags() == true) {
					this.gamephase = Gamephase.END;
					this.gameResult = GameResult.INDIFFERENT;
					break;
				}
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
				this.gamephase = gamephase;
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
