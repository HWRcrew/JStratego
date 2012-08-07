package jstratego.logic.pieces;

import java.util.ArrayList;
import jstratego.logic.game.GameState;

/**
 * abstraction of a piece.
 *
 * @author sebastiangrosse
 */
public abstract class Piece implements PieceInterface {

	private String NAME;
	private String DESCRIPTION;
	private MotionEnum MOTION;
	private ArrayList<String> beatenByList;
	private ColorEnum color;
	private boolean alive;
	private boolean covered;

	public Piece(ColorEnum color, boolean alive, boolean covered) {
		this.color = color;
		this.alive = alive;
		this.covered = covered;
		this.beatenByList = new ArrayList<String>();
	}

	@Override
	public boolean isBeatenBy(Piece challenger) {
		String c = challenger.getClass().getSimpleName().toString();
		return beatenByList.contains(c);
	}

	@Override
	public void fightAgainst(Piece defender, GameState gameState) throws NullPointerException {
		if (!this.color.equals(defender.color)) {
			if (this.getClass() == defender.getClass()) {
				this.alive = false;
				defender.alive = false;
			}
			if (defender.isBeatenBy(this)) {
				defender.alive = false;
			}
			if (!defender.isBeatenBy(this)) {
				this.alive = false;
			}
			gameState.setChallenger(this);
			gameState.setDefender(defender);
		}
		if (defender.isBeatenBy(this)) {
			defender.alive = false;
		}
		if (!defender.isBeatenBy(this)) {
			this.alive = false;
		}
		gameState.setChallenger(this);
		gameState.setDefender(defender);
	}

	@Override
	public String getNAME() {
		return this.NAME;
	}

	@Override
	public String getDESCRIPTION() {
		return this.DESCRIPTION;
	}

	@Override
	public ColorEnum getColor() {
		return this.color;
	}

	@Override
	public boolean isCovered() {
		return this.covered;
	}

	@Override
	public boolean isAlive() {
		return this.alive;
	}

	@Override
	public void setAlive(boolean alive) {
		this.alive = alive;
	}

	@Override
	public void setCovered(boolean covered) {
		this.covered = covered;
	}

	@Override
	public MotionEnum getMOTION() {
		return this.MOTION;
	}

	@Override
	public void addToBeatenByPiece(String pieceName) {
		this.beatenByList.add(pieceName);
	}
}
