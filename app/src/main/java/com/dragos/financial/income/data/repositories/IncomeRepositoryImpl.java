package com.dragos.financial.income.data.repositories;

import com.dragos.financial.income.domain.entities.DailyIncome;
import com.dragos.financial.income.domain.repositories.IncomeRepository;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.rxjava3.core.Single;

public class IncomeRepositoryImpl implements IncomeRepository {

    List<DailyIncome> dailyIncomes = new ArrayList<>();

    @Override
    public Single<Boolean> addTodayIncome(DailyIncome dailyIncome) {
        dailyIncomes.add(dailyIncome);
        return Single.just(true);
    }

}
