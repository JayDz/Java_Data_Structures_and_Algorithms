package com.jeffreydiaz.sorting;

/**
 * Implementation of the merge sort algorithm.
 * @author Jeffrey Diaz
 */
public class Merge extends Sorter {

	/**
	 * Sort an array of Comparable objects.
	 * @param items Array to sort.
	 */
	public static void sort(Comparable[] items)
	{
		Comparable[] aux = new Comparable[items.length];
		mergeSort(items, aux, 0, items.length-1);
	}

	private static void mergeSort(Comparable[] items, Comparable[] aux, int lo, int hi)
	{
		if (lo >= hi) {
			return;
		}

		int mid = lo + (hi - lo) / 2;
		mergeSort(items, aux, lo, mid);
		mergeSort(items, aux, mid+1, hi);
		merge(items, aux, lo, mid, hi);
	}

	private static void merge(Comparable[] items, Comparable[] aux, int lo, int mid, int hi)
	{
		for (int k = lo; k <= hi; ++k) {
			aux[k] = items[k];
		}

		int i = lo;
		int j = mid+1;

		for (int k = lo; k <= hi; ++k) {
			if (i > mid) {
				items[k] = aux[j];
				++j;
			} else if (j > hi) {
				items[k] = aux[i];
				++i;
			}
			else if (less(aux[i], aux[j])) {
				items[k] = aux[i];
				++i;
			} else {
				items[k] = aux[j];
				++j;
			}
		}
	}
}