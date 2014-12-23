package com.jeffreydiaz.collections;

import java.util.Iterator;

/**
 * Implementation of a Queue utilizing an array as the internal data structure.
 * @author Jeffrey Diaz
 */
public class ArrayQueue<Item> implements Iterable<Item> {

	private ArrayList<Item> queue;

	/**
	 * Create an empty Queue object.
	 */
	public ArrayQueue()
	{
		queue = new ArrayList<Item>();
	}

	/**
	 * Add an item to the queue.
	 * @param item item to add to queue.
	 */
	public void enqueue(Item item)
	{
		queue.append(item);
	}

	/**
	 * Return item at the head of the queue.
	 * @return First item in queue.
	 */
	public Item dequeue()
	{
		return queue.remove();
	}

	/**
	 * Know whether queue is empty or not.
	 * @return true if queue is empty.
	 */
	public boolean isEmpty()
	{
		return queue.isEmpty();
	}

	/**
	 * Ask for the size of the queue.
	 * @return Number of items in queue.
	 */
	public int size()
	{
		return queue.size();
	}

	/**
	 * Return an Iterator to visit objects on queue.
	 * @return An Iterator object.
	 */
	@Override
	public Iterator<Item> iterator()
	{
		return queue.iterator();
	}
}