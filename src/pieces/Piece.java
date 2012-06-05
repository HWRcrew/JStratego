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
public abstract class Piece {

	static private String NAME;
	static private String DESCRIPTION;
	static private ArrayList<String> BEATENBY;
	private String color;
	static private String imgurl;
	//TODO entscheiden ob diese Eigenschaften unnütz sind.
	private boolean alive;
	private boolean covered;
	private boolean movable;

	public Piece(String name, String description, ArrayList<String> beatenby, String c, String iurl) {
		NAME = name;
		DESCRIPTION = description;
		BEATENBY = beatenby;
		color = c;
		imgurl = iurl;
	}
}