package br.com.deitel.cap.fourtheen;

import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class LabelFrame extends JFrame {
	private JLabel label1;
	private JLabel label2;
	private JLabel label3;

	public LabelFrame() {
		super("Testing JLabel");
		setLayout(new FlowLayout());

		label1 = new JLabel("Label with text");
		label1.setToolTipText("This is label1");
		add(label1);

		ImageIcon icon = new ImageIcon(getClass().getResource("bug1.gif"));
		label2 = new JLabel("Label with text and icon", icon, SwingConstants.LEFT);
		label2.setToolTipText("This is label2");
		add(label2);

		label3 = new JLabel();
		label3.setText("Label with icon and text at bottom");
		label3.setIcon(icon);
		label3.setHorizontalTextPosition(SwingConstants.CENTER);
		label3.setVerticalAlignment(SwingConstants.BOTTOM);
		label3.setToolTipText("This is label3");
		add(label3);
	}
}
