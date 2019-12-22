package com.leiduanchn.unittesting.springbootunittesting.business;

import com.leiduanchn.unittesting.springbootunittesting.repository.SomeDataService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

/**
 * @author leiduanchn
 * @create 2019-12-18 1:04 p.m.
 */

/*
    https://github.com/mockito/mockito/wiki/FAQ
    Mockito 2.x specific limitations
        Requires Java 6+
        Cannot mock static methods
        Cannot mock constructors
        Cannot mock equals(), hashCode(). Firstly, you should not mock those methods. Secondly, Mockito defines and depends upon a specific implementation of these methods. Redefining them might break Mockito.
        Mocking is only possible on VMs that are supported by Objenesis. Don't worry, most VMs should work just fine.
        Spying on real methods where real implementation references outer Class via OuterClass.this is impossible. Don't worry, this is extremely rare case.

        Mocking Static, Private Methods and Constructors
        https://github.com/in28minutes/MockitoTutorialForBeginners/blob/master/Step15.md
        https://github.com/in28minutes/MockitoTutorialForBeginners/tree/master/src/test/java/com/in28minutes/powermock
 */

//@ExtendWith(MockitoExtension.class) 是Junit5，  @runwith(mockitojunitrunner.class)是Junit4，
//作用是注解进行mocks的初始化和注入，也可以在@Before 注解的方法中使用Mockito.initMocks(this)初始化。
@ExtendWith(MockitoExtension.class)
@DisplayName("Spring boot 2 mockito2 Junit5 example")
public class SomeBusinessImplMockTest {

    //@Mock创建一个Mock，此mock将被注入到 SomeBusinessImpl
    @Mock
    private SomeDataService dataServiceMock;

    //@InjectMocks 创建一个实例，其余用@Mock注解创建的mock将被自动注入到用该实例中。
    //mockit可以自动注入包含@Autowire, @Resource等注解的对象
    //但是mockit创建mock对象不能对final，Anonymous ，primitive类进行mock。
    @InjectMocks
    private SomeBusinessImpl business;

    @BeforeEach
    public void setup(){
        //initMocks(this);          //进行mocks的初始化和注入
        business.setSomeDataService(dataServiceMock);
    }

    @Test
    void calculateSumUsingDataService(){

        when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {1, 2, 3, 5});
        assertEquals(11, business.calculateSumUsingDataService());
    }


    @Test
    void calculateSum_empty() {
        when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {});
        assertEquals(0, business.calculateSumUsingDataService());

    }

    @Test
    void calculateSum_oneValue() {
        when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {3});
        assertEquals(3, business.calculateSumUsingDataService());
    }
}
