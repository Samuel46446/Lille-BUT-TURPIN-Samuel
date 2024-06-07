package tp10;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SchedulingQueueTest {
	public Book b1, b2;
	public Task t1, t2;
	public SchedulingQueue<Book> qBook;
	public SchedulingQueue<Task> qTask;

	@BeforeEach
	void initialization() {
		SchedulingQueue.queueCounter = 0;
		this.qBook = new SchedulingQueue<>();
		this.qTask = new SchedulingQueue<>();
		b1 = new Book("H2G2", "D. Adams", 1979);
		b2 = new Book("Flatland", "E.Abbott Abbott", 1884);
		t1 = new Task("a0", 2);
		t2 = new Task("a1", 4);
	}

	@Test
	void testAddElementBook() {
		assertEquals(0, qBook.size());
		qBook.addElement(b1);
		assertEquals(1, qBook.size());
		qBook.addElement(b2);
		assertEquals(2, qBook.size());
	}

	@Test
	void testHighestPriorityBook() {
		qBook.addElement(b1);qBook.addElement(b2);
		assertEquals(2, qBook.size());
		assertEquals(b1, qBook.highestPriority());
		assertEquals(1, qBook.size());
		assertEquals(b2, qBook.highestPriority());
		assertEquals(0, qBook.size());
		assertNull(qBook.highestPriority());
		qBook.addElement(b2);qBook.addElement(b1);
		assertEquals(2, qBook.size());
		assertEquals(b2, qBook.highestPriority());
		assertEquals(1, qBook.size());
		assertEquals(b1, qBook.highestPriority());
		assertEquals(0, qBook.size());
		assertNull(qBook.highestPriority());
	}

	@Test
	void testIsEmptyBook() {
		assertTrue(qBook.isEmpty());
		assertEquals(0, qBook.size());
		qBook.addElement(b1);
		assertFalse(qBook.isEmpty());
		assertEquals(1, qBook.size());
		assertEquals(b1, qBook.highestPriority());
		assertTrue(qBook.isEmpty());
		assertEquals(0, qBook.size());
	}

	@Test
	void testToStringBook() {
		assertEquals(0, qBook.size());
		assertEquals("Queue0 -> []", qBook.toString());
		qBook.addElement(b1);
		assertEquals(1, qBook.size());
		assertEquals("Queue0 -> [H2G2:D. Adams(1979)]", qBook.toString());
		qBook.addElement(b2);
		assertEquals(2, qBook.size());
		assertEquals("Queue0 -> [H2G2:D. Adams(1979), Flatland:E.Abbott Abbott(1884)]", qBook.toString());
	}

	@Test
	void testAddElementTask() {
		assertEquals(0, qTask.size());
		qTask.addElement(t1);
		assertEquals(1, qTask.size());
		qTask.addElement(t2);
		assertEquals(2, qTask.size());
	}

	@Test
	void testHighestPriorityTask() {
		qTask.addElement(t1);qTask.addElement(t2);
		assertEquals(2, qTask.size());
		assertEquals(t1, qTask.highestPriority());
		assertEquals(1, qTask.size());
		assertEquals(t2, qTask.highestPriority());
		assertEquals(0, qTask.size());
		assertNull(qTask.highestPriority());
	}

	@Test
	void testIsEmptyTask() {
		assertTrue(qTask.isEmpty());
		assertEquals(0, qTask.size());
		qTask.addElement(t1);
		assertFalse(qTask.isEmpty());
		assertEquals(1, qTask.size());
		assertEquals(t1, qTask.highestPriority());
		assertTrue(qTask.isEmpty());
		assertEquals(0, qTask.size());
	}

	@Test
	void testToStringTask() {
		assertEquals(0, qTask.size());
		assertEquals("Queue1 -> []", qTask.toString());
		qTask.addElement(t1);
		assertEquals(1, qTask.size());
		assertEquals("Queue1 -> [a0:"+LocalDate.now().plusDays(2)+"(2)]", qTask.toString());
		qTask.addElement(t2);
		assertEquals(2, qTask.size());
		assertEquals("Queue1 -> [a0:"+LocalDate.now().plusDays(2)+"(2), a1:" + LocalDate.now().plusDays(4)+"(4)]", qTask.toString());
	}

	class Task {
		String name;
		LocalDate deadline;
		int duration;

		Task(String name, int duration) {
			this.name = name;
			this.deadline = LocalDate.now().plusDays(duration);
			this.duration = duration;
		}
		public String toString() {return this.name + ":" + this.deadline + "(" + this.duration + ")";}
		@Override
		public boolean equals(Object obj) {
			if (this == obj) return true;
			if (obj == null) return false;
			if (getClass() != obj.getClass()) return false;
			Task other = (Task) obj;
			if (!getEnclosingInstance().equals(other.getEnclosingInstance())) return false;
			if (deadline == null) {
				if (other.deadline != null) return false;
			} else if (!deadline.equals(other.deadline)) return false;
			if (duration != other.duration) return false;
			if (name == null) {
				if (other.name != null) return false;
			} else if (!name.equals(other.name)) return false;
			return true;
		}
		private SchedulingQueueTest getEnclosingInstance() {return SchedulingQueueTest.this;}
	}

	class Book {
		String title;
		String author;
		int publicationYear;
		Book(String title, String author, int publicationYear) {
			this.title = title;
			this.author = author;
			this.publicationYear = publicationYear;
		}
		public String toString() {
			return this.title + ":" + this.author + "(" + this.publicationYear + ")";
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj) return true;
			if (obj == null) return false;
			if (getClass() != obj.getClass()) return false;
			Book other = (Book) obj;
			if (!getEnclosingInstance().equals(other.getEnclosingInstance())) return false;
			if (author == null) {
				if (other.author != null) return false;
			} else if (!author.equals(other.author)) return false;
			if (publicationYear != other.publicationYear) return false;
			if (title == null) {
				if (other.title != null) return false;
			} else if (!title.equals(other.title)) return false;
			return true;
		}
		private SchedulingQueueTest getEnclosingInstance() {return SchedulingQueueTest.this;}
	}
}
