package pl.sdacadaemy.hr;

import java.util.Comparator;
import java.util.Objects;
import java.util.stream.DoubleStream;

class Employee implements Comparable<Employee> {

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Employee employee = (Employee) o;
		return Objects.equals(firstName, employee.firstName) && Objects.equals(lastName, employee.lastName) &&
			Objects.equals(dateOfBirth, employee.dateOfBirth);
	}

	@Override
	public int hashCode() {

		return Objects.hash(firstName, lastName, dateOfBirth);
	}

	@Override

	public String toString() {
		return firstName + " " + lastName + " " + dateOfBirth;
	}

	private final String firstName;
	private final String lastName;
	private final String dateOfBirth;

	public Employee(String firstName, String lastName, String dateOfBirth) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getBirthOfDate() {
		return dateOfBirth;
	}

	public Boolean matches(String phrase) {
		return	firstName.contains(phrase)||
			lastName.contains(phrase) ||
			dateOfBirth.contains(phrase);
	}

	@Override
	public int compareTo(Employee otherEmployee) {
		return firstName.compareTo(otherEmployee.getFirstName());
	}
}
