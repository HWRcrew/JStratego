/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jstratego.logic.pieces;

import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author sebastiangrosse
 */
public class PieceTest {
	/**
	 * Test of isBeatenBy method, of class Piece.
	 */
	@Test
	public void testisBeatenBy() {
		Major major = new Major(Color.RED, true, true);
		Marshal marshal = new Marshal(Color.RED, true, true);
		Scout scout = new Scout(Color.RED, true, true);
		Miner miner = new Miner(Color.RED, true, true);
		Spy spy = new Spy(Color.RED, true, true);
		General general = new General(Color.RED, true, true);
		Bomb bomb = new Bomb(Color.RED, true, true);

		System.out.println("marshal is beaten by marshal?");
		Piece challenger = marshal;
		Piece instance = marshal;
		boolean expResult = true;
		boolean result = instance.isBeatenBy(challenger);
		assertEquals(expResult, result);

		System.out.println("marshal is beaten by spy?");
		challenger = spy;
		instance = marshal;
		expResult = true;
		result = instance.isBeatenBy(challenger);
		assertEquals(expResult, result);

		System.out.println("general is beaten by scout?");
		challenger = scout;
		instance = general;
		expResult = false;
		result = instance.isBeatenBy(challenger);
		assertEquals(expResult, result);

		System.out.println("bomb is beaten by marshal?");
		challenger = marshal;
		instance = bomb;
		expResult = false;
		result = instance.isBeatenBy(challenger);
		assertEquals(expResult, result);

		System.out.println("marshal is beaten by bomb?");
		challenger = bomb;
		instance = marshal;
		expResult = true;
		result = instance.isBeatenBy(challenger);
		assertEquals(expResult, result);

		System.out.println("spy is beaten by marshal?");
		challenger = marshal;
		instance = spy;
		expResult = true;
		result = instance.isBeatenBy(challenger);
		assertEquals(expResult, result);
		
		System.out.println("bomb is beaten by miner?");
		challenger = miner;
		instance = bomb;
		expResult = true;
		result = instance.isBeatenBy(challenger);
		assertEquals(expResult, result);
		
		System.out.println("bomb is beaten by major?");
		challenger = major;
		instance = bomb;
		expResult = false;
		result = instance.isBeatenBy(challenger);
		assertEquals(expResult, result);
		
		System.out.println("miner is beaten by major?");
		challenger = major;
		instance = miner;
		expResult = true;
		result = instance.isBeatenBy(challenger);
		assertEquals(expResult, result);
	}

	/**
	 * Test of fightAgainst method, of class Piece.
	 */
	@Test
	public void testFightAgainst() {
		Major major = new Major(Color.RED, true, true);
		Marshal marshal = new Marshal(Color.RED, true, true);
		Scout scout = new Scout(Color.RED, true, true);
		Miner miner = new Miner(Color.RED, true, true);
		Spy spy = new Spy(Color.RED, true, true);
		General general = new General(Color.RED, true, true);
		Bomb bomb = new Bomb(Color.RED, true, true);
		
		System.out.println("general fights against bomb!");
		Piece defender = bomb;
		Piece instance = general;
		instance.fightAgainst(defender, null);
		boolean expResult = true;
		assertEquals(expResult, defender.alive);
		expResult = false;
		assertEquals(expResult, instance.alive);
		
		System.out.println("major fights against bomb!");
		defender = bomb;
		instance = major;
		instance.fightAgainst(defender, null);
		expResult = true;
		assertEquals(expResult, defender.alive);
		expResult = false;
		assertEquals(expResult, instance.alive);
		
		System.out.println("spy fights against marshal!");
		defender = marshal;
		instance = spy;
		instance.fightAgainst(defender, null);
		expResult = false;
		assertEquals(expResult, defender.alive);
		expResult = true;
		assertEquals(expResult, instance.alive);
		
		System.out.println("miner fights against bomb!");
		defender = bomb;
		instance = miner;
		instance.fightAgainst(defender, null);
		expResult = false;
		assertEquals(expResult, defender.alive);
		expResult = true;
		assertEquals(expResult, instance.alive);
		
		System.out.println("marshal fights against marshal!");
		defender = marshal;
		instance = marshal;
		instance.fightAgainst(defender, null);
		expResult = false;
		assertEquals(expResult, defender.alive);
		expResult = false;
		assertEquals(expResult, instance.alive);
		
		System.out.println("miner fights against miner!");
		defender = miner;
		instance = miner;
		instance.fightAgainst(defender, null);
		expResult = false;
		assertEquals(expResult, defender.alive);
		expResult = false;
		assertEquals(expResult, instance.alive);
	}
}