package com.example.albertsons;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
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
