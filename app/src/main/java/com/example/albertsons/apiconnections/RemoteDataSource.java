package com.example.albertsons.apiconnections;


import android.app.Application;
import android.util.Log;

import com.example.albertsons.datamodels.AbbrevResponse;
import com.example.albertsons.di.RemoteDataSourceComponent;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

public class RemoteDataSource {
    public static final String BASE_URL = "http://www.nactem.ac.uk/software/acromine/dictionary.py/";
//    @Inject
//    Retrofit retrofit;

//    RemoteDataSourceComponent remoteDataSourceComponent = DaggerRemoteDataSourceComponent
//            .builder()
//            .apiClass();


    public static Retrofit createRetrofit(){
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    public static RemoteService getService(){
        return createRetrofit().create(RemoteService.class);
    }

    public static Observable<List<AbbrevResponse>> getAbbrevResponse(String userAcro){
        Observable<List<AbbrevResponse>> abbrevList = getService().getAbbrevs(userAcro);
        if(abbrevList != null){
            return abbrevList;
        }
        else{
            Log.d("TAG", "IN GETABBREVRESPONSE ELSE");
            return null;
        }

    }



    public interface RemoteService{

        @GET("sf")
        Observable<List<AbbrevResponse>> getAbbrevs(@Query("sf") String userAcro);

    }
}
