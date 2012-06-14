package jstratego.pieces;

import java.util.ArrayList;

/**
 *
 * @author sebastiangrosse
 */
public class Spy extends Piece {

	public Spy(Color color, boolean alive, boolean covered) {
		super(color, alive, covered);
		description = "Der Spion hat die besondere Eigenschaft, den Feldmarschall zu schlagen, wenn der Spion die angreifende Figur ist.";
		name = "Spion";
		motion = Motion.MOVABLE;
		// TODO add imageurl
		imgurl = "";
		this.beatenby = new ArrayList<String>();
		beatenby.add("General");
		beatenby.add("Colonel");
		beatenby.add("Major");
		beatenby.add("Captain");
		beatenby.add("Lieutenant");
		beatenby.add("Sergeant");
		beatenby.add("Miner");
		beatenby.add("Scout");
		beatenby.add("Spy");
		beatenby.add("Bomb");
	}
}