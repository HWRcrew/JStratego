package jstratego.pieces;

import java.util.ArrayList;

/**
 *
 * @author sebastiangrosse
 */
public class Lieutenant extends Piece {

	public Lieutenant(Color color, boolean alive, boolean covered) {
		super(color, alive, covered);
		// TODO description German + name
		description = "";
		name = "";
		motion = Motion.MOVABLE;
		imgurl = "";
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