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
public class Feldmarshall extends Spielfigur {

	@Override
	public void setMovable(boolean movable) {
		super.setMovable(true);
	}

	@Override
	public void setName(String name) {
		super.setName("Feldmarshall");
	}
}