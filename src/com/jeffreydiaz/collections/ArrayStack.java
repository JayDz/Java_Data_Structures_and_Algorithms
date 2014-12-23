package com.jeffreydiaz.collections;

import java.util.Iterator;

/**
 * Implementation of a Stack, utilizing an array as its internal data structure.
 * @author Jeffrey Diaz
 */
public class ArrayStack<Item> implements Iterable<Item> {

	private ArrayList<Item> stack;

	/**
	 * Create an empty ArrayStack.
	 */
	public ArrayStack()
	{
		stack = new ArrayList<Item>();
	}

	/**
	 * Push a item to top of Stack.
	 * @param item to push.
	 */
	public void push(Item item)
	{
		stack.append(item);
	}

	/**
	 * Remove the current item on top of stack.
	 * @return Item on top of stack, or null if empty.
	 */
	public Item pop()
	{
		return stack.removeBack();
	}

	/**
	 * Peek item on top of stack. Does not remove.
	 * @return Item on top of stack, or null if empty.
	 */
	public Item peek()
	{
		return stack.back();
	}

	/**
	 * Return the number of items currently in the stack.
	 * @return Number of items currently in the stack.
	 */
	public int size()
	{
		return stack.size();
	}

	/**
	 * Find out whether stack is empty or not.
	 * @return True if stack is empty.
	 */
	public boolean isEmpty()
	{
		return stack.isEmpty();
	}

	/**
	 * Return an Iterator to visit objects on stack. Order of items: bottom to top.
	 * @return Iterator object.
	 */
	@Override
	public Iterator<Item> iterator()
	{
		return stack.iterator();
	}
}