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
public class Bomb extends Piece{

	public Bomb(Color color, boolean alive, boolean covered) {
		super(color, alive, covered);
		description = "Bomben zerstören jeden Angreifer, außer den Mineuren. Die Bombe wird durch einen Mineur entfernt.";
		name = "Bombe";
		motion = Motion.UNMOVABLE;
		// TODO add imgurl
		imgurl = "";
		beatenby = new ArrayList<String>();
		beatenby.add("Miner");
	}
	@Override
	public boolean isWinnerAgainst(Object challenger) {
		if (Bomb.beatenby.contains(challenger.getClass().toString())) {
			return false;
		} else {
			return true;
		}
	}

}
