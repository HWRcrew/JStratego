package jstratego.logic.pieces;

import java.util.ArrayList;

/**
 *
 * @author sebastiangrosse
 */
public class Major extends Piece {

	public Major(Color color, boolean alive, boolean covered) {
		super(color, alive, covered);
		description = "Der Major liegt mit seiner Stärke im oberen Drittel der Spielfiguren.";
		name = "Major";
		motion = Motion.MOVABLE;
                //TODO add imgurl
		imgurl = "";
		this.beatenby = new ArrayList<String>();
		beatenby.add("Marshal");
		beatenby.add("General");
		beatenby.add("Colonel");
		beatenby.add("Major");
		beatenby.add("Bomb");
	}
}