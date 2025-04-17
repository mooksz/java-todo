package org.example.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TodoStatusTest {

	@Test
	void testToString() {
		assertEquals("Completed", TodoStatus.COMPLETED.toString());
		assertEquals("Not completed", TodoStatus.NOT_COMPLETED.toString());
	}

	@Test
	void testFromString() {
		assertEquals(TodoStatus.COMPLETED, TodoStatus.fromString("Completed"));
		assertEquals(TodoStatus.NOT_COMPLETED, TodoStatus.fromString("Not completed"));
	}
}
