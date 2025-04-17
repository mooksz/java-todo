package org.example.storage;

import org.example.model.Todo;
import org.example.model.TodoStatus;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TodoFileStorageTest {
	private static final String TEST_FILE = "test_todos.txt";
	private TodoFileStorage storage;

	@BeforeEach
	void setup() {
		storage = new TodoFileStorage(TEST_FILE);
	}

	@AfterEach
	void cleanup() {
		new File(TEST_FILE).delete();
	}

	@Test
	void testSaveAndLoadTodos() {
		List<Todo> todos = new ArrayList<>();
		Todo todo1 = new Todo(1, "Test A", TodoStatus.NOT_COMPLETED);
		Todo todo2 = new Todo(2, "Test B", TodoStatus.COMPLETED);
		todos.add(todo1);
		todos.add(todo2);

		System.out.println(todos);

		storage.saveTodos(todos);
		List<Todo> loaded = storage.getTodos();

		System.out.println(loaded);

		assertEquals(2, loaded.size());

		assertEquals(todo1.getId(), loaded.get(0).getId());
		assertEquals(todo1.getTitle(), loaded.get(0).getTitle());
		assertEquals(todo1.getStatus(), loaded.get(0).getStatus());

		assertEquals(todo2.getId(), loaded.get(1).getId());
		assertEquals(todo2.getTitle(), loaded.get(1).getTitle());
		assertEquals(todo2.getStatus(), loaded.get(1).getStatus());
	}
}