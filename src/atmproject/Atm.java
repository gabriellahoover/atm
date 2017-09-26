package atmproject;

public class Atm {
	private int accountNumber;
	private String pin;
	private double balance;
	
	private int amountOfMoneyInMachine;
	
	private int status;
	
	private int request;
	private int requestedAmount;
	
	public boolean doAuthenticate() {
		return true;
	}
	public void doHandleTransaction() {
		if(this.request == 1) {
			this.display("$"+ this.requestedAmount + " given");
		}
	}
	
	public void doHandleRequest() {
		this.request = 1;
		this.requestedAmount = 100;
		
	}
	
	public void doFinish() {
		System.out.println("Thank you");
	}
	
	public void display(String message) {
		System.out.println(message);
	}
	public static void main(String[]args) {
		Atm atm = new Atm();
		/* authenticate*/
		boolean authenticated = atm.doAuthenticate();
		if (authenticated) {
		atm.doHandleRequest();
		atm.doHandleTransaction();
		atm.doFinish();
		}
	}


}
