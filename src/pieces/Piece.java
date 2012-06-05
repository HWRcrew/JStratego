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

	public Piece(String name, String description, ArrayList<String> beatenby) {
		NAME = name;
		DESCRIPTION = description;
		BEATENBY = beatenby;
	}
}