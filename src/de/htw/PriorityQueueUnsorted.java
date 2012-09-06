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
	public QueueElement head;

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
		QueueElement deqElmWithMaxPrio = null;
		if (head != null) {
			deqElmWithMaxPrio = head;
			if (deqElmWithMaxPrio.next == null) {
				head = null;
				return deqElmWithMaxPrio.data;
			}

			QueueElement preDequeueElm = head;
			QueueElement pre = head;
			QueueElement current = head;
			while (current != null) {
				if (current.priority < deqElmWithMaxPrio.priority) {
					deqElmWithMaxPrio = current;
					preDequeueElm = pre;
				}
				pre = current;
				current = current.next;
			}

			// maxPrio is first element
			if (head.priority == deqElmWithMaxPrio.priority) {
				head = head.next;
				deqElmWithMaxPrio.next = null;
				return deqElmWithMaxPrio.data;
			} 
			//maxPrio is not first and last element
			if (deqElmWithMaxPrio.next != null) {
				preDequeueElm.next = deqElmWithMaxPrio.next;
				deqElmWithMaxPrio.next = null;
			} else { //maxPrio is last element
				preDequeueElm.next = null;
			}
			return deqElmWithMaxPrio.data;
		} else {
			return 0;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.htw.IPriorityQueue#enqueue(int, int)
	 */
	@Override
	public boolean enqueue(int data, int priority) {
		if (data <= 0)
			return false;

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
