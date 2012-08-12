package de.htw;

public class PriorityQueueSorted implements IPriorityQueue {

	/**
	 * Referenz auf das erste Element der Queue bzw. null, falls die Queue keine
	 * Elemente enthaelt, d.h. leer ist.
	 */
	public QueueElement head;

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
	public boolean enqueueChris(int data, int priority) {
		if (data <= 0)
			return false;

		QueueElement qe = new QueueElement(data, priority);
		QueueElement delElement;
		boolean added = false;

		// Insert into empty list
		if (head == null) {
			head = qe;
			return true;
		}
		// Insert after head
		if (head.next == null) {
			if (head.data == data) {
				head.priority = priority;
			} else {
				if (head.priority > priority) {
					qe.next = head;
					head = qe;
				} else {
					head.next = qe;
				}
			}
			return true;
		}
		
		// Override head data
		if (head.data == data) {
			delElement = head;
			head = delElement.next;
			delElement.next = null;
		}
		
		// Insert before head
		if (priority < head.priority) {
			qe.next = head;
			head = qe;
			added = true;
		}

		QueueElement pre = head;
		QueueElement current = head.next;
		while (current != null) {
			if (current.data == data) {
				pre.next = current.next;
				current.next = null;
			} else if ((priority < current.priority) && !added) {
				pre.next = qe;
				pre = pre.next;
				qe.next = current;
				added = true;
			}
			pre = current;
			current = current.next;
		}
		
		// Insert beyond tail
		if (priority > pre.priority) {
			pre.next = qe;
			qe.next = null;
		}

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

	public boolean enqueueGilles2(int data, int priority) {
		if (data <= 0)
			return false;

		QueueElement newNode = new QueueElement(data, priority);

		// Insert into empty list
		if (head == null) {
			head = newNode;
			return true;
		}

		// queue has only one node, update or add, before or after, the one node
		if (head.next == null) {
			if (head.data == data) {
				head.priority = priority;
			} else if (head.priority < priority) {
				head.next = newNode;
			} else {
				newNode.next = head;
				head = newNode;
			}
			return true;
		}

		// check if the head has to be removed
		if (head.data == data) {
			head = head.next;
		}

		// does the new node has to become the new head
		boolean alreadyAdded = false;
		if (head.priority > priority) {
			QueueElement oldHead = head;
			head = newNode;
			head.next = oldHead;
			alreadyAdded = true;
		}

		// this is our general case, iterates completely over the entire queue
		// remove the node with the same value as the argument data, because a
		// value is only allowed once in the queue
		// add a new node before the first node, which has a worse priority as
		// the argument priority
		QueueElement pre = head;
		QueueElement current = head.next;

		while (current != null) {
			if (current.data == data) { // remove current node
				pre.next = current.next;
				current = current.next; // switch to next node, and try again
				// pre stays the same as it points now to the new current node
				continue;
			}

			if (!alreadyAdded && priority < current.priority) {
				// add before current node, as the priority has become too worse
				pre.next = newNode;
				newNode.next = current;
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
		if (!alreadyAdded) {
			pre.next = newNode;
		}
		return true;
	}
	
	public boolean enqueue(int data, int priority){
		QueueElement prev = null;
		QueueElement cur = head;
		
		QueueElement left  = null;
		QueueElement right = null;
		
		boolean marked = false;
		boolean added = true;
		QueueElement nel = new QueueElement(data, priority);

		if(cur==null) {
			head = nel;
			return true;
		}
		while(cur != null) {
			if(!marked && cur.priority >= priority) {
				if(cur.data == data) {
					cur.priority = priority;
					return false;
				}
				else {
					left  = prev;
					right = cur;
					marked = true;
				}
			}
			if(cur.data == data) {
				if(prev != null)
					prev.next = cur.next;
				else
					head = cur.next;
				added = false;
			}
			prev = cur;
			cur  = cur.next;
		}
		if(!marked) {
			if(head != null)
				prev.next = nel;
			else
				head = nel;
			return added;
		}
		if(left != null)
			left.next = nel;
		else
			head = nel;
		nel.next = right;
		
		return added;
	}

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
