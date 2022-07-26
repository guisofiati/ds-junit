package tests.entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import entities.Account;
import tests.factory.AccountFactory;

public class AccountTests {
	
	@Test
	public void depositShouldIncreaseBalanceWhenAmountIsPositive() {
		
		// Arange -> declarar/instanciar os objetos
		double amount = 200.0; // sacar
		double expectedValue = 196.0;
		Account acc1 = AccountFactory.createEmptyAccount();
		
		// Act -> ação necessaria: depositar
		acc1.deposit(amount);
		
		// Assert -> o que deveria acontecer
		// assertEquals = os 2 args devem ser iguais
		Assertions.assertEquals(expectedValue, acc1.getBalance());
	}
	
	@Test
	public void withdrawShouldThrowsIllegalArgumentExceptionWhenInsufficientBalance() {
		
		double amount = 200.0;
		Account acc2 = AccountFactory.createAccount(100.0);
		
		// lança a illegal quando tenta fazer um saque maior que o saldo
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			acc2.withdraw(amount);
		});
	}
	
	@Test
	public void depositShouldDoNothingWhenNegativeAmount() {
		
		double amount = -200.0;
		//double expectedValue = 100.0;
		Account acc3 = AccountFactory.createAccount(100.0);
		
		acc3.deposit(amount);
		
		Assertions.assertTrue(acc3.getBalance() == 100.0);
	}
	
	@Test
	public void fullWithdrawShouldClearBalanceAndReturnFullBalance() {
		
		double expectedValue = 0.0;
		double initialBalance = 400.0;
		Account acc4 = AccountFactory.createAccount(initialBalance);
		
		double result = acc4.fullWithDraw();
		
		Assertions.assertEquals(expectedValue, acc4.getBalance());
		Assertions.assertTrue(result == initialBalance);
	}
	
	@Test
	public void withdrawShouldDecrementBalanceWhenSufficientBalance() {
		
		Account acc5 = AccountFactory.createAccount(600.0);
		
		acc5.withdraw(300.0);
		
		Assertions.assertEquals(300.0, acc5.getBalance());
	}
}
