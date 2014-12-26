package com.jeffreydiaz.sorting;

/**
 * Implementation of the Insertion sort method.
 * @author Jeffrey Diaz
 */
public class Insertion extends Sorter {

	/**
	 * Sort an array of Comparable objects.
	 * @param items Array to sort.
	 */
	public static void sort(Comparable[] items)
	{
		for (int i = 1; i < items.length; ++i) {
			int j = i;
			while (j > 0 && less(items[j], items[j-1])) {
				exch(items, j, j-1);
				--j;
			}
		}
	}
}