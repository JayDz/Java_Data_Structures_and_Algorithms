package com.jeffreydiaz.test.search;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Suite to run all tests under com.jeffreydiaz.test.search package.
 * @author Jeffrey Diaz
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({BinarySearchTest.class, LinearSearchTest.class})
public class SearchSuite {}