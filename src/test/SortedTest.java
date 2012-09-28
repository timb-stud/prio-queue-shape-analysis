package test;

import junit.framework.Assert;

import org.junit.Test;

import de.htw.PriorityQueueSorted;
import de.htw.QueueElement;

public class SortedTest extends Assert {
	

	@Test
	public void elements1() {
		PriorityQueueSorted pq = new PriorityQueueSorted();
		QueueElement qe1 = new QueueElement(1, 5);
		QueueElement qe2 = new QueueElement(12, 10);
		QueueElement qe3 = new QueueElement(123, 15);
		QueueElement qe4 = new QueueElement(1234, 1);
		QueueElement qe5 = new QueueElement(12345, 6);
		QueueElement qe6 = new QueueElement(1234, 100);
		qe1.next = qe5;
		qe5.next = qe2;
		qe2.next = qe3;
		qe3.next = qe6;
		assertTrue(pq.enqueue(qe1.data, qe1.priority));
		assertTrue(pq.enqueue(qe2.data, qe2.priority));
		assertTrue(pq.enqueue(qe3.data, qe3.priority));
		assertTrue(pq.enqueue(qe4.data, qe4.priority));
		assertTrue(pq.enqueue(qe5.data, qe5.priority));
		assertFalse(pq.enqueue(qe6.data, qe6.priority));
		assertListEquals(qe1, pq.head);
	}
	
	@Test
	public void updateHead() {
		PriorityQueueSorted pq = new PriorityQueueSorted();
		QueueElement qe1 = new QueueElement(1, 5);
		QueueElement qe2 = new QueueElement(12, 10);
		QueueElement qe3 = new QueueElement(123, 15);
		QueueElement qe4 = new QueueElement(1234, 1);
		QueueElement qe5 = new QueueElement(12345, 6);
		qe4.next = qe1;
		qe1.next = qe5;
		qe5.next = qe2;
		qe2.next = qe3;
		assertTrue(pq.enqueue(qe1.data, qe1.priority));
		assertTrue(pq.enqueue(qe2.data, qe2.priority));
		assertTrue(pq.enqueue(qe3.data, qe3.priority));
		assertTrue(pq.enqueue(qe4.data, qe4.priority));
		assertTrue(pq.enqueue(qe5.data, qe5.priority));
		assertListEquals(qe4, pq.head);
	}
	
	@Test
	public void addLastWithSamePrio() {
		PriorityQueueSorted pq = new PriorityQueueSorted();
		QueueElement qe1 = new QueueElement(1, 5);
		QueueElement qe2 = new QueueElement(12, 10);
		QueueElement qe3 = new QueueElement(123, 15);
		QueueElement qe4 = new QueueElement(1234, 1);
		QueueElement qe5 = new QueueElement(12345, 6);
		QueueElement qe6 = new QueueElement(121233, 15);
		qe4.next = qe1;
		qe1.next = qe5;
		qe5.next = qe2;
		qe2.next = qe3;
		qe3.next = qe6;
		assertTrue(pq.enqueue(qe1.data, qe1.priority));
		assertTrue(pq.enqueue(qe2.data, qe2.priority));
		assertTrue(pq.enqueue(qe3.data, qe3.priority));
		assertTrue(pq.enqueue(qe4.data, qe4.priority));
		assertTrue(pq.enqueue(qe5.data, qe5.priority));
		assertTrue(pq.enqueue(qe6.data, qe6.priority));
		assertListEquals(qe4, pq.head);
	}

	@Test
	public void elements2() {
		PriorityQueueSorted pq = new PriorityQueueSorted();
		QueueElement qe1 = new QueueElement(1, 5);
		QueueElement qe2 = new QueueElement(3, 10);
		QueueElement qe3 = new QueueElement(99, 15);
		QueueElement qe4 = new QueueElement(123, 1);
		qe4.next = qe1;
		qe1.next = qe2;
		qe2.next = qe3;
		assertTrue(pq.enqueue(qe1.data, qe1.priority));
		assertTrue(pq.enqueue(qe2.data, qe2.priority));
		assertTrue(pq.enqueue(qe3.data, qe3.priority));
		assertTrue(pq.enqueue(qe4.data, qe4.priority));
		assertListEquals(qe4, pq.head);
	}
	
	@Test
	public void elements2update() {
		PriorityQueueSorted pq = new PriorityQueueSorted();
		QueueElement qe1 = new QueueElement(1, 5);
		QueueElement qe2 = new QueueElement(3, 10);
		QueueElement qe3 = new QueueElement(1, 5);
		QueueElement qe4 = new QueueElement(123, 1);
		QueueElement qe5 = new QueueElement(123, 1);
		qe5.next = qe1;
		qe1.next = qe2;
		//qe2.next = qe3;
		assertTrue(pq.enqueue(qe1.data, qe1.priority));
		assertTrue(pq.enqueue(qe2.data, qe2.priority));
		assertFalse(pq.enqueue(qe3.data, qe3.priority));
		assertTrue(pq.enqueue(qe4.data, qe4.priority));
		assertFalse(pq.enqueue(qe5.data, qe5.priority));
		System.out.println(pq);
		assertListEquals(qe5, pq.head);
	}

	@Test
	public void addOneElement_updatePriority() {
		PriorityQueueSorted pq = new PriorityQueueSorted();
		QueueElement qe1 = new QueueElement(1, 1);
		QueueElement qe2 = new QueueElement(1, 2);
		//qe2 must be the only node in the queue
		
		assertTrue(pq.enqueue(qe1.data, qe1.priority));
		System.out.println(pq);
		assertFalse(pq.enqueue(qe2.data, qe2.priority));
		System.out.println(pq);
		assertEquals(qe2, pq.head);
	}

	@Test
	public void enqueueGillesElements1() {
		PriorityQueueSorted pq = new PriorityQueueSorted();
		QueueElement qe1 = new QueueElement(1, 5);
		QueueElement qe2 = new QueueElement(12, 10);
		QueueElement qe3 = new QueueElement(123, 15);
		QueueElement qe4 = new QueueElement(1234, 1);
		QueueElement qe5 = new QueueElement(12345, 6);
		qe4.next = qe1;
		qe1.next = qe5;
		qe5.next = qe2;
		qe2.next = qe3;
		assertTrue(pq.enqueueGilles(qe1.data, qe1.priority));
		assertTrue(pq.enqueueGilles(qe2.data, qe2.priority));
		assertTrue(pq.enqueueGilles(qe3.data, qe3.priority));
		assertTrue(pq.enqueueGilles(qe4.data, qe4.priority));
		assertTrue(pq.enqueueGilles(qe5.data, qe5.priority));
		//System.out.println(pq);
		assertListEquals(qe4, pq.head);
	}

	@Test
	public void enqueueGillesElements2() {
		PriorityQueueSorted pq = new PriorityQueueSorted();
		QueueElement qe1 = new QueueElement(1, 5);
		QueueElement qe2 = new QueueElement(3, 10);
		QueueElement qe3 = new QueueElement(99, 15);
		QueueElement qe4 = new QueueElement(123, 1);
		qe4.next = qe1;
		qe1.next = qe2;
		qe2.next = qe3;
		assertTrue(pq.enqueueGilles(qe1.data, qe1.priority));
		assertTrue(pq.enqueueGilles(qe2.data, qe2.priority));
		assertTrue(pq.enqueueGilles(qe3.data, qe3.priority));
		assertTrue(pq.enqueueGilles(qe4.data, qe4.priority));
		assertListEquals(qe4, pq.head);
	}
	
	@Test
	public void enqueueGillesElements2update() {
		PriorityQueueSorted pq = new PriorityQueueSorted();
		QueueElement qe1 = new QueueElement(1, 5);
		QueueElement qe2 = new QueueElement(3, 10);
		QueueElement qe3 = new QueueElement(1, 5);
		QueueElement qe4 = new QueueElement(123, 1);
		QueueElement qe5 = new QueueElement(123, 1);
		qe5.next = qe3;
		qe3.next = qe2;
		//qe2.next = qe3;
		assertTrue(pq.enqueueGilles(qe1.data, qe1.priority));
		assertTrue(pq.enqueueGilles(qe2.data, qe2.priority));
		assertFalse(pq.enqueueGilles(qe3.data, qe3.priority));
		assertTrue(pq.enqueueGilles(qe4.data, qe4.priority));
		assertFalse(pq.enqueueGilles(qe5.data, qe5.priority));

		assertListEquals(qe5, pq.head);
	}

	@Test
	public void enqueueGillesSorted_addOneElement_updatePriority() {
		PriorityQueueSorted pq = new PriorityQueueSorted();
		QueueElement qe1 = new QueueElement(1, 1);
		QueueElement qe2 = new QueueElement(1, 2);
		//qe2 must be the only node in the queue
		
		assertTrue(pq.enqueueGilles(qe1.data, qe1.priority));
		assertFalse(pq.enqueueGilles(qe2.data, qe2.priority));
		assertEquals(qe2, pq.head);
	}

	public void assertListEquals(QueueElement expected, QueueElement actual) {
		while (expected != null && expected.equals(actual)) {
			expected = expected.next;
			actual = actual.next;
		}
		if ((expected == null && actual == null) || (expected != null && expected.equals(actual))) {
			return;
		} else {
			failNotEquals("Elements are not equal", expected, actual);
		}

	}

}
