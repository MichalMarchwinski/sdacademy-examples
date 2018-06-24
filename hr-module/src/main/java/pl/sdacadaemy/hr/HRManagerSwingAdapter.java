package pl.sdacadaemy.hr;

import javax.swing.table.DefaultTableModel;

public class HRManagerSwingAdapter {

	private HRManager hrManager;

	public HRManagerSwingAdapter(HRManager hrManager) {
		this.hrManager = hrManager;
	}

	public void addNewEmployee(DefaultTableModel tableModel, String firstName, String lastName,
				   String dateOfBirth) {
		Employee newEmployye = hrManager.create(firstName,lastName,dateOfBirth);

		tableModel.addRow(new Object[]{newEmployye.getFirstName(), newEmployye.getLastName(), newEmployye.getBirthOfDate()});
	}
}
