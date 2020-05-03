package br.com.deitel.cap.seventheen;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class ReadTextFile {
	private Scanner input;

	public void openFile() {
		try {
			input = new Scanner(new File("clientes.txt"));
		} catch (FileNotFoundException fileNotFoundException) {
			System.err.println("Error opening file.");
			System.exit(1);
		}
	}

	public void readRecords() {
		AccountRecord accountRecord = new AccountRecord();
		System.out.printf("%-10s%-12s%-12s%10s\n", "Account", "First Name", "Last Name", "Balance");

		try {
			while (input.hasNext()) {
				accountRecord.setAccount(input.nextInt());
				accountRecord.setFirstName(input.next());
				accountRecord.setLastName(input.next());
				accountRecord.setBalance(input.nextDouble());

				System.out.printf("%-10d%-12s%-12s%10.2f\n", accountRecord.getAccount(), accountRecord.getFirstName(),
						accountRecord.getLastName(), accountRecord.getBalance());
			}
		} catch (NoSuchElementException elementException) {
			System.err.println("File improperly formed.");
			input.close();
			System.exit(1);
		} catch (IllegalStateException stateException) {
			System.err.println("Error reading from file.");
			System.exit(1);
		}
	}

	public void closeFile() {
		if (input != null) {
			input.close();
		}
	}
}
