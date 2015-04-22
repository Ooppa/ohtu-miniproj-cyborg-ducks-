package fi.cyborgducks.biblexrefmanager.factory;

import fi.cyborgducks.biblexrefmanager.references.*;

public class ReferenceFactory {

    public static Book createBook(String[] bookParameters) {
        return new Book(bookParameters[0],
                bookParameters[1],
                bookParameters[2],
                bookParameters[3],
                bookParameters[4]);
    }

    public static Article createArticle(String[] articleParameters) {
        return new Article(
                articleParameters[0],
                articleParameters[1],
                articleParameters[2],
                articleParameters[3],
                articleParameters[4],
                articleParameters[5]);
    }
}
