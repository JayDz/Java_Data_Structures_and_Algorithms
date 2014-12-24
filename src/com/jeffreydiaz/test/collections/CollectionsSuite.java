package com.jeffreydiaz.test.collections;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Suite to run all tests under com.jeffreydiaz.test.collections package.
 * @author Jeffrey Diaz
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({DoublyLinkedListTest.class,
	             SinglyLinkedListTest.class,
	             ArrayListTest.class,
                     ArrayStackTest.class,
	             LinkedStackTest.class,
		     ArrayQueueTest.class,
		     LinkedQueueTest.class,
		     ArrayBagTest.class,
		     LinkedBagTest.class,
		     ArrayDequeTest.class,
		     LinkedDequeTest.class})
public class CollectionsSuite {}