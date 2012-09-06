package de.htw;

/**
 * Eine einfache Vorrangwarteschlange; intern basierend auf einer
 * doppeltverketten Liste.
 */
public class PriorityQueueUnsorted implements IPriorityQueue {

	/**
	 * Referenz auf das erste Element der Queue bzw. null, falls die Queue keine
	 * Elemente enthaelt, d.h. leer ist.
	 */
	protected QueueElement head;

	public PriorityQueueUnsorted() {
		this.head = null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.htw.IPriorityQueue#peek()
	 */
	@Override
	public int peek() {

		if (head == null) {
			return 0;
		}
		
		QueueElement maxPrio = head;
		QueueElement current = head.next;
		while (current != null) {
			if (current.priority < maxPrio.priority) { // Variable vertauschen,
														// in tvla
														// maxPrio.priority > current.priority
				maxPrio = current;
			}
			current = current.next;
		}
		return maxPrio.data;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.htw.IPriorityQueue#dequeue()
	 */
	@Override
	public int dequeue() {
		int result = 0;
		if (head != null) {
			QueueElement preDequeueElm = head;
			QueueElement pre = head;
			result = head.data;
			if (preDequeueElm.next == null) {
				head = null;
				return result;
			}

			int maxPrio = head.priority;
			QueueElement current = head;
			while (current != null) {
				if (current.priority < maxPrio) {
					maxPrio = current.priority;
					result = current.data;
					preDequeueElm = pre;
				}
				pre = current;
				current = current.next;
			}

			QueueElement dequeueElm;
			if (preDequeueElm.priority == maxPrio) {
				dequeueElm = head;
				head = dequeueElm.next;
			} else
				dequeueElm = preDequeueElm.next;

			if (dequeueElm.next != null) {
				preDequeueElm.next = dequeueElm.next;
				dequeueElm.next = null;
			} else {
				preDequeueElm.next = null;
			}
		}
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.htw.IPriorityQueue#enqueue(int, int)
	 */
	@Override
	public boolean enqueue(int data, int priority) {
//		if (data <= 0)
//			return false;

		QueueElement newElement = new QueueElement();
		newElement.data = data;
		newElement.priority = priority;

		// if list contains element with the same data, the priority must be
		// updated
		QueueElement current = this.head;
		while (current != null) {
			if (current.data == newElement.data) {
				current.priority = newElement.priority;
				return false;
			}
			current = current.next;
		}

		QueueElement second = head;
		head = newElement;
		head.next = second;

		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.htw.IPriorityQueue#isEmpty()
	 */
	@Override
	public boolean isEmpty() {
		return this.head == null;
	}

	public String toString() {
		String output = "";
		QueueElement current = head;
		while (current != null) {
			output += current.toString() + "-->";
			current = current.next;
		}
		return output;
	}
}
