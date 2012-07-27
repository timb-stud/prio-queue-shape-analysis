import de.htw.PriorityQueueSorted;


public class Main {
	
	
	public static void main(String[] args) {
//		PrioQueueSorted pqs = new PrioQueueSorted();
//		System.out.println(pqs.enqueue(2, 2));
//		System.out.println(pqs.enqueue(1, 1));
//		System.out.println(pqs.enqueue(3, 3));
//		System.out.println(pqs.toString());
		
		PriorityQueueSorted pq = new PriorityQueueSorted();
		System.out.println("Element added: " + pq.enqueue(2, 2));
		System.out.println("Element added: " + pq.enqueue(1, 1));
		System.out.println("Element added: " + pq.enqueue(3, 3));
		//System.out.println(pq.enqueue(6, 6));
		System.out.println("Element added: " + pq.enqueue(5, 5));
		System.out.println("Element added: " + pq.enqueue(4, 4));
		System.out.println(pq.toString());
		System.out.println("peek: " + pq.peek());
		System.out.println("dequeue: " + pq.dequeue());
		System.out.println(pq.toString());
		System.out.println("dequeue: " + pq.dequeue());
		System.out.println(pq.toString());
		System.out.println("Element added: " + pq.enqueue(3, 2));
		System.out.println(pq.toString());
		System.out.println("peek: " + pq.peek());
	}
}

