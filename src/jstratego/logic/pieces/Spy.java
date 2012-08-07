package jstratego.logic.pieces;

/**
 *
 * @author sebastiangrosse
 */
public class Spy extends Piece {

	public static final String DESCRIPTION = "Der Spion hat die besondere Eigenschaft, den Feldmarschall zu schlagen, wenn der Spion die angreifende Figur ist.";
	public static final String NAME = "Spion";
	public static final MotionEnum MOTION = MotionEnum.MOVABLE;

	public Spy(ColorEnum color, boolean alive, boolean covered) {
		super(color, alive, covered);
		addToBeatenByPiece("Marshal");
		addToBeatenByPiece("General");
		addToBeatenByPiece("Colonel");
		addToBeatenByPiece("Major");
		addToBeatenByPiece("Captain");
		addToBeatenByPiece("Lieutenant");
		addToBeatenByPiece("Sergeant");
		addToBeatenByPiece("Miner");
		addToBeatenByPiece("Scout");
		addToBeatenByPiece("Spy");
		addToBeatenByPiece("Bomb");
	}
}