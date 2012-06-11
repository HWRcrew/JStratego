package jstratego.pieces;

import java.util.ArrayList;

/**
 *
 * @author sebastiangrosse
 */
public class Sergeant extends Piece {

	public Sergeant(Color color, boolean alive, boolean covered) {
		super(color, alive, covered);
		description = "Der Unteroffizier liegt mit seiner Stärke im unteren Drittel der Figuren.";
		name = "Unteroffizier";
		motion = Motion.MOVABLE;
		// TODO add imgurl
		imgurl = "";
		beatenby = new ArrayList<String>();
		beatenby.add("Marshal");
		beatenby.add("General");
		beatenby.add("Colonel");
		beatenby.add("Major");
		beatenby.add("Captain");
		beatenby.add("Lieutenant");
		beatenby.add("Sergeant");
		beatenby.add("Bomb");
	}

	@Override
	public boolean isWinnerAgainst(Object challenger) {
		if (Sergeant.beatenby.contains(challenger.getClass().toString())) {
			return false;
		} else {
			return true;
		}
	}
}
