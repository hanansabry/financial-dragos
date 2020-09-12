package com.dragos.financial.income.domain.entities;

public class IncomeType {

    public enum Branch {October, Nasr_City}

    private double value;
    private Branch branch;

    public IncomeType(Branch branch, double value) {
        this.branch = branch;
        this.value = value;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public Branch getBranch() {
        return branch;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }
}
