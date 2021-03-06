package pl.sdacadaemy.hr;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class CommandLineRunnerTest {

	@DisplayName("Should reject input data when 3 arguments are given and first name is not given")
	@Test
	void test00() {
		//given
		HRManager hrManager = new HRManager();
		String[] args = {"lastName=Miauczyński", "dateOfBirth=10-02-1960", "anything"};
		//when
		// super hard stuff -  read it later !!
		// przekazujemy funkcję, która będzzie wywołana później ;)
		assertThatThrownBy(() -> CommandLineRunner.load(args, hrManager))
			//then
			.isInstanceOf(IllegalArgumentException.class);
	}
	@DisplayName("Should reject input data when 3 arguments are given and last name is not given")
	@Test
	void test01() {
		//given
		HRManager hrManager = new HRManager();
		String[] args = {"firstName=Adaś", "dateOfBirth=10-02-1960", "anything"};
		//when
		assertThatThrownBy(() -> CommandLineRunner.load(args, hrManager))
			//then
			.isInstanceOf(IllegalArgumentException.class);
	}
	@DisplayName("Should reject input data when 3 arguments are given and date of birth is not given")
	@Test
	void test02() {
		//given
		HRManager hrManager = new HRManager();
		String[] args = {"firstName=Adaś", "lastName=Miauczyński", "anything"};
		//when
		assertThatThrownBy(() -> CommandLineRunner.load(args, hrManager))
			//then
			.isInstanceOf(IllegalArgumentException.class);
	}
	@DisplayName("Should check if firstname lastname and dateofbirth is given then database isn't empty")
	@Test
	void test03() {
		//given
		HRManager hrManager = new HRManager();
		String[] args = {"firstName=Adaś", "lastName=Miauczyński", "dateOfBirth=11-11-1911"};
		//when
		CommandLineRunner.load(args, hrManager);
		//then
		assertThat(hrManager.findAll()).isNotEmpty();
	}
	@DisplayName("Should check if firstname lastname and dateofbirth isn't empty than database contains " +
		"single employee with the same firstname lastname dateofbirth")
	@Test
	void test04 () {
		//given
		HRManager hrManager = new HRManager();
		String[] args = {"firstName=Adaś", "lastName=Miauczyński", "dateOfBirth=11-11-1911"};
		//when
		CommandLineRunner.load(args, hrManager);
		//then
		Employee employee = hrManager.findAll().get(0);
		assertThat(employee.getFirstName()).isEqualTo("Adaś");
		assertThat(employee.getLastName()).isEqualTo("Miauczyński");
		assertThat(employee.getBirthOfDate()).isEqualTo("11-11-1911");
	}
	@DisplayName("Should return list of text representation of all Employees from database")
	@Test
	void test05() {
		//given
		HRManager hrManager = new HRManager();
		String[] args = {"firstName=Adaś", "lastName=Miauczyński", "dateOfBirth=11-11-1911"};
		CommandLineRunner.load(args,hrManager);
		//when
		List<String> allEmployees = CommandLineRunner.list(hrManager);
		//then
		assertThat(allEmployees).containsOnly("Adaś Miauczyński, 11-11-1911");
	}
}

