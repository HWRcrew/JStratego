package jstratego.logic.pieces;

import java.util.ArrayList;

/**
 *
 * @author sebastiangrosse
 */
public class General extends Piece {

	public General(Color color, boolean alive, boolean covered) {
		super(color, alive, covered);
		description = "Der General ist die zweitstärkste Figur im Spiel.";
		name = "General";
		motion = Motion.MOVABLE;
		this.beatenby = new ArrayList<String>();
		beatenby.add("Marshal");
		beatenby.add("General");
		beatenby.add("Bomb");
	}
}