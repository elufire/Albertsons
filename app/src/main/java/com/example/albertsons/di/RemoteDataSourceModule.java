package com.example.albertsons.di;

import com.example.albertsons.apiconnections.RemoteDataSource;
import com.example.albertsons.datamodels.AbbrevResponse;

import java.util.List;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.reactivex.Observable;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class RemoteDataSourceModule {



//    @Provides
//    @Singleton
//    Retrofit getRetrofit(){
//        return new Retrofit
//                .Builder()
//                .addConverterFactory(GsonConverterFactory.create())
//                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
//                .baseUrl(BASE_URL)
//                .build();
//    }

//    @Provides
//    @Singleton
//    Observable<List<AbbrevResponse>> getAbbrevList(Retrofit retrofit){
//        return retrofit
//                .create(RemoteDataSource.RemoteService.class)
//                .getAbbrevs();
//    }


}
