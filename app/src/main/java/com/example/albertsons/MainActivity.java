package com.example.albertsons;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.widget.Toast;

import com.example.albertsons.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding activityMainBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        MainViewModel mainViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        mainViewModel.init();
        //mainViewModel.createApiCall();
        activityMainBinding.setMainViewModel(mainViewModel);
        activityMainBinding.executePendingBindings();
        activityMainBinding.recyclerView.setLayoutManager(new LinearLayoutManager(this));

        mainViewModel.getAbbrevLiveData().observe(this, new Observer<List<AbbrevResponse>>() {
            @Override
            public void onChanged(@Nullable List<AbbrevResponse> abbrevResponseList) {
                if(abbrevResponseList != null){
                    Log.d("TAG", "User Observer onChanged: " + abbrevResponseList.get(0).getSf());
                    activityMainBinding.setAcro(abbrevResponseList.get(0));
                    RecyclerAdapter recyclerViewAdapter = new RecyclerAdapter(new ArrayList<>(abbrevResponseList.get(0).getLfs()));
                    activityMainBinding.recyclerView.setAdapter(recyclerViewAdapter);
                }
                else{
                    Toast.makeText(getBaseContext(), "We have no suggestions for this Acronym", Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}
