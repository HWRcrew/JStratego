package jstratego.pieces;

import java.util.ArrayList;

/**
 *
 * @author sebastiangrosse
 */
public class Captain extends Piece {

	public Captain(Color color, boolean alive, boolean covered) {
		super(color, alive, covered);
		// TODO description and Name in German
		description = "Der Hauptmann liegt mit seiner Stärke im oberen Drittel der Spielfiguren.";
		name = "Hauptmann";
		motion = Motion.MOVABLE;
		imgurl = "";
		beatenby = new ArrayList<String>();
		beatenby.add("Marshal");
		beatenby.add("General");
		beatenby.add("Colonel");
		beatenby.add("Major");
		beatenby.add("Captain");
		beatenby.add("Bomb");
	}
}