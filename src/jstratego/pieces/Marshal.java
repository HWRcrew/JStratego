package jstratego.pieces;

import java.util.ArrayList;

/**
 *
 * @author sebastiangrosse
 */
public class Marshal extends Piece {

	public Marshal(Color color, boolean alive, boolean covered) {
		super(color, alive, covered);
		// TODO descr + name
		description = "";
		name = "";
		motion = Motion.MOVABLE;
		imgurl = "";
		this.beatenby = new ArrayList<String>();
		beatenby.add("Marshal");
		beatenby.add("Spy");
		beatenby.add("Bomb");
	}
}