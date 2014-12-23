package com.jeffreydiaz.test.collections;

import com.jeffreydiaz.collections.ArrayStack;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test class for ArrayStack.
 * @author Jeffrey Diaz
 */
public class ArrayStackTest {

	private ArrayStack<Integer> stack;

	@Before
	public void setUp()
	{
		stack = new ArrayStack<Integer>();
	}

	@After
	public void tearDown()
	{
		stack = null;
	}

	@Test
	public void CreateEmptyStack()
	{
		assertTrue(stack.isEmpty());
		assertEquals("Stack is not zero", 0, stack.size());
	}

	@Test
	public void TestPushingAndPopping()
	{
		int[] items = new int[1000];
		for (int i = 0; i < items.length; ++i) {
			items[i] = i;
			stack.push(i);
		}

		for (int i = items.length - 1; i >= 0; --i) {
			assertTrue(stack.pop().equals(items[i]));
		}
	}

	@Test
	public void PushTenItemsAndConfirmSize()
	{
		for (int i = 0; i < 10; ++i) {
			stack.push(i);
		}

		assertFalse(stack.isEmpty());
		assertEquals("Stack size is not 10", 10, stack.size());
	}

	@Test
	public void PopAllItemsAndConfirmSize()
	{
		for (int i = 0; i < 100; ++i) {
			stack.push(i);
		}

		for (int i = 0; i < 100; ++i) {
			stack.pop();
		}

		assertEquals("Stack is not empty", 0, stack.size());
		assertTrue(stack.isEmpty());
	}

	@Test
	public void PushNullItemsAndConfirmSizeIsZero()
	{
		for (int i = 0; i < 16; ++i) {
			stack.push(null);
		}

		assertTrue(stack.isEmpty());
		assertEquals("Stack is not empty", 0, stack.size());
	}

	@Test
	public void TestPeeking()
	{
		int x = 27;
		int y = 28;

		stack.push(x);
		stack.push(y);

		assertTrue(stack.peek() == y);
		stack.pop();
		assertTrue(stack.peek() == x);
	}

	@Test
	public void TestStackIterator()
	{
		for (int i = 0; i < 500; ++i) {
			stack.push(i);
		}

		int i = 0;
		for (int val : stack) {
			assertTrue(val == i);
			++i;
		}
	}
}