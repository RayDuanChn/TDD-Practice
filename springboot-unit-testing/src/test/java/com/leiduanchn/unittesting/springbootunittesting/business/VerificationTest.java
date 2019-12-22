package com.leiduanchn.unittesting.springbootunittesting.business;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

/**
 * @author leiduanchn
 * @create 2019-12-19 7:42 p.m.
 */
public class VerificationTest {

    private List<String> listMock = mock(List.class);


    /**
     * Verify the number of times a method was executed
     */
    @Test
    public void test_verification_basic(){
        listMock.get(0);
        listMock.get(1);

        verify(listMock).get(0);
        verify(listMock, times(2)).get(anyInt());
        verify(listMock, atLeast(1)).get(anyInt());
        verify(listMock, atLeastOnce()).get(anyInt());
        verify(listMock, atMost(2)).get(anyInt());
        verify(listMock, never()).get(2);
    }
}
