package jstratego.logic.game;

import jstratego.logic.pieces.Piece;

/**
 * logical representation of the playboard
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
	}

	public void setField(Piece piece, int x, int y) {
		if (board[x][y] == null || !board[x][y].blocked) {
			board[x][y] = new Field(piece, false);
		}
	}
}
