import de.htw.PrioQueueSorted;
import de.htw.PriorityQueue;


public class Main {
	
	
	public static void main(String[] args) {
		PrioQueueSorted pqs = new PrioQueueSorted();
		System.out.println(pqs.enqueue(2, 2));
		System.out.println(pqs.enqueue(1, 1));
		System.out.println(pqs.enqueue(3, 3));
		System.out.println(pqs.toString());
		
		PriorityQueue pq = new PriorityQueue();
		System.out.println(pq.enqueue(2, 2));
		System.out.println(pq.enqueue(1, 1));
		System.out.println(pq.enqueue(3, 3));
		System.out.println(pq.enqueue(5, 5));
		System.out.println(pq.enqueue(4, 4));
		System.out.println(pq.toString());
		System.out.println(pq.peek());
		System.out.println(pq.dequeue());
		System.out.println(pq.toString());
	}
}
