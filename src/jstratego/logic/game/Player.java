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
	public List<Piece> pieces = new ArrayList<Piece>();

	public Player(String name, Color playerColor) {
		this.name = name;
		this.playerColor = playerColor;
		handoutPieces();
	}

	public Piece getPiece(String typ) {
		if (typ.equals("Marshal")) {
			int index = this.pieces.indexOf(Marshal.class);
			if (index >= 0) {
				return this.pieces.get(index);
			}
		}
		if (typ.equals("General")) {
			int index = this.pieces.indexOf(General.class);
			if (index >= 0) {
				return this.pieces.get(index);
			}
		}
		if (typ.equals("Colonel")) {
			int index = this.pieces.indexOf(Colonel.class);
			if (index >= 0) {
				return this.pieces.get(index);
			}
		}
		if (typ.equals("Major")) {
			int index = this.pieces.indexOf(Major.class);
			if (index >= 0) {
				return this.pieces.get(index);
			}
		}
		if (typ.equals("Captain")) {
			int index = this.pieces.indexOf(Captain.class);
			if (index >= 0) {
				return this.pieces.get(index);
			}
		}
		if (typ.equals("Lieutenant")) {
			int index = this.pieces.indexOf(Lieutenant.class);
			if (index >= 0) {
				return this.pieces.get(index);
			}
		}
		if (typ.equals("Sergeant")) {
			int index = this.pieces.indexOf(Sergeant.class);
			if (index >= 0) {
				return this.pieces.get(index);
			}
		}
		if (typ.equals("Miner")) {
			int index = this.pieces.indexOf(Miner.class);
			if (index >= 0) {
				return this.pieces.get(index);
			}
		}
		if (typ.equals("Scout")) {
			int index = this.pieces.indexOf(Scout.class);
			if (index >= 0) {
				return this.pieces.get(index);
			}
		}
		if (typ.equals("Spy")) {
			int index = this.pieces.indexOf(Spy.class);
			if (index >= 0) {
				return this.pieces.get(index);
			}
		}
		if (typ.equals("Bomb")) {
			int index = this.pieces.indexOf(Bomb.class);
			if (index >= 0) {
				return this.pieces.get(index);
			}
		}
		if (typ.equals("Flag")) {
			int index = this.pieces.indexOf(Flag.class);
			if (index >= 0) {
				return this.pieces.get(index);
			}
		}
		return null;
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