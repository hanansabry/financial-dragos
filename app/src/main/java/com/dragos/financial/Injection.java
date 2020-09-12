package com.dragos.financial;

import com.dragos.financial.income.data.repositories.IncomeRepositoryImpl;
import com.dragos.financial.income.domain.repositories.IncomeRepository;
import com.dragos.financial.income.domain.usecase.AddNewIncomeUseCase;

public class Injection {
    public static AddNewIncomeUseCase getAddIncomeUseCase() {
        return new AddNewIncomeUseCase(getIncomeRepository());
    }

    private static IncomeRepository getIncomeRepository() {
        return new IncomeRepositoryImpl();
    }
}
