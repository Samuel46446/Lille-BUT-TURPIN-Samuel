package tp10;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PrioritySchedulingQueueTest {
	public Task t1, t2, t3;
	public PrioritySchedulingQueue<Task> orderedTasks;

	@BeforeEach
	void initialization() {
		SchedulingQueue.queueCounter = 0;
		this.orderedTasks = new PrioritySchedulingQueue<>();
		t1 = new Task("t1", 6);
		t2 = new Task("t2", 4);
		t3 = new Task("t3", 2);
	}

	@Test
	void testAddElementTask() {
		assertEquals(0, orderedTasks.size());
		orderedTasks.addElement(t1);
		assertEquals(1, orderedTasks.size());
		orderedTasks.addElement(t2);
		assertEquals(2, orderedTasks.size());
	}

	@Test
	void testHighestPriorityTask_oneElement() {
		orderedTasks.addElement(t1);
		assertEquals(1, orderedTasks.size());
		assertEquals(t1, orderedTasks.highestPriority());
		assertEquals(0, orderedTasks.size());
		assertNull(orderedTasks.highestPriority());
	}

	@Test
	void testHighestPriorityTask_twoElements_ordered() {
		orderedTasks.addElement(t2);
		orderedTasks.addElement(t1);
		assertEquals(2, orderedTasks.size());
		assertEquals(t2, orderedTasks.highestPriority());
		assertEquals(1, orderedTasks.size());
		assertEquals(t1, orderedTasks.highestPriority());
		assertEquals(0, orderedTasks.size());
		assertNull(orderedTasks.highestPriority());
	}

	@Test
	void testHighestPriorityTask_twoElements_nonOrdered() {
		orderedTasks.addElement(t1);
		orderedTasks.addElement(t2);
		assertEquals(2, orderedTasks.size());
		assertEquals(t2, orderedTasks.highestPriority());
		assertEquals(1, orderedTasks.size());
		assertEquals(t1, orderedTasks.highestPriority());
		assertEquals(0, orderedTasks.size());
		assertNull(orderedTasks.highestPriority());
	}

	@Test
	void testHighestPriorityTask_threeElements() {
		orderedTasks.addElement(t1);
		orderedTasks.addElement(t3);
		orderedTasks.addElement(t2);
		assertEquals(3, orderedTasks.size());
		assertEquals(t3, orderedTasks.highestPriority());
		assertEquals(2, orderedTasks.size());
		assertEquals(t2, orderedTasks.highestPriority());
		assertEquals(1, orderedTasks.size());
		assertEquals(t1, orderedTasks.highestPriority());
		assertEquals(0, orderedTasks.size());
		assertNull(orderedTasks.highestPriority());
	}

	@Test
	void testIsEmptyTask() {
		assertTrue(orderedTasks.isEmpty());
		assertEquals(0, orderedTasks.size());
		orderedTasks.addElement(t1);
		assertFalse(orderedTasks.isEmpty());
		assertEquals(1, orderedTasks.size());
		assertEquals(t1, orderedTasks.highestPriority());
		assertTrue(orderedTasks.isEmpty());
		assertEquals(0, orderedTasks.size());
	}

	@Test
	void testToStringTask() {
		assertEquals(0, orderedTasks.size());
		assertEquals("Queue0 -> []", orderedTasks.toString());
		orderedTasks.addElement(t1);
		assertEquals(1, orderedTasks.size());
		assertEquals("Queue0 -> [t1(6)]", orderedTasks.toString());
		orderedTasks.addElement(t2);
		assertEquals(2, orderedTasks.size());
		assertEquals("Queue0 -> [t2(4), t1(6)]", orderedTasks.toString());
	}

	class Task implements IPriority{
		String name;
		int priority;

		Task(String name, int priority) {
			this.name = name;
			this.priority = priority;
		}
		public String toString() {return this.name + "(" + this.priority + ")";}
		public int getPriority() {return this.priority;}
	}
}
