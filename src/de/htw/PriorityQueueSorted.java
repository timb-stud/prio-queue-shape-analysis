package de.htw;

public class PriorityQueueSorted implements IPriorityQueue {

	/**
	 * Referenz auf das erste Element der Queue bzw. null, falls die Queue keine
	 * Elemente enthaelt, d.h. leer ist.
	 */
	protected QueueElement head;

	public PriorityQueueSorted() {
		this.head = null;
	}

	@Override
	public int peek() {
		if (head == null)
			return 0;
		return head.data;
	}

	@Override
	public int dequeue() {
		if (head == null)
			return 0;
		QueueElement dequeueElm = head;
		if (dequeueElm.next != null) {
			head = dequeueElm.next;
			dequeueElm.next = null;
		} else {
			head = null;
		}
		return dequeueElm.data;
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

		QueueElement qe = new QueueElement(data, priority);
		if (head == null) {
			head = qe;
			return true;
		}

		// if list contains element with the same data, the priority must be
		// updated
		QueueElement preD = head;
		QueueElement currentD = head;
		while (currentD != null) {
			if (currentD.data == data) {
				QueueElement dequeueElm = currentD;
				if (dequeueElm.next != null) {
					preD.next = dequeueElm.next;
					dequeueElm.next = null;
				} else {
					preD.next = null;
				}
			}
			preD = currentD;
			currentD = currentD.next;
		}

		QueueElement pre = head;
		QueueElement current = head;
		while (current != null) {
			if (current.priority < priority) {
				pre = current;
				current = current.next;
			} else {
				current = null; // loop exit
			}
		}
		if (pre.next != null) {
			qe.next = pre.next;
		}
		pre.next = qe;

		return true;
	}

	public boolean enqueueGilles(int data, int priority) {
		if (data <= 0)
			return false;

		QueueElement newNode = new QueueElement(data, priority);

		// Insert into empty list
		if (head == null) {
			head = newNode;
			return true;
		}

		// this is our general case, iterates completely over the entire queue
		// remove the node with the same value as the argument data, because a
		// value is only allowed once in the queue
		// add a new node before the first node, which has a worse priority as
		// the argument priority
		QueueElement pre = null;
		QueueElement current = head;
		boolean alreadyAdded = false;
		while (current != null) {
			if (current.data == data) { // remove current node
				if (pre != null) {
					pre.next = current.next;
				} else { // current node is the head of the queue
					head = current.next;
				}

				current = current.next; // switch to next node, and try again
				// pre stays the same as it points now to the new current node
				continue;
			}

			if (!alreadyAdded && priority < current.priority) {
				// add before current node, as the priority has become too worse
				if (pre != null) { // add the new node between two nodes
					pre.next = newNode;
					newNode.next = current;
				} else { // current node is the head of the queue
					head = newNode;
					head.next = current;
				}
				alreadyAdded = true; // make sure that the new node is only
										// added once
			}
			pre = current;
			current = current.next;
		}

		// if no node was added to the queue, add it as last element
		// because no other place in the queue has been found, which fits for
		// the new node
		// pre is the tail of the queue
		if (!alreadyAdded) { // element was not yet added
			if (pre != null) { // queue is not empty
				pre.next = newNode;
			} else { // queue is empty
				head = newNode;
			}
		}
		return true;
	}

	@Override
	public boolean isEmpty() {
		return this.head == null;
	}

	public String toString() {
		String output = "{prio,data}-->";
		QueueElement current = head;
		while (current != null) {
			output += "{" + current.priority + ", " + current.data + "}-->";
			current = current.next;
		}
		return output;
	}

}
