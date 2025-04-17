package org.example.storage;

import org.example.model.Todo;
import org.example.model.TodoStatus;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.io.FileReader;

public class TodoFileStorage {
	private final String fileName;

	public TodoFileStorage(String fileName) {
		this.fileName = fileName;
	}

	public List<Todo> getTodos() {
		List<Todo> todos = new ArrayList<>();

		try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
			String line;
			while ((line = reader.readLine()) != null) {
				String[] parts = line.split(" - ");
				int id = Integer.parseInt(parts[0]);
				String title = parts[1];
				TodoStatus completed;
				try {
					completed = TodoStatus.fromString(parts[2]);
				} catch (IllegalArgumentException e) {
					completed = TodoStatus.NOT_COMPLETED;
				}

				todos.add(new Todo(id, title, completed));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return todos;
	}

	public void saveTodos(List<Todo> todos) {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
			for (Todo todo : todos) {
				writer.write(todo.toString());
				writer.newLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
