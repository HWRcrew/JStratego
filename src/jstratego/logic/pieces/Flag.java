package jstratego.logic.pieces;

/**
 *
 * @author sebastiangrosse
 */
public class Flag extends Piece {

	public static final String DESCRIPTION = "Die Flagge muss zum Sieg des Spiels erobert werden. Sie muss bis aufs Letzte verteidigt werden.";
	public static final String NAME = "Flagge";
	public static final Motion MOTION = Motion.UNMOVABLE;

	public Flag(Color color, boolean alive, boolean covered) {
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