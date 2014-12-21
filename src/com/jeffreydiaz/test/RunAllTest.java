package com.jeffreydiaz.test;

import com.jeffreydiaz.test.collections.CollectionsSuite;
import com.jeffreydiaz.test.connectivity.ConnectivitySuite;
import com.jeffreydiaz.test.search.SearchSuite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Suite which runs all Test Cases in project.
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({CollectionsSuite.class, ConnectivitySuite.class, SearchSuite.class})
public class RunAllTest {}