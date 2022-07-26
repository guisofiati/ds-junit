package tests.entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import entities.Financing;
import tests.factory.FinancingFactory;

public class FinancingTests {

	@Test
	public void constructorShouldAllowFinancingWhenValidData() {
		
		Financing f1 = FinancingFactory.createFinancing(100000.0, 2000.0, 80);

		Assertions.assertEquals(f1.getTotalAmount(), 100000.0);
		Assertions.assertEquals(f1.getIncome(), 2000.0);
		Assertions.assertEquals(f1.getMonths(), 80);
	}

	@Test
	public void constructorShouldThrowIllegalArgumentExceptionWhenInvalidData() {
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> { 
			// valor cota: 4000
			Financing f2 = FinancingFactory.createFinancing(100000.0, 2000.0, 20);
		});
	}
	
	@Test
	public void setTotalAmountShouldUpdateWhenValidData() {
		
		Financing f3 = FinancingFactory.createFinancing(100000.0, 2000.0, 80);

		f3.setTotalAmount(50000.0);
		
		Assertions.assertEquals(f3.getTotalAmount(), 50000.0);
		Assertions.assertEquals(f3.getIncome(), 2000.0);
		Assertions.assertEquals(f3.getMonths(), 80);
	}
	
	@Test
	public void setTotalAmountShouldThrowExceptionWhenInvalidData() {
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Financing f4 = FinancingFactory.createFinancing(100000.0, 2000.0, 80);
			
			f4.setTotalAmount(200000.0); // valor cota: 2000.0
		});
	}
	
	@Test
	public void setIncomeShouldUpdateWhenValidData() {
		
		Financing f5 = FinancingFactory.createFinancing(100000.0, 2000.0, 80);

		f5.setIncome(3000.0);
		
		Assertions.assertEquals(f5.getTotalAmount(), 100000.0);
		Assertions.assertEquals(f5.getIncome(), 3000.0);
		Assertions.assertEquals(f5.getMonths(), 80);
	}
	
	@Test
	public void setIncomeShouldThrowExceptionWhenInvalidData() {
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Financing f6 = FinancingFactory.createFinancing(100000.0, 2000.0, 80);
			
			f6.setIncome(1000.0);
		});
	}
	
	@Test
	public void setMonthsShouldUpdateWhenValidData() {
		
		Financing f7 = FinancingFactory.createFinancing(100000.0, 2000.0, 80);
		
		f7.setMonths(81);
		
		Assertions.assertEquals(f7.getTotalAmount(), 100000.0);
		Assertions.assertEquals(f7.getIncome(), 2000.0);
		Assertions.assertEquals(f7.getMonths(), 81);
	}
	
	@Test
	public void setMonthsShouldThrowExceptionWhenInvalidData() {
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Financing f8 = FinancingFactory.createFinancing(100000.0, 2000.0, 79);

			f8.setIncome(1000.0);
		});
	}
	
	@Test
	public void entryShouldBeCorrectlyCalculated() {
		
		Financing f9 = FinancingFactory.createFinancing(100000.0, 2000.0, 80);
		double expectedEntryValue = 20000.0;
		
		Assertions.assertEquals(f9.entry(), expectedEntryValue);
	}
	
	@Test
	public void quotaShouldBeCorrectlyCalculated() {
		
		Financing f10 = FinancingFactory.createFinancing(100000.0, 2000.0, 80);
		double expectedQuotaValue = 1000.0;
		
		Assertions.assertEquals(f10.quota(), expectedQuotaValue);
	}
}
