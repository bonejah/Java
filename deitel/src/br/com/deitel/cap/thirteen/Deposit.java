package br.com.deitel.cap.thirteen;

public class Deposit extends Transaction {
	private double amount;
	private Keypad keypad;
	private DepositSlot depositSlot;

	private final static int CANCELED = 0;

	public Deposit(int userAccountNumber, Screen atmScreen, BankDatabase atmBankDatabase, Keypad atmKeypad,
			DepositSlot atmDepositSlot) {
		super(userAccountNumber, atmScreen, atmBankDatabase);
		keypad = atmKeypad;
		depositSlot = atmDepositSlot;
	}

	@Override
	public void execute() {
		BankDatabase bankDatabase = getBankDatabase();
		Screen screen = getScreen();

		amount = promptForDepositAmount();

		if (amount != CANCELED) {
			screen.displayMessage("\nPlease insert a deposit envelope containing ");
			screen.displayDollarAmount(amount);
			screen.displayMessageLine(".");

			boolean envelopeRececeived = depositSlot.isEnvelopeRececeived();

			if (envelopeRececeived) {
				screen.displayMessageLine(
						"\nYour envelope has been received.\nNote: The mnoney just deposited will not ve available until we verify the amount of any enclosed cash an your checks clear");
				bankDatabase.credit(getAccountNumber(), amount);
			} else {
				screen.displayMessageLine(
						"\nYou did not insert an envelope, so the ATM has cancelled your transaction.");
			}
		} else {
			screen.displayMessageLine("\nCancelling transaction...");
		}
	}

	private double promptForDepositAmount() {
		Screen screen = getScreen();
		screen.displayMessage("\nPlease enter a deposit amount in CENTS (or 0 to cancel): ");
		int input = keypad.getInput();

		if (input == CANCELED) {
			return CANCELED;
		} else {
			return (double) input / 100;
		}
	}
}
