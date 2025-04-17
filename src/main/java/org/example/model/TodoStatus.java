package org.example.model;

public enum TodoStatus {
	NOT_COMPLETED("Not completed"), COMPLETED("Completed");

	private final String status;

	TodoStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return status;
	}

	public static TodoStatus fromString(String status) throws IllegalArgumentException {
		for (TodoStatus todoStatus : TodoStatus.values()) {
			if (todoStatus.status.equalsIgnoreCase(status)) {
				return todoStatus;
			}
		}
		throw new IllegalArgumentException("Unknown status: " + status);
	}
}
