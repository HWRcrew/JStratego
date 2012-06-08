/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pieces;

import java.util.ArrayList;

/**
 *
 * @author sebastiangrosse
 */
public class Scout extends Piece{

	public Scout(Color color, boolean alive, boolean covered) {
		super(color, alive, covered);
		description = "";
		name = "";
		motion = Motion.SUPERMOVABLE;
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
		beatenby.add("Bomb");
	}
	
}
