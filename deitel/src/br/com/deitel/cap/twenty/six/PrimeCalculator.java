package br.com.deitel.cap.twenty.six;

import java.util.List;
import java.util.Random;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.SwingWorker;

public class PrimeCalculator extends SwingWorker<Integer, Integer> {
	private final Random generator = new Random();
	private final JTextArea intermediateJTextArea;
	private final JButton getPrimesJButton;
	private final JButton cancelJButton;
	private final JLabel statusJLabel; // exibe o status do calculo
	private final boolean[] primes; // array booleano para localizar primos

	public PrimeCalculator(int max, JTextArea intermediate, JLabel status, JButton getPrimes, JButton cancel) {
		intermediateJTextArea = intermediate;
		statusJLabel = status;
		getPrimesJButton = getPrimes;
		cancelJButton = cancel;
		primes = new boolean[max];

		// inicializa todos os valores de array primos como verdadeiros
		for (int i = 0; i < max; i++) {
			primes[i] = true;
		}
	}

	@Override
	protected Integer doInBackground() throws Exception {
		int count = 0; // o numero de primos localizados

		// iniciando no terceiro valor, circula pelo array e coloca
		// falso como valor de qualquer numero maior que for um multiplo
		for (int i = 2; i < primes.length; i++) {
			if (isCancelled())
				return count;
			else {
				setProgress(100 * (i + 1) / primes.length);

				try {
					Thread.sleep(generator.nextInt(5));
				} catch (InterruptedException interruptedException) {
					statusJLabel.setText("Worker thread interrupted");
					return count;
				}

				if (primes[i]) { // i é primo
					publish(i); // disponibiliza para exibicao na lista de
								// primos
					++count;

					for (int j = i + 1; j < primes.length; j += i) {
						primes[j] = false; // i não é primo
					}
				}
			}
		}

		return count;
	}

	protected void process(List<Integer> publishedVals) {
		for (int i = 0; i < publishedVals.size(); i++) {
			intermediateJTextArea.append(publishedVals.get(i) + "\n");
		}
	}

	protected void done() {
		getPrimesJButton.setEnabled(true);
		cancelJButton.setEnabled(false);

		int numPrimes;

		try {
			numPrimes = get(); // recupera o valor de retorno do doInBackGround
		} catch (InterruptedException interruptedException) {
			statusJLabel.setText("Interrupted while waiting for results");
			return;
		} catch (ExecutionException executionException) {
			statusJLabel.setText("Error performing computation");
			return;
		} catch (CancellationException cancellationException) {
			statusJLabel.setText("Cancelled");
			return;
		}

		statusJLabel.setText("Found " + numPrimes + " primes.");
	}
}
