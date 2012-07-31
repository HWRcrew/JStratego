package jstratego.logic.game;

import java.util.ArrayList;
import java.util.List;
import jstratego.logic.pieces.*;

/**
 * Representation a Stratego-Player.
 *
 * @author sebastiangrosse
 */
public class Player {

	public String name;
	public Color playerColor;
	List<Piece> pieces = new ArrayList<Piece>();
	public Player(String name, Color playerColor) {
		this.name = name;
		this.playerColor = playerColor;
		handoutPieces();
	}

	private void handoutPieces() {
		this.pieces.add(new Marshal(this.playerColor, true, false));
		this.pieces.add(new General(this.playerColor, true, false));
		this.pieces.add(new Colonel(this.playerColor, true, false));
		this.pieces.add(new Colonel(this.playerColor, true, false));
		this.pieces.add(new Major(this.playerColor, true, false));
		this.pieces.add(new Major(this.playerColor, true, false));
		this.pieces.add(new Major(this.playerColor, true, false));
		this.pieces.add(new Captain(this.playerColor, true, false));
		this.pieces.add(new Captain(this.playerColor, true, false));
		this.pieces.add(new Captain(this.playerColor, true, false));
		this.pieces.add(new Captain(this.playerColor, true, false));
		this.pieces.add(new Lieutenant(this.playerColor, true, false));
		this.pieces.add(new Lieutenant(this.playerColor, true, false));
		this.pieces.add(new Lieutenant(this.playerColor, true, false));
		this.pieces.add(new Lieutenant(this.playerColor, true, false));
		this.pieces.add(new Sergeant(this.playerColor, true, false));
		this.pieces.add(new Sergeant(this.playerColor, true, false));
		this.pieces.add(new Sergeant(this.playerColor, true, false));
		this.pieces.add(new Sergeant(this.playerColor, true, false));
		this.pieces.add(new Miner(this.playerColor, true, false));
		this.pieces.add(new Miner(this.playerColor, true, false));
		this.pieces.add(new Miner(this.playerColor, true, false));
		this.pieces.add(new Miner(this.playerColor, true, false));
		this.pieces.add(new Miner(this.playerColor, true, false));
		this.pieces.add(new Scout(this.playerColor, true, false));
		this.pieces.add(new Scout(this.playerColor, true, false));
		this.pieces.add(new Scout(this.playerColor, true, false));
		this.pieces.add(new Scout(this.playerColor, true, false));
		this.pieces.add(new Scout(this.playerColor, true, false));
		this.pieces.add(new Scout(this.playerColor, true, false));
		this.pieces.add(new Scout(this.playerColor, true, false));
		this.pieces.add(new Scout(this.playerColor, true, false));
		this.pieces.add(new Spy(this.playerColor, true, false));
		this.pieces.add(new Bomb(this.playerColor, true, false));
		this.pieces.add(new Bomb(this.playerColor, true, false));
		this.pieces.add(new Bomb(this.playerColor, true, false));
		this.pieces.add(new Bomb(this.playerColor, true, false));
		this.pieces.add(new Bomb(this.playerColor, true, false));
		this.pieces.add(new Bomb(this.playerColor, true, false));
		this.pieces.add(new Flag(this.playerColor, true, false));
	}
}