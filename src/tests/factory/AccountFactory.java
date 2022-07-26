package tests.factory;

import entities.Account;

// Factory Pattern. Instanciar o objeto em uma classe 'fabrica'
// Ação repetitiva no sistema
public class AccountFactory {
	
	public static Account createEmptyAccount() {
		return new Account(1L, 0.0);
	}
	
	public static Account createAccount(double initialBalance) {
		return new Account(1L, initialBalance);
	}
}
