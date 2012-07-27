import static org.junit.Assert.*;
import de.htw.PrioQueueSorted;
import de.htw.PriorityQueueUnsorted;


public class Test {
	
	@org.junit.Test
	public void enQueueDeQueueSorted(){
		PrioQueueSorted pqs = new PrioQueueSorted();
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
		PrioQueueSorted pqs = new PrioQueueSorted();
		assertTrue(pqs.isEmpty());
	}
}
