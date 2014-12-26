package com.jeffreydiaz.sorting;

/**
 * Abstract class containing operations used by all sorting methods.
 * @author Jeffrey Diaz
 */
public abstract class Sorter {

	/**
	 * Know whether p is less than q.
	 * @param p a Comparable object.
	 * @param q a Comparable object.
	 * @return true if p is less than q.
	 */
	protected static boolean less(Comparable p, Comparable q)
	{
		return p.compareTo(q) < 0;
	}

	/**
	 * Exchange two items within Comparable array.
	 * @param items array of Comparables.
	 * @param i index of item to exchange.
	 * @param j index of item to exchange.
	 */
	protected static void exch(Comparable[] items, int i, int j)
	{
		Comparable temp = items[i];
		items[i] = items[j];
		items[j] = temp;
	}
}