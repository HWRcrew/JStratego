package jstratego.logic.game;

import java.util.ArrayList;
import jstratego.logic.pieces.ColorEnum;
import jstratego.logic.pieces.MotionEnum;
import jstratego.logic.pieces.Piece;

/**
 * logical representation for the playboard
 *
 * @author sebastiangrosse
 */
public class PlayBoard implements PlayBoardInterface {

	public Field[][] board;

	public PlayBoard() {
		board = new Field[10][10];
		initializeFields();
	}

	private boolean addReachable(Field tmpField, Field field, ArrayList<Field> fields) {
		Piece tmpPiece = tmpField.getPiece();
		//TODO Scout darf keine gegn. Pieces überspringen
		if (!tmpField.isBlocked() && (tmpPiece == null || !tmpPiece.getColor().equals(field.getPiece().getColor()))) {
			fields.add(tmpField);
		} else {
			return true;
		}
		return false;
	}

	/**
	 * initializes the Fields for a new board.
	 */
	private void initializeFields() {
		/*
		 * Lake 1
		 */
		board[4][2] = new Field(null, true, 4, 2);
		board[4][3] = new Field(null, true, 4, 3);
		board[5][2] = new Field(null, true, 5, 2);
		board[5][3] = new Field(null, true, 5, 3);
		/*
		 * Lake 2
		 */
		board[4][6] = new Field(null, true, 4, 6);
		board[4][7] = new Field(null, true, 4, 7);
		board[5][6] = new Field(null, true, 5, 6);
		board[5][7] = new Field(null, true, 5, 7);
		/*
		 * Fields for the players
		 */
		for (int x = 0; x < 10; x++) {
			for (int y = 0; y < 10; y++) {
				if (board[x][y] == null) {
					board[x][y] = new Field(null, false, x, y);
				}
			}
		}
	}

	@Override
	public boolean onlyBombsAndFlagsLeft() {
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

	@Override
	public void blockFieldsForSetup(Player player) {
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
		if (player.getColor().equals(ColorEnum.RED)) {
			for (int i = 0; i <= 3; i++) {
				for (int j = 0; j <= 9; j++) {
					board[i][j].setBlocked(true);
				}
			}
		}
		if (player.getColor().equals(ColorEnum.BLUE)) {
			for (int i = 6; i <= 9; i++) {
				for (int j = 0; j <= 9; j++) {
					board[i][j].setBlocked(true);
				}
			}
		}
	}

	@Override
	public void unblockFieldsForSetup(Player player) {
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
		if (player.getColor().equals(ColorEnum.RED)) {
			for (int i = 0; i <= 3; i++) {
				for (int j = 0; j <= 9; j++) {
					board[i][j].setBlocked(false);
				}
			}
		}
		if (player.getColor().equals(ColorEnum.BLUE)) {
			for (int i = 6; i <= 9; i++) {
				for (int j = 0; j <= 9; j++) {
					board[i][j].setBlocked(false);
				}
			}
		}
	}

	@Override
	public void coverPiecesForPlayer(Player player) throws NullPointerException {
		for (int i = 0; i <= 9; i++) {
			for (int j = 0; j <= 9; j++) {
				try {
					Piece tmpPiece = board[i][j].getPiece();
					if (tmpPiece.getColor().equals(player.getColor())) {
						tmpPiece.setCovered(true);
					}
				} catch (NullPointerException npe) {
				}
			}
		}
	}

	@Override
	public void uncoverPiecesForPlayer(Player player) throws NullPointerException {
		for (int i = 0; i <= 9; i++) {
			for (int j = 0; j <= 9; j++) {
				try {
					Piece tmpPiece = board[i][j].getPiece();
					if (tmpPiece.getColor().equals(player.getColor())) {
						tmpPiece.setCovered(false);
					}
				} catch (NullPointerException npe) {
				}
			}
		}
	}

	@Override
	public ArrayList<Field> listOfReachableFields(Field field, GamephaseEnum gamePhase) {
		ArrayList<Field> fields;
		fields = new ArrayList<Field>();
		if (field.getPiece().getMOTION().equals(MotionEnum.MOVABLE)) {
			Field tmpField;
			if (field.getX() + 1 <= 9) {
				int x = field.getX() + 1;
				tmpField = this.board[x][field.getY()];
				addReachable(tmpField, field, fields);
			}
			if (field.getX() - 1 >= 0) {
				int x = field.getX() - 1;
				tmpField = this.board[x][field.getY()];
				addReachable(tmpField, field, fields);
			}
			if (field.getY() + 1 <= 9) {
				int y = field.getY() + 1;
				tmpField = this.board[field.getX()][y];
				addReachable(tmpField, field, fields);
			}
			if (field.getY() - 1 >= 0) {
				int y = field.getY() - 1;
				tmpField = this.board[field.getX()][y];
				addReachable(tmpField, field, fields);
			}
		}
		if (field.getPiece().getMOTION().equals(MotionEnum.SUPERMOVABLE)) {
			Field tmpField;
			for (int x = field.getX() + 1; x <= 9; x++) {
				tmpField = this.board[x][field.getY()];
				addReachable(tmpField, field, fields);
			}
			for (int x = field.getX() - 1; x >= 0; x--) {
				tmpField = this.board[x][field.getY()];
				addReachable(tmpField, field, fields);
			}
			for (int y = field.getY() + 1; y <= 9; y++) {
				tmpField = this.board[field.getX()][y];
				if (addReachable(tmpField, field, fields));
			}
			for (int y = field.getY() - 1; y >= 0; y--) {
				tmpField = this.board[field.getX()][y];
				addReachable(tmpField, field, fields);
			}
		}
		if (field.getPiece().getMOTION().equals(MotionEnum.UNMOVABLE)) {
			fields.clear();
			return fields;
		}
		return fields;
	}

	@Override
	public void movePiece(Field pieceField, Field destinationField, GameState gameState) {
		if(pieceField.getPiece()!=null){
			if(listOfReachableFields(pieceField, gameState.getCurrentGamephase()).contains(destinationField)){
				destinationField.setPiece(pieceField.getPiece(), gameState);
			} else {
				System.out.println("Cannot move to this field. Field not reachable.");
			}
		}
	}
}
