package pl.sdacadaemy.hr;

class Employee {

	@Override
	public String toString() {
		return "Employee{" + "firstName='" + firstName + '\'' + ", lastName='" + lastName + '\'' + ", " +
			"dateOfBirth='" + dateOfBirth + '\'' + '}';
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
	public String getSecondName() {
		return lastName;
	}
	public String getBirthOfDate() {
		return dateOfBirth;
	}
}
