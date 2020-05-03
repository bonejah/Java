package br.com.deitel.cap.eightheen;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Fractal extends JFrame {
	private static final int WIDTH = 400;
	private static final int HEIGHT = 480;
	private static final int MIN_LEVEL = 0, MAX_LEVEL = 15;

	private JButton changeColorJButton, increaseLevelJButton, decreaseLevelJButton;
	private JLabel levelJLabel;
	private JPanel mainJPanel, controlJPanel;
	private FractalJPanel drawSpace;

	public Fractal() {
		super("Fractal");

		// configura o painel de controle
		controlJPanel = new JPanel();
		controlJPanel.setLayout(new FlowLayout());

		// configura o botao e cor e registra o ouvinte
		changeColorJButton = new JButton("Color");
		controlJPanel.add(changeColorJButton);
		changeColorJButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Color color = JColorChooser.showDialog(Fractal.this, "Choose a color", Color.BLUE);

				// configura a cor padrao, se nenhuma cor for retornada
				if (color == null)
					color = Color.BLUE;

				drawSpace.setColor(color);
			}
		});

		decreaseLevelJButton = new JButton("Decrease Level");
		controlJPanel.add(decreaseLevelJButton);
		decreaseLevelJButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int level = drawSpace.getLevel();
				--level; // diminui o nivel por um

				if ((level >= MIN_LEVEL) && (level <= MAX_LEVEL)) {
					levelJLabel.setText("Level: " + level);
					repaint();
				}
			}
		});

		increaseLevelJButton = new JButton("Increase Level");
		controlJPanel.add(increaseLevelJButton);
		increaseLevelJButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int level = drawSpace.getLevel();
				++level;

				if ((level >= MIN_LEVEL) && (level <= MAX_LEVEL)) {
					levelJLabel.setText("Level: " + level);
					drawSpace.setLevel(level);
					repaint();
				}
			}
		});

		levelJLabel = new JLabel("Level: 0");
		controlJPanel.add(levelJLabel);
		drawSpace = new FractalJPanel(0);

		mainJPanel = new JPanel();
		mainJPanel.add(controlJPanel);
		mainJPanel.add(drawSpace);
		add(mainJPanel);
		setSize(WIDTH, HEIGHT);
		setVisible(true);
	}

	public static void main(String[] args) {
		Fractal fractal = new Fractal();
		fractal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
