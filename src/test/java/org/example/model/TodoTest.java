package org.example.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TodoTest {
	private Todo todo;

	@BeforeEach
	void setUp() {
		todo = new Todo(1, "Test Todo", TodoStatus.NOT_COMPLETED);
	}

	@Test
	void testTodoConstructor() {
		assertEquals(1, todo.getId());
		assertEquals("Test Todo", todo.getTitle());
		assertEquals(TodoStatus.NOT_COMPLETED, todo.getStatus());
	}

	@Test
	void testSetTitle() {
		todo.setTitle("Updated Todo");
		assertEquals("Updated Todo", todo.getTitle());
	}

	@Test
	void testSetCompleted() {
		todo.setStatus(TodoStatus.COMPLETED);
		assertEquals(TodoStatus.COMPLETED, todo.getStatus());
	}

	@Test
	void testToggleCompletion() {
		todo.toggleCompletion();
		assertEquals(TodoStatus.COMPLETED, todo.getStatus());

		todo.toggleCompletion();
		assertEquals(TodoStatus.NOT_COMPLETED, todo.getStatus());
	}

	@Test
	void testToString() {
		assertEquals("1 - Test Todo - not completed", todo.toString());

		todo.setStatus(TodoStatus.COMPLETED);
		assertEquals("1 - Test Todo - completed", todo.toString());
	}
}
