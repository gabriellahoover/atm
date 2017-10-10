package atmproject;

import java.util.Scanner;

public class Atm {
	public static final int TX_WITHDRAW = 0;

	private int accountNumber = 19;
	private String pin = "0110";
	private double balance = 100;
	private Scanner inputScanner;

	private int amountOfMoneyInMachine = 500;

	private int request;
	private int requestedAmount;

	private int amountOfTwenties = 10;
	private int amountOfTens = 30;
	private int requestedTwenties;
	private int requestedTens;

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
			if (this.requestedAmount > this.amountOfMoneyInMachine) {
				display("Not enough money in machine");
			}
			if (this.requestedAmount > this.balance) {
				display("Not enough money in account");
			}
			if (requestedAmount < this.amountOfMoneyInMachine && requestedAmount < this.balance) {
				this.balance = this.balance - requestedAmount;
				this.display("$" + requestedTwenties + " twenties and " + requestedTens
						+ " ten given. \nBalance is now " + this.balance);
			}
			if (this.request == 2)

			{
				if (requestedAmount <= this.amountOfMoneyInMachine) {
					this.balance = this.balance + requestedAmount;
					this.display("$" + requestedAmount + " deposited. \nBalance is now " + this.balance);
					this.amountOfMoneyInMachine = this.amountOfMoneyInMachine + requestedAmount;
				}
			}
		}
	}

	public void withdrawBills() {
		if (this.request == 1) {
			if (this.requestedAmount % 20 > amountOfTwenties) {
				this.requestedTens = requestedAmount / 10;
				this.amountOfTens = amountOfTens - requestedTens; 
			}
			this.requestedTwenties = requestedAmount / 20;
			this.amountOfTwenties = amountOfTwenties - requestedTwenties;
			this.requestedTens = ((requestedAmount % 20) / 10);
			this.amountOfTens = amountOfTens - requestedTens;
		}
	}
	/*public void withdrawTwenties() {
		if (this.request == 1) {
			this.requestedTwenties = requestedAmount / 20;
			this.amountOfTwenties = amountOfTwenties - requestedTwenties;
		}

	}

	public void withdrawTens() {
		if (this.request == 1) {
			if (this.requestedAmount % 20 > amountOfTwenties) {
				this.requestedTens = requestedAmount / 10;
				this.amountOfTens = amountOfTens - requestedTens; 
			}
			this.requestedTens = ((requestedAmount % 20) / 10);
			this.amountOfTens = amountOfTens - requestedTens;
		}
	}*/

	/*
	 * public void billsWithdrawn() { if (this.request == 1) {
	 * this.requestedTwenties = requestedAmount / 20; this.amountOfTwenties =
	 * amountOfTwenties - requestedTwenties; this.requestedTens = ((requestedAmount
	 * % 20) / 10); this.amountOfTens = amountOfTens - requestedTens;
	 * System.out.println(amountOfTwenties + " " + amountOfTens);
	 * System.out.println(requestedTwenties + " " + requestedTens);
	 * 
	 * } }
	 */


	public void doHandleRequest() {
		this.display("Press 1 for withdraw, Press 2 for deposit");
		Scanner input = new Scanner(System.in);
		this.request = input.nextInt();
		if (this.request < 1) {
			display("Error");
		}
		if (this.request > 2) {
			display("Error");
		}
		if (this.request == 1 || this.request == 2) {
			this.display("Enter amount");
			this.requestedAmount = input.nextInt();
		}
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
		/*
		 * boolean authenticated = false; while (!authenticated) { authenticated =
		 * atm.doAuthenticate(); if (!authenticated) { atm.display("Failed try again");
		 * } }
		 */
		atm.doHandleRequest();
		atm.withdrawBills();
		atm.doHandleTransaction();
		atm.doFinish();
		/* System.out.print(atm.amountOfMoneyInMachine); */

		scan.close();
	}
}
