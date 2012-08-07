package jstratego.logic.pieces;

/**
 *
 * @author sebastiangrosse
 */
public class Captain extends Piece {

	public static final String NAME = "Hauptmann";
	public static final String DESCRIPTION = "Der Hauptmann liegt mit seiner Stärke im oberen Drittel der Spielfiguren.";
	public static final MotionEnum MOTION = MotionEnum.MOVABLE;

	public Captain(ColorEnum color, boolean alive, boolean covered) {
		super(color, alive, covered);
		addToBeatenByPiece("Marshal");
		addToBeatenByPiece("General");
		addToBeatenByPiece("Colonel");
		addToBeatenByPiece("Major");
		addToBeatenByPiece("Captain");
		addToBeatenByPiece("Bomb");
	}
}