package com.jeffreydiaz.collections;

import java.util.Iterator;

/**
 * An abstract class containing implementations used by subclasses.
 * @author Jeffrey Diaz
 */
public abstract class AbstractUnorderedPQ<Key extends Comparable<Key>>
	implements PriorityQueue<Key>, Iterable<Key> {

	private static final int INITIAL_CAPACITY = 8;
	protected Key[] keys;
	private int size = 0;

	/**
	 * Remove a key. Is the max or min removed? That is up to the sub-class to decide.
	 * @return Removed key.
	 */
	protected abstract Key removeKey();

	/**
	 * Create an empty Priority Queue with an initial capacity of 8.
	 */
	protected AbstractUnorderedPQ()
	{
		this(INITIAL_CAPACITY);
	}

	/**
	 * Create an empty Priority Queue with an initial capacity.
	 * @param capacity initial capacity.
	 */
	@SuppressWarnings("unchecked")
	protected AbstractUnorderedPQ(int capacity)
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
		if (key == null) {
			return;
		}

		expandSize();
		keys[size] = key;
		++size;
	}

	private void expandSize()
	{
		if (size == keys.length) {
			resize(2*keys.length);
		}
	}

	/**
	 * Remove a key.
	 * @return key removed.
	 */
	@Override
	public Key remove()
	{
		if (isEmpty()) {
			return null;
		}

		Key key = removeKey();
		patchNullHole();
		--size;
		shrinkSize();

		return key;
	}

	private void patchNullHole()
	{
		int nullIndex = 0;
		while (nullIndex < size) {
			if (keys[nullIndex++] == null) {
				break;
			}
		}

		for (int i = nullIndex; i < size; ++i) {
			keys[i-1] = keys[i];
		}
		keys[size-1] = null;
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

	protected boolean less(Comparable p, Comparable q)
	{
		return p.compareTo(q) < 0;
	}

	/**
	 * Know whether priority queue is empty or not.
	 * @return true if priority queue is empty.
	 */
	@Override
	public boolean isEmpty()
	{
		return size() == 0;
	}

	/**
	 * Return the number of keys currently in priority queue.
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

		private int current = 0;

		@Override
		public boolean hasNext()
		{
			return current < size;
		}

		@Override
		public Key next()
		{
			return keys[current++];
		}

		@Override
		public void remove()
		{
			throw new UnsupportedOperationException("PQIterator.remove is not supported.");
		}
	}
}