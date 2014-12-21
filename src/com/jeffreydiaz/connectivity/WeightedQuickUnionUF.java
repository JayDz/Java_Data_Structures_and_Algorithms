package com.jeffreydiaz.connectivity;

import com.jeffreydiaz.exceptions.InvalidInputException;

/**
 * Connectivity problem solved using the Weighted Quick Union method.
 * Complexities:
 *      Creation: ~N
 *      find: ~lg N
 *      union: ~lg N
 * @author Jeffrey Diaz
 */
public class WeightedQuickUnionUF {

	private int[] forest;
	private int[] weight;
	/**
	 * Create a WeightedQuickUnionUF containing a forest of size n.
	 * @param n size of forest.
	 * @throws InvalidInputException if n is less than or equal to zero.
	 */
	public WeightedQuickUnionUF(int n) throws InvalidInputException
	{
		validateSizeOfN(n);
		forest = new int[n];
		weight = new int[n];
		initForest();
		initWeight();
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

	// All nodes have an initial weight of one.
	private void initWeight()
	{
		for (int i = 0; i < weight.length; ++i) {
			weight[i] = 1;
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

		int weightOfRootOfP = weight[rootOfP];
		int weightOfRootOfQ = weight[rootOfQ];

		if (weightOfRootOfQ > weightOfRootOfP) {
			forest[rootOfP] = rootOfQ;
			weight[rootOfQ] += weight[rootOfP];
		} else {
			forest[rootOfQ] = rootOfP;
			weight[rootOfP] += weight[rootOfQ];
		}
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
			// Path Compression
			forest[id] = forest[forest[id]];
			id = forest[id];
		}

		return id;
	}
}