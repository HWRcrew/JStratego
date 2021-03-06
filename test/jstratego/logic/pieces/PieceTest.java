/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jstratego.logic.pieces;

import jstratego.logic.game.GameState;
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
		Major major = new Major(ColorEnum.RED, true, true);
		Marshal marshal = new Marshal(ColorEnum.RED, true, true);
		Scout scout = new Scout(ColorEnum.RED, true, true);
		Miner miner = new Miner(ColorEnum.RED, true, true);
		Spy spy = new Spy(ColorEnum.RED, true, true);
		General general = new General(ColorEnum.RED, true, true);
		Bomb bomb = new Bomb(ColorEnum.RED, true, true);

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
		Major major = new Major(ColorEnum.RED, true, true);
		Marshal marshal = new Marshal(ColorEnum.RED, true, true);
		Scout scout = new Scout(ColorEnum.RED, true, true);
		Miner miner = new Miner(ColorEnum.RED, true, true);
		Spy spy = new Spy(ColorEnum.RED, true, true);
		General general = new General(ColorEnum.RED, true, true);
		Bomb bomb = new Bomb(ColorEnum.RED, true, true);
		GameState gameState = new GameState();
		
		System.out.println("general fights against bomb!");
		Piece defender = bomb;
		Piece instance = general;
		instance.fightAgainst(defender, gameState);
		boolean expResult = true;
		assertEquals(expResult, defender.isAlive());
		expResult = false;
		assertEquals(expResult, instance.isAlive());
		assertEquals(bomb, gameState.getDefender());
		assertEquals(general, gameState.getChallenger());
		
		System.out.println("major fights against bomb!");
		defender = bomb;
		instance = major;
		instance.fightAgainst(defender, gameState);
		expResult = true;
		assertEquals(expResult, defender.isAlive());
		expResult = false;
		assertEquals(expResult, instance.isAlive());
		assertEquals(bomb, gameState.getDefender());
		assertEquals(major, gameState.getChallenger());
		
		System.out.println("spy fights against marshal!");
		defender = marshal;
		instance = spy;
		instance.fightAgainst(defender, gameState);
		expResult = false;
		assertEquals(expResult, defender.isAlive());
		expResult = true;
		assertEquals(expResult, instance.isAlive());
		
		System.out.println("miner fights against bomb!");
		defender = bomb;
		instance = miner;
		instance.fightAgainst(defender, gameState);
		expResult = false;
		assertEquals(expResult, defender.isAlive());
		expResult = true;
		assertEquals(expResult, instance.isAlive());
		
		System.out.println("marshal fights against marshal!");
		defender = marshal;
		instance = marshal;
		instance.fightAgainst(defender, gameState);
		expResult = false;
		assertEquals(expResult, defender.isAlive());
		expResult = false;
		assertEquals(expResult, instance.isAlive());
		
		System.out.println("miner fights against miner!");
		defender = miner;
		instance = miner;
		instance.fightAgainst(defender, gameState);
		expResult = false;
		assertEquals(expResult, defender.isAlive());
		expResult = false;
		assertEquals(expResult, instance.isAlive());
	}
}