package org.example.service;

import org.example.exception.NonExistingTodoException;
import org.example.model.Todo;
import org.example.repository.TodoRepositoryImpl;

import java.util.List;

public class TodosService {
	private final TodoRepositoryImpl repo;

	public TodosService(TodoRepositoryImpl repo) {
		this.repo = repo;
	}

	/**
	 * Add todo
	 *
	 * @param title the name of the todo
	 */
	public void addTodo(String title) {
		repo.addTodo(title);
	}

	/**
	 * Remove todo by id
	 *
	 * @param todoId id of todo
	 * @throws NonExistingTodoException if the todo doesn't exist
	 */
	public void removeTodoById(int todoId) throws NonExistingTodoException {
		if ( !repo.exists(todoId)) {
			throw new NonExistingTodoException("Todo with ID " + todoId + " does not exist.");
		}
		repo.removeTodoById(todoId);
	}

	/**
	 * Update todo title
	 *
	 * @param todoId todo ID to update
	 * @param title the new title
	 */
	public void updateTodoTitle(int todoId, String title) throws NonExistingTodoException  {
		if ( !repo.exists(todoId)) {
			throw new NonExistingTodoException("Todo with ID " + todoId + " does not exist.");
		}

		repo.updateTodoTitle(todoId, title);
	}

	/**
	 * Toggle todo completion status
	 *
	 * @param todoId todo ID to update
	 */
	public void toggleTodoCompletion(int todoId) throws NonExistingTodoException {
		if ( !repo.exists(todoId)) {
			throw new NonExistingTodoException("Todo with ID " + todoId + " does not exist.");
		}

		repo.toggleTodoCompletion(todoId);
	}

	/**
	 * Get all the todo's
	 *
	 * @return List
	 */
	public List<Todo> getTodos() {
		return repo.getTodos();
	}

	/**
	 * Print the todo's into console
	 */
	public void printTodos() {
		repo.getTodos().forEach(System.out::println);
	}
}
