
package fi.cyborgducks.biblexrefmanager.factory;

import fi.cyborgducks.biblexrefmanager.references.*;

public class BookFactory {

    public BookFactory() {
    }
    
    
    public static Book createBook(String[] bookParameters) {
        return new Book(bookParameters[0], 
                        bookParameters[1],
                        bookParameters[2],
                        bookParameters[3],
                        bookParameters[4]);
    }
}
