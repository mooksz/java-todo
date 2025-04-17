package org.example.exception;

public class NonExistingTodoException extends RuntimeException {
	public NonExistingTodoException(String message) {
		super(message);
	}
}
