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
public class Flag extends Piece {

	public Flag(Color color, boolean alive, boolean covered) {
		super(color, alive, covered);
		description = "Die Flagge muss zum Sieg des Spiels erobert werden. Sie muss bis aufs Letzte verteidigt werden.";
		name = "Flagge";
		motion = Motion.UNMOVABLE;
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
		beatenby.add("Miner");
		beatenby.add("Scout");
		beatenby.add("Spy");
		beatenby.add("Bomb");
	}

	@Override
	public boolean isWinnerAgainst(Object challenger) {
		if (Flag.beatenby.contains(challenger.getClass().getName())) {
			return false;
		} else {
			return true;
		}
	}
}