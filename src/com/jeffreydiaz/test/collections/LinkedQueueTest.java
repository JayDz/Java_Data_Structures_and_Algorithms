package com.jeffreydiaz.test.collections;

import com.jeffreydiaz.collections.LinkedQueue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Test class for LinkedQueue.
 * @author Jeffrey Diaz
 */
public class LinkedQueueTest {

	private LinkedQueue<String> queue;

	@Before
	public void setUp()
	{
		queue = new LinkedQueue<String>();
	}

	@After
	public void tearDown()
	{
		queue = null;
	}

	@Test
	public void CreateEmptyQueue()
	{
		assertTrue(queue.isEmpty());
		assertTrue(queue.size() == 0);
	}

	@Test
	public void TestAddingAndRemovingItems()
	{
		for (int i = 0; i < 1000; ++i) {
			queue.enqueue(Integer.toString(i));
		}

		assertFalse(queue.isEmpty());
		assertTrue(queue.size() == 1000);

		for (int i = 0; i < 1000; ++i) {
			assertTrue(queue.dequeue().equals(Integer.toString(i)));
		}

		assertTrue(queue.isEmpty());
		assertTrue(queue.size() == 0);
	}

	@Test
	public void TestQueueIterator()
	{
		for (int i = 0; i < 1000; ++i) {
			queue.enqueue(Integer.toString(i));
		}

		int i = 0;
		for (String val : queue) {
			assertTrue(val.equals(Integer.toString(i)));
			++i;
		}
	}
}