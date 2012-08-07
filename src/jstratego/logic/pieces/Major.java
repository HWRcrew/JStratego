package jstratego.logic.pieces;

/**
 *
 * @author sebastiangrosse
 */
public class Major extends Piece {

	public static final String DESCRIPTION = "Der Major liegt mit seiner Stärke im oberen Drittel der Spielfiguren.";
	public static final String NAME = "Major";
	public static final MotionEnum MOTION = MotionEnum.MOVABLE;

	public Major(ColorEnum color, boolean alive, boolean covered) {
		super(color, alive, covered);
		addToBeatenByPiece("Marshal");
		addToBeatenByPiece("General");
		addToBeatenByPiece("Colonel");
		addToBeatenByPiece("Major");
		addToBeatenByPiece("Bomb");
	}
}