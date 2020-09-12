package com.dragos.financial.income.domain.repositories;

import com.dragos.financial.income.domain.entities.DailyIncome;

import io.reactivex.rxjava3.core.Single;

public interface IncomeRepository {

    Single<Boolean> addTodayIncome(DailyIncome dailyIncome);
}
