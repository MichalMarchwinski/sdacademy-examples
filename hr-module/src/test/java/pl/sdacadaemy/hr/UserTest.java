package pl.sdacadaemy.hr;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;


class UserTest {


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
	@DisplayName("Should create a new allEmployees with all fields: /first name, last name, and date of birth")
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
		assertThat(employee.getSecondName()).isEqualTo(lastName);
		assertThat(employee.getBirthOfDate()).isEqualTo(dateOfBirth);
	}
	@DisplayName("Should check if new Employee is add to the database")
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


}