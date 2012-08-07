package jstratego.logic.pieces;

/**
 *
 * @author sebastiangrosse
 */
public class Colonel extends Piece {

	public static final String DESCRIPTION = "Der Oberst besitzt den dritthöchsten Rang der Spielfiguren.";
	public static final String NAME = "Oberst";
	public static final MotionEnum MOTION = MotionEnum.MOVABLE;

	public Colonel(ColorEnum color, boolean alive, boolean covered) {
		super(color, alive, covered);
		addToBeatenByPiece("Marshal");
		addToBeatenByPiece("General");
		addToBeatenByPiece("Colonel");
		addToBeatenByPiece("Bomb");
	}
}