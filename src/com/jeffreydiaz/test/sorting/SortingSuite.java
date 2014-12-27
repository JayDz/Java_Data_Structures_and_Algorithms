package com.jeffreydiaz.test.sorting;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * A JUNIT Suite for the sorting package.
 * @author Jeffrey Diaz
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({BubbleTest.class,
		     InsertionTest.class,
	             SelectionTest.class,
                     MergeTest.class,
		     QuickTest.class})
public class SortingSuite {}