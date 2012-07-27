import static org.junit.Assert.*;
import de.htw.PriorityQueueSorted;
import de.htw.PriorityQueueUnsorted;


public class Test {
	
	@org.junit.Test
	public void enQueueDeQueueSorted(){
		PriorityQueueSorted pqs = new PriorityQueueSorted();
		pqs.enqueue(2, 2);
		pqs.enqueue(1, 1);
		pqs.enqueue(5, 5);
		pqs.enqueue(3, 3);
		
		int output = pqs.peek();
		assertEquals(5, output);
	}
	
	@org.junit.Test
	public void enQueueDeQueue(){
		PriorityQueueUnsorted pq = new PriorityQueueUnsorted();
		pq.enqueue(1, 1);
		pq.enqueue(5, 5);
		pq.enqueue(3, 3);
		
		int output = pq.peek();
		assertEquals(5, output);
	}
	
	@org.junit.Test
	public void emptyTest() {
		PriorityQueueSorted pqs = new PriorityQueueSorted();
		assertTrue(pqs.isEmpty());
	}
}
