package com.jeffreydiaz.collections;

import java.util.Iterator;

/**
 * Implementation of a List with an array as the data structure.
 * @author Jeffrey Diaz
 */
public class ArrayList<Item> implements Iterable<Item> {

	private static final int INITIAL_CAPACITY = 8;
	Item[] items;
	int head = 0;
	int count = 0;

	/**
	 * Create an empty ArrayList with an initial capacity of eight.
	 */
	public ArrayList()
	{
		this(INITIAL_CAPACITY);
	}

	/**
	 * Create an ArrayList with an initial capacity.
	 * @param n initial capacity.
	 */
	@SuppressWarnings("unchecked")
	public ArrayList(int n)
	{
		items = (Item[]) new Object[n];
	}

	/**
	 * Peek at the first element in the list.
	 * @return First element in the list.
	 */
	public Item front()
	{
		if (isEmpty()) {
			return null;
		}

		return items[index(0)];
	}

	/**
	 * Peek at the last element in the list.
	 * @return Last element in the list.
	 */
	public Item back()
	{
		if (isEmpty()) {
			return null;
		}

		return items[index(count-1)];
	}

	/**
	 * Append an item to the back of the list.
	 * @param item to append to back of list.
	 */
	public void append(Item item)
	{
		if (item == null) {
			return;
		}

		expandSize();
		int index = index(count);
		items[index] = item;
		++count;
	}

	/**
	 * Prepend an item to the front of the list.
	 * @param item to place in front of list.
	 */
	public void prepend(Item item)
	{
		if (item == null) {
			return;
		}

		expandSize();
		int index = index(-1);
		items[index] = item;
		head = index;
		++count;
	}

	private void expandSize()
	{
		if (count == items.length) {
			resize(2*items.length);
		}
	}

	/**
	 * Remove the first item in the list.
	 * @return First item in the list.
	 */
	public Item remove()
	{
		if (isEmpty()) {
			return null;
		}

		shrinkSize();
		--count;
		int i = index(0);
		Item item = items[i];
		items[i] = null;
		head = index(1);
		return item;
	}

	/**
	 * Remove the last item in the list.
	 * @return Last item in the list.
	 */
	public Item removeBack()
	{
		if (isEmpty()) {
			return null;
		}

		shrinkSize();
		--count;
		int i = index(count);
		Item item = items[i];
		items[i] = null;
		return item;
	}

	private void shrinkSize()
	{
		if (count > 0 && count == items.length/4) {
			resize(items.length / 2);
		}
	}

	@SuppressWarnings("unchecked")
	private void resize(int size)
	{
		Item[] temp = (Item[]) new Object[size];
		for (int i = 0; i < count; ++i) {
			temp[i] = items[index(i)];
		}

		items = temp;
		head = 0;
	}

	/**
	 * Check whether ArrayList is empty.
	 * @return true if empty.
	 */
	public boolean isEmpty()
	{
		return size() == 0;
	}

	/**
	 * Get the current count of items in ArrayList.
	 * @return number of items in ArrayList.
	 */
	public int size()
	{
		return count;
	}

	private int index(int i)
	{
		return (head + i + items.length) % items.length;
	}

	/**
	 * Get an Iterator object.
	 * @return Iterator object.
	 */
	@Override
	public Iterator<Item> iterator()
	{
		return new ArrayListIterator();
	}

	private class ArrayListIterator implements Iterator<Item> {

		private int current = 0;

		@Override
		public boolean hasNext()
		{
			return current < count;
		}

		@Override
		public Item next()
		{
			return items[index(current++)];
		}

		@Override
		public void remove()
		{
			throw new UnsupportedOperationException("Iterator.remove() is not supported");
		}
	}
}