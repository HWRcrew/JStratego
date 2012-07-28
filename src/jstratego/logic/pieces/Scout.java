package jstratego.logic.pieces;

import java.util.ArrayList;

/**
 *
 * @author sebastiangrosse
 */
public class Scout extends Piece {

	public Scout(Color color, boolean alive, boolean covered) {
		super(color, alive, covered);
		description = "Der Aufklärer kann nicht durch seine Stärke überzeugen, dafür aber mehrere Felder weit ziehen.";
		name = "Aufklärer";
		motion = Motion.SUPERMOVABLE;
                //TODO add imgurl
		imgurl = "";
		this.beatenby = new ArrayList<String>();
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