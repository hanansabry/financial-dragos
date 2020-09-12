package com.dragos.financial.income.domain.entities;

public class IncomeTypeOnlineOrderingSystems extends IncomeType{

    public enum OrderingSystems { Otlob, Akelni, Uber_Eats}

    private OrderingSystems orderingSystem;

    public IncomeTypeOnlineOrderingSystems(OrderingSystems orderingSystem, double value) {
        super(Branch.October, value);
        this.orderingSystem = orderingSystem;
    }

    public IncomeTypeOnlineOrderingSystems(Branch branch, OrderingSystems orderingSystem, double value) {
        super(branch, value);
        this.orderingSystem = orderingSystem;
    }
}
