package br.com.deitel.cap.fourtheen;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ButtonFrame extends JFrame {
	private JButton plainJButton;
	private JButton fancyButton;

	public ButtonFrame() {
		super("Testing Buttons");
		setLayout(new FlowLayout());

		plainJButton = new JButton("Plain Button");
		add(plainJButton);

		ImageIcon bug1 = new ImageIcon(getClass().getResource("bug1.gif"));
		ImageIcon bug2 = new ImageIcon(getClass().getResource("bug2.gif"));
		fancyButton = new JButton("Fancy Button", bug1);
		fancyButton.setRolloverIcon(bug2);
		add(fancyButton);

		ButtonHandler handler = new ButtonHandler();
		fancyButton.addActionListener(handler);
		plainJButton.addActionListener(handler);
	}

	private class ButtonHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent event) {
			JOptionPane.showMessageDialog(ButtonFrame.this, String.format("You pressed: %s", event.getActionCommand()));
		}
	}
}
