package com.dragos.financial.income.domain.viewmodels;

import com.dragos.financial.BaseResponse;
import com.dragos.financial.income.domain.entities.DailyIncome;
import com.dragos.financial.income.domain.usecase.AddNewIncomeUseCase;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class AddIncomeViewModel extends ViewModel {

    private final CompositeDisposable disposables;
    private final AddNewIncomeUseCase addIncomeUseCase;

    private final MutableLiveData<BaseResponse<Boolean>> response = new MutableLiveData<>();

    public AddIncomeViewModel(AddNewIncomeUseCase addIncomeUseCase) {
        this.addIncomeUseCase = addIncomeUseCase;
        disposables = new CompositeDisposable();
    }

    public void addTodayIncome(DailyIncome dailyIncome) {
        disposables.add(addIncomeUseCase.execute(dailyIncome)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(__ -> response.setValue(BaseResponse.loading()))
                .subscribe(
                        success -> response.setValue(BaseResponse.success(success)),
                        throwable -> response.setValue(BaseResponse.error(throwable != null ? throwable.getMessage() : "Error"))));
    }

    public MutableLiveData<BaseResponse<Boolean>> getResponse() {
        return response;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        disposables.clear();
    }
}
