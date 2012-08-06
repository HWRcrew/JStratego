package jstratego.logic.game;

import java.util.ArrayList;
import java.util.List;
import jstratego.logic.pieces.*;

/**
 * Representation a Stratego-Player.
 *
 * @author sebastiangrosse
 */
public class Player implements PlayerInterface {

	private String name;
	private Color playerColor;
	private List<Piece> pieces = new ArrayList<Piece>();

	public Player(String name, Color playerColor) {
		this.name = name;
		this.playerColor = playerColor;
		handoutPieces();
	}

	public String getName() {
		return name;
	}

	public Color getPlayerColor() {
		return playerColor;
	}

	public List<Piece> getPieces() {
		return pieces;
	}

	@Override
	public Piece getPiece(String className) {
		for (Piece currentPiece : this.pieces) {
			if (currentPiece.getClass().getSimpleName().equals(className)) {
				return currentPiece;
			}
		}
		return null;
	}

	@Override
	public int getLeftNumberOfPieceInList(Piece piece) {
		int i = 0;
		for (Piece currentPiece : this.pieces) {
			if (currentPiece.getClass().equals(piece.getClass())) {
				i++;
			}
		}
		return i;
	}

	/**
	 * adds a piece to a player.
	 *
	 * @param piece
	 */
	private void addPieceToPlayer(Piece piece) {
		this.pieces.add(piece);
	}

	/**
	 * hands out the pieces to the player.
	 */
	private void handoutPieces() {
		this.addPieceToPlayer(new Marshal(this.playerColor, true, false));
		this.addPieceToPlayer(new General(this.playerColor, true, false));
		this.addPieceToPlayer(new Colonel(this.playerColor, true, false));
		this.addPieceToPlayer(new Colonel(this.playerColor, true, false));
		this.addPieceToPlayer(new Major(this.playerColor, true, false));
		this.addPieceToPlayer(new Major(this.playerColor, true, false));
		this.addPieceToPlayer(new Major(this.playerColor, true, false));
		this.addPieceToPlayer(new Captain(this.playerColor, true, false));
		this.addPieceToPlayer(new Captain(this.playerColor, true, false));
		this.addPieceToPlayer(new Captain(this.playerColor, true, false));
		this.addPieceToPlayer(new Captain(this.playerColor, true, false));
		this.addPieceToPlayer(new Lieutenant(this.playerColor, true, false));
		this.addPieceToPlayer(new Lieutenant(this.playerColor, true, false));
		this.addPieceToPlayer(new Lieutenant(this.playerColor, true, false));
		this.addPieceToPlayer(new Lieutenant(this.playerColor, true, false));
		this.addPieceToPlayer(new Sergeant(this.playerColor, true, false));
		this.addPieceToPlayer(new Sergeant(this.playerColor, true, false));
		this.addPieceToPlayer(new Sergeant(this.playerColor, true, false));
		this.addPieceToPlayer(new Sergeant(this.playerColor, true, false));
		this.addPieceToPlayer(new Miner(this.playerColor, true, false));
		this.addPieceToPlayer(new Miner(this.playerColor, true, false));
		this.addPieceToPlayer(new Miner(this.playerColor, true, false));
		this.addPieceToPlayer(new Miner(this.playerColor, true, false));
		this.addPieceToPlayer(new Miner(this.playerColor, true, false));
		this.addPieceToPlayer(new Scout(this.playerColor, true, false));
		this.addPieceToPlayer(new Scout(this.playerColor, true, false));
		this.addPieceToPlayer(new Scout(this.playerColor, true, false));
		this.addPieceToPlayer(new Scout(this.playerColor, true, false));
		this.addPieceToPlayer(new Scout(this.playerColor, true, false));
		this.addPieceToPlayer(new Scout(this.playerColor, true, false));
		this.addPieceToPlayer(new Scout(this.playerColor, true, false));
		this.addPieceToPlayer(new Scout(this.playerColor, true, false));
		this.addPieceToPlayer(new Spy(this.playerColor, true, false));
		this.addPieceToPlayer(new Bomb(this.playerColor, true, false));
		this.addPieceToPlayer(new Bomb(this.playerColor, true, false));
		this.addPieceToPlayer(new Bomb(this.playerColor, true, false));
		this.addPieceToPlayer(new Bomb(this.playerColor, true, false));
		this.addPieceToPlayer(new Bomb(this.playerColor, true, false));
		this.addPieceToPlayer(new Bomb(this.playerColor, true, false));
		this.addPieceToPlayer(new Flag(this.playerColor, true, false));
	}
}