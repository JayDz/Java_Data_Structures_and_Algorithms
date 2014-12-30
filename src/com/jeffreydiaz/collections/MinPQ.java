package com.jeffreydiaz.collections;

import java.util.Iterator;

/**
 * Implementation of a Min Priority Queue utilizing the binary heap method.
 * Operation cost:
 *      remove: ~lgN
 *      insert: ~lgN
 * @author Jeffrey Diaz
 */
public class MinPQ<Key extends Comparable<Key>>
	implements PriorityQueue<Key>, Iterable<Key> {

	private static final int INITIAL_CAPACITY = 8;
	private Key[] keys;
	private int size = 0;

	/**
	 * Create an empty Priority Queue with an initial capacity of 8.
	 */
	public MinPQ()
	{
		this(INITIAL_CAPACITY);
	}

	/**
	 * Create an empty Priority Queue with an initial capacity.
	 * @param capacity initial of array.
	 */
	@SuppressWarnings("unchecked")
	public MinPQ(int capacity)
	{
		keys = (Key[]) new Comparable[capacity+1];
	}

	/**
	 * insert a key.
	 * @param key to insert.
	 */
	@Override
	public void insert(Key key)
	{
		if (key == null) {
			return;
		}

		++size;
		expandSize();
		keys[size] = key;
		swim(size);
	}

	private void expandSize()
	{
		if (size >= keys.length-1) {
			resize(2*keys.length);
		}
	}

	private void swim(int k)
	{
		while (k > 1) {
			if (greater(keys[k / 2], keys[k])) {
				exch(k,k/2);
				k = k/2;
			} else {
				break;
			}
		}
	}

	protected void exch(int i, int j)
	{
		Key temp = keys[i];
		keys[i] = keys[j];
		keys[j] = temp;
	}

	/**
	 * Remove the max key.
	 * @return max key.
	 */
	@Override
	public Key remove()
	{
		if (isEmpty()) {
			return null;
		}

		exch(1, size);
		Key ret = keys[size];
		keys[size] = null;
		--size;
		sink(1);
		shrinkSize();
		return ret;
	}

	// http://algs4.cs.princeton.edu/24pq/MinPQ.java.html
	private void sink(int k)
	{
		while (2*k <= size) {
			int j = 2*k;
			if (j < size && greater(keys[j], keys[j+1])) {
				++j;
			}
			if (!greater(keys[k], keys[j])) {
				break;
			}
			exch(k, j);
			k = j;
		}
	}

	private void shrinkSize()
	{
		if ((size > 0) && (size == (keys.length-1)/4)) {
			resize(keys.length/2);
		}
	}

	@SuppressWarnings("unchecked")
	private boolean greater(Comparable p, Comparable q)
	{
		return p.compareTo(q) > 0;
	}

	@SuppressWarnings("unchecked")
	private void resize(int newSize)
	{
		Key[] temp = (Key[]) new Comparable[newSize];
		for (int i = 1; i <= size; ++i) {
			temp[i] = keys[i];
		}

		keys = temp;
	}

	/**
	 * Ask whether priority queue is empty.
	 * @return true if empty.
	 */
	@Override
	public boolean isEmpty()
	{
		return size() == 0;
	}

	/**
	 * The number of keys currently in priority queue.
	 * @return number of keys in priority queue.
	 */
	@Override
	public int size()
	{
		return size;
	}

	/**
	 * Get an Iterator object.
	 * @return an Iterator object.
	 */
	@Override
	public Iterator<Key> iterator()
	{
		return new PQIterator();
	}

	private class PQIterator implements Iterator<Key> {

		private int current = 1;

		@Override
		public boolean hasNext()
		{
			return current <= size;
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