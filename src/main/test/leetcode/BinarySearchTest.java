package leetcode;

import org.junit.Test;

import junit.framework.TestCase;

public class BinarySearchTest extends TestCase {
	BinarySearch bs = new BinarySearch();

	@Test
	public void test() {
		int[] array = {-1,0,3,5,9,12};
		int elm = 9;

		final int result = bs.search(array, elm);
		assertTrue(result == 4);
	}

}