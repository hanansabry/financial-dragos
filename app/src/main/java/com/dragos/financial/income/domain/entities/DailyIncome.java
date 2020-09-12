package com.dragos.financial.income.domain.entities;

import java.util.HashMap;
import java.util.List;

public class DailyIncome {

    private String date;
    private double total;
    private HashMap<IncomeType.Branch, Double> branchIncomeTotal;
    private List<IncomeType> incomeTypes;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getTotal() {
        if (incomeTypes != null) {
            for (IncomeType incomeType : incomeTypes) {
                total += incomeType.getValue();
            }
        }
        return total;
    }

    public List<IncomeType> getIncomeTypes() {
        return incomeTypes;
    }

    public void setIncomeTypes(List<IncomeType> incomeTypes) {
        this.incomeTypes = incomeTypes;
    }

    public HashMap<IncomeType.Branch, Double> getBranchIncomeTotal() {
        branchIncomeTotal = new HashMap<>();
        for (IncomeType incomeType : incomeTypes) {
            if (branchIncomeTotal.containsKey(incomeType.getBranch())) {
                branchIncomeTotal.put(incomeType.getBranch(),
                        branchIncomeTotal.get(incomeType.getBranch()) + incomeType.getValue());
            } else {
                branchIncomeTotal.put(incomeType.getBranch(), incomeType.getValue());
            }
         }
        return branchIncomeTotal;
    }
}
