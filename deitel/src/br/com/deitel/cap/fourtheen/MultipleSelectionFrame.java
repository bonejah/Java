package br.com.deitel.cap.fourtheen;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

public class MultipleSelectionFrame extends JFrame {
	private JList colorJList;
	private JList copyJList;
	private JButton copyButton;
	private static final String[] colorNames = { "Black", "Blue", "Cyan", "Dark Gray", "Gray", "Green", "Light Gray",
			"Magenta", "Orange", "Pink", "Red", "White", "Yellow" };

	public MultipleSelectionFrame() {
		super("Multiple Selection Frame");
		setLayout(new FlowLayout());

		colorJList = new JList(colorNames);
		colorJList.setVisibleRowCount(5);
		colorJList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		add(new JScrollPane(colorJList));
		
		copyButton = new JButton("Copy >>>");
		copyButton.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				copyJList.setListData(colorJList.getSelectedValues());
			}
		});
		add(copyButton);
		
		copyJList = new JList();
		copyJList.setVisibleRowCount(5);
		copyJList.setFixedCellWidth(100);
		copyJList.setFixedCellHeight(15);
		copyJList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		add(new JScrollPane(copyJList));
	}
}
