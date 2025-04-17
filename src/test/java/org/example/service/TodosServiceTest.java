package org.example.service;

import org.example.model.Todo;
import org.example.model.TodoStatus;
import org.example.repository.TodoRepositoryImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

class TodosServiceTest {
	private TodoRepositoryImpl mockRepo;
	private TodosService todosService;

	@BeforeEach
	void setUp() {
		mockRepo = mock(TodoRepositoryImpl.class);
		todosService = new TodosService(mockRepo);
	}

	@Test
	void testAddTodo() {
		// Arrange
		String title = "New Todo";
		doNothing().when(mockRepo).addTodo(anyString());

		// Act
		todosService.addTodo(title);

		// Assert
		verify(mockRepo).addTodo(title);
	}

	@Test
	void testRemoveTodoById() {
		// Arrange
		int todoId = 1;
		doNothing().when(mockRepo).removeTodoById(anyInt());

		// Act
		todosService.removeTodoById(todoId);

		// Assert
		verify(mockRepo).removeTodoById(todoId);
	}

	@Test
	void testUpdateTodoTitle() {
		// Arrange
		int todoId = 1;
		String newTitle = "Updated Todo";
		doNothing().when(mockRepo).updateTodoTitle(anyInt(), anyString());

		// Act
		todosService.updateTodoTitle(todoId, newTitle);

		// Assert
		verify(mockRepo).updateTodoTitle(todoId, newTitle);
	}

	@Test
	void testToggleTodoCompletion() {
		// Arrange
		int todoId = 1;
		doNothing().when(mockRepo).toggleTodoCompletion(anyInt());

		// Act
		todosService.toggleTodoCompletion(todoId);

		// Assert
		verify(mockRepo).toggleTodoCompletion(todoId);
	}

	@Test
	void testGetTodos() {
		// Arrange
		List<Todo> todos = Arrays.asList(
			new Todo(1, "Test Todo", TodoStatus.NOT_COMPLETED),
			new Todo(2, "Test Todo 2", TodoStatus.NOT_COMPLETED)
		);
		when(mockRepo.getTodos()).thenReturn(todos);

		// Act
		List<Todo> result = todosService.getTodos();

		// Assert
		verify(mockRepo).getTodos();
		assert(result.equals(todos));
	}

	@Test
	void testPrintTodos() {
		// Arrange
		List<Todo> todos = Arrays.asList(
			new Todo(1, "Test Todo", TodoStatus.NOT_COMPLETED),
			new Todo(2, "Test Todo 2", TodoStatus.NOT_COMPLETED)
		);
		when(mockRepo.getTodos()).thenReturn(todos);

		// Act
		todosService.printTodos();

		// Assert
		verify(mockRepo).getTodos();
		// Since we can't capture System.out directly here, you may use an OutputStream or a logger for better testability.
	}
}
