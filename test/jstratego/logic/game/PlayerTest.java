/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jstratego.logic.game;

import jstratego.logic.pieces.Color;
import jstratego.logic.pieces.Piece;
import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author sebastiangrosse
 */
public class PlayerTest {
	
	/**
	 * Test of getPiece method, of class Player.
	 */
	@Test
	public void testGetPiece() {
		System.out.println("getPiece"); 
		String typ = "Flagge";
		Player instance = new Player("Basti", Color.RED);
		Piece expResult = instance.getPieces().get(5);
		System.out.println(expResult.getNAME());
		Piece result = instance.getPiece(typ);
		System.out.println(result.getNAME());
		assertEquals(expResult, result);
	}
}
