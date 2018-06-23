package pl.sdacadaemy.hr;

import java.util.stream.DoubleStream;

class Employee {

	@Override
	public String toString() {
		return firstName + " " + lastName + ", " + dateOfBirth;
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

}
