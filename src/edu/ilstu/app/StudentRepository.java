package edu.ilstu.app;

import java.util.ArrayList;
import java.util.List;

public class StudentRepository {
	private List<StudentInformation> dataBank;
	private FileParse fileReader;

	public StudentRepository() {
		dataBank = new ArrayList<StudentInformation>();
		fileReader = new FileParse();
	}

	public void addData(InputObject object) {
		List<StudentInformation> retrievedData = fileReader.readData(object);
		dataBank.addAll(retrievedData);
	}

	public List<StudentInformation> getStudentInformation(String id) {
		List<StudentInformation> response = new ArrayList<StudentInformation>();
		for (StudentInformation studentInformation : dataBank) {
			if (studentInformation.getId().equals(id)) {
				response.add(studentInformation);
			}
		}
		return response;
	}

	public List<StudentInformation> gradeSelect(InputObject inputObject){
		List<StudentInformation> result = dataBank;
		result = getSemesterData(result, inputObject.getSemester());
		result = getYearData(result, inputObject.getYear());
		result = getCourseData(result, inputObject.getCourse());
		return result;
	}
	
	private List<StudentInformation> getSemesterData(List<StudentInformation> data, String semester) {
		List<StudentInformation> response = new ArrayList<StudentInformation>();
		for (StudentInformation studentInformation : data) {
			if (studentInformation.getSemester().equals(semester)) {
				response.add(studentInformation);
			}
		}
		return response;
	}

	private List<StudentInformation> getYearData(List<StudentInformation> data, String year) {
		List<StudentInformation> response = new ArrayList<StudentInformation>();
		for (StudentInformation studentInformation : data) {
			if (studentInformation.getYear().equals(year)) {
				response.add(studentInformation);
			}
		}
		return response;
	}
	
	private List<StudentInformation> getCourseData(List<StudentInformation> data, String course) {
		List<StudentInformation> response = new ArrayList<StudentInformation>();
		for (StudentInformation studentInformation : data) {
			if (studentInformation.getCourse().equals(course)) {
				response.add(studentInformation);
			}
		}
		return response;
	}
}
