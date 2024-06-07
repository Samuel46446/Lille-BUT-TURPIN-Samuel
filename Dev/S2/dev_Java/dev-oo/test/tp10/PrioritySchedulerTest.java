package tp10;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PrioritySchedulerTest {
	public Task t1, t2, t3, t4, t5;
	public PriorityScheduler myScheduler;
	public int width;

	@BeforeEach
	void initialization() {
		SchedulingQueue.queueCounter = 0; // reset of automatic numbering from SchedulingQueue
		width = 4;
		myScheduler = new PriorityScheduler(width);
		t1 = new Task("t1", 3);
		t2 = new Task("t2", 3);
		t3 = new Task("t3", 1);
		t4 = new Task("t4", 5);
		t5 = new Task("t5", 2);
	}

	@Test
	void testSize(){
		assertEquals(0, myScheduler.size()); // empty PriorityScheduler
		for(int i=0; i<=width+1; i++) assertEquals(0, myScheduler.size(i));
		myScheduler.addElement(t1); // 1 task, priority 3
		assertEquals(1, myScheduler.size());
		for(int i=0; i<=width+1; i++)
			if(i==3) assertEquals(1, myScheduler.size(i));
			else assertEquals(0, myScheduler.size(i));
		myScheduler.addElement(t2); // 2 tasks, same priority
		assertEquals(2, myScheduler.size());
		for(int i=0; i<=width+1; i++)
			if(i==3) assertEquals(2, myScheduler.size(i));
			else assertEquals(0, myScheduler.size(i));
		myScheduler.addElement(t3); // 3 tasks, 2 priority values
		assertEquals(3, myScheduler.size());
		for(int i=0; i<=width+1; i++)
			if(i==1) assertEquals(1, myScheduler.size(i));
			else if(i==3) assertEquals(2, myScheduler.size(i));
			else assertEquals(0, myScheduler.size(i));
		myScheduler.addElement(t4); // new task with priority > nbQueue
		assertEquals(4, myScheduler.size());
		for(int i=0; i<=width+1; i++)
			if(i==1) assertEquals(1, myScheduler.size(i));
			else if(i==3) assertEquals(3, myScheduler.size(i));
			else assertEquals(0, myScheduler.size(i));
	}

	@Test
	void testHighestPriorityTask_noElement() {
		assertEquals(0, myScheduler.size());
		assertNull(myScheduler.highestPriority());
	}

	@Test
	void testHighestPriorityTask_oneElement() {
		myScheduler.addElement(t1);
		assertEquals(1, myScheduler.size());
		assertEquals(t1, myScheduler.highestPriority());
		assertEquals(0, myScheduler.size());
		assertNull(myScheduler.highestPriority());
	}

	@Test
	void testHighestPriorityTask_twoElements_samePriority() {
		myScheduler.addElement(t2);
		myScheduler.addElement(t1);
		assertEquals(2, myScheduler.size());
		assertEquals(t2, myScheduler.highestPriority());
		assertEquals(1, myScheduler.size());
		assertEquals(t1, myScheduler.highestPriority());
		assertEquals(0, myScheduler.size());
		assertNull(myScheduler.highestPriority());
	}

	@Test
	void testHighestPriorityTask_twoElements_nonOrdered() {
		myScheduler.addElement(t4);
		myScheduler.addElement(t2);
		assertEquals(2, myScheduler.size());
		assertEquals(t4, myScheduler.highestPriority());
		assertEquals(1, myScheduler.size());
		assertEquals(t2, myScheduler.highestPriority());
		assertEquals(0, myScheduler.size());
		assertNull(myScheduler.highestPriority());
	}

	@Test
	void testHighestPriorityTask_threeElements() {
		myScheduler.addElement(t1);
		myScheduler.addElement(t3);
		myScheduler.addElement(t2);
		assertEquals(3, myScheduler.size());
		assertEquals(t3, myScheduler.highestPriority());
		assertEquals(2, myScheduler.size());
		assertEquals(t1, myScheduler.highestPriority());
		assertEquals(1, myScheduler.size());
		assertEquals(t2, myScheduler.highestPriority());
		assertEquals(0, myScheduler.size());
		assertNull(myScheduler.highestPriority());
	}

	@Test
	void testIsEmptyTask() {
		assertTrue(myScheduler.isEmpty());
		assertEquals(0, myScheduler.size());
		myScheduler.addElement(t1);
		assertFalse(myScheduler.isEmpty());
		assertEquals(1, myScheduler.size());
		assertEquals(t1, myScheduler.highestPriority());
		assertTrue(myScheduler.isEmpty());
		assertEquals(0, myScheduler.size());
	}

	@Test
	void testToStringTask() {
		assertEquals(0, myScheduler.size());
		assertEquals("PriorityQueue:\nQueue0 -> []\nQueue1 -> []\nQueue2 -> []\nQueue3 -> []\n", myScheduler.toString());
		myScheduler.addElement(t1);
		assertEquals(1, myScheduler.size());
		assertEquals("PriorityQueue:\nQueue0 -> []\nQueue1 -> []\nQueue2 -> []\nQueue3 -> [t1(3)]\n", myScheduler.toString());
		myScheduler.addElement(t2);
		assertEquals(2, myScheduler.size());
		assertEquals("PriorityQueue:\nQueue0 -> []\nQueue1 -> []\nQueue2 -> []\nQueue3 -> [t1(3), t2(3)]\n", myScheduler.toString());
		myScheduler.addElement(t3);
		assertEquals(3, myScheduler.size());
		assertEquals("PriorityQueue:\nQueue0 -> []\nQueue1 -> [t3(1)]\nQueue2 -> []\nQueue3 -> [t1(3), t2(3)]\n", myScheduler.toString());
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
