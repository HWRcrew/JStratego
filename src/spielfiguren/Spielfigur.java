/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package spielfiguren;

import com.sun.tools.javac.util.List;

/**
 *
 * @author sebastiangrosse
 */
public class Spielfigur {

	private String name;
	private List<Spielfigur> beatenby;
	private boolean movable;

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
	 * @return the beatenby
	 */
	public List<Spielfigur> getBeatenby() {
		return beatenby;
	}

	/**
	 * @param beatenby the beatenby to set
	 */
	public void setBeatenby(List<Spielfigur> beatenby) {
		this.beatenby = beatenby;
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
}
