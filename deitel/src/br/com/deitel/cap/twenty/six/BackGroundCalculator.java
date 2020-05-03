package br.com.deitel.cap.twenty.six;

import java.util.concurrent.ExecutionException;

import javax.swing.JLabel;
import javax.swing.SwingWorker;

import br.com.deitel.cap.eightheen.FibonacciCalculator;

public class BackGroundCalculator extends SwingWorker<Long, Object> {
	private final int n; // numero de Fibonacci a calcular
	private final JLabel resultJLabel; // JLabel para exibir o resultado

	public BackGroundCalculator(int number, JLabel label) {
		n = number;
		resultJLabel = label;
	}

	// codigo demorado a ser executado em uma thread trabalhadora
	@Override
	protected Long doInBackground() throws Exception {
		long nthFib = fibonacci(n);
		//return String.valueOf(nthFib);
		return nthFib;
	}

	protected void done() {
		try {
			// obtem o resultado do doInBackGround e exibe-o
			resultJLabel.setText(get().toString());
		} catch (InterruptedException interruptedException) {
			resultJLabel.setText("Interrupted while waiting for results.");
		} catch (ExecutionException executionException) {
			resultJLabel.setText("Error encountered while performing calculation.");
		}
	}

	public long fibonacci(long number) {
		if (number == 0 || number == 1)
			return number;
		else
			return fibonacci(number - 1) + fibonacci(number - 2);
	}

}
