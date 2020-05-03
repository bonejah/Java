package br.com.deitel.cap.fourtheen;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class TextFieldFrame extends JFrame {
	private JTextField textField1;
	private JTextField textField2;
	private JTextField textField3;
	private JPasswordField jPasswordField;

	public TextFieldFrame() {
		super("Testing JTextField and JPassWordField");
		setLayout(new FlowLayout());

		textField1 = new JTextField(10);
		add(textField1);

		textField2 = new JTextField("Enter text here");
		add(textField2);

		textField3 = new JTextField("uneditable text field", 21);
		textField3.setEditable(false);
		add(textField3);

		jPasswordField = new JPasswordField("Hidden text");
		add(jPasswordField);

		TextFieldHandler handler = new TextFieldHandler();
		textField1.addActionListener(handler);
		textField2.addActionListener(handler);
		textField3.addActionListener(handler);
		jPasswordField.addActionListener(handler);
	}

	private class TextFieldHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent event) {
			String string = "";
			
			if (event.getSource() == textField1) {
				string = String.format("textField1: %s", event.getActionCommand());
			} else if (event.getSource() == textField2) {
				string = String.format("textField2: %s", event.getActionCommand());
			} else if (event.getSource() == textField3) {
				string = String.format("textField3: %s", event.getActionCommand());
			} else if (event.getSource() == jPasswordField) {
				string = String.format("jPasswordField: %s", event.getActionCommand());
			}
			
			JOptionPane.showMessageDialog(null, string);
		}
	}
}
