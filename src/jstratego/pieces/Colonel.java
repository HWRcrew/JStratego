package jstratego.pieces;

import java.util.ArrayList;

/**
 *
 * @author sebastiangrosse
 */
public class Colonel extends Piece {

	public Colonel(Color color, boolean alive, boolean covered) {
		super(color, alive, covered);
		// TODO german description
		description = "";
		name = "";
		motion = Motion.MOVABLE;
		imgurl = "";
		beatenby = new ArrayList<String>();
		beatenby.add("Marshal");
		beatenby.add("General");
		beatenby.add("Colonel");
		beatenby.add("Bomb");
	}
}