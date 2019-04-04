package com.example.albertsons.viewmodels;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.support.v4.app.FragmentActivity;
import android.util.Log;

import com.example.albertsons.datamodels.AbbrevResponse;
import com.example.albertsons.activities.MainActivity;
import com.example.albertsons.apiconnections.RemoteDataSource;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MainViewModel extends ViewModel {

    MutableLiveData<List<AbbrevResponse>> abbrevLiveData;
    String userAcro;

    @Inject
    public MainViewModel() {

    }

    public void init(){
        abbrevLiveData = new MutableLiveData<>();
    }

    public void createApiCall(){
        RemoteDataSource.getAbbrevResponse(userAcro)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<List<AbbrevResponse>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                        Log.d("TAG", "onSubscribe: ");
                    }

                    @Override
                    public void onNext(List<AbbrevResponse> abbrevs) {
                        if(abbrevs != null){
                            abbrevLiveData.setValue(abbrevs);
                            Log.d(MainActivity.class.getSimpleName()+"_TAG", "onNext: "+ abbrevs.size());
                        }
                        else{
                            Log.d("TAG", "onNext: DOES NOT EXIST");
                        }

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d("TAG", "onError: "+ e.getMessage());

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    public LiveData<List<AbbrevResponse>> getAbbrevLiveData(){
        return abbrevLiveData;
    }

    public void onTextChanged(CharSequence s) {
        Log.w("tag", "onTextChanged " + s);
        userAcro = s.toString();
    }

    public void handleClick(){
        Log.d("TAG", "HandleClick: " + userAcro);
        createApiCall();
    }
}
