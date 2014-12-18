package com.jeffreydiaz.test.connectivity;

import com.jeffreydiaz.connectivity.QuickUnionUF;
import com.jeffreydiaz.exceptions.InvalidInputException;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Test class for QuickUnionUF
 * @author Jeffrey Diaz
 */
public class QuickUnionUFTest {

	@Test
	public void CreateValidQuickUnionUFObject() throws InvalidInputException
	{
		QuickUnionUF quickUnionUF = new QuickUnionUF(1);
		assertNotNull(quickUnionUF);
	}

	@Test(expected = InvalidInputException.class)
	public void CreateInvalidQuickUnionUFObject() throws InvalidInputException
	{
		QuickUnionUF quickUnionUF = new QuickUnionUF(0);
	}

	@Test(expected = InvalidInputException.class)
	public void InsertInvalidUnionIndexP() throws InvalidInputException
	{
		QuickUnionUF quickUnionUF = new QuickUnionUF(2);
		int p = 2;
		int q = 1;
		quickUnionUF.union(p, q);
	}

	@Test(expected = InvalidInputException.class)
	public void InsertInvalidUnionIndexQ() throws InvalidInputException
	{
		QuickUnionUF quickUnionUF = new QuickUnionUF(1);
		int p = 0;
		int q = 1;
		quickUnionUF.union(p, q);
	}

	@Test(expected = InvalidInputException.class)
	public void InsertInvalidFindIndexP() throws InvalidInputException
	{
		QuickUnionUF quickUnionUF = new QuickUnionUF(1);
		int p = 1;
		int q = 0;
		quickUnionUF.find(p, q);
	}

	@Test(expected = InvalidInputException.class)
	public void InsertInvalidFindIndexQ() throws InvalidInputException
	{
		QuickUnionUF quickUnionUF = new QuickUnionUF(1);
		int p = 0;
		int q = 1;
		quickUnionUF.find(p, q);
	}

	@Test
	public void IsReflexive() throws InvalidInputException
	{
		QuickUnionUF quickUnionUF = new QuickUnionUF(1);
		int p = 0;

		assertTrue(quickUnionUF.find(p, p));
	}

	@Test
	public void IsSymmetric() throws InvalidInputException
	{
		QuickUnionUF quickUnionUF = new QuickUnionUF(2);
		int p = 0;
		int q = 1;
		quickUnionUF.union(p, q);

		assertTrue(quickUnionUF.find(p, q));
		assertTrue(quickUnionUF.find(q, p));
	}

	@Test
	public void IsTransitive() throws InvalidInputException
	{
		QuickUnionUF quickUnionUF = new QuickUnionUF(3);
		int p = 0;
		int q = 1;
		int r = 2;

		quickUnionUF.union(p, q);
		quickUnionUF.union(q, r);

		assertTrue(quickUnionUF.find(p, r));
	}

	@Test
	public void ValidateUnionFindLogic() throws InvalidInputException
	{
		QuickUnionUF quickUnionUF = new QuickUnionUF(8);

		quickUnionUF.union(0, 1);
		quickUnionUF.union(2, 3);
		assertTrue(quickUnionUF.find(0, 1));
		assertTrue(quickUnionUF.find(2, 3));
		assertFalse(quickUnionUF.find(1, 2));
		assertFalse(quickUnionUF.find(0, 3));

		quickUnionUF.union(1,2);
		assertTrue(quickUnionUF.find(1, 2));
		assertTrue(quickUnionUF.find(0, 3));

		quickUnionUF.union(4, 5);
		quickUnionUF.union(6, 7);
		assertTrue(quickUnionUF.find(4, 5));
		assertTrue(quickUnionUF.find(6, 7));
		assertFalse(quickUnionUF.find(5, 6));
		assertFalse(quickUnionUF.find(4, 7));

		quickUnionUF.union(5,6);
		assertTrue(quickUnionUF.find(5, 6));
		assertTrue(quickUnionUF.find(4, 7));

		assertFalse(quickUnionUF.find(0, 7));
		quickUnionUF.union(0,7);

		assertTrue(quickUnionUF.find(3,4));
		assertTrue(quickUnionUF.find(2,5));
		assertTrue(quickUnionUF.find(1,6));
		assertTrue(quickUnionUF.find(7,0));
	}
}