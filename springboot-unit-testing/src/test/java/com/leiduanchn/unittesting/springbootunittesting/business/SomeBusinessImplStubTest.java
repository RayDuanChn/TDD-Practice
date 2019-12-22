package com.leiduanchn.unittesting.springbootunittesting.business;

import com.leiduanchn.unittesting.springbootunittesting.repository.SomeDataService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * @author leiduanchn
 * @create 2019-12-17 9:45 p.m.
 */
public class SomeBusinessImplStubTest {


    @Test
    void calculateSumUsingDataService(){

        SomeDataServiceImpl dataService = new SomeDataServiceImpl();
//        SomeDataService dataService = mock(SomeDataService.class);
//        when(dataService.retrieveAllData()).thenReturn(new int[] {1, 2, 3, 5});

        SomeBusinessImpl business = new SomeBusinessImpl();
        business.setSomeDataService(dataService);
        int actualSum = business.calculateSumUsingDataService();
        int expectedSum = 11;
        assertEquals(expectedSum, actualSum);
    }
}


// stub of SomeDataService by inheritance
class SomeDataServiceImpl implements SomeDataService{
    @Override
    public int[] retrieveAllData() {
        return new int[] {1, 2, 3, 5};
    }
}
