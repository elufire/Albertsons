package com.example.albertsons;

import android.app.Application;

import com.example.albertsons.di.RemoteDataSourceComponent;

public class AlbertsonsApp extends Application {

    //private RemoteDataSourceComponent remoteDataSourceComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        //remoteDataSourceComponent = DaggerRemoteDataSourceComponent;
    }
}
