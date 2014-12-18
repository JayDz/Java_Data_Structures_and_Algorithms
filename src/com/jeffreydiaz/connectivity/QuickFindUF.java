package com.jeffreydiaz.connectivity;

import com.jeffreydiaz.exceptions.InvalidInputException;

/**
 * Connectivity problem solved using a Quick find method, but o(n) union operation.
 * Complexities:
 *      create: O(N)
 *      find: O(1)
 *      union: O(N)
 * @author Jeffrey Diaz
 */
public class QuickFindUF {

	private int[] components;

	/**
	 * Create a QuickFindUF holding n nodes.
	 * @param n the number of nodes.
	 * @throws InvalidInputException if n < 0 or greater than possible int max.
	 */
	public QuickFindUF(int n) throws InvalidInputException
	{
		validateSizeOfN(n);
		components = new int[n];
		initComponentsArray();
	}

	private void validateSizeOfN(int n) throws InvalidInputException
	{
		if (n < 0 || n > Integer.MAX_VALUE) {
			throw new InvalidInputException("Invalid size");
		}
	}

	// Initialize components array so every element has its index as its value.
	private void initComponentsArray()
	{
		for (int i = 0; i < components.length; ++i) {
			components[i] = i;
		}
	}

	/**
	 * union, or connect two nodes currently in components array.
	 * @param p valid id of a node.
	 * @param q valid id of a node.
	 * @throws InvalidInputException if either p or q is not a valid node id.
	 */
	public void union(int p, int q) throws InvalidInputException
	{
		validatePAndQAreIndexes(p, q);

		int prevId = components[q];
		components[q] = components[p];
		for (int i = 0; i < components.length; ++i) {
			if (components[i] == prevId) {
				components[i] = components[p];
			}
		}
	}

	/**
	 * Tell us whether p and q are connected nodes (are in same component).
	 * @param p valid id of a node.
	 * @param q valid id of a node.
	 * @return true if connected, false if not.
	 * @throws InvalidInputException if either p or q is not a valid node id.
	 */
	public boolean find(int p, int q) throws InvalidInputException
	{
		validatePAndQAreIndexes(p, q);
		return components[p] == components[q];
	}

	private void validatePAndQAreIndexes(int p, int q) throws InvalidInputException
	{
		if (p < 0 || p >= components.length) {
			throw new InvalidInputException("Invalid input " + p);
		}
		if (q < 0 || q >= components.length) {
			throw new InvalidInputException("Invalid input " + q);
		}
	}
}