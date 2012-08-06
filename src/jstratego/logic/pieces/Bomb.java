package jstratego.logic.pieces;

/**
 *
 * @author sebastiangrosse
 */
public class Bomb extends Piece {

	public static final String DESCRIPTION = "Bomben zerstören jeden Angreifer, außer den Mineuren. Die Bombe kann nur durch einen Mineur entfernt werden.";
	public static final String NAME = "Bombe";
	public static final Motion MOTION = Motion.UNMOVABLE;

	public Bomb(Color color, boolean alive, boolean covered) {
		super(color, alive, covered);
		addToBeatenByPiece("Miner");
	}
}