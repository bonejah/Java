package br.com.deitel.cap.fourtheen;

import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class MouseDetailsFrame extends JFrame {
	private String details;
	private JLabel statusBar;

	public MouseDetailsFrame() {
		super("Mouse clicks and buttons");
		statusBar = new JLabel("Click the mouse");
		add(statusBar, BorderLayout.SOUTH);
		addMouseListener(new MouseClickHandler());
	}

	private class MouseClickHandler extends MouseAdapter {
		public void mouseClicked(MouseEvent event) {
			int xPos = event.getX();
			int yPos = event.getY();

			details = String.format("Clicked %d time(s)", event.getClickCount());

			if (event.isMetaDown()) {
				details += "With right mouse button";
			} else if (event.isAltDown()) {
				details += "With center mouse button";
			} else {
				details += "With left mouse button";
			}

			statusBar.setText(details);
		}
	}
}
