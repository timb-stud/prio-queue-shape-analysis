package de.htw;
/**
  * Eine einfache Vorrangwarteschlange; intern basierend auf einer doppeltverketten Liste.
  */
public class PriorityQueueUnsorted implements IPriorityQueue {

	/**
	  * Referenz auf das erste Element der Queue bzw. null, falls die
	  * Queue keine Elemente enthaelt, d.h. leer ist.
	  */
	protected QueueElement head;

	public PriorityQueueUnsorted() {
		this.head = null;
	}
	
	/* (non-Javadoc)
	 * @see de.htw.IPriorityQueue#peek()
	 */
	@Override
	public int peek() {
		int result = 0;
		if (head != null){
			int maxPrio = head.priority;
			result = head.data;
			QueueElement current = head;
			while (current != null){
				if (current.priority > maxPrio){
					maxPrio = current.priority;
					result = current.data;
				}
				current = current.next;
			}
		}
		return result;
	}
	
	/* (non-Javadoc)
	 * @see de.htw.IPriorityQueue#dequeue()
	 */	
	@Override
		
	public int dequeue() {
		int result = 0;
		if (head != null){
			QueueElement preDequeueElm = head;
			QueueElement pre = head;
			result = head.data;
			if(preDequeueElm.next == null){
				head = null;
				return result;
			}
			
			int maxPrio = head.priority;
			QueueElement current = head;
			while (current != null){
				if(current.priority > maxPrio){
					maxPrio = current.priority;
					result = current.data;
					preDequeueElm = pre;
				}
				pre = current;
				current = current.next;
			}
			
			QueueElement dequeueElm;
			if(preDequeueElm.priority == maxPrio){
				dequeueElm = head;
				head = dequeueElm.next;
			}else
				dequeueElm = preDequeueElm.next;
			
			if(dequeueElm.next != null){
				preDequeueElm.next = dequeueElm.next;
				dequeueElm.next = null;
			} else {
				preDequeueElm.next = null;
			}
		}
		return result;
	}
	
	
	/* (non-Javadoc)
	 * @see de.htw.IPriorityQueue#enqueue(int, int)
	 */
	@Override
	public boolean enqueueGilles( int data, int priority ) {
		if (data <= 0)
			return false;
		
		//if list contains element with the same data, the priority must be updated
		QueueElement preD = head;
		QueueElement currentD = head;
		while (currentD != null){
			if (currentD.data == data){
				QueueElement dequeueElm = currentD;
				if(preD.data == data){ //first element has same data
					head = preD.next;
				} else if (dequeueElm.next != null){
					preD.next = dequeueElm.next;
					dequeueElm.next = null;
				} else {
					preD.next = null;
				}
			}
			preD = currentD;
			currentD = currentD.next;
		}
		
		QueueElement qe = new QueueElement(data, priority);
		QueueElement current = head;
		head = qe;
		qe.next = current;
		
		return true;
	}
	
	
	/* (non-Javadoc)
	 * @see de.htw.IPriorityQueue#isEmpty()
	 */
	@Override
	public boolean isEmpty() {
		return this.head == null;
	}
	
	public String toString(){
		String output = "{prio,data}\n";
		QueueElement current = head;
		
		if(head == null)
			System.out.println("head is null!");
		
		while (current != null){
			output += "{" + current.priority + ", " + current.data + "}-->";
			current = current.next;
		}
		return output;
	}
}
