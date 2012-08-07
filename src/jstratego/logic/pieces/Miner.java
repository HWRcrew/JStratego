package jstratego.logic.pieces;

/**
 *
 * @author sebastiangrosse
 */
public class Miner extends Piece {

	public static final String DESCRIPTION = "Mineure können als einzige Figuren Bomben aus dem Spiel nehmen.";
	public static final String NAME = "Mineur";
	public static final MotionEnum MOTION = MotionEnum.MOVABLE;

	public Miner(ColorEnum color, boolean alive, boolean covered) {
		super(color, alive, covered);
		addToBeatenByPiece("Marshal");
		addToBeatenByPiece("General");
		addToBeatenByPiece("Colonel");
		addToBeatenByPiece("Major");
		addToBeatenByPiece("Captain");
		addToBeatenByPiece("Lieutenant");
		addToBeatenByPiece("Sergeant");
		addToBeatenByPiece("Miner");
	}
}