package com.jeffreydiaz.test.collections;

import com.jeffreydiaz.collections.LinkedBag;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Test class for LinkedBag.
 * @author Jeffrey Diaz
 */
public class LinkedBagTest {

	private LinkedBag<Integer> bag;

	@Before
	public void setUp()
	{
		bag = new LinkedBag<Integer>();
	}

	@After
	public void tearDown()
	{
		bag = null;
	}

	@Test
	public void CreateEmptyBag()
	{
		assertTrue(bag.isEmpty());
		assertTrue(bag.size() == 0);
	}

	@Test
	public void AddItemsToBagAndVerifySize()
	{
		final int size = 100;
		for (int i = 0; i < size; ++i) {
			bag.add(i);
		}

		assertTrue(bag.size() == size);
	}

	@Test
	public void TestBagIteration()
	{
		for (int i = 0; i < 1000; ++i) {
			bag.add(i);
		}

		int i = 0;
		for (Integer val : bag) {
			assertTrue(val.equals(i));
			++i;
		}
	}
}