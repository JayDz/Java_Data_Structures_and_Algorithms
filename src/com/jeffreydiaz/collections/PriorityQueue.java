package com.jeffreydiaz.collections;

/**
 * API implemented by various PriorityQueue implementations.
 * @author Jeffrey Diaz
 */
public interface PriorityQueue<Key extends Comparable<Key>> {

	public void insert(Key key);
	public Key remove();
	public boolean isEmpty();
	public int size();
}