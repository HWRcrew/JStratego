/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jstratego.logic.game;

import java.util.List;
import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author sebastiangrosse
 */
public class PlayBoardTest {
	
	public PlayBoardTest() {
	}

	@BeforeClass
	public static void setUpClass() throws Exception {
	}

	@AfterClass
	public static void tearDownClass() throws Exception {
	}
	
	@Before
	public void setUp() {
	}
	
	@After
	public void tearDown() {
	}

	/**
	 * Test of setFields method, of class PlayBoard.
	 */
	@Test
	public void testSetFields() {
		System.out.println("setFields");
		PlayBoard instance = new PlayBoard();
		instance.setFields();
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of blockFieldsForSetup method, of class PlayBoard.
	 */
	@Test
	public void testBlockFieldsForSetup() {
		System.out.println("blockFieldsForSetup");
		PlayBoard instance = new PlayBoard();
		instance.blockFieldsForSetup();
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of unblockFieldsForSetup method, of class PlayBoard.
	 */
	@Test
	public void testUnblockFieldsForSetup() {
		System.out.println("unblockFieldsForSetup");
		PlayBoard instance = new PlayBoard();
		instance.unblockFieldsForSetup();
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of reachableFields method, of class PlayBoard.
	 */
	@Test
	public void testReachableFields() {
		System.out.println("reachableFields");
		Field field = null;
		PlayBoard instance = new PlayBoard();
		List expResult = null;
		List result = instance.reachableFields(field);
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}
}
