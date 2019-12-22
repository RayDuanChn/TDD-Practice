package com.leiduanchn.unittesting.springbootunittesting.business;

import com.leiduanchn.unittesting.springbootunittesting.repository.SomeDataService;

/**
 * @author leiduanchn
 * @create 2019-12-16 10:13 p.m.
 */
public class SomeBusinessImpl {

    private SomeDataService someDataService;

    public int calculateSum(int[] data){
        int sum = 0;
        for (int value : data) {
            sum += value;
        }
        return sum;
    }


    public int calculateSumUsingDataService(){
        int[] data = someDataService.retrieveAllData();
        int sum = 0;
        for (int value : data) {
            sum += value;
        }
        return sum;
    }

    public void setSomeDataService(SomeDataService someDataService) {
        this.someDataService = someDataService;
    }
}
