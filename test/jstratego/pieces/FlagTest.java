package jstratego.pieces;

import org.junit.*;
import static org.junit.Assert.*;

/**
 * Testclass for attacks on the flag;
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
		Major major = new Major(Color.RED, true, true);
		
	}
	
	@After
	public void tearDown() {
	}

	/**
	 * Test of isWinnerAgainst method, of class Flag.
	 */
	@Test
	public void testIsWinnerAgainst() {
		System.out.println("isWinnerAgainst");
		Object challenger = new Major(Color.BLUE, true, true);
		Flag instance = new Flag(Color.RED, true, true);
		boolean expResult = true;
		boolean result = instance.isWinnerAgainst(challenger);
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
	}
}
