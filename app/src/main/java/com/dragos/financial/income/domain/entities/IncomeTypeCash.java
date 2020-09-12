package com.dragos.financial.income.domain.entities;

public class IncomeTypeCash extends IncomeType {

    public IncomeTypeCash(double value) {
        super(Branch.October, value);
    }

    public IncomeTypeCash(Branch branch, double value) {
        super(branch, value);
    }
}
