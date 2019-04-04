package com.example.albertsons;

import com.example.albertsons.apiconnections.RemoteDataSource;
import com.example.albertsons.viewmodels.MainViewModel;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class ViewModelTest {

    //@Mock
    MainViewModel mainViewModel;

    @Test
    public void testRetrofitApiCall(){
        assertNotNull(RemoteDataSource.getAbbrevResponse("ddd"));
    }



}
