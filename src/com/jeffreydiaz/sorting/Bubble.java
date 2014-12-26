package com.jeffreydiaz.sorting;

/**
 * Implementation of the Bubble Sort algorithm.
 * @author Jeffrey Diaz
 */
public class Bubble extends Sorter {

	/**
	 * Sort given array using the bubble sort method.
	 * @param items array of Comparable objects.
	 */
	public static void sort(Comparable[] items)
	{
		for (int i = 0; i < items.length; ++i) {
			for (int j = 1; j < items.length - i; ++j) {
				if (less(items[j], items[j-1])) {
					exch(items, j, j-1);
				}
			}
		}
	}
}