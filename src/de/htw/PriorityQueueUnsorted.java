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
				if (current.priority < maxPrio){
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
				if(current.priority < maxPrio){
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
	public boolean enqueue( int data, int priority ) {
		if (data <= 0)
			return false;
		
		//if list contains element with the same data, the priority must be updated
		QueueElement current = head;
		while (current != null){
			if (current.data == data){
				current.priority = priority;
				return false;
			}
			current = current.next;
		}
		
		QueueElement second = head;
		head = new QueueElement(data, priority);
		head.next = second;
		
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
		String output = "";
		QueueElement current = head;
		while (current != null){
			output += current.toString() + "-->";
			current = current.next;
		}
		return output;
	}
}
