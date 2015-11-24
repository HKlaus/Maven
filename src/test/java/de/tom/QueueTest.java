package de.tom;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Unit test for simple Queue
 */
public class QueueTest {
	Queue q1 = new Queue(3);

	@Test
	public void testEnqueue() {
		final int testVal = 1;
		q1.enqueue(testVal);
		assertEquals(testVal, q1.dequeue());
	}

	@Test
	public void testQueue() {
		for (int i = 0; i < 3; i++) {
			q1.enqueue(i);
		}
		for (int i = 0; i < 3; i++) {
			assertEquals(i, q1.dequeue());
		}
	}

	@Test(expected = IllegalStateException.class)
	public void testQueueLeer() {
		for (int i = 0; i < 5; i++) {
			assertEquals(i, q1.dequeue());
		}
	}

	@Test(expected = IllegalArgumentException.class)
	public void testLeereQueue() {
		@SuppressWarnings("unused")
		Queue q2 = new Queue(0);
	}
}
