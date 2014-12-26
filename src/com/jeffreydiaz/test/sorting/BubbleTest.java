package com.jeffreydiaz.test.sorting;

import com.jeffreydiaz.sorting.Bubble;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.Random;

/**
 * Test class for Bubble sort method.
 * @author Jeffrey Diaz
 */
public class BubbleTest {

	@Test
	public void TestSorting()
	{
		Integer[] values = new Integer[1000];
		Random random = new Random();

		for (int i = 0; i < values.length; ++i) {
			values[i] = random.nextInt();
		}

		Bubble.sort(values);
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