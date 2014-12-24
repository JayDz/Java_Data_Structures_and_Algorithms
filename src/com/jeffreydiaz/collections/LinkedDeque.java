package com.jeffreydiaz.collections;

import java.util.Iterator;

/**
 * Implementation of a Deque utilizing a doubly linked list as the internal data structure.
 * @author Jeffrey Diaz
 */
public class LinkedDeque<Item> implements Iterable<Item> {

	private DoublyLinkedList<Item> deque;

	/**
	 * Create an empty LinkedDeque object.
	 */
	public LinkedDeque()
	{
		deque = new DoublyLinkedList<Item>();
	}

	/**
	 * Add an item to the front of the deque.
	 * @param item to add to front of deque.
	 */
	public void prepend(Item item)
	{
		deque.prepend(item);
	}

	/**
	 * Add an item to the back of the deque.
	 * @param item to add to back of queue.
	 */
	public void append(Item item)
	{
		deque.append(item);
	}

	/**
	 * Remove the fist item in the deque.
	 * @return first item in deque, or null if deque is empty.
	 */
	public Item remove()
	{
		return deque.remove();
	}

	/**
	 * Remove the last item in the deque.
	 * @return last item in deque, or null if deque is empty.
	 */
	public Item removeBack()
	{
		return deque.removeBack();
	}

	/**
	 * Look at the first item in deque. Is not removed.
	 * @return first item in deque, or null if deque is empty.
	 */
	public Item front()
	{
		return deque.front();
	}

	/**
	 * Look at the last item in deque. Is not removed.
	 * @return last item in deque, or null if deque is empty.
	 */
	public Item back()
	{
		return deque.back();
	}

	/**
	 * Know whether deque is empty.
	 * @return true if deque is empty.
	 */
	public boolean isEmpty()
	{
		return deque.isEmpty();
	}

	/**
	 * Get the number of items currently in the deque.
	 * @return the number of items in deque.
	 */
	public int size()
	{
		return deque.size();
	}

	/**
	 * Get an Iterator object.
	 * @return Iterator object.
	 */
	@Override
	public Iterator<Item> iterator()
	{
		return deque.iterator();
	}
}