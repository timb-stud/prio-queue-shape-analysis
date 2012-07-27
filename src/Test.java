import static org.junit.Assert.*;
import de.htw.PriorityQueueSorted;
import de.htw.PriorityQueueUnsorted;


public class Test {
	
	@org.junit.Test
	public void enQueueDeQueueSorted(){
		PriorityQueueSorted pqs = new PriorityQueueSorted();
		pqs.enqueueGilles(2, 2);
		pqs.enqueueGilles(1, 1);
		pqs.enqueueGilles(5, 5);
		pqs.enqueueGilles(3, 3);
		
		int output = pqs.peek();
		assertEquals(1, output);
	}
	
	@org.junit.Test
	public void enqueueSorted_addOneElement_updatePriority(){
		PriorityQueueSorted pqs = new PriorityQueueSorted();
		pqs.enqueueGilles(1, 1);
		pqs.enqueueGilles(1, 2);
		
		int output = pqs.peek();
		assertEquals(1, output);
	}
	
	@org.junit.Test
	public void enqueueSorted_addOneElement_AddOneAfterHead(){
		PriorityQueueSorted pqs = new PriorityQueueSorted();
		pqs.enqueueGilles(1, 1);
		pqs.enqueueGilles(2, 2);
		
		int output = pqs.peek();
		assertEquals(1, output);
	}
	
	@org.junit.Test
	public void enqueueSorted_addMoreElements_updatePriority(){
		PriorityQueueSorted pqs = new PriorityQueueSorted();
		pqs.enqueueGilles(2, 2);
		pqs.enqueueGilles(1, 1);
		pqs.enqueueGilles(5, 5);
		pqs.enqueueGilles(3, 3);
		
		pqs.enqueueGilles(5, 1);
		pqs.enqueueGilles(2, 4);
		pqs.enqueueGilles(3, 6);
		
		int output = pqs.dequeue();
		assertEquals(1, output);
		output = pqs.peek();
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
