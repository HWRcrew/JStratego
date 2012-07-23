package jstratego.logic.pieces;

import java.util.ArrayList;

/**
 *
 * @author sebastiangrosse
 */
public class Scout extends Piece {

	public Scout(Color color, boolean alive, boolean covered) {
		super(color, alive, covered);
		// TODO description
		description = "";
		name = "Aufklärer";
		motion = Motion.SUPERMOVABLE;
		imgurl = "";
		this.beatenby = new ArrayList<String>();
		beatenby.add("Marshal");
		beatenby.add("General");
		beatenby.add("Colonel");
		beatenby.add("Major");
		beatenby.add("Captain");
		beatenby.add("Lieutenant");
		beatenby.add("Sergeant");
		beatenby.add("Miner");
		beatenby.add("Scout");
		beatenby.add("Bomb");
	}
}