package com.jeffreydiaz.connectivity;

import com.jeffreydiaz.exceptions.InvalidInputException;

/**
 * Connectivity problem solved using a Quick Union method.
 * Complexities:
 *      Creation: o(N)
 *      union: o(N) worst case
 *      find: o(N) worst case
 * @author Jeffrey Diaz
 */
public class QuickUnionUF {

	private int[] forest;

	/**
	 * Create a QuickUnionUF containing a forest of size n.
	 * @param n size of forest.
	 * @throws InvalidInputException if n is <= 0.
	 */
	public QuickUnionUF(int n) throws InvalidInputException
	{
		validateSizeOfN(n);
		forest = new int[n];
		initForest();
	}

	private void validateSizeOfN(int n) throws InvalidInputException
	{
		if (n <= 0) {
			throw new InvalidInputException("Invalid size");
		}
	}

	// Initialize forest so every element has its index as its value.
	private void initForest()
	{
		for (int i = 0; i < forest.length; ++i) {
			forest[i] = i;
		}
	}

	/**
	 * connect two nodes currently in forest.
	 * @param p valid id of a node.
	 * @param q valid id of a node.
	 * @throws InvalidInputException if either p or q is not a valid node id.
	 */
	public void union(int p, int q) throws InvalidInputException
	{
		validatePAndQAreIndexes(p, q);
		int rootOfP = findRoot(p);
		int rootOfQ = findRoot(q);
		forest[rootOfP] = rootOfQ;
	}

	/**
	 * Tell us whether p and q are connected (share the same root).
	 * @param p valid id of a node.
	 * @param q valid id of a node.
	 * @return true if connected, false if not.
	 * @throws InvalidInputException if either p or q is not a valid node id.
	 */
	public boolean find(int p, int q) throws InvalidInputException
	{
		validatePAndQAreIndexes(p, q);
		return findRoot(p) == findRoot(q);
	}

	private void validatePAndQAreIndexes(int p, int q) throws InvalidInputException
	{
		if (p < 0 || p >= forest.length) {
			throw new InvalidInputException("Invalid input " + p);
		}
		if (q < 0 || q >= forest.length) {
			throw new InvalidInputException("Invalid input " + q);
		}
	}

	private int findRoot(int id)
	{
		while (forest[id] != id) {
			id = forest[id];
		}

		return id;
	}
}