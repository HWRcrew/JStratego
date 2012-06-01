/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package spielfiguren;

import com.sun.tools.javac.util.List;
import java.util.ArrayList;

/**
 *
 * @author sebastiangrosse
 */
public class Spielfigur {

	private String name;
	private boolean movable;
	private ArrayList<String> beatenby;

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the movable
	 */
	public boolean isMovable() {
		return movable;
	}

	/**
	 * @param movable the movable to set
	 */
	public void setMovable(boolean movable) {
		this.movable = movable;
	}

	/**
	 * @return the beatenby
	 */
	public ArrayList<String> getBeatenby() {
		return beatenby;
	}

	/**
	 * @param beatenby the beatenby to set
	 */
	public void setBeatenby(ArrayList<String> beatenby) {
		this.beatenby = beatenby;
	}
}
