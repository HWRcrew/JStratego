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
public class Flag extends Piece {

	public Flag(String name, String description, ArrayList<String> beatenby, String c, String iurl) {
		super(name, description, beatenby, c, iurl);
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
	// TODO beatenby-Liste erstellen und füllen.
}
