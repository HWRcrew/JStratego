package jstratego.logic.game;

import java.util.ArrayList;
import java.util.List;
import jstratego.logic.pieces.Motion;

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
		board[3][5] = new Field(null, true, 3, 5);
		board[3][6] = new Field(null, true, 3, 6);
		board[4][5] = new Field(null, true, 4, 5);
		board[4][6] = new Field(null, true, 4, 6);
		/*
		 * Water Area 2
		 */
		board[7][5] = new Field(null, true, 7, 5);
		board[7][6] = new Field(null, true, 7, 6);
		board[8][5] = new Field(null, true, 8, 5);
		board[8][6] = new Field(null, true, 8, 6);
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
					board[x][y] = new Field(null, false, x, y);
				}
			}
		}
	}

	List<Field> reachableFields(int x, int y) {
		List<Field> fields;
		fields = new ArrayList<Field>();
		Field field = board[x][y];
		//TODO parametrisierbarer Algorithmus, der die möglichen Felder für Bewegungen in einer Liste ablegt. Der Parameter gibt die maximale Schrittweite an. maximum ist 9
		if (field.piece.motion == Motion.MOVABLE) {
			try {
				if ((board[x + 1][y].piece == null || board[x + 1][y].piece.color != field.piece.color) && !board[x + 1][y].blocked) {
					fields.add(board[x + 1][y]);
				}
				if ((board[x - 1][y].piece == null || board[x - 1][y].piece.color != field.piece.color) && !board[x - 1][y].blocked) {
					fields.add(board[x - 1][y]);
				}
				if ((board[x][y + 1].piece == null || board[x][y + 1].piece.color != field.piece.color) && !board[x][y + 1].blocked) {
					fields.add(board[x][y + 1]);
				}
				if ((board[x][y - 1].piece == null || board[x][y - 1].piece.color != field.piece.color) && !board[x][y - 1].blocked) {
					fields.add(board[x][y - 1]);
				}
			} catch (IndexOutOfBoundsException ioobe) {
			}
		}
		if (field.piece.motion == Motion.SUPERMOVABLE) {
			//TODO
		}
		if (field.piece.motion == Motion.UNMOVABLE) {
			fields.clear();
			return fields;
		}
		return fields;
	}
}