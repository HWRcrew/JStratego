/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jstratego.logic.game;

import jstratego.logic.pieces.Captain;
import jstratego.logic.pieces.Colonel;
import jstratego.logic.pieces.ColorEnum;
import jstratego.logic.pieces.Piece;
import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author sebastiangrosse
 */
public class FieldTest {

	/**
	 * Test of setPiece method, of class Field.
	 */
	@Test
	public void testSetPiece() {
		System.out.println("setPiece");
		Piece piece = new Captain(ColorEnum.RED, true, false);
		GameState gameState = new GameState();
		gameState.setPlayerWithMove(new Player("Basti", ColorEnum.RED));
		Field instance = new Field(null, false, 0, 0);
		instance.setPiece(piece, gameState);
		assertEquals(piece, instance.getPiece());
	}

	/**
	 * Test of getPiece method, of class Field.
	 */
	@Test
	public void testGetPiece() {
		System.out.println("getPiece");
		Piece piece = new Colonel(ColorEnum.RED, true, true);
		Field instance = new Field(piece, true, 0, 9);
		Piece expResult = piece;
		Piece result = instance.getPiece();
		assertEquals(expResult, result);
	}
}
