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
public class Marshal extends Piece {

	public Marshal(Color color, boolean alive, boolean covered) {
		super(color, alive, covered);
		// TODO descr + name
		description = "";
		name = "";
		motion = Motion.MOVABLE;
		imgurl = "";
		beatenby = new ArrayList<String>();
		beatenby.add("Marshal");
		beatenby.add("Spy");
		beatenby.add("Bomb");
	}

	@Override
	public boolean isWinnerAgainst(Object challenger) {
		if (Marshal.beatenby.contains(challenger.getClass().toString())) {
			return false;
		} else {
			return true;
		}
	}
}
