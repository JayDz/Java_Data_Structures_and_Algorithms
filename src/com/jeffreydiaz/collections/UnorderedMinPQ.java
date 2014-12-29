package com.jeffreydiaz.collections;

/**
 * Implementation of an unordered Priority Queue where the min key can be removed.
 * Operation Cost:
 *      remove: ~N
 *      insert: ~1 (however, we may need to resize array).
 * @author Jeffrey Diaz
 */
public class UnorderedMinPQ<Key extends Comparable<Key>> extends AbstractUnorderedPQ<Key> {

	/**
	 * Create an empty priority queue with an array of a initial capacity of 8.
	 */
	public UnorderedMinPQ()
	{
		super();
	}

	/**
	 * Create an empty priority queue with an initial capacity of capacity.
	 * @param capacity initial array capacity.
	 */
	public UnorderedMinPQ(int capacity)
	{
		super(capacity);
	}

	/**
	 * Remove the max key from priority queue.
	 * @return max key.
	 */
	@Override
	protected Key removeKey()
	{
		int min = 0;
		for (int i = 1; i < size(); ++i) {
			if (less(keys[i], keys[min])) {
				min = i;
			}
		}

		Key ret = keys[min];
		keys[min] = null;
		return ret;
	}
}