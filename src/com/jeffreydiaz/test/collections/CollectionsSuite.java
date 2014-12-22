package com.jeffreydiaz.test.collections;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Suite to run all tests under com.jeffreydiaz.test.collections package.
 * @author Jeffrey Diaz
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({DoublyLinkedListTest.class, SinglyLinkedListTest.class, ArrayListTest.class})
public class CollectionsSuite {}