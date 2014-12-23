package com.jeffreydiaz.collections;

import java.util.Iterator;

/**
 * Implementation of a Queue utilizing a Singly Linked List as the underlining data structure.
 * @author Jeffrey Diaz
 */
public class LinkedQueue<Item> implements Iterable<Item> {

	private SinglyLinkedList<Item> queue;

	/**
	 * Create an empty LinkedQueue object.
	 */
	public LinkedQueue()
	{
		queue = new SinglyLinkedList<Item>();
	}

	/**
	 * Append an Item to the back of the queue.
	 * @param item to add to back of queue.
	 */
	public void enqueue(Item item)
	{
		queue.append(item);
	}

	/**
	 * Remove the first item in queue.
	 * @return First item in queue.
	 */
	public Item dequeue()
	{
		return queue.remove();
	}

	/**
	 * Know whether the queue is empty or not.
	 * @return True if queue is empty.
	 */
	public boolean isEmpty()
	{
		return queue.isEmpty();
	}

	/**
	 * Get the number of items in queue.
	 * @return Size of queue.
	 */
	public int size()
	{
		return queue.size();
	}

	/**
	 * Get an Iterator.
	 * @return Iterator object.
	 */
	@Override
	public Iterator<Item> iterator()
	{
		return queue.iterator();
	}
}