package com.leiduanchn.unittesting.springbootunittesting.business;

import com.leiduanchn.unittesting.springbootunittesting.repository.SomeDataService;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author leiduanchn
 * @create 2019-12-16 10:16 p.m.
 */
class SomeBusinessImplTest {

    @Test
    void calculateSum_basic() {
        SomeBusinessImpl business = new SomeBusinessImpl();
        int[] a = new int[] {1, 2, 3};
        int actualSum = business.calculateSum(a);
        int expectedSum = 6;
        assertEquals(expectedSum, actualSum);
    }

    @Test
    void calculateSum_empty() {
        SomeBusinessImpl business = new SomeBusinessImpl();
        int[] a = new int[] {};
        int actualSum = business.calculateSum(a);
        int expectedSum = 0;
        assertEquals(expectedSum, actualSum);
    }

    @Test
    void calculateSum_oneValue() {
        SomeBusinessImpl business = new SomeBusinessImpl();
        int[] a = new int[] {3};
        int actualSum = business.calculateSum(a);
        int expectedSum = 3;
        assertEquals(expectedSum, actualSum);
    }

}