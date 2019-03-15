package com.example.albertsons;

import dagger.Module;
import dagger.Provides;

@Module
public class ViewModelModule {

    @Provides
    RemoteDataSource getRemoteDataSource(){
        return new RemoteDataSource();
    }
}
