package com.example.albertsons.di;

import android.app.Application;

import com.example.albertsons.apiconnections.RemoteDataSource;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;

@Singleton
@Component(modules = {RemoteDataSourceModule.class})
public interface RemoteDataSourceComponent {

    void inject(RemoteDataSource remoteDataSource);

    @Component.Builder
    interface Builder {

        @BindsInstance
        Builder apiClass(RemoteDataSource remoteDataSource);

        RemoteDataSourceComponent build();
    }
}
