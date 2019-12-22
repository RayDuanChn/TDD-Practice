package com.tdd.isbntools;

/**
 * @author leiduanchn
 * @create 2019-12-08 9:42 p.m.
 */
public class StoreManagement {

    private ExternalISBNDataService databaseService;

    private ExternalISBNDataService webService;

    public StoreManagement(ExternalISBNDataService databaseService, ExternalISBNDataService webService) {
        this.databaseService = databaseService;
        this.webService = webService;
    }

    public String getLocatorCode(String isbn) {

        Book book = databaseService.lookup(isbn);
        if (book == null) {
           book = webService.lookup(isbn);
        }
        StringBuilder locatorCode = new StringBuilder();
        locatorCode.append(book.getIsbn().substring(book.getIsbn().length() - 4));
        locatorCode.append(book.getAuthor().substring(0, 1));
        locatorCode.append(book.getTitle().split(" ").length);
        return locatorCode.toString();
    }

    public void setDatabaseService(ExternalISBNDataService databaseService) {
        this.databaseService = databaseService;
    }

    public void setWebService(ExternalISBNDataService webService) {
        this.webService = webService;
    }
}
