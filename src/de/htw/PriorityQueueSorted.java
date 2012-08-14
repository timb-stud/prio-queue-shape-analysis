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
	public boolean enqueue(int data, int priority) {
		QueueElement qe = new QueueElement(data, priority);
		boolean removed = false; //z0 = false

		// Insert into empty list
		if (head == null) {
			head = qe;
			return true;
		}
		// Insert after head
		if (head.next == null) {
			if (head.data == data) { //Add data_equals action
				head.priority = priority; //Add Set_priority action; update set_priority action
				return false;
			} else {
				if (head.priority > priority) { //Add priorty_greater action
					qe.next = head;
					head = qe;
				} else {
					head.next = qe;
				}
				return true;
			}
		}

		// Override head data
		if (head.data == data) { //Add data_equals action
			head.priority = priority; //Add Set_priority action; update set_priority action
			return false;
		}

		//Remove item with equal data
		QueueElement pre = head;
		QueueElement current = head.next;
		while(current != null && !removed){ //Add action to test removed true/false
			if(current.data == data){  //Add data_equals action
				pre.next = current.next;
				current.next = null;
				removed = true; //z0 = true
			}
			pre = current;
			current = current.next;
		}
		
		// Insert before head
		if (head.priority > priority) {  //Add priorty_greater action
			qe.next = head;
			head = qe;
			if(removed){ //Add action to test removed true/false
				return false;
			} else {
				return true;
			}
		}
		
		//Add item (always!!!)
		pre = head;
		current = head.next;
		while(current != null){
			if(current.priority > priority){ //Add priorty_greater action
				pre.next = qe;
				qe.next = current;
				if(removed){ //Add action to test removed true/false
					return false;
				} else {
					return true;
				}
			}
			pre = current;
			current = current.next;
		}

		// Insert beyond tail
		if (priority > pre.priority) {
			pre.next = qe;
			qe.next = null;
		}
		
		if(removed){ //Add action to test removed true/false
			return false;
		}else{
			return true;
		}
	}

	public boolean enqueueGilles(int data, int priority) {

		QueueElement newNode = new QueueElement(data, priority);

		// this is our general case, iterates completely over the entire queue
		// remove the node with the same value as the argument data, because a
		// value is only allowed once in the queue
		// add a new node before the first node, which has a worse priority as
		// the argument priority
		QueueElement pre = null;
		QueueElement current = head;
		boolean alreadyAdded = false;
		boolean updated = false;
		while (current != null) {
			if (!updated && current.data == data) { // remove current node
				if (pre != null) {
					pre.next = current.next;
				} else { // current node is the head of the queue
					head = current.next;
				}
				updated = true;
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

		return updated ? false : true;

	}
	
	public boolean enqueueJoerg(int data, int priority){
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
