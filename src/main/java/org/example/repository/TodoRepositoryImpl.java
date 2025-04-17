package org.example.repository;

import org.example.model.Todo;
import org.example.model.TodoStatus;
import org.example.storage.TodoFileStorage;

import java.util.List;

public class TodoRepositoryImpl implements TodoRepository {
	private final List<Todo> todos;
	private static TodoRepositoryImpl instance;
	private final TodoFileStorage todoFileStorage = new TodoFileStorage("todo.txt");;

	/**
	 * Get todos from file
	 */
	private TodoRepositoryImpl() {
		todos = todoFileStorage.getTodos();
	}

	/**
	 * Singleton instance
	 *
	 * @return TodoRepositoryImpl
	 */
	public static TodoRepositoryImpl getInstance() {
		if (instance == null) {
			instance = new TodoRepositoryImpl();
		}
		return instance;
	}

	/**
	 * Add todo
	 *
	 * @param title the name of the todo
	 */
	@Override
	public void addTodo(String title) {
		todos.add(new Todo(todos.size() + 1, title, TodoStatus.NOT_COMPLETED));
		saveTodos();
	}

	/**
	 * Remove todo by id
	 *
	 * @param todoId id of todo
	 */
	@Override
	public void removeTodoById(int todoId) {
		todos.removeIf(todo -> todo.getId() == todoId);
		saveTodos();
	}

	@Override
	public void updateTodoTitle(int todoId, String title) {
		todos.stream().filter(todo -> todo.getId() == todoId).findFirst().ifPresent(todo -> todo.setTitle(title));
		todoFileStorage.saveTodos(todos);
	}

	@Override
	public void toggleTodoCompletion(int todoId) {
		todos.stream().filter(todo -> todo.getId() == todoId).findFirst().ifPresent(Todo::toggleCompletion);
		todoFileStorage.saveTodos(todos);
	}

	@Override
	public List<Todo> getTodos() {
		return todos;
	}

	@Override
	public void saveTodos() {
		todoFileStorage.saveTodos(todos);
	}

	@Override
	public boolean exists(int todoId) {
		return todos.stream().anyMatch(todo -> todo.getId() == todoId);
	}
}
