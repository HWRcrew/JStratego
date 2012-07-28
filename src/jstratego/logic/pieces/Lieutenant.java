package jstratego.logic.pieces;

import java.util.ArrayList;

/**
 *
 * @author sebastiangrosse
 */
public class Lieutenant extends Piece {

	public Lieutenant(Color color, boolean alive, boolean covered) {
		super(color, alive, covered);
		description = "Der Leutnant liegt mit seiner Stärke im Mittelfeld der Figuren.";
		name = "Leutnant";
		motion = Motion.MOVABLE;
		beatenby = new ArrayList<String>();
		beatenby.add("Marshal");
		beatenby.add("General");
		beatenby.add("Colonel");
		beatenby.add("Major");
		beatenby.add("Captain");
		beatenby.add("Lieutenant");
		beatenby.add("Bomb");
	}
}