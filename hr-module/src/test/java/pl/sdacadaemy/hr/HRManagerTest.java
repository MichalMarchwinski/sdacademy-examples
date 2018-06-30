package pl.sdacadaemy.hr;

import org.junit.experimental.theories.suppliers.TestedOn;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;


class HRManagaerTest {


	private HRManager hrManager = new HRManager();

	@BeforeEach
	void setup() {
		hrManager = new HRManager();
	}

	@DisplayName("Should create non-null new allEmployees when first name, last name, and date of birth is given")
	@Test
	void test0() {
		//given
		String firstName = "Adan";
		String lastName = "Nowak";
		String dateOfBirth = "01-12-1960";

		//when
		Employee employee = hrManager.create(firstName, lastName, dateOfBirth);

		//then
		assertThat(employee).isNotNull();
	}
	@DisplayName("Should create a new employee with all fields: /first name, last name, and date of birth")
	@Test
	void test1() {
		//given
		String firstName = "Adam";
		String lastName = "Miauczyński";
		String dateOfBirth = "01-12-1960";
		//when
		Employee employee = hrManager.create(firstName,lastName,dateOfBirth);
		//then
		assertThat(employee.getFirstName()).isEqualTo(firstName);
		assertThat(employee.getLastName()).isEqualTo(lastName);
		assertThat(employee.getBirthOfDate()).isEqualTo(dateOfBirth);
	}
	@DisplayName("Should check if new Employee is added to the database")
	@Test
	void test2() {
		//given
		String firstName = "Adam";
		String lastName = "Kot";
		String dateOfBirth = "01-12-1960";
		Employee newEmployee = hrManager.create(firstName,lastName,dateOfBirth);

		//when
		List<Employee> allEmployees = hrManager.findAll();

		//then
		assertThat(allEmployees).containsOnly(newEmployee);
	}
	@DisplayName("Should check if two new Employees are added to the database")
	@Test
	void test3() {
		//given
		Employee adam = hrManager.create("Adam","Kot","01-12-1960");
		Employee gorge = hrManager.create("Gorege", "Pierzchała", "03-05-1988");
		//when
		List<Employee> allEmployees = hrManager.findAll();

		//then
		assertThat(allEmployees).containsOnly(adam, gorge);
	}
	@DisplayName("Should find single employee with given last name")
	@Test
	void test4() {
		//given
		Employee adam = hrManager.create("Adam","Miauczyński","01-12-1960");
		Employee gorge = hrManager.create("Gorege", "Pierzchała", "03-05-1988");
		//when
		List<Employee> foundEmployees = hrManager.searchByLastName("Miauczyński");
		//then
		assertThat(foundEmployees).containsOnly(adam);
	}
	@DisplayName("Should find every employee with given last name")
	@Test
	void test5() {
		//given
		Employee adam = hrManager.create("Adam","Miauczyński","01-12-1960");
		Employee gorge = hrManager.create("Gorege", "Pierzchała", "03-05-1988");
		Employee jurgen = hrManager.create("Jurgen", "Miauczyński", "02-06-1999");
		//when
		List<Employee> foundEmployees = hrManager.searchByLastName("Miauczyński");
		//then
		assertThat(foundEmployees).containsOnly(adam, jurgen);
	}
	@DisplayName("Should find no employee when there is no employee with given last name")
	@Test
	void test6() {
		//given
		Employee adam = hrManager.create("Adam","Miauczyński","01-12-1960");
		Employee gorge = hrManager.create("Gorege", "Pierzchała", "03-05-1988");
		Employee jurgen = hrManager.create("Jurgen", "Miauczyński", "02-06-1999");
		//when
		List<Employee> foundEmployees = hrManager.searchByLastName("Kowalski");
		//then
		assertThat(foundEmployees).isEmpty();
	}
	@DisplayName("Should find two employee with name Adam when firstName matches given search phrase")
	@Test
	void test7() {
		//given
		Employee adamMiauczynski = hrManager.create("Adam","Miauczyński","01-12-1960");
		Employee gorge = hrManager.create("Gorege", "Pierzchała", "03-05-1988");
		Employee adamMuller = hrManager.create("Adam", "Mulller", "02-06-1999");
		//when
		List<Employee> foundEmployees = hrManager.searchByPhrase("Adam");
		//then
		assertThat(foundEmployees).containsOnly(adamMiauczynski, adamMuller);
	}
	@DisplayName("Should find two employee with name Miauczyński when last name matches given search phrase")
	@Test
	void test8() {
		//given
		Employee adamMiauczynski = hrManager.create("Adam","Miauczyński","01-12-1960");
		Employee gorgeMiauczynski = hrManager.create("Gorege", "Miauczyński", "03-05-1988");
		Employee adamMuller = hrManager.create("Adam", "Mulller", "02-06-1999");
		//when
		List<Employee> foundEmployees = hrManager.searchByPhrase("Miauczyński");
		//then
		assertThat(foundEmployees).containsOnly(adamMiauczynski, gorgeMiauczynski);
	}
	@DisplayName("Should find two employee with birth date 01-12-1960 when date of birth matches given search " +
		"phrase")
	@Test
	void test9() {
		//given
		Employee adamMiauczynski = hrManager.create("Adam","Miauczyński","01-12-1960");
		Employee gorgeMiauczynski = hrManager.create("Gorege", "Miauczyński", "03-05-1988");
		Employee adamMuller = hrManager.create("Adam", "Mulller", "02-06-1999");
		Employee stefanMuller = hrManager.create("Stefan", "Mulller", "01-12-1960");
		//when
		List<Employee> foundEmployees = hrManager.searchByPhrase("01-12-1960");
		//then
		assertThat(foundEmployees).containsOnly(adamMiauczynski, stefanMuller);
	}
	@DisplayName("Should sort by first name ascending")
	@Test
	void test10() {
		//given
		Employee adamMiauczynski = hrManager.create("Adam","Miauczyński","01-12-1960");
		Employee gorgeMiauczynski = hrManager.create("Gorege", "Miauczyński", "03-05-1988");
		Employee zenonMuller = hrManager.create("Zenon", "Mulller", "02-06-1999");
		Employee stefanMuller = hrManager.create("Stefan", "Mulller", "01-12-1960");
		//when
		List<Employee> sortedEmployees = hrManager.sortByFirstName();
		//then
		assertThat(sortedEmployees).containsExactly(adamMiauczynski, gorgeMiauczynski, stefanMuller, zenonMuller);
	}
	@DisplayName("Should sort two employees by first name descending")
	@Test
	void test11() {
		//given
		Employee adamMiauczynski = hrManager.create("Adam","Miauczyński","01-12-1960");
		Employee gorgeMiauczynski = hrManager.create("Gorege", "Miauczyński", "03-05-1988");
		//when
		List<Employee> sortedEmployees = hrManager.sortByFirstNameWithBubble();
		//then
		assertThat(sortedEmployees).containsExactly(gorgeMiauczynski, adamMiauczynski);
	}
	@DisplayName("Should sort three employees by first name descending")
	@Test
	void test12() {
		//given
		Employee adamMiauczynski = hrManager.create("Adam","Miauczyński","01-12-1960");
		Employee gorgeMiauczynski = hrManager.create("Gorege", "Miauczyński", "03-05-1988");
		Employee stefanMuller = hrManager.create("Stefan", "Mulller", "01-12-1960");
		//when
		List<Employee> sortedEmployees = hrManager.sortByFirstNameWithBubble();
		//then
		assertThat(sortedEmployees).containsExactly(stefanMuller, gorgeMiauczynski, adamMiauczynski);
	}
	@DisplayName("Should sort four employees by first name descending")
	@Test
	void test13() {
		//given
		Employee adamMiauczynski = hrManager.create("Adam","Miauczyński","01-12-1960");
		Employee gorgeMiauczynski = hrManager.create("Gorege", "Miauczyński", "03-05-1988");
		Employee stefanMuller = hrManager.create("Stefan", "Mulller", "01-12-1960");
		Employee zenonMuller = hrManager.create("Zenon", "Mulller", "02-06-1999");
		//when
		List<Employee> sortedEmployees = hrManager.sortByFirstNameWithBubble();
		//then
		assertThat(sortedEmployees).containsExactly(zenonMuller, stefanMuller, gorgeMiauczynski,
			adamMiauczynski);
	}
	@DisplayName("Should sort four employees by last name")
	@Test
	void test14() {
		//given
		Employee adamMiauczynski = hrManager.create("Adam","Miauczyński","01-12-1960");
		Employee gorgeGrzeszczak = hrManager.create("Gorege", "Grzeszczak", "03-05-1988");
		Employee stefanMuller = hrManager.create("Stefan", "Mulller", "01-12-1960");
		Employee zenonTroll = hrManager.create("Zenon", "Troll", "02-06-1999");
		//when
		List<Employee> sortedEmployees = hrManager.sortByLastName();
		//then
		assertThat(sortedEmployees).containsExactly(gorgeGrzeszczak, adamMiauczynski, stefanMuller, zenonTroll);
	}

}