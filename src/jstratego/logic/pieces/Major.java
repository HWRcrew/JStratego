package jstratego.logic.pieces;

import java.util.ArrayList;

/**
 *
 * @author sebastiangrosse
 */
public class Major extends Piece {

	public Major(Color color, boolean alive, boolean covered) {
		super(color, alive, covered);
		// TODO descr. + name
		description = "";
		name = "";
		Major.motion = Motion.MOVABLE;
		imgurl = "";
		this.beatenby = new ArrayList<String>();
		beatenby.add("Marshal");
		beatenby.add("General");
		beatenby.add("Colonel");
		beatenby.add("Major");
		beatenby.add("Bomb");
	}
}