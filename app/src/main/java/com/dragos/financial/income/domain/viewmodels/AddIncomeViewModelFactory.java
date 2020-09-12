package com.dragos.financial.income.domain.viewmodels;

import com.dragos.financial.income.domain.usecase.AddNewIncomeUseCase;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public class AddIncomeViewModelFactory implements ViewModelProvider.Factory {

    AddNewIncomeUseCase useCase;

    public AddIncomeViewModelFactory(AddNewIncomeUseCase useCase) {
        this.useCase = useCase;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new AddIncomeViewModel(useCase);
    }
}
