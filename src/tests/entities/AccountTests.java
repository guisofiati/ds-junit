package tests.entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import entities.Account;

public class AccountTests {
	
	@Test
	public void depositShouldIncreaseBalanceWhenAmountIsPositive() {
		
		// Arange -> declarar/instanciar os objetos
		double amount = 200.0; // sacar
		double expectedValue = 196.0;
		Account acc1 = new Account(1L, 0.0);
		
		// Act -> ação necessaria: depositar
		acc1.deposit(amount);
		
		// Assert -> o que deveria acontecer
		// assertEquals = os 2 args devem ser iguais
		Assertions.assertEquals(expectedValue, acc1.getBalance());
	}
	
	@Test
	public void withdrawShouldThrowsIllegalArgumentExceptionWhenAmountIsHigherThanBalance() {
		
		double amount = 200.0;
		Account acc2 = new Account(2L, 100.0);
		
		// lança a illegal quando tenta fazer um saque maior que o saldo
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			acc2.withdraw(amount);
		});
	}
	
	@Test
	public void depositShouldDoNothingWhenNegativeAmount() {
		
		double amount = -200.0;
		//double expectedValue = 100.0;
		Account acc3 = new Account(3L, 100.0);
		
		acc3.deposit(amount);
		
		Assertions.assertTrue(acc3.getBalance() == 100.0);
	}
}
