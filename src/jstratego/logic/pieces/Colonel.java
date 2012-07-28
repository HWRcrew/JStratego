package jstratego.logic.pieces;

import java.util.ArrayList;

/**
 *
 * @author sebastiangrosse
 */
public class Colonel extends Piece {

	public Colonel(Color color, boolean alive, boolean covered) {
		super(color, alive, covered);
		description = "Der Oberst besitzt den dritthöchsten Rang der Spielfiguren.";
		name = "Oberst";
		motion = Motion.MOVABLE;
		beatenby = new ArrayList<String>();
		beatenby.add("Marshal");
		beatenby.add("General");
		beatenby.add("Colonel");
		beatenby.add("Bomb");
	}
}