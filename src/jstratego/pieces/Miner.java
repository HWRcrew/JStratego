/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
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
		beatenby = new ArrayList<String>();
		beatenby.add("Marshal");
		beatenby.add("General");
		beatenby.add("Colonel");
		beatenby.add("Major");
		beatenby.add("Captain");
		beatenby.add("Lieutenant");
		beatenby.add("Sergeant");
		beatenby.add("Miner");
	}

	@Override
	public boolean isWinnerAgainst(Object challenger) {
		if (Miner.beatenby.contains(challenger.getClass().toString())) {
			return false;
		} else {
			return true;
		}
	}
}
