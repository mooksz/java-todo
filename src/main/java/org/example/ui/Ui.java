package org.example.ui;

import org.example.exception.NonExistingTodoException;
import org.example.repository.TodoRepositoryImpl;
import org.example.service.TodosService;

import java.util.Scanner;

public class Ui {
	private static final TodoRepositoryImpl todoRepository = TodoRepositoryImpl.getInstance();
	private static final TodosService todos = new TodosService(todoRepository);
	private static final Scanner scanner = new Scanner(System.in);

	private static void printOptions() {
		System.out.println("\n1. List todos");
		System.out.println("2. Add todo");
		System.out.println("3. Remove todo");
		System.out.println("4. Toggle todo completion status");
		System.out.println("5. Update todo title");
		System.out.println("6. Exit");
		System.out.print("Choose an option: ");
	}

	private static void listTodos() {
		if (todos.getTodos().isEmpty()) {
			System.out.println("No todos yet");
			return;
		}

		todos.printTodos();
	}

	private static void addTodo() {
		System.out.print("Enter todo title: ");
		String title = scanner.nextLine();
		todos.addTodo(title);
		todos.printTodos();
	}

	private static void removeTodo() {
		System.out.print("Enter todo ID to remove: ");
		String input = scanner.nextLine();
		try {
			int id = Integer.parseInt(input);
			todos.removeTodoById(id);
			todos.printTodos();
		} catch (NumberFormatException e) {
			System.out.println(input + " isn't a valid ID.");
		} catch (NonExistingTodoException e) {
			System.out.println(e.getMessage());
		}
	}

	private static void toggleTodoCompletionStatus() {
		System.out.print("Enter todo ID to toggle completion: ");
		String input = scanner.nextLine();

		try {
			int id = Integer.parseInt(scanner.nextLine());
			todos.toggleTodoCompletion(id);
			todos.printTodos();
		} catch (NumberFormatException e) {
			System.out.println(input + " isn't a valid ID.");
		} catch (NonExistingTodoException e) {
			System.out.println(e.getMessage());
		}
	}

	private static void updateTodoTitle() {
		System.out.print("Enter todo ID to update title: ");
		String input = scanner.nextLine();
		try {
			int id = Integer.parseInt(input);

			System.out.print("Enter new title: ");
			String newTitle = scanner.nextLine();

			todos.updateTodoTitle(id, newTitle);
			todos.printTodos();
		} catch (NumberFormatException e) {
			System.out.println(input + " isn't a valid ID.");
		} catch (NonExistingTodoException e) {
			System.out.println(e.getMessage());
		}
	}

	private static void exit() {
		System.out.println("Bye!");
		scanner.close();
		System.exit(0);
	}

	private static void fallback() {
		System.out.println("Invalid option.");
	}

	public static  void start() {
		while (true) {
			printOptions();

			String input = scanner.nextLine();

			switch (input) {
				case "1": {
					listTodos();
					break;
				}
				case "2": {
					addTodo();
					break;
				}
				case "3": {
					removeTodo();
					break;
				}
				case "4": {
					toggleTodoCompletionStatus();
					break;
				}
				case "5": {
					updateTodoTitle();
					break;
				}
				case "6": {
					exit();
					break;
				}
				default: {
					fallback();
				}
			}
		}
	}
}
