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
	 * Test of getName method, of class Player.
	 */
	@Test
	public void testGetName() {
		System.out.println("getName");
		Player instance = new Player("Basti", Color.RED);
		String expResult = "Basti";
		String result = instance.getName();
		assertEquals(expResult, result);
	}

	/**
	 * Test of getPlayerColor method, of class Player.
	 */
	@Test
	public void testGetPlayerColor() {
		System.out.println("getPlayerColor red");
		Player instance = new Player("Basti", Color.RED);
		Color expResult = Color.RED;
		Color result = instance.getPlayerColor();
		assertEquals(expResult, result);

		System.out.println("getPlayerColor blue");
		instance = new Player("Basti", Color.BLUE);
		expResult = Color.BLUE;
		result = instance.getPlayerColor();
		assertEquals(expResult, result);
	}

	/**
	 * Test of getPiece method, of class Player.
	 */
	@Test
	public void testGetPiece() {
		System.out.println("getPiece Marshal");
		String className = "Marshal";
		Player instance = new Player("Basti", Color.RED);
		Piece expResult = instance.getPieces().get(0);
		Piece result = instance.getPiece(className);
		assertEquals(expResult, result);
		
		System.out.println("getPiece Colonel");
		className = "Colonel";
		instance = new Player("Basti", Color.RED);
		expResult = instance.getPieces().get(2);
		result = instance.getPiece(className);
		assertEquals(expResult, result);
		
		System.out.println("getPiece Flag");
		className = "Flag";
		instance = new Player("Basti", Color.RED);
		expResult = instance.getPieces().get(39);
		result = instance.getPiece(className);
		assertEquals(expResult, result);
		
	}

	/**
	 * Test of getLeftNumberOfPieceInList method, of class Player.
	 */
	@Test
	public void testGetLeftNumberOfPieceInList() {
		System.out.println("getLeftNumberOfPieceInList Colonel");
		Player instance = new Player("Basti", Color.RED);
		Piece piece = instance.getPieces().get(3);
		int expResult = 2;
		int result = instance.getLeftNumberOfPieceInList(piece);
		assertEquals(expResult, result);
		
		System.out.println("getLeftNumberOfPieceInList Flag");
		instance = new Player("Basti", Color.RED);
		piece = instance.getPieces().get(39);
		expResult = 1;
		result = instance.getLeftNumberOfPieceInList(piece);
		assertEquals(expResult, result);
	}
}
