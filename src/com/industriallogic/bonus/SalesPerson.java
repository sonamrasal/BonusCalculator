package com.industriallogic.bonus;

public class SalesPerson {

	private double quota;
	private double commission;

	public SalesPerson(double quota, double commission) {
		this.quota = quota;
		this.commission = commission;
	}

	public double individualBonus(double sales, double tax) {
		double excess = Math.max(sales - quota, 0);
		double taxableCommission = excess * (commission / 100);
		double taxToDeduct = taxableCommission * (tax / 100);
		return taxableCommission - taxToDeduct;
	}

	public double teamBonus(double sales, int teamSize) {
		double individualBonus = individualBonus(sales, 0);
		return teamSize > 0 ? individualBonus / teamSize : 0;
	}

}
