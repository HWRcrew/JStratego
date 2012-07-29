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
	
	public void switchGamephase(Gamephase gamephase) {
		switch (gamephase) {
			case SETUPred:
				this.gamephase = gamephase;
				this.playBoard.blockFieldsForSetup();
				break;
			case SETUPblue:
				this.gamephase = gamephase;
				this.playBoard.blockFieldsForSetup();
				break;
			case CHANGE:
			case MOVEred:
				this.gamephase = gamephase;
				this.playBoard.unblockFieldsForSetup();
				break;
			case MOVEblue:
				this.gamephase = gamephase;
				this.playBoard.unblockFieldsForSetup();
				break;
			case END:
			default:
		}
	}
}
