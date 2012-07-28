package jstratego.logic.pieces;

import java.util.ArrayList;

/**
 *
 * @author sebastiangrosse
 */
public class Miner extends Piece {

	public Miner(Color color, boolean alive, boolean covered) {
		super(color, alive, covered);
		description = "Mineure können als einzige Figuren Bomben aus dem Spiel nehmen.";
		name = "Mineur";
		motion = Motion.UNMOVABLE;
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