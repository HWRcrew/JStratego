package jstratego.logic.game;

import java.util.ArrayList;
import java.util.List;
import jstratego.logic.pieces.Motion;
import jstratego.logic.pieces.Piece;

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
		board[4][2] = new Field(null, true, 4, 2);
		board[4][3] = new Field(null, true, 4, 3);
		board[5][2] = new Field(null, true, 5, 2);
		board[5][3] = new Field(null, true, 5, 3);
		/*
		 * Water Area 2
		 */
		board[4][6] = new Field(null, true, 4, 6);
		board[4][7] = new Field(null, true, 4, 7);
		board[5][6] = new Field(null, true, 5, 6);
		board[5][7] = new Field(null, true, 5, 7);
		setFields();
	}

	/**
	 * this Method is iterating through the board-Array initializing new
	 * Field Objects
	 */
	final void setFields() {
		for (int x = 0; x < 10; x++) {
			for (int y = 0; y < 10; y++) {
				if (!board[x][y].isBlocked()) {
					board[x][y] = new Field(null, false, x, y);
				}
			}
		}
	}

	/**
	 * returns true if there are only Flags and Bombs left.
	 *
	 * @return
	 */
	//TODO t
	public boolean onlyBombsAndFlags() {
		ArrayList<String> movablePieces = new ArrayList<String>();
		movablePieces.add("Marshal");
		movablePieces.add("General");
		movablePieces.add("Colonel");
		movablePieces.add("Major");
		movablePieces.add("Captain");
		movablePieces.add("Lieutenant");
		movablePieces.add("Sergeant");
		movablePieces.add("Miner");
		movablePieces.add("Scout");
		movablePieces.add("Spy");
		for (int i = 0; i <= 9; i++) {
			for (int j = 0; j <= 9; j++) {
				Piece tmpPiece = this.board[i][j].getPiece();
				if (tmpPiece != null) {
					String tmpPieceString = tmpPiece.getClass().getSimpleName().toString();
					for (int a = 0; a <= movablePieces.size(); a++) {
						if (movablePieces.contains(tmpPieceString)) {
							return false;
						}
					}
				}
			}
		}
		return true;
	}

	/**
	 * this Method blocks the Fields in the middle to ensure, that there is
	 * no figure placed on Setup
	 */
	public void blockFieldsForSetup() {
		board[4][0].setBlocked(true);
		board[4][1].setBlocked(true);
		board[4][4].setBlocked(true);
		board[4][5].setBlocked(true);
		board[4][8].setBlocked(true);
		board[4][9].setBlocked(true);
		board[5][0].setBlocked(true);
		board[5][1].setBlocked(true);
		board[5][4].setBlocked(true);
		board[5][5].setBlocked(true);
		board[5][8].setBlocked(true);
		board[5][9].setBlocked(true);
	}

	/**
	 * this Method unblocks the Fields in the middle.
	 */
	public void unblockFieldsForSetup() {
		board[4][0].setBlocked(false);
		board[4][1].setBlocked(false);
		board[4][4].setBlocked(false);
		board[4][5].setBlocked(false);
		board[4][8].setBlocked(false);
		board[4][9].setBlocked(false);
		board[5][0].setBlocked(false);
		board[5][1].setBlocked(false);
		board[5][4].setBlocked(false);
		board[5][5].setBlocked(false);
		board[5][8].setBlocked(false);
		board[5][9].setBlocked(false);
	}

	/**
	 * covers the pieces of the selected player
	 *
	 * @param player
	 */
	//TODO stattdessen liste mit akt figuren?
	public void coverPiecesForPlayer(Player player) {
		for (int i = 0; i <= 9; i++) {
			for (int j = 0; j <= 9; j++) {
				Piece tmpPiece = board[i][j].getPiece();
				if (tmpPiece.color.equals(player.playerColor)) {
					tmpPiece.covered = true;
				}
			}
		}
	}

	/**
	 * uncovers the pieces of the selected player
	 *
	 * @param player
	 */
	public void uncoverPiecesForPlayer(Player player) {
		for (int i = 0; i <= 9; i++) {
			for (int j = 0; j <= 9; j++) {
				Piece tmpPiece = board[i][j].getPiece();
				if (tmpPiece.color.equals(player.playerColor)) {
					tmpPiece.covered = false;
				}
			}
		}
	}

	/**
	 * returns a list of all reachable Fields für a piece on a field.
	 *
	 * @param field
	 * @return
	 */
	public List<Field> reachableFields(Field field) {
		List<Field> fields;
		fields = new ArrayList<Field>();
		if (field.getPiece().motion == Motion.MOVABLE) {
			Field tmpField;
			if (field.getX() + 1 <= 9) {
				int x = field.getX() + 1;
				tmpField = this.board[x][field.getY()];
				if (!tmpField.isBlocked() && (tmpField.getPiece() == null || !tmpField.getPiece().color.equals(field.getPiece().color))) {
					fields.add(tmpField);
				}
			}
			if (field.getX() - 1 >= 0) {
				int x = field.getX() - 1;
				tmpField = this.board[x][field.getY()];
				if (!tmpField.isBlocked() && (tmpField.getPiece() == null || !tmpField.getPiece().color.equals(field.getPiece().color))) {
					fields.add(tmpField);
				}
			}
			if (field.getY() + 1 <= 9) {
				int y = field.getY() + 1;
				tmpField = this.board[field.getX()][y];
				if (!tmpField.isBlocked() && (tmpField.getPiece() == null || !tmpField.getPiece().color.equals(field.getPiece().color))) {
					fields.add(tmpField);
				}
			}
			if (field.getY() - 1 >= 0) {
				int y = field.getY() - 1;
				tmpField = this.board[field.getX()][y];
				if (!tmpField.isBlocked() && (tmpField.getPiece() == null || !tmpField.getPiece().color.equals(field.getPiece().color))) {
					fields.add(tmpField);
				}
			}
		}
		if (field.getPiece().motion == Motion.SUPERMOVABLE) {
			Field tmpField;
			for (int x = field.getX() + 1; x <= 9; x++) {
				tmpField = this.board[x][field.getY()];
				if (!tmpField.isBlocked() && (tmpField.getPiece() == null || !tmpField.getPiece().color.equals(field.getPiece().color))) {
					fields.add(tmpField);
				} else {
					break;
				}
			}
			for (int x = field.getX() - 1; x >= 0; x--) {
				tmpField = this.board[x][field.getY()];
				if (!tmpField.isBlocked() && (tmpField.getPiece() == null || !tmpField.getPiece().color.equals(field.getPiece().color))) {
					fields.add(tmpField);
				} else {
					break;
				}
			}
			for (int y = field.getY() + 1; y <= 9; y++) {
				tmpField = this.board[field.getX()][y];
				if (!tmpField.isBlocked() && (tmpField.getPiece() == null || !tmpField.getPiece().color.equals(field.getPiece().color))) {
					fields.add(tmpField);
				} else {
					break;
				}
			}
			for (int y = field.getY() - 1; y >= 0; y--) {
				tmpField = this.board[field.getX()][y];
				if (!tmpField.isBlocked() && (tmpField.getPiece() == null || !tmpField.getPiece().color.equals(field.getPiece().color))) {
					fields.add(tmpField);
				} else {
					break;
				}
			}
		}
		if (field.getPiece().motion == Motion.UNMOVABLE) {
			fields.clear();
			return fields;
		}
		return fields;
	}
}