package pl.sdacadaemy.hr;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;


public class SwingView {

	private static final HRManagerSwingAdapter adapter = new HRManagerSwingAdapter(new HRManager());
	private static DefaultTableModel tableModel = new DefaultTableModel();

	public static void main(String[] args) {
		tableModel.addColumn("First Name");
		tableModel.addColumn("Second Name");
		tableModel.addColumn("Date of Birth");


		SwingUtilities.invokeLater(() -> {

			// prepare the jframe
			final JFrame jFrame = new JFrame();
			LayoutManager layout = new GridLayout(3, 1);
			jFrame.setLayout(layout);
			jFrame.setTitle("HRManager");
			jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

			// content
			addFirstRow(jFrame);
			addSecondRow(jFrame);
			addThirdRow(jFrame);


			// pack and show
			jFrame.setPreferredSize(new Dimension(640, 480));
			jFrame.pack();
			jFrame.setVisible(true);
		});

	}

	private static void addThirdRow(JFrame jFrame) {
		JPanel row = new JPanel();
		LayoutManager layout = new GridLayout(3, 1);
		row.setLayout(layout);

		JPanel lableRow = new JPanel();
		lableRow.add(new JLabel("Filter Options: "));

		JPanel lastNameSearch = new JPanel();
		lastNameSearch.add(new JLabel("Last Name"));
		lastNameSearch.add(new JTextField("Last Name Search"));
		lastNameSearch.add(new JButton("Search Last Name"));

		JPanel anyPhraseSearch = new JPanel();
		anyPhraseSearch.add(new JLabel("Any Phrase"));
		anyPhraseSearch.add(new JTextField("Any Phrase"));
		anyPhraseSearch.add(new JButton("Search phrase"));

		row.add(lableRow);
		row.add(lastNameSearch);
		row.add(anyPhraseSearch);


		jFrame.add(row);
	}


	private static void addSecondRow(JFrame jFrame) {
		//populate row
		JTable table = new JTable(tableModel);
		JScrollPane scrollPane = new JScrollPane(table);
		jFrame.add(scrollPane);
		//add row to jframe
	}

	private static void addFirstRow(JFrame jFrame) {
		//Populate row
		JPanel row = new JPanel();

		JButton addButton = new JButton("Add");
		JTextField firstNameText = new JTextField("First Name");
		JTextField lastNameText = new JTextField("Last Name");
		JTextField dateNameText = new JTextField("Date of Birth");
		addButton.addActionListener(e -> {
			adapter.addNewEmployee(tableModel, firstNameText.getText(), lastNameText.getText(),
				dateNameText.getText());
		});

		row.add(addButton);
		row.add(new JLabel("First Name"));
		row.add(firstNameText);
		row.add(new JLabel("Last Name"));
		row.add(lastNameText);
		row.add(new JLabel("Date of Birth"));
		row.add(dateNameText);

		//add row to jframe
		jFrame.add(row);
	}
}
