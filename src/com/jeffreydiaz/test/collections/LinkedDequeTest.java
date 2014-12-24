package com.jeffreydiaz.test.collections;

import com.jeffreydiaz.collections.LinkedDeque;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Test class for LinkedDeque.
 * @author Jeffrey Diaz
 */
public class LinkedDequeTest {

	private LinkedDeque<Integer> deque;

	@Before
	public void setUp()
	{
		deque = new LinkedDeque<Integer>();
	}

	@After
	public void tearDown()
	{
		deque = null;
	}

	@Test
	public void CreateEmptyDeque()
	{
		assertTrue(deque.isEmpty());
		assertTrue(deque.size() == 0);
		assertTrue(deque.remove() == null);
		assertTrue(deque.removeBack() == null);
	}

	@Test
	public void InsertNullItemsAndVerifySizeIsZero()
	{
		deque.append(null);
		deque.prepend(null);

		assertTrue(deque.isEmpty());
		assertTrue(deque.size() == 0);
	}

	@Test
	public void InsertItemsAndVerifySize()
	{
		deque.append(10);
		deque.prepend(20);
		deque.append(30);

		assertTrue(deque.size() == 3);
		assertFalse(deque.isEmpty());
	}

	@Test
	public void InsertItemsThenRemoveAndVerifySize()
	{
		deque.append(10);
		deque.append(20);
		deque.prepend(30);

		deque.remove();
		deque.removeBack();

		assertTrue(deque.size() == 1);
	}

	@Test
	public void TestPeekingAtFrontItem()
	{
		deque.append(10);
		deque.prepend(20);
		deque.prepend(30);

		assertTrue(deque.front().equals(30));
	}

	@Test
	public void TestPeekingAtBackItem()
	{
		deque.append(10);
		deque.prepend(20);
		deque.prepend(30);

		assertTrue(deque.back().equals(10));
	}

	@Test
	public void RemoveFromEmptyDeque()
	{
		assertEquals("Not null", null, deque.remove());
		assertEquals("Not null", null, deque.removeBack());
	}

	@Test
	public void VerifyInsertingAndDeletingLogic()
	{
		// deque layout: 1, 54, 30, 20, 10, 100, 45
		deque.append(10);
		deque.prepend(20);
		deque.prepend(30);
		deque.prepend(54);
		deque.append(100);
		deque.append(45);
		deque.prepend(null);
		deque.prepend(1);

		assertTrue(deque.remove().equals(1));
		// deque layout: 54, 30, 20, 10, 100, 45

		assertTrue(deque.removeBack().equals(45));
		// deque layout: 54, 30, 20, 10, 100

		assertTrue(deque.removeBack().equals(100));
		// deque layout: 54, 30, 20, 10

		assertTrue(deque.removeBack().equals(10));
		// deque layout: 54, 30, 20

		assertTrue(deque.removeBack().equals(20));
		// deque layout: 54, 30

		assertTrue(deque.remove().equals(54));
		// deque layout: 30

		assertTrue(deque.remove().equals(30));
		// deque layout: empty

		assertTrue(deque.isEmpty());
	}
}