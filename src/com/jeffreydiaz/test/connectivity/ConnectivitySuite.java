package com.jeffreydiaz.test.connectivity;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Suite to run all tests under com.jeffreydiaz.test.connectivity package.
 * @author Jeffrey Diaz
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({QuickFindUFTest.class, QuickUnionUFTest.class, WeightedQuickUnionUFTest.class})
public class ConnectivitySuite {}