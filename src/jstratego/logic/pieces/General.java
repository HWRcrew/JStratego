package jstratego.logic.pieces;

/**
 *
 * @author sebastiangrosse
 */
public class General extends Piece {

	public static final String DESCRIPTION = "Der General ist die zweitstärkste Figur im Spiel.";
	public static final String NAME = "General";
	public static final Motion MOTION = Motion.MOVABLE;

	public General(Color color, boolean alive, boolean covered) {
		super(color, alive, covered);
		addToBeatenByPiece("Marshal");
		addToBeatenByPiece("General");
		addToBeatenByPiece("Bomb");
	}
}