package com.jeffreydiaz.sorting;

/**
 * Implementation of the selection sort method.
 * @author Jeffrey Diaz
 */
public class Selection extends Sorter {

	/**
	 * Sort an array of Comparable objects.
	 * @param items Array to sort.
	 */
	public static void sort(Comparable[] items)
	{
		for (int i = 0; i < items.length; ++i) {
			int min = i;
			for (int j = i + 1; j < items.length; ++j) {
				if (less(items[j], items[min])) {
					min = j;
				}
			}
			exch(items, i, min);
		}
	}
}