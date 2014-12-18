package com.jeffreydiaz.test.connectivity;

import com.jeffreydiaz.connectivity.QuickFindUF;
import com.jeffreydiaz.exceptions.InvalidInputException;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test class for QuickFindUF
 * @author Jeffrey Diaz
 */
public class QuickFindUFTest {

	@Test
	public void CreateValidQuickFindUFObject() throws InvalidInputException
	{
		QuickFindUF quickFindUF = new QuickFindUF(1);
		assertNotNull(quickFindUF);
	}

	@Test(expected = InvalidInputException.class)
	public void CreateInvalidQuickFindUFObject() throws InvalidInputException
	{
		QuickFindUF quickFindUF = new QuickFindUF(0);
	}

	@Test(expected = InvalidInputException.class)
	public void InsertInvalidUnionIndexP() throws InvalidInputException
	{
		QuickFindUF quickFindUF = new QuickFindUF(2);
		int p = 2;
		int q = 1;
		quickFindUF.union(p, q);
	}

	@Test(expected = InvalidInputException.class)
	public void InsertInvalidUnionIndexQ() throws InvalidInputException
	{
		QuickFindUF quickFindUF = new QuickFindUF(1);
		int p = 0;
		int q = 1;
		quickFindUF.union(p, q);
	}

	@Test(expected = InvalidInputException.class)
	public void InsertInvalidFindIndexP() throws InvalidInputException
	{
		QuickFindUF quickFindUF = new QuickFindUF(1);
		int p = 1;
		int q = 0;
		quickFindUF.find(p, q);
	}

	@Test(expected = InvalidInputException.class)
	public void InsertInvalidFindIndexQ() throws InvalidInputException
	{
		QuickFindUF quickFindUF = new QuickFindUF(1);
		int p = 0;
		int q = 1;
		quickFindUF.find(p, q);
	}

	@Test
	public void IsReflexive() throws InvalidInputException
	{
		QuickFindUF quickFindUF = new QuickFindUF(1);
		int p = 0;

		assertTrue(quickFindUF.find(p, p));
	}

	@Test
	public void IsSymmetric() throws InvalidInputException
	{
		QuickFindUF quickFindUF = new QuickFindUF(2);
		int p = 0;
		int q = 1;
		quickFindUF.union(p, q);

		assertTrue(quickFindUF.find(p, q));
		assertTrue(quickFindUF.find(q, p));
	}

	@Test
	public void IsTransitive() throws InvalidInputException
	{
		QuickFindUF quickFindUF = new QuickFindUF(3);
		int p = 0;
		int q = 1;
		int r = 2;

		quickFindUF.union(p, q);
		quickFindUF.union(q, r);

		assertTrue(quickFindUF.find(p, r));
	}

	@Test
	public void ValidateUnionFindLogic() throws InvalidInputException
	{
		QuickFindUF quickFindUF = new QuickFindUF(8);

		quickFindUF.union(0, 1);
		quickFindUF.union(2, 3);
		assertTrue(quickFindUF.find(0, 1));
		assertTrue(quickFindUF.find(2, 3));
		assertFalse(quickFindUF.find(1, 2));
		assertFalse(quickFindUF.find(0, 3));

		quickFindUF.union(1,2);
		assertTrue(quickFindUF.find(1, 2));
		assertTrue(quickFindUF.find(0, 3));

		quickFindUF.union(4, 5);
		quickFindUF.union(6, 7);
		assertTrue(quickFindUF.find(4, 5));
		assertTrue(quickFindUF.find(6, 7));
		assertFalse(quickFindUF.find(5, 6));
		assertFalse(quickFindUF.find(4, 7));

		quickFindUF.union(5,6);
		assertTrue(quickFindUF.find(5, 6));
		assertTrue(quickFindUF.find(4, 7));

		assertFalse(quickFindUF.find(0, 7));
		quickFindUF.union(0,7);

		assertTrue(quickFindUF.find(3,4));
		assertTrue(quickFindUF.find(2,5));
		assertTrue(quickFindUF.find(1,6));
		assertTrue(quickFindUF.find(7,0));
	}
}