package jstratego.pieces;

import java.util.ArrayList;

/**
 *
 * @author sebastiangrosse
 */
public class Miner extends Piece {

	public Miner(Color color, boolean alive, boolean covered) {
		super(color, alive, covered);
		description = "";
		name = "Mineur";
		motion = Motion.UNMOVABLE;
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
	}
}