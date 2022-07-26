package entities;

public class Financing {
	
	private static final double FINANCE_ENTRANCE = 0.2;
	
	private Double totalAmount;
	private Double income;
	private Integer months;
	
	public Financing() {
	}

	public Financing(Double totalAmount, Double income, Integer months) {
		validateFinancing(totalAmount, income, months);
		this.totalAmount = totalAmount;
		this.income = income;
		this.months = months;
	}
	
	public double entry() {
		return totalAmount * 0.2;
	}
	
	public double quota() {
		return (totalAmount - entry()) / months;
	}
	
	public void validateFinancing(Double totalAmount, Double income, Integer months) {
		double entryValue = totalAmount * FINANCE_ENTRANCE;
		double remainingValue = totalAmount - entryValue;
		if (remainingValue / months > income / 2.0) {
			throw new IllegalArgumentException("The quote cannot be higher than your monthly income");
		}
	}

	public Double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Double totalAmount) {
		validateFinancing(totalAmount, income, months);
		this.totalAmount = totalAmount;
	}

	public Double getIncome() {
		return income;
	}

	public void setIncome(Double income) {
		validateFinancing(totalAmount, income, months);
		this.income = income;
	}

	public Integer getMonths() {
		return months;
	}

	public void setMonths(Integer months) {
		validateFinancing(totalAmount, income, months);
		this.months = months;
	}
}
