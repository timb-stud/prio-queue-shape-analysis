package de.htw;

public class PriorityQueueSorted implements IPriorityQueue {

	/**
	  * Referenz auf das erste Element der Queue bzw. null, falls die
	  * Queue keine Elemente enthaelt, d.h. leer ist.
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
		QueueElement delElement;
		
		//Insert into empty list
		if(head == null){
			head = qe;
			return true;
		} 
		//Insert after head
		if(head.next == null){
			if(head.data == data){
				head.priority = priority;
			} else {
				if(head.priority > priority){
					qe.next = head;
					head = qe;
				} else {
					head.next = qe;
				}
			}
			return true;
		}
		//Insert before head
		if(priority < head.priority){
			qe.next = head;
			head = qe;
			return true;
		}
		//Override head data
		if(head.data == data){	
			delElement = head;
			head = delElement.next;
			delElement.next = null;
		}
		
		QueueElement pre = head;
		QueueElement current = head.next;
		while (current != null) {
			if (current.data == data){
				pre.next = current.next;
				current.next = null;
			}
			if(priority < current.priority){
				qe.next = current;
				pre.next = qe;
			}
			pre = current;
			current = current.next;
		}
		
		//Insert beyond tail
		if (priority > pre.priority){
			pre.next = qe;
		}
		
		return true;
	}

	@Override
	public boolean isEmpty() {
		return this.head == null;
	}
	
	public String toString(){
		String output = "";
		QueueElement current = head;
		while (current != null){
			output += current.toString() + "-->";
			current = current.next;
		}
		return output;
	}

}
