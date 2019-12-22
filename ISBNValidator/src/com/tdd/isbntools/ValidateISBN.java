package com.tdd.isbntools;

/**
 * @author leiduanchn
 * @create 2019-12-04 10:40 p.m.
 */
public class ValidateISBN {

    private static final int LONG_ISBN_LENGTH = 13;
    private static final int SHORT_ISBN_LENGTH = 10;
    private static final int SHORT_ISBN_MULTIPLIER = 11;
    private static final int LONG_ISBN_MULTIPLIER = 10;

    public boolean checkISBN(String isbn) {

        if (isbn.length() == LONG_ISBN_LENGTH) {
            return isThisAValidLongISBN(isbn);
        } else if (isbn.length() == SHORT_ISBN_LENGTH) {
            return isThisAValidShortISBN(isbn);
        }

        throw new NumberFormatException("isbn number must 10 or 13 digits long");
    }

    private boolean isThisAValidShortISBN(String isbn) {
        int total = 0;
        //Pattern pattern = Pattern.compile("[0-9]*");
        //if(!pattern.matcher(isbn).matches()) throw  new NumberFormatException("isbn number can only contain numeric digits");

        for (int i = 0; i < SHORT_ISBN_LENGTH; i++) {
            if (!Character.isDigit(isbn.charAt(i))) {
                if (i == 9 && isbn.charAt(i) == 'X') {
                    total += 10;
                } else {
                    throw new NumberFormatException();
                }
            }

            total += Character.getNumericValue(isbn.charAt(i)) * (SHORT_ISBN_LENGTH - i);
        }

        return total % SHORT_ISBN_MULTIPLIER == 0;
    }

    private boolean isThisAValidLongISBN(String isbn) {
        int total = 0;
        for (int i = 0; i < LONG_ISBN_LENGTH; i++) {
            if (i % 2 == 0) {
                total += Character.getNumericValue(isbn.charAt(i));
            } else {
                total += Character.getNumericValue(isbn.charAt(i)) * 3;
            }
        }

        return  total % LONG_ISBN_MULTIPLIER == 0;
    }
}
