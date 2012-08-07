package jstratego.logic.pieces;

/**
 *
 * @author sebastiangrosse
 */
public class Sergeant extends Piece {

	public static final String DESCRIPTION = "Der Unteroffizier liegt mit seiner Stärke im unteren Drittel der Figuren.";
	public static final String NAME = "Unteroffizier";
	public static final MotionEnum MOTION = MotionEnum.MOVABLE;

	public Sergeant(ColorEnum color, boolean alive, boolean covered) {
		super(color, alive, covered);
		addToBeatenByPiece("Marshal");
		addToBeatenByPiece("General");
		addToBeatenByPiece("Colonel");
		addToBeatenByPiece("Major");
		addToBeatenByPiece("Captain");
		addToBeatenByPiece("Lieutenant");
		addToBeatenByPiece("Sergeant");
		addToBeatenByPiece("Bomb");
	}
}