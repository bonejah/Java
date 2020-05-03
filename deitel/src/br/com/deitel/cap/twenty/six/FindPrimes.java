package br.com.deitel.cap.twenty.six;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

public class FindPrimes extends JFrame {
	private final JTextField highestPrimeJTextField = new JTextField();
	private final JButton getPrimesJButton = new JButton("Get Primes");
	private final JTextArea displayPrimesJTextArea = new JTextArea();
	private final JButton cancelJButton = new JButton("Cancel");
	private final JProgressBar progressBarJProgressBar = new JProgressBar();
	private final JLabel statusJLabel = new JLabel();
	private PrimeCalculator calculator;

	public FindPrimes() {
		super("Finding Primes with SwingWorker");
		setLayout(new BorderLayout());

		// inicializa o painel para obter o numero do usuario
		JPanel northJPanel = new JPanel();
		northJPanel.add(new JLabel("Find primes less than: "));
		highestPrimeJTextField.setColumns(5);
		northJPanel.add(highestPrimeJTextField);

		getPrimesJButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				progressBarJProgressBar.setValue(0); // redeine JProgressbar
				displayPrimesJTextArea.setText(""); // limpa JTextArea
				statusJLabel.setText(""); // limpa JLabel

				int number; // pesquisa primos para cima ate esse valor

				try {
					// obtem entrada do usuario
					number = Integer.parseInt(highestPrimeJTextField.getText());
				} catch (NumberFormatException numberFormatException) {
					statusJLabel.setText("Enter an integer.");
					return;
				}

				// constroi um novo objeto PrimeCalculator
				calculator = new PrimeCalculator(number, displayPrimesJTextArea, statusJLabel, getPrimesJButton,
						cancelJButton);

				// ouve alteracoes de propriedade na barra de progresso
				calculator.addPropertyChangeListener(new PropertyChangeListener() {
					@Override
					public void propertyChange(PropertyChangeEvent evt) {
						// se a propriedade alterada for progress atualiza a
						// barra de progresso
						if (evt.getPropertyName().equals("progress")) {
							int newValue = (Integer) evt.getNewValue();
							progressBarJProgressBar.setValue(newValue);
						}

					}
				});

				getPrimesJButton.setEnabled(false);
				cancelJButton.setEnabled(true);
				calculator.execute();
			}
		});

		northJPanel.add(getPrimesJButton);

		// adiciona uma JList rolavel para exibir os resultados do calculo
		displayPrimesJTextArea.setEditable(false);
		add(new JScrollPane(displayPrimesJTextArea, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER));

		// inicializa um painel para exibir cancelJButton,
		// progressBarJProgressBar e statusJLabel
		JPanel southJPanel = new JPanel(new GridLayout(1, 3, 10, 10));
		cancelJButton.setEnabled(false);
		cancelJButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				calculator.cancel(true);

			}
		});

		southJPanel.add(cancelJButton);
		progressBarJProgressBar.setStringPainted(true);
		southJPanel.add(progressBarJProgressBar);
		southJPanel.add(statusJLabel);

		add(northJPanel, BorderLayout.NORTH);
		add(southJPanel, BorderLayout.SOUTH);
		setSize(350, 300);
		setVisible(true);
	}

	public static void main(String[] args) {
		FindPrimes findPrimes = new FindPrimes();
		findPrimes.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}
