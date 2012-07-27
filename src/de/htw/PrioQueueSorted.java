package de.htw;

public class PrioQueueSorted implements IPriorityQueue {

	/**
	  * Referenz auf das erste Element der Queue bzw. null, falls die
	  * Queue keine Elemente enthaelt, d.h. leer ist.
	  */
	protected QueueElement head;

	public PrioQueueSorted() {
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
		if (dequeueElm.next != null){
			head = dequeueElm.next;
			dequeueElm.next = null;
		} else {
			head = null;
		}
		return dequeueElm.data;
	}

	/* (non-Javadoc)
	 * @see de.htw.IPriorityQueue#enqueue(int, int)
	 */
	@Override
	public boolean enqueue( int data, int priority ) {
		if (data <= 0)
			return false;
		
		QueueElement qe = new QueueElement( data, priority );
		if(head == null){
			head = qe;
			return true;
		}
		
		//if list contains element with the same data, the priority must be updated
		QueueElement preD = head;
		QueueElement currentD = head;
		while (currentD != null){
			if (currentD.data == data){
				QueueElement dequeueElm = currentD;
				if (dequeueElm.next != null){
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
		while (current != null){
			if (current.priority < priority){
				pre = current;
				current = current.next;
			} else {
				current = null; //loop exit
			}
		}
		if(pre.next != null){
			qe.next = pre.next;
		}
		pre.next = qe;
		
		return true;
	}

	@Override
	public boolean isEmpty() {
		return this.head == null;
	}
	
	public String toString(){
		String output = "{prio,data}-->";
		QueueElement current = head;
		while (current != null){
			output += "{" + current.priority + ", " + current.data + "}-->";
			current = current.next;
		}
		return output;
	}

}
