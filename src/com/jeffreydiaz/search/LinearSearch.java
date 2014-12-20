package com.jeffreydiaz.search;

/**
 * Implementation of the classic Linear Search algorithm.
 * Complexity: ~N
 * @author Jeffrey Diaz
 */
public class LinearSearch {

	/**
	 * Linearly search for item elem in array items.
	 * @param items an array of Item objects who've implemented the equals method.
	 * @param elem item to search array items for.
	 * @return true if elem is found within items.
	 */
	public static <Item> boolean search(Item[] items, Item elem)
	{
		for (int i = 0; i < items.length; ++i) {
			if (items[i].equals(elem)){
				return true;
			}
		}
		return false;
	}

	/**
	 * Linearly search for elem in Iterable items.
	 * @param items Collection implementing the Iterable interface.
	 * @param elem Item to search collection for.
	 * @return true if elem is found within items.
	 */
	public static <Item> boolean search(Iterable<Item> items, Item elem)
	{
		for (Item item : items) {
			if (item.equals(elem)) {
				return true;
			}
		}
		return false;
	}
}