package com.jeffreydiaz.search;

/**
 * Implementation of the Binary Search algorithm on sorted arrays.
 * @author Jeffrey Diaz
 */
public class BinarySearch {

	/**
	 * Search for a given item in a given sorted array using the Binary Search algorithm.
	 * @param items A sorted array of Item objects.
	 * @param elem Element to find in sorted Array items.
	 * @param <Item> Generic type implementing the Comparable interface.
	 * @return true if elem is found in items array.
	 */
	public static <Item> boolean search(Comparable<Item>[] items, Item elem)
	{
		int lo = 0;
		int hi = items.length - 1;

		while (lo <= hi) {
			int mid = lo + (hi - lo) / 2;
			if (items[mid].compareTo(elem) < 0) {
				lo = mid + 1;
			} else if (items[mid].compareTo(elem) > 0) {
				hi = mid - 1;
			} else {
				return true;
			}
		}
		return false;
	}
}