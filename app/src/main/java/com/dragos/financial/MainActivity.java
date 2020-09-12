package com.dragos.financial;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.util.Log;

import com.dragos.financial.income.domain.entities.DailyIncome;
import com.dragos.financial.income.domain.entities.IncomeType;
import com.dragos.financial.income.domain.entities.IncomeTypeCash;
import com.dragos.financial.income.domain.entities.IncomeTypeOnlineOrderingSystems;
import com.dragos.financial.income.domain.entities.IncomeTypeOnlineOrderingSystems.*;
import com.dragos.financial.income.domain.entities.IncomeTypeVisa;
import com.dragos.financial.income.domain.viewmodels.AddIncomeViewModel;
import com.dragos.financial.income.domain.viewmodels.AddIncomeViewModelFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        HashMap<IncomeType.Branch, Double> branchsTotal = dailyIncome.getBranchIncomeTotal();
//        for (IncomeType.Branch branch : branchsTotal.keySet()) {
//            Log.e(branch.name(), "total = " + branchsTotal.get(branch));
//        }



    }
}