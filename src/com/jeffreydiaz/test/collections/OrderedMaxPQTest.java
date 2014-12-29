package com.jeffreydiaz.test.collections;

import com.jeffreydiaz.collections.OrderedMaxPQ;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

/**
 * Test class for OrderedMaxPQ.
 * @author Jeffrey Diaz
 */
public class OrderedMaxPQTest {

	private OrderedMaxPQ<Integer> pq;

	@Before
	public void setUp()
	{
		pq = new OrderedMaxPQ<Integer>();
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
		int i;
		for (i = 0; i < 100; ++i) {
			pq.insert(i);
		}

		for (Integer val : pq) {
			assertTrue(val.equals(--i));
		}
	}

	@Test
	public void InsertAndRemoveRandomValues()
	{
		Random random = new Random();
		for (int i = 0; i < 1000; ++i) {
			pq.insert(random.nextInt());
		}

		int prev = pq.remove();
		while (!pq.isEmpty()) {
			int curr = pq.remove();
			assertTrue(prev > curr);
			prev = curr;
		}
	}
}