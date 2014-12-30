package com.jeffreydiaz.test.collections;

import com.jeffreydiaz.collections.MaxPQ;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;
import java.util.Random;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Test class for MaxPQ.
 * @author Jeffrey Diaz.
 */
public class MaxPQTest {

	private MaxPQ<Integer> pq;

	@Before
	public void setUp()
	{
		pq = new MaxPQ<Integer>();
	}

	@After
	public void tearDown()
	{
		pq = null;
	}

	@Test
	public void CreateEmptyPQ()
	{
		assertTrue(pq.isEmpty());
		assertTrue(pq.size() == 0);
	}

	@Test
	public void InsertNullsAndValidateSizeIsZero()
	{
		pq.insert(null);
		pq.insert(null);

		assertTrue(pq.isEmpty());
		assertTrue(pq.size() == 0);
	}

	@Test
	public void InsertValuesAndValidateCorrectSize()
	{
		pq.insert(10);
		pq.insert(20);

		assertFalse(pq.isEmpty());
		assertTrue(pq.size() == 2);
	}

	@Test
	public void InsertAndRemoveValuesThenValidateZeroSize()
	{
		pq.insert(10);
		pq.insert(20);
		pq.remove();
		pq.remove();

		assertTrue(pq.isEmpty());
		assertTrue(pq.size() == 0);
	}

	@Test
	public void ValidatePQLogicWithRemoves()
	{
		int i;
		for (i = 0; i < 100; ++i) {
			pq.insert(i);
		}

		for (int j = 0; j < pq.size(); ++j) {
			assertTrue(pq.remove().equals(--i));
		}
	}

	@Test
	public void ValidatePQLogicWithIterator()
	{
		pq.insert(13);
		pq.insert(13);
		pq.insert(29);
		pq.insert(26);
		pq.insert(14);
		pq.insert(10);
		pq.insert(16);
		pq.insert(13);
		pq.insert(27);
		pq.insert(12);

		// expected heap layout: [29,27,16,26,14,10,13,13,13,12]
		Iterator<Integer> iterator = pq.iterator();
		assertTrue(iterator.next().equals(29));
		assertTrue(iterator.next().equals(27));
		assertTrue(iterator.next().equals(16));
		assertTrue(iterator.next().equals(26));
		assertTrue(iterator.next().equals(14));
		assertTrue(iterator.next().equals(10));
		assertTrue(iterator.next().equals(13));
		assertTrue(iterator.next().equals(13));
		assertTrue(iterator.next().equals(13));
		assertTrue(iterator.next().equals(12));
		assertFalse(iterator.hasNext());
	}

	@Test
	public void InsertAndRemoveRandomValues()
	{
		Random random = new Random();
		for (int i = 0; i < 10000; ++i) {
			pq.insert(random.nextInt(100) + 10);
		}

		int prev = pq.remove();
		while (!pq.isEmpty()) {
			int curr = pq.remove();
			assertTrue(prev >= curr);
			prev = curr;
		}
	}
}