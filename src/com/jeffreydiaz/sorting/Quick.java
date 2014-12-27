package com.jeffreydiaz.sorting;

/**
 * Implementation of the QuickSort algorithm.
 * @author Jeffrey Diaz
 */
public class Quick extends Sorter {

	/**
	 * Sorts an array of Comparable objects.
	 * @param items Array to sort.
	 */
	public static void sort(Comparable[] items)
	{
		sort(items, 0, items.length - 1);
	}

	private static void sort(Comparable[] items, int lo, int hi)
	{
		if (lo >= hi) {
			return;
		}

		exch(items, lo, random(lo,hi));
		int pivot = partition(items, lo, hi);
		sort(items, lo, pivot-1);
		sort(items, pivot+1, hi);
	}

	private static int random(int lo, int hi)
	{
		return lo + (int) Math.floor((hi-lo+1)*Math.random());
	}

	// http://algs4.cs.princeton.edu/23quicksort/Quick.java.html
	private static int partition(Comparable[] items, int lo, int hi)
	{
		int i = lo;
		int j = hi + 1;
		int p = lo;

		while (true) {
			while (less(items[++i], items[p])) {
				if (i == hi) {
					break;
				}
			}

			while (less(items[p], items[--j])) {
				if (j == lo) {
					break;
				}
			}

			if (i >= j) {
				break;
			}

			exch(items, i, j);
		}
		exch(items, lo, j);

		return j;
	}
}