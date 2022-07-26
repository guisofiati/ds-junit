package entities;

public class Account {
	
	private static double DEPOSIT_FEE = 0.02;
	
	private Long id;
	private Double balance;
	
	public Account() {
		super();
	}

	public Account(Long id, Double balance) {
		super();
		this.id = id;
		this.balance = balance;
	}
	
	public void deposit(double amount) {
		if (amount > 0.0) { 
			amount -= amount * DEPOSIT_FEE;
			balance += amount;
		}
	}
	
	public void withdraw(double amount) {
		if (amount > balance) {
			throw new IllegalArgumentException("Not enough balance");
		}
		balance -= amount;
	}
	
	public double fullWithDraw() {
		double aux = balance;
		balance = 0.0;
		return aux;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getBalance() {
		return balance;
	}
}