package jstratego.logic.pieces;

/**
 *
 * @author sebastiangrosse
 */
public class Lieutenant extends Piece {

	public static final String DESCRIPTION = "Der Leutnant liegt mit seiner Stärke im Mittelfeld der Figuren.";
	public static final String NAME = "Leutnant";
	public static final MotionEnum MOTION = MotionEnum.MOVABLE;

	public Lieutenant(ColorEnum color, boolean alive, boolean covered) {
		super(color, alive, covered);
		addToBeatenByPiece("Marshal");
		addToBeatenByPiece("General");
		addToBeatenByPiece("Colonel");
		addToBeatenByPiece("Major");
		addToBeatenByPiece("Captain");
		addToBeatenByPiece("Lieutenant");
		addToBeatenByPiece("Bomb");
	}
}