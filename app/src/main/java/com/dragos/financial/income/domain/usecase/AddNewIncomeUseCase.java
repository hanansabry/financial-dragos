package com.dragos.financial.income.domain.usecase;

import com.dragos.financial.income.domain.entities.DailyIncome;
import com.dragos.financial.income.domain.repositories.IncomeRepository;

import io.reactivex.rxjava3.core.Single;

public class AddNewIncomeUseCase {

    private IncomeRepository incomeRepository;

    public AddNewIncomeUseCase(IncomeRepository incomeRepository) {
        this.incomeRepository = incomeRepository;
    }

    public Single<Boolean> execute(DailyIncome dailyIncome) {
        return incomeRepository.addTodayIncome(dailyIncome);
    }
}
