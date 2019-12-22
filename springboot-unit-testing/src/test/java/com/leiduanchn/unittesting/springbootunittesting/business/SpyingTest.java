package com.leiduanchn.unittesting.springbootunittesting.business;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;


/**
 * @author leiduanchn
 * @create 2019-12-20 4:28 p.m.
 */
public class SpyingTest {

    /*
    So typically when we create a mock, the entire behavior of the interface or the class get lost.
    It is not the real class. if its a void method, then it will do nothing when you call the method


    or if its a method with a return then it may return null, empty or the default value.

 */
    @Test
    public void mock_Test(){
        List<Integer> listMock = mock(ArrayList.class);

        System.out.println(listMock.get(0));    //null
        System.out.println(listMock.size());    //0
        listMock.add(1);
        listMock.add(2);
        System.out.println(listMock.size());    //0

        when(listMock.size()).thenReturn(5);
        System.out.println(listMock.size());    //5

    }

    /*
       while in spy, there is the real object and you just spying or stubbing specific methods of it.
       since it is a real method, when you are not stubbing the method, then it will call the real method behavior.
       If you want to change and mock the method, then you need to stub it.

     */
    @Test
    public void spy_Test(){
        List<Integer> listMock = spy(ArrayList.class);

        //System.out.println(listMock.get(0));    //java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
        System.out.println(listMock.size());    //0
        listMock.add(1);
        listMock.add(2);
        System.out.println(listMock.get(0));    //1
        System.out.println(listMock.size());    //2

        when(listMock.size()).thenReturn(5);
        System.out.println(listMock.size());    //5

        listMock.add(3);
        System.out.println(listMock.size());    //5

        verify(listMock).add(3);
    }


}
