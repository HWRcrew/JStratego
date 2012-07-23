package jstratego.logic.pieces;

import java.util.ArrayList;

/**
 *
 * @author sebastiangrosse
 */
public class General extends Piece {

	public General(Color color, boolean alive, boolean covered) {
		super(color, alive, covered);
		// TODO description & name
		description = "";
		name = "";
		motion = Motion.MOVABLE;
		imgurl = "";
		this.beatenby = new ArrayList<String>();
		beatenby.add("Marshal");
		beatenby.add("General");
		beatenby.add("Bomb");
	}
}