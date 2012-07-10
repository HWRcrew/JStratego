/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jstratego.pieces;

import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author sebastiangrosse
 */
public class PieceTest {

	public PieceTest() {
	}

	@After
	public void tearDown() {
	}

	/**
	 * Test of isLoserAgainst method, of class Piece.
	 */
	@Test
	public void testIsLoserAgainst() {
		Major major = new Major(Color.RED, true, true);
		Marshal marshal = new Marshal(Color.RED, true, true);
		Scout scout = new Scout(Color.RED, true, true);
		Miner miner = new Miner(Color.RED, true, true);
		Spy spy = new Spy(Color.RED, true, true);
		General general = new General(Color.RED, true, true);
		Bomb bomb = new Bomb(Color.RED, true, true);

		System.out.println("isLoserAgainst 1");
		Piece challenger = marshal;
		Piece instance = marshal;
		boolean expResult = true;
		boolean result = instance.isLoserAgainst(challenger);
		assertEquals(expResult, result);

		System.out.println("isLoserAgainst 2");
		challenger = spy;
		instance = marshal;
		expResult = true;
		result = instance.isLoserAgainst(challenger);
		assertEquals(expResult, result);

		System.out.println("isLoserAgainst 3");
		challenger = scout;
		instance = general;
		expResult = false;
		result = instance.isLoserAgainst(challenger);
		assertEquals(expResult, result);

		System.out.println("isLoserAgainst 4");
		challenger = marshal;
		instance = bomb;
		expResult = false;
		result = instance.isLoserAgainst(challenger);
		assertEquals(expResult, result);

		System.out.println("isLoserAgainst 5");
		challenger = bomb;
		instance = marshal;
		expResult = true;
		result = instance.isLoserAgainst(challenger);
		assertEquals(expResult, result);

		System.out.println("isLoserAgainst 6");
		challenger = marshal;
		instance = spy;
		expResult = false;
		result = instance.isLoserAgainst(challenger);
		assertEquals(expResult, result);
	}

	/**
	 * Test of fightAgainst method, of class Piece.
	 */
	@Test
	public void testFightAgainst() {
		System.out.println("fightAgainst");
		Piece defender = null;
		Piece instance = null;
		instance.fightAgainst(defender);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	public class PieceImpl extends Piece {

		public PieceImpl() {
			super(null, false, false);
		}
	}
}