package com.example.albertsons.di;

import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.support.v4.app.FragmentActivity;

import com.example.albertsons.apiconnections.RemoteDataSource;
import com.example.albertsons.viewmodels.MainViewModel;

import dagger.BindsInstance;
import dagger.Component;

@Component(modules = ViewModelModule.class)
public interface ViewModelComponent {

    MainViewModel providesViewModel();


}
