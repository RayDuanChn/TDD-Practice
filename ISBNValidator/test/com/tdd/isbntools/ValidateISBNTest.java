package com.tdd.isbntools;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author leiduanchn
 * @create 2019-12-04 10:13 p.m.
 */
public class ValidateISBNTest {

    @Test
    public void checkValid10DigitsISBN(){
        //fail();       //always start with red bar
        ValidateISBN validator = new ValidateISBN();
        boolean result = validator.checkISBN("0140449116");
        assertTrue(result, "first value");

        boolean result2 = validator.checkISBN("0140177396");
        assertTrue(result2, "second value");
    }

    @Test
    public void checkValid13DigitsISBN(){
//       fail();
        //write the minimum code to get test to pass
        ValidateISBN validator = new ValidateISBN();
        boolean result = validator.checkISBN("9781853260087");
        assertTrue(result);
    }

    @Test
    public void ISBMNumbersEndingInAnXAreValid(){
        ValidateISBN validator = new ValidateISBN();
        boolean result = validator.checkISBN("012000030X");
        assertTrue(result);
    }

    @Test
    public void checkAnInValid10DigitsISBN(){
        //fail();
        ValidateISBN validator = new ValidateISBN();
        boolean result = validator.checkISBN("0140449117");
        assertFalse(result);
    }

    @Test
    public void checkAnInValid13DigitsISBN(){
        ValidateISBN validator = new ValidateISBN();
        boolean result = validator.checkISBN("9781853260086");
        assertFalse(result);
    }


    //@Test(expected = NumberFormatException.class)         //Junit4 , process exception
    @Test
    public void checkTheLengthOfISBN(){
        ValidateISBN validator = new ValidateISBN();
        assertThrows(NumberFormatException.class, () -> {   //Junit5 , process exception
            validator.checkISBN("123456789");
        });

        assertThrows(NumberFormatException.class, () -> {   //Junit5 , process exception
            validator.checkISBN("12345678900000");
        });
    }

    @Test
    public void nonNumericISBNsAreNotAllowed(){
        ValidateISBN validator = new ValidateISBN();
        assertThrows(NumberFormatException.class, () -> {
            validator.checkISBN("helloworld");
        }, "checkISBNIsNumbers is failed!");
    }

}
