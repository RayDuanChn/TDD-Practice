package com.tdd.isbntools;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.*;

/**
 * @author leiduanchn
 * @create 2019-12-08 8:25 p.m.
 */
public class StoreManagementTest {

    private ExternalISBNDataService databaseService;
    private ExternalISBNDataService webService;
    private StoreManagement sm;

    @BeforeEach
    public void setup(){
        databaseService = mock(ExternalISBNDataService.class);
        webService = mock(ExternalISBNDataService.class);
        sm = new StoreManagement(databaseService, webService);
    }

    //Stub
    @Test
    public void testGetLocatorCode(){

        //Stub
        String isbn = "0140177396";
        when(databaseService.lookup(isbn)).thenReturn(null);
        when(webService.lookup(isbn)).thenReturn(new Book("0140177396", "J.steinbeck", "Of Mick And Men"));
        String locatorCode = sm.getLocatorCode("0140177396");
        assertEquals("7396J4", locatorCode);

    }

    @Test
    public void testDatabaseIsUsedIfDataPresent(){

        String isbn = "0140177396";
        //Mock
        when(databaseService.lookup(isbn)).thenReturn(new Book("0140177396", "J.steinbeck", "Of Mick And Men"));

        String locatorCode = sm.getLocatorCode("0140177396");

        verify(databaseService, times(1)).lookup(isbn);
        verify(webService, never()).lookup(isbn);

    }

    @Test
    public void testWebServerIsUsedIfDataIsNotPresentInDatabase(){
        String isbn = "0140177396";
        when(databaseService.lookup(anyString())).thenReturn(null);
        when(webService.lookup(isbn)).thenReturn(new Book("0140177396", "J.steinbeck", "Of Mick And Men"));

        String locatorCode = sm.getLocatorCode("0140177396");

        verify(databaseService, times(1)).lookup(isbn);
        verify(webService, times(1)).lookup(anyString());
    }
}
