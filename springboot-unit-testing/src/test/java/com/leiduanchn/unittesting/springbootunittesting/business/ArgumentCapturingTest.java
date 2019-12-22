package com.leiduanchn.unittesting.springbootunittesting.business;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

/**
 * @author leiduanchn
 * @create 2019-12-19 7:55 p.m.
 */
public class ArgumentCapturingTest {

    private List<String> listMock = mock(List.class);

    //Capture method parameters
    @Test
    public void test_arguments_capturing(){

        //stub
        listMock.add("hello world");

        //ArgumentCaptor: Use it to capture argument values for further assertions.
        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        verify(listMock).add(captor.capture());

        assertEquals("hello world", captor.getValue());

    }

    @Test
    public void test_multiple_arguments_capturing(){

        //stub
        listMock.add("hello world1");
        listMock.add("hello world2");
        listMock.remove("hello world3");

        //ArgumentCaptor: Use it to capture argument values for further assertions.
        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        verify(listMock, times(2)).add(captor.capture());
        verify(listMock).remove(captor.capture());

        // get all parameters
        List<String> allValues = captor.getAllValues();

        assertEquals("hello world1", allValues.get(0));
        assertEquals("hello world2", allValues.get(1));
        assertEquals("hello world3", allValues.get(2));

    }


}
