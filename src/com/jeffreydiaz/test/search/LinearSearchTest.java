package com.jeffreydiaz.test.search;

import com.jeffreydiaz.search.LinearSearch;

import org.junit.Test;

import java.util.Stack;

import static org.junit.Assert.*;

/**
 * Test class for LinearSearch
 * @author Jeffrey Diaz
 */
public class LinearSearchTest {

	@Test
	public void TestArraySearchForFoundItem()
	{
		Integer[] items = getIntegerArray();
		boolean found = LinearSearch.search(items, 12);

		assertTrue(found);
	}

	@Test
	public void TestArraySearchForItemNotFound()
	{
		Integer[] items = getIntegerArray();
		boolean found = LinearSearch.search(items, -12);

		assertFalse(found);
	}

	private Integer[] getIntegerArray()
	{
		return new Integer[] {5, 10, 12, 20, 65, 100, -14, - 40, 80, -100, 1, 0};
	}

	@Test
	public void TestIterableSearchForFoundItem()
	{
		Stack<Integer> stack = getFilledStack();
		boolean found = LinearSearch.search(stack, 12);

		assertTrue(found);
	}

	@Test
	public void TestIterableForItemNotFound()
	{
		Stack<Integer> stack = getFilledStack();
		boolean found = LinearSearch.search(stack, -12);

		assertFalse(found);
	}

	private Stack<Integer> getFilledStack()
	{
		Stack<Integer> stack = new Stack<Integer>();
		Integer[] items = getIntegerArray();
		for (Integer i : items) {
			stack.push(i);
		}

		return stack;
	}
}