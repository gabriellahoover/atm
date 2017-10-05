package atmproject;

import java.util.Scanner;

public class Atm {
	public static final int TX_WITHDRAW = 0;

	private int accountNumber = 19;
	private String pin = "0110";
	private double balance = 100;
	private Scanner inputScanner;

	private int amountOfMoneyInMachine = 1250;

	private int status;

	private int request;
	private int requestedAmount;

	private int amountOfTwenties;
	private int amountOfTens;
	/*
	 * private int amountOfFives; private int amountOfOnes;
	 */

	public boolean doAuthenticate() {
		/* display */

		display("Enter account number and PIN");

		/* get input */

		int inputAccount = inputScanner.nextInt();
		String inputPIN = inputScanner.next();
		/* input.close(); */
		if (inputAccount == this.accountNumber && inputPIN.equals(this.pin)) {
			display("PASS");
			return true;
		}
		display("FAIL");
		return false;
	}

	public void doHandleTransaction() {
		if (this.request == 1) {
			if (requestedAmount <= this.amountOfMoneyInMachine) {
				this.balance = this.balance - requestedAmount;
				this.display("$" + requestedAmount + " given. \nBalance is now " + this.balance);

			}
		}
		if (this.request == 2) {
			if (requestedAmount <= this.amountOfMoneyInMachine) {
				this.balance = this.balance + requestedAmount;
				this.display("$" + requestedAmount + " deposited. \nBalance is now " + this.balance);
			}
			else {
				display("Not enough money in machine");
			}
		}
	}

	public void doHandleRequest() {
		this.display("Press 1 for withdraw, Press 2 for deposit");
		Scanner input = new Scanner(System.in);
		this.request = input.nextInt();
		this.display("How much would like to transact?");
		this.requestedAmount = input.nextInt();

	}

	public Atm(Scanner input) {
		this.inputScanner = input;
	}

	public void doFinish() {
		System.out.println("Thank you");
	}

	public void display(String message) {
		System.out.println(message);
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Atm atm = new Atm(scan);
		boolean authenticated = false;
		while (!authenticated) {
			authenticated = atm.doAuthenticate();
			if (!authenticated) {
				atm.display("Failed try again");
			}
		}
		/* authenticate */
		atm.doHandleRequest();
		atm.doHandleTransaction();
		atm.doFinish();

		scan.close();
	}
}
