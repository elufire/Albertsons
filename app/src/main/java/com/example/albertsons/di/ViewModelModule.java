package com.example.albertsons.di;

import android.app.Activity;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.support.v4.app.FragmentActivity;

import com.example.albertsons.activities.MainActivity;
import com.example.albertsons.apiconnections.RemoteDataSource;
import com.example.albertsons.viewmodels.MainViewModel;
import com.example.albertsons.viewmodels.MainViewModelFactory;

import javax.inject.Inject;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoMap;

@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel.class)
    abstract ViewModel bindMainViewModel(MainViewModel userViewModel);

    @Binds abstract ViewModelProvider.Factory bindViewModelFactory(MainViewModelFactory factory);
}
