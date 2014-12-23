package com.jeffreydiaz.collections;

import java.util.Iterator;

/**
 * Implementation of a Stack utilizing a singly linked list as its internal data structure.
 * @author Jeffrey Diaz
 */
public class LinkedStack<Item> implements Iterable<Item> {

	private SinglyLinkedList<Item> stack;

	/**
	 * Create an empty LinkedStack object.
	 */
	public LinkedStack()
	{
		stack = new SinglyLinkedList<Item>();
	}

	/**
	 * Push a item to top of Stack.
	 * @param item to push.
	 */
	public void push(Item item)
	{
		stack.prepend(item);
	}

	/**
	 * Remove the current item on top of stack.
	 * @return Item on top of stack, or null if empty.
	 */
	public Item pop()
	{
		return stack.remove();
	}

	/**
	 * Peek item on top of stack. Does not remove.
	 * @return Item on top of stack, or null if empty.
	 */
	public Item peek()
	{
		return stack.front();
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
	 * Return an Iterator to visit objects on stack. Order of items: top to bottom.
	 * @return Iterator object.
	 */
	@Override
	public Iterator<Item> iterator()
	{
		return stack.iterator();
	}
}