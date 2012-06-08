/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pieces;

import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author sebastiangrosse
 */
public class FlagTest {
	
	public FlagTest() {
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
	 * Test of isWinner method, of class Flag.
	 */
	@Test
	public void testIsWinner() {
		System.out.println("isWinner");
		Object attacker = null;
		Flag instance = null;
		boolean expResult = false;
		boolean result = instance.isWinner(attacker);
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}
}
