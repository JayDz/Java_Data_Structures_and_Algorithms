package com.jeffreydiaz.collections;

/**
 * Implementation of an unordered Priority Queue where the max key can be removed.
 * Operation Cost:
 *      remove: ~N
 *      insert: ~1 (however, we may need to resize array).
 * @author Jeffrey Diaz
 */
public class UnorderedMaxPQ<Key extends Comparable<Key>> extends AbstractUnorderedPQ<Key> {

	/**
	 * Create an empty priority queue with an initial capacity of 8.
	 */
	public UnorderedMaxPQ()
	{
		super();
	}

	/**
	 * Create an empty priority queue with an initial capacity of capacity.
	 * @param capacity initial array capacity.
	 */
	public UnorderedMaxPQ(int capacity)
	{
		super(capacity);
	}

	/**
	 * Remove the min key from priority queue.
	 * @return min key.
	 */
	@Override
	protected Key removeKey()
	{
		int max = 0;
		for (int i = 1; i < size(); ++i) {
			if (less(keys[max], keys[i])) {
				max = i;
			}
		}

		Key ret = keys[max];
		keys[max] = null;
		return ret;
	}
}