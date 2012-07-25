package jstratego.logic.game;

/**
 * logical representation for the playboard
 *
 * @author sebastiangrosse
 */
public class PlayBoard {

	public Field[][] board = new Field[10][10];

	public PlayBoard() {
		/*
		 * Water Area 1
		 */
		board[3][5] = new Field(null, true);
		board[3][6] = new Field(null, true);
		board[4][5] = new Field(null, true);
		board[4][6] = new Field(null, true);
		/*
		 * Water Area 2
		 */
		board[7][5] = new Field(null, true);
		board[7][6] = new Field(null, true);
		board[8][5] = new Field(null, true);
		board[8][6] = new Field(null, true);
		setFields();
	}

	/**
	 * this Method is iterating through the board-Array initializing new
	 * Field Objects
	 */
	final void setFields() {
		for (int x = 0; x < 10; x++) {
			for (int y = 0; y < 10; y++) {
				if (!board[x][y].blocked) {
					board[x][y] = new Field(null, false);
				}
			}
		}
	}
}
