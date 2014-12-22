package com.jeffreydiaz.test.collections;

import com.jeffreydiaz.collections.SinglyLinkedList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.*;

/**
 * Test class for SinglyLinkedList.
 */
public class SinglyLinkedListTest {

	private SinglyLinkedList<Integer> list;

	@Before
	public void setUp()
	{
		list = new SinglyLinkedList<Integer>();
	}

	@After
	public void tearDown()
	{
		list = null;
	}

	@Test
	public void CreateAnEmptyList()
	{
		assertTrue(list.isEmpty());
		assertTrue(list.size() == 0);
	}

	@Test
	public void TestPrependingItems()
	{
		list.prepend(10);
		list.prepend(20);
		list.prepend(30);
		list.prepend(40);
		list.prepend(50);

		assertFalse(list.isEmpty());
		assertTrue(list.size() == 5);
	}

	@Test
	public void TestAppendingItems()
	{
		list.append(10);
		list.append(20);
		list.append(30);
		list.append(40);
		list.append(50);

		assertFalse(list.isEmpty());
		assertTrue(list.size() == 5);
	}

	@Test
	public void TestPeekingAtFront()
	{
		list.append(10);
		int value = list.front();
		assertTrue(value == 10);

		list.append(20);
		value = list.front();
		assertTrue(value == 10);

		list.prepend(30);
		value = list.front();
		assertTrue(value == 30);
	}

	@Test
	public void TestPeekingAtBack()
	{
		int value;

		list.append(10);
		value = list.back();
		assertTrue(value == 10);

		list.append(20);
		value = list.back();
		assertTrue(value == 20);

		list.prepend(30);
		value = list.back();
		assertTrue(value == 20);
	}

	@Test
	public void TestRemovingItemsFromFront()
	{
		list.append(10);
		list.append(20);
		list.append(30);
		list.append(40);
		list.append(50);

		int value;

		value = list.remove();
		assertTrue(value == 10);
		assertTrue(list.size() == 4);

		value = list.remove();
		assertTrue(value == 20);
		assertTrue(list.size() == 3);

		value = list.remove();
		assertTrue(value == 30);
		assertTrue(list.size() == 2);

		value = list.remove();
		assertTrue(value == 40);
		assertTrue(list.size() == 1);

		value = list.remove();
		assertTrue(value == 50);
		assertTrue(list.size() == 0);
	}

	@Test
	public void TestRemovingItemsFromEmptyList()
	{
		Integer value = list.remove();
		assertNull(value);
	}

	@Test
	public void TestListIterator()
	{
		list.append(10);
		list.prepend(20);
		list.append(30);
		list.prepend(40);
		list.append(50);

		Iterator<Integer> iterator = list.iterator();

		int value;
		value = iterator.next();
		assertTrue(value == 40);

		value = iterator.next();
		assertTrue(value == 20);

		value = iterator.next();
		assertTrue(value == 10);

		value = iterator.next();
		assertTrue(value == 30);

		value = iterator.next();
		assertTrue(value == 50);

		assertFalse(iterator.hasNext());
	}

	@Test
	public void InsertNullItem()
	{
		list.prepend(null);
		list.append(null);

		assertTrue(list.isEmpty());
	}
}