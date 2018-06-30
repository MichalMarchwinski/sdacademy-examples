package pl.sdacadaemy.hr;

import javax.swing.table.DefaultTableModel;
import java.util.List;

public class HRManagerSwingAdapter {

	private HRManager hrManager;

	public HRManagerSwingAdapter(HRManager hrManager) {
		this.hrManager = hrManager;
	}

	public void addNewEmployee(DefaultTableModel tableModel, String firstName, String lastName,
				   String dateOfBirth) {
		Employee newEmployye = hrManager.create(firstName,lastName,dateOfBirth);
		addRow(tableModel, newEmployye);
	}

	private void addRow(DefaultTableModel tableModel, Employee newEmployye) {
		tableModel.addRow(new Object[]{newEmployye.getFirstName(), newEmployye.getLastName(), newEmployye.getBirthOfDate()});
	}


	public void sortByLastName(DefaultTableModel tableModel) {
		tableModel.getDataVector().clear();
		List<Employee> allEmployees = hrManager.sortByLastName();
		for (Employee employee : allEmployees){
			addRow(tableModel, employee);
		}
	}
}
