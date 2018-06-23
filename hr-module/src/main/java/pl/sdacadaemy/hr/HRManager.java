package pl.sdacadaemy.hr;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class HRManager {

	private List<Employee> allEmployees = new ArrayList<>();

	Employee create(String firstName, String lastName, String dateOfBirth) {
		Employee employee = new Employee(firstName, lastName, dateOfBirth);
		allEmployees.add(employee);
		return employee;
	}

	public List<Employee> findAll() {
		return allEmployees;
	}

	public List<Employee> searchByLastName(String lastName) {
		return allEmployees.stream().filter(employee -> employee.getLastName().contains(lastName)).collect
			(Collectors.toList());

/*		doing the same, but with much longer code

		List<Employee> foundEmployees = new ArrayList<>();
		for (Employee employee : allEmployees) {
			if (employee.getLastName().equals(lastName)) {
				foundEmployees.add(employee);
			}
		}
		return foundEmployees;*/
	}

	public List<Employee> searchByPhrase(String phrase) {
		return allEmployees.stream().filter(employee -> employee.matches(phrase)).collect(Collectors.toList());
	}

	public List<Employee> sortByFirstName() {
	//return allEmployees.stream().sorted(Comparator.comparing(Employee::getFirstName)).collect(Collectors.toList());
		return allEmployees.stream().sorted().collect(Collectors.toList());
	}
}
