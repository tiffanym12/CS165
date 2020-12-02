import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class TestCases {

	//Switch which line is commented out in order to test the correct vs broken code
	//TestingFunctions functions = new BlackBoxCorrect();
	//TestingFunctions functions = new BlackBoxIncorrect();
	TestingFunctions functions = new MyFunction();
	
	/**
	 * This is a simple validity check for the method greatestCommonDivisor. Checks that the method
	 * returns the correct result for a known GCD problem gcd(2,4) = 2
	 */
	@Test
	public void testGCD() {
		assertEquals("Error: should return 2", 2, functions.greatestCommonDivisor(2, 4));
	}
	@Test
	public void testGCDZero() {
		assertEquals("Error: should return 7", 7, functions.greatestCommonDivisor(0, 7));
	}
	@Test
	public void testGCDNegative() {
		assertEquals("Error: should return -1", -1, functions.greatestCommonDivisor(0, -3));
		
	}
	@Test
	public void testEqual() {
		assertEquals("Error: should return 50", 50, functions.greatestCommonDivisor(50, 100));
	}
	/**
	 * This is a simple check of the reverseWindow method. Checks if the method will reverse the entire contents
	 * of the passed array correctly.
	 */
	@Test
	public void testReverseWindow() {
		int[] arr = {0,1,2,3,4};
		int [] expected = {4,3,2,1,0};
		functions.reverseWindow(arr,0,5);
		assertArrayEquals("Error: should be {4,3,2,1,0}", expected, arr);
	}
	@Test(expected = IndexOutOfBoundsException.class)
	public void IndexOutOfBounds() {
		int[] arr = {0,1,2,3,4};
		int[] rev = {4,3,2,1,0};
		functions.reverseWindow(arr, -3, 5);
		assertArrayEquals("Error: should be {4,3,2,1,0}", rev, arr);
	}
	@Test
	public void testEmpty() {
		int[] arr = {};
		int [] expected = {};
		functions.reverseWindow(arr, 0, 0);
		assertArrayEquals("Error: should be {}", expected, arr);
	}
	@Test
	public void test() {
		int [] arr = new int [] {1};
		functions.reverseWindow(arr, 0, 1);
		assertEquals("Error: should return equal [1]", 1, functions.greatestCommonDivisor(0, 1));
	}

	//For completion, write additonal tests as described in the lab documentation.
}
