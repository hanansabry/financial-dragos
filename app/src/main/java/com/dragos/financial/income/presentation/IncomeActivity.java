package com.dragos.financial.income.presentation;

import android.os.Bundle;
import android.widget.Toast;

import com.dragos.financial.BaseActivity;
import com.dragos.financial.Injection;
import com.dragos.financial.R;
import com.dragos.financial.income.domain.entities.DailyIncome;
import com.dragos.financial.income.domain.entities.IncomeType;
import com.dragos.financial.income.domain.entities.IncomeTypeCash;
import com.dragos.financial.income.domain.entities.IncomeTypeOnlineOrderingSystems;
import com.dragos.financial.income.domain.entities.IncomeTypeVisa;
import com.dragos.financial.income.domain.viewmodels.AddIncomeViewModel;
import com.dragos.financial.income.domain.viewmodels.AddIncomeViewModelFactory;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.ActionBar;
import androidx.lifecycle.ViewModelProviders;

public class IncomeActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_income);
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_income;
    }

    @Override
    protected void init() {
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.custom_toolbar_income_activity2);

        AddIncomeViewModel addIncomeViewModel =
                ViewModelProviders.of(this,
                        new AddIncomeViewModelFactory(Injection.getAddIncomeUseCase()))
                        .get(AddIncomeViewModel.class);

        addIncomeViewModel.addTodayIncome(getSampleOfDailyIncome());
        addIncomeViewModel.getResponse().observe(this, response -> {
            switch (response.status) {
                case LOADING:
                    Toast.makeText(this, "Loading", Toast.LENGTH_SHORT).show();
                    break;
                case ERROR:
                    Toast.makeText(this, "Error : " + response.errorMsg, Toast.LENGTH_SHORT).show();
                    break;
                case SUCCESS:
                    Toast.makeText(this, "Success : " + response.data, Toast.LENGTH_SHORT).show();
                    break;
            }
        });

    }

    private DailyIncome getSampleOfDailyIncome() {
        IncomeTypeCash cash = new IncomeTypeCash(5000);
        IncomeTypeCash cashNasr = new IncomeTypeCash(IncomeType.Branch.Nasr_City, 5000);
        IncomeTypeVisa visa = new IncomeTypeVisa(4000);
        IncomeTypeVisa visaNasr = new IncomeTypeVisa(IncomeType.Branch.Nasr_City, 4000);
        IncomeTypeOnlineOrderingSystems otlob = new IncomeTypeOnlineOrderingSystems(IncomeTypeOnlineOrderingSystems.OrderingSystems.Otlob, 2000);
        IncomeTypeOnlineOrderingSystems akelni = new IncomeTypeOnlineOrderingSystems(IncomeType.Branch.Nasr_City, IncomeTypeOnlineOrderingSystems.OrderingSystems.Akelni, 2000);

        List<IncomeType> incomeTypes = new ArrayList<>();
        incomeTypes.add(cash);
        incomeTypes.add(cashNasr);
        incomeTypes.add(visa);
        incomeTypes.add(visaNasr);
        incomeTypes.add(otlob);
        incomeTypes.add(akelni);

        DailyIncome dailyIncome = new DailyIncome();
        dailyIncome.setDate("11-9-2020");
        dailyIncome.setIncomeTypes(incomeTypes);
        return dailyIncome;
    }
}