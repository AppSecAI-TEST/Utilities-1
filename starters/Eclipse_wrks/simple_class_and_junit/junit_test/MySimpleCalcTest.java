/**
 * 
 */
package junit_test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class MySimpleCalcTest {
	private MySimpleCalc mc = null;
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
			mc = new MySimpleCalc();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		mc = null;
	}

	/**
	 * Test method for {@link junit_test.MySimpleCalc#add(int, int)}.
	 */
	@Test
	public void testAdd() {
		assert ((mc.add(3,4) == 7));
	}

	/**
	 * Test method for {@link junit_test.MySimpleCalc#substr(int, int)}.
	 */
	@Test
	public void testSubstr() {
		assert ((mc.add(3,4) == -1));
	}

	/**
	 * Test method for {@link junit_test.MySimpleCalc#mult(int, int)}.
	 */
	@Test
	public void testMult() {
		assert ((mc.mult(3,4) == 12));
	}

	/**
	 * Test method for {@link junit_test.MySimpleCalc#div(int, int)}.
	 */
	@Test
	public void testDiv() {
		fail("Not yet implemented");
	}

}
