package br.com.deitel.cap.twenty.six;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class FibonacciNumbers extends JFrame {
	// componentes para calcular o Fibonacci de um numero inserido pelo usuario
	private final JPanel workerJPanel = new JPanel(new GridLayout(2, 2, 5, 5));
	private final JTextField numberJTextField = new JTextField();
	private final JButton goJButton = new JButton("Go");
	private final JLabel fibonacciJLabel = new JLabel();

	// componentes e variaveis para obter o proximo numero de Fibonacci
	private final JPanel eventThreadJPanel = new JPanel(new GridLayout(2, 2, 5, 5));
	private long n1 = 0; // inicializa com o primeiro numero de Fibonacci
	private long n2 = 1; // inicializa com o segundo numero de Fibonacci
	private int count = 1; // numero de Fibonacci atual a exibir
	private final JLabel nJLabel = new JLabel("Fibonacci of 1: ");
	private final JLabel nFibonacciJLabel = new JLabel(String.valueOf(n2));
	private final JButton nextNumberJButton = new JButton("Next number");

	public FibonacciNumbers() {
		super("Fibonacci Numbers");
		setLayout(new GridLayout(2, 1, 10, 10));

		// adiciona componentes UI ao painel SwingWorker
		workerJPanel.setBorder(new TitledBorder(new LineBorder(Color.BLACK), "With SwingWorker"));
		workerJPanel.add(new JLabel("Get Fibonacci of:"));
		workerJPanel.add(numberJTextField);

		goJButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int n;

				try {
					// recupera a entrada de usuario como um numero inteiro
					n = Integer.parseInt(numberJTextField.getText());
				} catch (NumberFormatException numberFormatException) {
					fibonacciJLabel.setText("Enter a integer.");
					return;
				}

				// indica que iniciou o calculo
				fibonacciJLabel.setText("Calculating...");

				// cria uma tarefa para faer o calculo em segundo plano
				BackGroundCalculator task = new BackGroundCalculator(n, fibonacciJLabel);
				task.execute();
			}
		});

		workerJPanel.add(goJButton);
		workerJPanel.add(fibonacciJLabel);

		// adiciona componentes GUIao painel da thread de despacho de eventos
		eventThreadJPanel.setBorder(new TitledBorder(new LineBorder(Color.BLACK), "Without SwingWorker"));
		eventThreadJPanel.add(nJLabel);
		eventThreadJPanel.add(nFibonacciJLabel);

		nextNumberJButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// calcula o numero de Fibonacci depois de n2
				long temp = n1 + n2;
				n1 = n2;
				n2 = temp;
				++count;

				// exibe o seguinte numero de Fibonacci
				nJLabel.setText("Fibonacci of " + count + ": ");
				nFibonacciJLabel.setText(String.valueOf(n2));
			}
		});

		eventThreadJPanel.add(nextNumberJButton);

		add(workerJPanel);
		add(eventThreadJPanel);
		setSize(275, 200);
		setVisible(true);
	}

	public static void main(String[] args) {
		FibonacciNumbers fibonacciNumbers = new FibonacciNumbers();
		fibonacciNumbers.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}
