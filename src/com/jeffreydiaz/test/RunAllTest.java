package com.jeffreydiaz.test;

import com.jeffreydiaz.test.collections.CollectionsSuite;
import com.jeffreydiaz.test.connectivity.ConnectivitySuite;
import com.jeffreydiaz.test.search.SearchSuite;
import com.jeffreydiaz.test.sorting.SortingSuite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Suite which runs all Test Cases in project.
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({CollectionsSuite.class,
		     ConnectivitySuite.class,
		     SearchSuite.class,
	             SortingSuite.class})
public class RunAllTest {}