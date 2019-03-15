package com.example.albertsons;

import dagger.Component;

@Component(modules = ViewModelModule.class)
public interface ViewModelComponent {

    void inject(RemoteDataSource remoteDataSource);
}
