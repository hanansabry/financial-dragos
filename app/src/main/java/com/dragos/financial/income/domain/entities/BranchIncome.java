package com.dragos.financial.income.domain.entities;

public class BranchIncome {

    private IncomeType.Branch branch;
    private double total;

    public IncomeType.Branch getBranch() {
        return branch;
    }

    public void setBranch(IncomeType.Branch branch) {
        this.branch = branch;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
