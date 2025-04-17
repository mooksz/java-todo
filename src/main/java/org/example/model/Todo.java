package org.example.model;

public class Todo {
	private final int id;
	private String title;
	private TodoStatus status = TodoStatus.NOT_COMPLETED;

	public Todo(int id, String title, TodoStatus status) {
		this.id = id;
		this.title = title;
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public TodoStatus getStatus() {
		return status;
	}

	public void setStatus(TodoStatus status) {
		this.status = status;
	}

	public void toggleCompletion() {
		if (status == TodoStatus.NOT_COMPLETED)
			status = TodoStatus.COMPLETED;
		else
			status = TodoStatus.NOT_COMPLETED;
	}

	@Override
	public String toString() {
		return this.id + " - " + this.title + " - " + this.status.toString().toLowerCase();
	}
}
