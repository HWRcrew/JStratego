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
public class General extends Piece{

	public General(Color color, boolean alive, boolean covered) {
		super(color, alive, covered);
		// TODO description & name
		description = "";
		name = "";
		motion = Motion.MOVABLE;
		imgurl = "";
		beatenby = new ArrayList<String>();
		beatenby.add("Marshal");
		beatenby.add("General");
		beatenby.add("Bomb");
	}

	@Override
	public boolean isWinnerAgainst(Object challenger) {
		if (Flag.beatenby.contains(challenger.getClass().toString())) {
			return false;
		} else {
			return true;
		}
	}
	
}
