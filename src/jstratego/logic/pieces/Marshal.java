package jstratego.logic.pieces;

import java.util.ArrayList;

/**
 *
 * @author sebastiangrosse
 */
public class Marshal extends Piece {

	public Marshal(Color color, boolean alive, boolean covered) {
		super(color, alive, covered);
		description = "Der Feldmarschall ist die stärkste Figur im Spiel. Spione stellen für ihn allerdings eine große Gefahr dar.";
		name = "Feldmarschall";
		motion = Motion.MOVABLE;
                //TODO add imgurl
		imgurl = "";
		this.beatenby = new ArrayList<String>();
		beatenby.add("Marshal");
		beatenby.add("Spy");
		beatenby.add("Bomb");
	}
}