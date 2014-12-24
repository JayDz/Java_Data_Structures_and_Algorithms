package com.jeffreydiaz.collections;

import java.util.Iterator;

/**
 * Implementation of the Bag data structure. Where items may be added and traversed, but not removed.
 * Implemented utilizing a Singly Linked List as the internal data structure.
 * @author Jeffrey Diaz
 */
public class LinkedBag<Item> implements Iterable<Item> {

	private SinglyLinkedList<Item> bag;

	/**
	 * Create an empty LinkedBag object.
	 */
	public LinkedBag()
	{
		bag = new SinglyLinkedList<Item>();
	}

	/**
	 * Add an item to the bag.
	 * @param item to add to bag.
	 */
	public void add(Item item)
	{
		bag.append(item);
	}

	/**
	 * Know whether bag is empty.
	 * @return True if empty.
	 */
	public boolean isEmpty()
	{
		return bag.isEmpty();
	}

	/**
	 * Get the number of items inside the bag.
	 * @return number of items in bag.
	 */
	public int size()
	{
		return bag.size();
	}

	/**
	 * Get an Iterator object.
	 * @return Iterator object.
	 */
	@Override
	public Iterator<Item> iterator()
	{
		return bag.iterator();
	}
}