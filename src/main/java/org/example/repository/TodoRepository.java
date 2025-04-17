package org.example.repository;

import org.example.model.Todo;

import java.util.List;

public interface TodoRepository
{
	 void addTodo(String title);
	 void removeTodoById(int todoId);
	 void updateTodoTitle(int todoId, String title);
	 void toggleTodoCompletion(int todoId);
	 void saveTodos();
	 boolean exists(int todoId);
	 List<Todo> getTodos();
}
