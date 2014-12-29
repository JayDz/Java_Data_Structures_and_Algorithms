package com.jeffreydiaz.collections;

/**
 * Implementation of a Priority Queue with an array as the internal data structure.
 * Operation cost:
 *      remove: ~1 (however, we may need to shrink array).
 *      insert: ~N
 *      @author Jeffrey Diaz
 */
public class OrderedMinPQ<Key extends Comparable<Key>> extends AbstractOrderedPQ<Key> {

	/**
	 * Create an empty OrderedMinPQ with an initial capacity of 8.
	 */
	public OrderedMinPQ()
	{
		super();
	}

	/**
	 * Create an empty OrderedMinPQ with an initial capacity.
	 * @param capacity initial capacity.
	 */
	@SuppressWarnings("unchecked")
	public OrderedMinPQ(int capacity)
	{
		super(capacity);
	}

	@Override
	public void orderKeys()
	{
		for (int i = size - 1; i > 0; --i) {
			if (less(keys[i-1], keys[i])) {
				exch(i,i-1);
			}
		}
	}
}