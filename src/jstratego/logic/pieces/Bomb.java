package jstratego.logic.pieces;

import java.util.ArrayList;

/**
 *
 * @author sebastiangrosse
 */
public class Bomb extends Piece {

	public Bomb(Color color, boolean alive, boolean covered) {
		super(color, alive, covered);
		description = "Bomben zerstören jeden Angreifer, außer den Mineuren. Die Bombe kann nur durch einen Mineur entfernt werden.";
		name = "Bombe";
		motion = Motion.UNMOVABLE;
		// TODO add imgurl
		imgurl = "";
		beatenby = new ArrayList<String>();
		beatenby.add("Miner");
	}
}