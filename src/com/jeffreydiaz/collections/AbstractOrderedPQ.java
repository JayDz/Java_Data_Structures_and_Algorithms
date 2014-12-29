package com.jeffreydiaz.collections;

import java.util.Iterator;

/**
 * A super class containing implementations used by AbstractOrderedPQ subclasses.
 * @author Jeffrey Diaz
 */
public abstract class AbstractOrderedPQ<Key extends Comparable<Key>>
	implements PriorityQueue<Key>, Iterable<Key> {

	private static final int INITIAL_CAPACITY = 8;
	protected Key[] keys;
	protected int size = 0;

	/**
	 * Defines the order (ascending or descending) of keys in array keys.
	 */
	public abstract void orderKeys();

	/**
	 * Create an empty OrderedMinPQ with an initial capacity of 8.
	 */
	protected AbstractOrderedPQ()
	{
		this(INITIAL_CAPACITY);
	}

	/**
	 * Create an empty OrderedMinPQ with an initial capacity.
	 * @param capacity initial capacity.
	 */
	@SuppressWarnings("unchecked")
	protected AbstractOrderedPQ(int capacity)
	{
		keys = (Key[]) new Comparable[capacity];
	}

	/**
	 * Insert a key.
	 * @param key to insert.
	 */
	@Override
	public void insert(Key key)
	{
		if (key == null ) {
			return;
		}
		expandSize();

		keys[size] = key;
		++size;
		orderKeys();
	}

	private void expandSize()
	{
		if (size == keys.length) {
			resize(2*keys.length);
		}
	}

	protected boolean less(Comparable p, Comparable q)
	{
		return p.compareTo(q) < 0;
	}

	protected void exch(int i, int j)
	{
		Key temp = keys[i];
		keys[i] = keys[j];
		keys[j] = temp;
	}

	/**
	 * Remove the minimum key.
	 * @return minimum key.
	 */
	@Override
	public Key remove()
	{
		if (isEmpty()) {
			return null;
		}

		--size;
		Key k = keys[size];
		keys[size] = null;
		shrinkSize();

		return k;
	}

	private void shrinkSize()
	{
		if (size > 0 && size == keys.length/4) {
			resize(keys.length / 2);
		}
	}

	@SuppressWarnings("unchecked")
	private void resize(int newSize)
	{
		Key[] temp = (Key[]) new Comparable[newSize];
		for (int i = 0; i < size; ++i) {
			temp[i] = keys[i];
		}

		keys = temp;
	}

	/**
	 * Know whether Priority Queue is empty or not.
	 * @return true if Priority Queue is empty.
	 */
	@Override
	public boolean isEmpty()
	{
		return size() == 0;
	}

	/**
	 * Get the number of keys currently in Priority Queue.
	 * @return number of keys in priority queue.
	 */
	@Override
	public int size()
	{
		return size;
	}

	/**
	 * Get an Iterator object.
	 * @return Iterator object.
	 */
	@Override
	public Iterator<Key> iterator()
	{
		return new PQIterator();
	}

	private class PQIterator implements Iterator<Key> {

		private int current = size;

		@Override
		public boolean hasNext()
		{
			return current <= 0;
		}

		@Override
		public Key next()
		{
			return keys[--current];
		}

		@Override
		public void remove()
		{
			throw new UnsupportedOperationException("PQIterator.remove is not supported.");
		}
	}
}