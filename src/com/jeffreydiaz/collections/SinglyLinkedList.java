package com.jeffreydiaz.collections;

import java.util.Iterator;

/**
 * Implementation of the classical Singly Linked List data structure.
 * @author Jeffrey Diaz
 */
public class SinglyLinkedList<Item> implements Iterable<Item> {

	// A Link implements the concept of a link in a Linked List chain. It holds a value and a pointer to the next link.
	private class Link {

		private Item value;
		private Link next;

		public Link(Item value, Link next)
		{
			this.value = value;
			this.next = next;
		}

		public Item getValue()
		{
			return value;
		}

		public Link getNext()
		{
			return next;
		}

		public void setNext(Link next)
		{
			this.next = next;
		}
	}

	private Link head;
	private Link tail;
	private int size = 0;

	/**
	 * Add a new value to the end of the List.
	 * @param item Object to add to the back of the List.
	 */
	public void append(Item item)
	{
		if (item == null) {
			return;
		}

		if (isEmpty()) {
			initEmptyList(item);
		} else {
			appendLink(item);
		}
		++size;
	}

	private void appendLink(Item item)
	{
		Link newLink = new Link(item, null);
		tail.setNext(newLink);
		tail = newLink;
	}

	/**
	 * Add a new value to the front of the List.
	 * @param item Object to add to the front of the List.
	 */
	public void prepend(Item item)
	{
		if (item == null) {
			return;
		}

		if (isEmpty()) {
			initEmptyList(item);
		} else {
			prependLink(item);
		}
		++size;
	}

	private void prependLink(Item item)
	{
		Link newLink = new Link(item, head);
		head = newLink;
	}

	private void initEmptyList(Item item)
	{
		head = new Link(item, null);
		tail = head;
	}

	/**
	 * Remove the value in the front of the List.
	 * @return Object in front of List.
	 */
	public Item remove()
	{
		if (isEmpty()) {
			return null;
		}
		Item item = head.getValue();
		head = head.getNext();
		--size;
		return item;
	}

	/**
	 * Take a look at the first value in the List. List will maintain a reference to object.
	 * @return First object in front of List.
	 */
	public Item front()
	{
		if (isEmpty()) {
			return null;
		}
		return head.getValue();
	}

	/**
	 * Take a look at the last value in the List. List will maintain a reference to object.
	 * @return Last object in List.
	 */
	public Item back()
	{
		if (isEmpty()) {
			return null;
		}
		return tail.getValue();
	}

	/**
	 * The number of values currently in the List.
	 * @return Size of the list.
	 */
	public int size()
	{
		return size;
	}

	/**
	 * Know whether the List is empty or not.
	 * @return true if the list is empty.
	 */
	public boolean isEmpty()
	{
		return size == 0;
	}

	/**
	 * Get an iterator to visit all values in List.
	 * @return Iterator object.
	 */
	@Override
	public Iterator<Item> iterator()
	{
		return new ListIterator();
	}

	// Implementation of the Iterator interface. Needed for foreach support.
	private class ListIterator implements Iterator<Item> {

		private Link current = head;

		@Override
		public boolean hasNext()
		{
			return current != null;
		}

		@Override
		public Item next()
		{
			if (hasNext()) {
				Item value = current.getValue();
				current = current.getNext();
				return value;
			}
			return null;
		}

		@Override
		public void remove()
		{
			throw new UnsupportedOperationException("Iterator.remove() not supported.");
		}
	}
}