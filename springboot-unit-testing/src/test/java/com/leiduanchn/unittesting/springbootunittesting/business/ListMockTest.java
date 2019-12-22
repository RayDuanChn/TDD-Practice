package com.leiduanchn.unittesting.springbootunittesting.business;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

/**
 * @author leiduanchn
 * @create 2019-12-19 7:10 p.m.
 */
public class ListMockTest {

    private List listMock = mock(List.class);

    @Test
    public void test_return_basic(){
        when(listMock.size()).thenReturn(5);
        assertEquals(5, listMock.size());
    }

    @Test
    public void test_return_different_values(){
        when(listMock.size()).thenReturn(5).thenReturn(10);

        assertEquals(5, listMock.size());
        assertEquals(10, listMock.size());
    }

    @Test
    public void test_return_with_parameters(){
        when(listMock.get(0)).thenReturn("hello world").thenReturn(10);

        assertEquals("hello world", listMock.get(0));
        assertEquals(10, listMock.get(0));
    }

    //anyInt() is the method of ArgumentMatchers class
    @Test
    public void test_return_any_parameters(){
        when(listMock.get(anyInt())).thenReturn("hello world").thenReturn(10);

        assertEquals("hello world", listMock.get(1));
        assertEquals(10, listMock.get(0));
    }


}
