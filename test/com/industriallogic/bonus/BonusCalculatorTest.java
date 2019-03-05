/// ***************************************************************************
/// Copyright (c) 2009, Industrial Logic, Inc., All Rights Reserved.
///
/// This code is the exclusive property of Industrial Logic, Inc. It may ONLY be
/// used by students during Industrial Logic's workshops or by individuals
/// who are being coached by Industrial Logic on a project.
///
/// This code may NOT be copied or used for any other purpose without the prior
/// written consent of Industrial Logic, Inc.
/// ****************************************************************************

package com.industriallogic.bonus;

import static org.junit.Assert.*;

import org.junit.Test;

public class BonusCalculatorTest {
	private static final double precision = 0.001;

	@Test
	public void noBonusForUnderPerformers() {
		SalesPerson salesPerson = new SalesPerson(1500, 10);
		assertEquals(0, salesPerson.individualBonus(1200, 0), precision);
	}

	@Test
	public void noBonusForAveragePerformers() {
		SalesPerson salesPerson = new SalesPerson(1200, 10);
		assertEquals(0, salesPerson.individualBonus(1200, 0), precision);
	}

	@Test
	public void salesExceedingQuotaEarnBonus() {
		SalesPerson salesPerson = new SalesPerson(1100, 10);
		assertEquals(10d, salesPerson.individualBonus(1200, 0), precision);
	}
	
	@Test
	public void salesExceedingQuotaEarnBonusAfterDeductingTax() {
		SalesPerson salesPerson = new SalesPerson(1100, 10);
		assertEquals(9, salesPerson.individualBonus(1200, 10), precision);
	}
	
	@Test
	public void noBonusForUnderPerformingTeam() {
		SalesPerson salesPerson = new SalesPerson(1500, 10);
		assertEquals(0, salesPerson.teamBonus(1200, 4), precision);
	}
	
	@Test
	public void noBonusForAveragePerformingTeam() {
		SalesPerson salesPerson = new SalesPerson(1200, 10);
		assertEquals(0, salesPerson.teamBonus(1200, 4), precision);
	}
	
	@Test
	public void salesExceedingQuotaEarnEqualBonusForTeamMembers() {
		SalesPerson salesPerson = new SalesPerson(1100, 10);
		assertEquals(2.5, salesPerson.teamBonus(1200, 4), precision);
	}
	
	@Test
	public void failSafe() {
		SalesPerson salesPerson = new SalesPerson(1100, 10);
		assertEquals(0, salesPerson.teamBonus(1200, 0), precision);
	}
}
