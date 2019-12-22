package com.tdd.isbntools;

/**
 * @author leiduanchn
 * @create 2019-12-08 10:06 p.m.
 */
public interface ExternalISBNDataService {

    Book lookup(String sbn);
}
