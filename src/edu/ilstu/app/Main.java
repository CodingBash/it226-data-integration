package edu.ilstu.app;

import edu.ilstu.app.InputAdapter;

public class Main {
	public static void main(String[] args) {
		InputAdapter inputAdapter = new InputAdapter();
		OutputAdapter outputAdapter = new OutputAdapter();
		StudentRepository repository = new StudentRepository();
		boolean running = true;
		while (running) {
			Response response = inputAdapter.pollInput();
			switch (response) {
			case ADD_DATA:
				repository.addData(inputAdapter.addDataObject());
				break;
			case SAVE_DATA:
				outputAdapter.exportData(repository.getStudentInformation(inputAdapter.getStudentId()), inputAdapter.getFileName());
				break;
			case GRADE_SELECT:
				System.out
						.println("Number of students: " + repository.gradeSelect(inputAdapter.getGradeSelectRequest()));
				break;
			case EXIT:
				running = false;
				break;
			}
		}
	}
}
