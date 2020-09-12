package com.dragos.financial.income.domain.entities;

public class IncomeTypeVisa extends IncomeType {

    public IncomeTypeVisa(double value) {
        super(Branch.October, value);
        setValue(value);
    }

    public IncomeTypeVisa(Branch branch, double value) {
        super(branch, value);
        setValue(value);
    }
}
