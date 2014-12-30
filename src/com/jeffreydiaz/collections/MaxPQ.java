package com.jeffreydiaz.collections;

import java.util.Iterator;

/**
 * Implementation of a Max Priority Queue utilizing the binary heap method.
 * Operation cost:
 *      remove: ~lgN
 *      insert: ~lgN
 * @author Jeffrey Diaz
 */
public class MaxPQ<Key extends Comparable<Key>>
	implements PriorityQueue<Key>, Iterable<Key> {

	private static final int INITIAL_CAPACITY = 8;
	private Key[] keys;
	private int size = 0;

	/**
	 * Create an empty Priority Queue with an initial capacity of 8.
	 */
	public MaxPQ()
	{
		this(INITIAL_CAPACITY);
	}

	/**
	 * Create an empty Priority Queue with an initial capacity.
	 * @param capacity initial of array.
	 */
	@SuppressWarnings("unchecked")
	public MaxPQ(int capacity)
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
			if (less(keys[k/2], keys[k])) {
				exch(k,k/2);
				k = k/2;
			} else {
				break;
			}
		}
	}

	@SuppressWarnings("unchecked")
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
		return ret;
	}

	// http://algs4.cs.princeton.edu/24pq/MaxPQ.java.html
	private void sink(int k)
	{
		while (2*k <= size) {
			int j = 2*k;
			if (j < size && less(keys[j], keys[j+1])) {
				++j;
			}
			if (!less(keys[k], keys[j])) {
				break;
			}
			exch(k, j);
			k = j;
		}
	}

	@SuppressWarnings("unchecked")
	private void resize(int newSize)
	{
		Key[] temp = (Key[]) new Comparable[newSize+1];
		for (int i = 1; i < size; ++i) {
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