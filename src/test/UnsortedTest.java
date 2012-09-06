package test;

import junit.framework.Assert;

import org.junit.Test;

import de.htw.PriorityQueueUnsorted;
import de.htw.QueueElement;

public class UnsortedTest extends Assert {
	

	@Test
	public void enqueueElm1() {
		PriorityQueueUnsorted pq = new PriorityQueueUnsorted();
		QueueElement qe1 = new QueueElement(1, 5);
		QueueElement qe2 = new QueueElement(12, 10);
		QueueElement qe3 = new QueueElement(123, 15);
		QueueElement qe4 = new QueueElement(1234, 1);
		QueueElement qe5 = new QueueElement(12345, 6);

		qe5.next = qe4;
		qe4.next = qe3;
		qe3.next = qe2;
		qe2.next = qe1;
		
		assertTrue(pq.enqueue(qe1.data, qe1.priority));
		assertTrue(pq.enqueue(qe2.data, qe2.priority));
		assertTrue(pq.enqueue(qe3.data, qe3.priority));
		assertTrue(pq.enqueue(qe4.data, qe4.priority));
		assertTrue(pq.enqueue(qe5.data, qe5.priority));
		
		assertListEquals(qe5, pq.head);
	}

	@Test
	public void enqeueElm2() {
		PriorityQueueUnsorted pq = new PriorityQueueUnsorted();
		QueueElement qe1 = new QueueElement(1, 5);
		QueueElement qe2 = new QueueElement(3, 10);
		QueueElement qe3 = new QueueElement(99, 15);
		QueueElement qe4 = new QueueElement(123, 1);

		qe4.next = qe3;
		qe3.next = qe2;
		qe2.next = qe1;
		
		assertTrue(pq.enqueue(qe1.data, qe1.priority));
		assertTrue(pq.enqueue(qe2.data, qe2.priority));
		assertTrue(pq.enqueue(qe3.data, qe3.priority));
		assertTrue(pq.enqueue(qe4.data, qe4.priority));
		
		assertListEquals(qe4, pq.head);
	}
	
	@Test
	public void enqeueElm3() {
		PriorityQueueUnsorted pq = new PriorityQueueUnsorted();
		QueueElement qe1 = new QueueElement(1, 5);
		QueueElement qe2 = new QueueElement(12, 10);
		QueueElement qe3 = new QueueElement(123, 15);
		QueueElement qe4 = new QueueElement(1234, 1);
		QueueElement qe5 = new QueueElement(12345, 6);
		
		qe5.next = qe4;
		qe4.next = qe3;
		qe3.next = qe2;
		qe2.next = qe1;
		
		assertTrue(pq.enqueue(qe1.data, qe1.priority));
		assertTrue(pq.enqueue(qe2.data, qe2.priority));
		assertTrue(pq.enqueue(qe3.data, qe3.priority));
		assertTrue(pq.enqueue(qe4.data, qe4.priority));
		assertTrue(pq.enqueue(qe5.data, qe5.priority));
		assertListEquals(qe5, pq.head);
	}

	@Test
	public void enqeueElm4() {
		PriorityQueueUnsorted pq = new PriorityQueueUnsorted();
		QueueElement qe1 = new QueueElement(1, 5);
		QueueElement qe2 = new QueueElement(3, 10);
		QueueElement qe3 = new QueueElement(99, 15);
		QueueElement qe4 = new QueueElement(123, 1);
		
		qe4.next = qe3;
		qe3.next = qe2;
		qe2.next = qe1;
		
		assertTrue(pq.enqueue(qe1.data, qe1.priority));
		assertTrue(pq.enqueue(qe2.data, qe2.priority));
		assertTrue(pq.enqueue(qe3.data, qe3.priority));
		assertTrue(pq.enqueue(qe4.data, qe4.priority));
		assertListEquals(qe4, pq.head);
	}
	
	@Test
	public void enqeueElm2update() {
		PriorityQueueUnsorted pq = new PriorityQueueUnsorted();
		QueueElement qe1 = new QueueElement(1, 5);
		QueueElement qe2 = new QueueElement(3, 10);
		QueueElement qe3 = new QueueElement(1, 5);
		QueueElement qe4 = new QueueElement(123, 1);
		QueueElement qe5 = new QueueElement(123, 1);
		
		qe5.next = qe2;
		qe2.next = qe1;
		
		assertTrue(pq.enqueue(qe1.data, qe1.priority));
		assertTrue(pq.enqueue(qe2.data, qe2.priority));
		assertFalse(pq.enqueue(qe3.data, qe3.priority));
		assertTrue(pq.enqueue(qe4.data, qe4.priority));
		assertFalse(pq.enqueue(qe5.data, qe5.priority));
		
		assertListEquals(qe5, pq.head);
	}


	@Test
	public void enqeueElm3update() {
		PriorityQueueUnsorted pq = new PriorityQueueUnsorted();
		QueueElement qe1 = new QueueElement(1, 5);
		QueueElement qe2 = new QueueElement(3, 10);
		QueueElement qe3 = new QueueElement(1, 5);
		QueueElement qe4 = new QueueElement(123, 1);
		QueueElement qe5 = new QueueElement(123, 1);
		
		qe5.next = qe2;
		qe2.next = qe3;
		
		assertTrue(pq.enqueue(qe1.data, qe1.priority));
		assertTrue(pq.enqueue(qe2.data, qe2.priority));
		assertFalse(pq.enqueue(qe3.data, qe3.priority));
		assertTrue(pq.enqueue(qe4.data, qe4.priority));
		assertFalse(pq.enqueue(qe5.data, qe5.priority));

		System.out.println(printQueue(qe5));
		System.out.println(printQueue(pq.head));
		
		assertListEquals(qe5, pq.head);
	}
	
	@Test
	public void enqueueOneElement_updatePriority() {
		PriorityQueueUnsorted pq = new PriorityQueueUnsorted();
		QueueElement qe1 = new QueueElement(1, 1);
		QueueElement qe2 = new QueueElement(1, 2);
		//qe2 must be the only node in the queue
		
		assertTrue(pq.enqueue(qe1.data, qe1.priority));
		assertFalse(pq.enqueue(qe2.data, qe2.priority));
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
	
	private String printQueue(QueueElement curQueueElm){
		StringBuilder sb = new StringBuilder();
		while(curQueueElm != null){
			sb.append(curQueueElm);
			curQueueElm = curQueueElm.next;
		}
		return sb.toString();
	}

	@Test
	public void dequeueElm1(){
		PriorityQueueUnsorted pq = new PriorityQueueUnsorted();
		QueueElement qe1 = new QueueElement(1, 5);
		QueueElement qe2 = new QueueElement(12, 10);
		QueueElement qe3 = new QueueElement(123, 15);
		QueueElement qe4 = new QueueElement(1234, 1);
		QueueElement qe5 = new QueueElement(12345, 6);

		qe5.next = qe4;
		qe4.next = qe3;
		qe3.next = qe2;
		qe2.next = qe1;
		
		assertTrue(pq.enqueue(qe1.data, qe1.priority));
		assertTrue(pq.enqueue(qe2.data, qe2.priority));
		assertTrue(pq.enqueue(qe3.data, qe3.priority));
		assertTrue(pq.enqueue(qe4.data, qe4.priority));
		assertTrue(pq.enqueue(qe5.data, qe5.priority));
		
		assertListEquals(qe5, pq.head);
		
		assertEquals(1234, pq.dequeue());
		assertEquals(1, pq.dequeue());
		assertEquals(12345, pq.dequeue());
		assertEquals(12, pq.dequeue());
		assertEquals(123, pq.dequeue());
	}

	@Test
	public void dequeueOneElmQueue1(){
		PriorityQueueUnsorted pq = new PriorityQueueUnsorted();
		QueueElement qe1 = new QueueElement(1, 5);

		qe1.next = null;
		
		assertTrue(pq.enqueue(qe1.data, qe1.priority));
		
		assertListEquals(qe1, pq.head);
		
		assertEquals(1, pq.dequeue());
	}
	
	@Test //first elm is max prio
	public void dequeueTwoElmQueue1(){
		PriorityQueueUnsorted pq = new PriorityQueueUnsorted();
		QueueElement qe1 = new QueueElement(1, 5);
		QueueElement qe2 = new QueueElement(3, 2);

		qe2.next = qe1;
		
		assertTrue(pq.enqueue(qe1.data, qe1.priority));
		assertTrue(pq.enqueue(qe2.data, qe2.priority));
		
		assertListEquals(qe2, pq.head);
		
		assertEquals(3, pq.dequeue());
	}
	
	@Test //last elm is max prio
	public void dequeueTwoElmQueue2(){
		PriorityQueueUnsorted pq = new PriorityQueueUnsorted();
		QueueElement qe1 = new QueueElement(1, 5);
		QueueElement qe2 = new QueueElement(3, 7);

		qe2.next = qe1;
		
		assertTrue(pq.enqueue(qe1.data, qe1.priority));
		assertTrue(pq.enqueue(qe2.data, qe2.priority));
		
		assertListEquals(qe2, pq.head);
		
		assertEquals(1, pq.dequeue());
	}
}
