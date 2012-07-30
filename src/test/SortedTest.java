package test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import junit.framework.Assert;

import org.junit.ComparisonFailure;
import org.junit.Test;

import de.htw.PriorityQueueSorted;
import de.htw.QueueElement;

public class SortedTest extends Assert{

	@Test
	public void enqueueNegativeElement() {
		PriorityQueueSorted pq = new PriorityQueueSorted();
		assertFalse(pq.enqueue(-1, 4));
	}
	
	@Test
	public void enqueueElements1() {
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
		fail(pq.toString());
		assertListEquals(qe4, pq.head);
	}
	
	@Test
	public void enqueueElements2() {
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
	
	public void assertListEquals(QueueElement expected, QueueElement actual) {
		while(expected != null && expected.equals(actual)){
			expected = expected.next;
			actual = actual.next;
		}
		if((expected == null && actual == null) || (expected != null && expected.equals(actual))){
			return;
		} else {
			failNotEquals("Elements are not equal", expected, actual);
		}
		
	}

}
