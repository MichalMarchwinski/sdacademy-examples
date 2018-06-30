package pl.sdacadaemy.hr;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class HRManagerSwingAdapterTest {

	@DisplayName("Should add to the tableModel new row marching Employe created by HRManager given Adam " +
		"Miauczyński")
	@Test
	void test01() {
		//given
		//create empty table model
		DefaultTableModel tableModel = new DefaultTableModel();
		HRManagerSwingAdapter adapter = new HRManagerSwingAdapter(fakeCreateHRManager());
		tableModel.addColumn("First Name");
		tableModel.addColumn("Last Name");
		tableModel.addColumn("Date of Birth");
		//when
		adapter.addNewEmployee(tableModel, "Adam", "Miauczyński", "11-11-1988");
		//then
		Object firstNameFromTableModel = tableModel.getValueAt(0, 0);
		assertThat(firstNameFromTableModel).isEqualTo("Zoltan");
		Object lastNameFromTableModel = tableModel.getValueAt(0,1);
		assertThat(lastNameFromTableModel).isEqualTo("Bloodhammer");
		Object dateOfBirthFromTableModel = tableModel.getValueAt(0,2);
		assertThat(dateOfBirthFromTableModel).isEqualTo("11-01-1210");
	}

	private HRManager fakeCreateHRManager() {
		return new HRManager() {
			@Override
			Employee create(String firstName, String lastName, String dateOfBirth) {
				if (firstName.equals("Adam") && lastName.equals("Miauczyński") && dateOfBirth.equals
					("11-11-1988"))
				{
					return new Employee("Zoltan", "Bloodhammer", "11-01-1210");
				}
				throw new IllegalArgumentException("Bad argument");
			}
		};
	}
	@DisplayName("Should add to empty Table Model exactly two rows returned by HRManager when used sort" )
	@Test
	void test02() {
		//given
		//create empty table model
		DefaultTableModel tableModel = new DefaultTableModel();
		HRManagerSwingAdapter adapter = new HRManagerSwingAdapter(fakeSortHRManager());
		tableModel.addColumn("First Name");
		tableModel.addColumn("Last Name");
		tableModel.addColumn("Date of Birth");
		//when
		adapter.sortByLastName(tableModel);
		//then
		Object firstNameFromTableModel = tableModel.getValueAt(0, 0);
		assertThat(firstNameFromTableModel).isEqualTo("Tomek");
		Object lastNameFromTableModel = tableModel.getValueAt(0,1);
		assertThat(lastNameFromTableModel).isEqualTo("Bloodhammer");
		Object dateOfBirthFromTableModel = tableModel.getValueAt(0,2);
		assertThat(dateOfBirthFromTableModel).isEqualTo("11-12-2011");
		Object first1NameFromTable = tableModel.getValueAt(1,0);
		assertThat(first1NameFromTable).isEqualTo("Igor");
		Object last1NameFromTableModel = tableModel.getValueAt(1,1);
		assertThat(last1NameFromTableModel).isEqualTo("Czytytczy");
		Object date1OfBirthFromTableModel = tableModel.getValueAt(1,2);
		assertThat(date1OfBirthFromTableModel).isEqualTo("10-10-2012");

	}

	private HRManager fakeSortHRManager() {
		return new HRManager() {
			@Override
			public List<Employee> sortByLastName() {
				return Arrays.asList(new Employee("Tomek", "Bloodhammer", "11-12-2011"),
					new Employee("Igor", "Czytytczy", "10-10-2012"));
			}
		};
	}

	@DisplayName("Should replace all existing rows in table model with data from fakeSortHRManager")
	@Test
	void test03() {
		//given
		//create empty table model
		DefaultTableModel tableModel = new DefaultTableModel();
		HRManagerSwingAdapter adapter = new HRManagerSwingAdapter(fakeSortHRManager());
		tableModel.addColumn("First Name");
		tableModel.addColumn("Last Name");
		tableModel.addColumn("Date of Birth");
		tableModel.addRow(new Object[]{"George", "Martin", "10-11-2015"});
		tableModel.addRow(new Object[]{"Tomek", "Bloodhammer", "11-10-2011" });
		//when
		adapter.sortByLastName(tableModel);
		//then
		Object firstNameFromTableModel = tableModel.getValueAt(0, 0);
		assertThat(firstNameFromTableModel).isEqualTo("Tomek");
		Object lastNameFromTableModel = tableModel.getValueAt(0,1);
		assertThat(lastNameFromTableModel).isEqualTo("Bloodhammer");
		Object dateOfBirthFromTableModel = tableModel.getValueAt(0,2);
		assertThat(dateOfBirthFromTableModel).isEqualTo("11-12-2011");
		Object first1NameFromTable = tableModel.getValueAt(1,0);
		assertThat(first1NameFromTable).isEqualTo("Igor");
		Object last1NameFromTableModel = tableModel.getValueAt(1,1);
		assertThat(last1NameFromTableModel).isEqualTo("Czytytczy");
		Object date1OfBirthFromTableModel = tableModel.getValueAt(1,2);
		assertThat(date1OfBirthFromTableModel).isEqualTo("10-10-2012");

	}
	}


