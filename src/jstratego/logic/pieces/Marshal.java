package jstratego.logic.pieces;

/**
 *
 * @author sebastiangrosse
 */
public class Marshal extends Piece {

	public static final String NAME = "Feldmarschall";
	public static final String DESCRIPTION = "Der Feldmarschall ist die stärkste Figur im Spiel. Spione und Bomben stellen für ihn allerdings eine große Gefahr dar.";
	public static final Motion MOTION = Motion.MOVABLE;

	public Marshal(Color color, boolean alive, boolean covered) {
		super(color, alive, covered);
		addToBeatenByPiece("Marshal");
		addToBeatenByPiece("Spy");
		addToBeatenByPiece("Bomb");
	}
}