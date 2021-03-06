package com.jeffreydiaz.test.sorting;

import com.jeffreydiaz.sorting.Merge;

import org.junit.Ignore;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.assertTrue;

/**
 * Test class for Merge.
 * @author Jeffrey Diaz
 */
public class MergeTest {

	@Test
	public void TestSorting()
	{
		Integer[] values = new Integer[1000];
		Random random = new Random();

		for (int i = 0; i < values.length; ++i) {
			values[i] = random.nextInt();
		}

		Merge.sort(values);
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