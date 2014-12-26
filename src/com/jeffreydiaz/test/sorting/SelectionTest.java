package com.jeffreydiaz.test.sorting;

import com.jeffreydiaz.sorting.Selection;

import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.assertTrue;

/**
 * Test class for Selection.
 * @author Jeffrey Diaz
 */
public class SelectionTest {

	@Test
	public void TestSorting()
	{
		Integer[] values = new Integer[1000];
		Random random = new Random();

		for (int i = 0; i < values.length; ++i) {
			values[i] = random.nextInt();
		}

		Selection.sort(values);
		assertTrue(isSorted(values));
	}

	private boolean isSorted(Integer[] values)
	{
		for (int i = 1; i < values.length; ++i) {
			if (values[i] < values[i-1]) {
				return false;
			}
		}
		return true;
	}
}