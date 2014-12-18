package com.jeffreydiaz.test.connectivity;

import com.jeffreydiaz.connectivity.WeightedQuickUnionUF;
import com.jeffreydiaz.exceptions.InvalidInputException;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Test class for WeightedQuickUnionUF
 * @author Jeffrey Diaz
 */
public class WeightedQuickUnionUFTest {

	@Test
	public void CreateValidQuickUnionUFObject() throws InvalidInputException
	{
		WeightedQuickUnionUF weightedQuickUnionUF = new WeightedQuickUnionUF(1);
		assertNotNull(weightedQuickUnionUF);
	}

	@Test(expected = InvalidInputException.class)
	public void CreateInvalidQuickUnionUFObject() throws InvalidInputException
	{
		WeightedQuickUnionUF weightedQuickUnionUF = new WeightedQuickUnionUF(0);
	}

	@Test(expected = InvalidInputException.class)
	public void InsertInvalidUnionIndexP() throws InvalidInputException
	{
		WeightedQuickUnionUF weightedQuickUnionUF = new WeightedQuickUnionUF(2);
		int p = 2;
		int q = 1;
		weightedQuickUnionUF.union(p, q);
	}

	@Test(expected = InvalidInputException.class)
	public void InsertInvalidUnionIndexQ() throws InvalidInputException
	{
		WeightedQuickUnionUF weightedQuickUnionUF = new WeightedQuickUnionUF(1);
		int p = 0;
		int q = 1;
		weightedQuickUnionUF.union(p, q);
	}

	@Test(expected = InvalidInputException.class)
	public void InsertInvalidFindIndexP() throws InvalidInputException
	{
		WeightedQuickUnionUF weightedQuickUnionUF = new WeightedQuickUnionUF(1);
		int p = 1;
		int q = 0;
		weightedQuickUnionUF.find(p, q);
	}

	@Test(expected = InvalidInputException.class)
	public void InsertInvalidFindIndexQ() throws InvalidInputException
	{
		WeightedQuickUnionUF weightedQuickUnionUF = new WeightedQuickUnionUF(1);
		int p = 0;
		int q = 1;
		weightedQuickUnionUF.find(p, q);
	}

	@Test
	public void IsReflexive() throws InvalidInputException
	{
		WeightedQuickUnionUF weightedQuickUnionUF = new WeightedQuickUnionUF(1);
		int p = 0;

		assertTrue(weightedQuickUnionUF.find(p, p));
	}

	@Test
	public void IsSymmetric() throws InvalidInputException
	{
		WeightedQuickUnionUF weightedQuickUnionUF = new WeightedQuickUnionUF(2);
		int p = 0;
		int q = 1;
		weightedQuickUnionUF.union(p, q);

		assertTrue(weightedQuickUnionUF.find(p, q));
		assertTrue(weightedQuickUnionUF.find(q, p));
	}

	@Test
	public void IsTransitive() throws InvalidInputException
	{
		WeightedQuickUnionUF weightedQuickUnionUF = new WeightedQuickUnionUF(3);
		int p = 0;
		int q = 1;
		int r = 2;

		weightedQuickUnionUF.union(p, q);
		weightedQuickUnionUF.union(q, r);

		assertTrue(weightedQuickUnionUF.find(p, r));
	}

	@Test
	public void ValidateUnionFindLogic() throws InvalidInputException
	{
		WeightedQuickUnionUF weightedQuickUnionUF = new WeightedQuickUnionUF(8);

		weightedQuickUnionUF.union(0, 1);
		weightedQuickUnionUF.union(2, 3);
		assertTrue(weightedQuickUnionUF.find(0, 1));
		assertTrue(weightedQuickUnionUF.find(2, 3));
		assertFalse(weightedQuickUnionUF.find(1, 2));
		assertFalse(weightedQuickUnionUF.find(0, 3));

		weightedQuickUnionUF.union(1,2);
		assertTrue(weightedQuickUnionUF.find(1, 2));
		assertTrue(weightedQuickUnionUF.find(0, 3));

		weightedQuickUnionUF.union(4, 5);
		weightedQuickUnionUF.union(6, 7);
		assertTrue(weightedQuickUnionUF.find(4, 5));
		assertTrue(weightedQuickUnionUF.find(6, 7));
		assertFalse(weightedQuickUnionUF.find(5, 6));
		assertFalse(weightedQuickUnionUF.find(4, 7));

		weightedQuickUnionUF.union(5,6);
		assertTrue(weightedQuickUnionUF.find(5, 6));
		assertTrue(weightedQuickUnionUF.find(4, 7));

		assertFalse(weightedQuickUnionUF.find(0, 7));
		weightedQuickUnionUF.union(0,7);

		assertTrue(weightedQuickUnionUF.find(3,4));
		assertTrue(weightedQuickUnionUF.find(2,5));
		assertTrue(weightedQuickUnionUF.find(1,6));
		assertTrue(weightedQuickUnionUF.find(7,0));
	}
}