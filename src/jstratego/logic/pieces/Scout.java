package jstratego.logic.pieces;

/**
 *
 * @author sebastiangrosse
 */
public class Scout extends Piece {

	public static final String DESCRIPTION = "Der Aufklärer kann nicht durch seine Stärke überzeugen, dafür aber mehrere Felder weit ziehen.";
	public static final String NAME = "Aufklärer";
	public static final MotionEnum MOTION = MotionEnum.SUPERMOVABLE;

	public Scout(ColorEnum color, boolean alive, boolean covered) {
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
		addToBeatenByPiece("Bomb");
	}
}