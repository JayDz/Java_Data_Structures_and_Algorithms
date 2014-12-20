package com.jeffreydiaz.test.search;

import com.jeffreydiaz.search.BinarySearch;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test class for BinarySearch
 * @author Jeffrey Diaz
 */
public class BinarySearchTest {

	@Test
	public void TestBinarySearchWithFoundItem()
	{
		Integer[] items = getIntegerArray();
		boolean found = BinarySearch.search(items, 40);

		assertTrue(found);
	}

	@Test
	public void TestBinarySearchWithItemNotFound()
	{
		Integer[] items = getIntegerArray();
		boolean found = BinarySearch.search(items, 0);

		assertFalse(found);
	}

	private Integer[] getIntegerArray()
	{
		return new Integer[] {12, 15, 20, 40, 50, 100, 400, 405, 500};
	}
}