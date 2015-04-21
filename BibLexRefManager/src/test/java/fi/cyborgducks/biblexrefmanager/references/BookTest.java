/*
 * Miniprojekti Ohjelmistotuotanto kevät 2015
 * Helsingin yliopisto Tietojenkäsittelytieteen laitos
 * Cyborg Ducks 2015 - GNU General Public License, version 3.
 */
package fi.cyborgducks.biblexrefmanager.references;

import org.jbibtex.BibTeXEntry;
import org.jbibtex.KeyValue;
import org.junit.*;
import static org.junit.Assert.assertTrue;

/**
 *
 * @author Ooppa
 */

public class BookTest {

    private Book book;

    public BookTest() {
    }

    @Before
    public void setUp() {
        book = new Book(
                "cleancode",
                "Robert C. Martin",
                "Clean Code: A Handbook of Agile Software Craftsmanship",
                "Prentice Hall",
                "2008");
    }

    @After
    public void tearDown() {
        book = null;
    }

    @Test

    public void testAbleToAddOptionalField() {
        KeyValue value = new KeyValue("First Edition");
        book.addField(BibTeXEntry.KEY_EDITION, value);

        assertTrue(book.getField(BibTeXEntry.KEY_EDITION).equals(value));
    }

    @Test
    public void testNotAbleToAddWrongField() {
       //book.addField(BibTeXEntry.KEY_HOWPUBLISHED, new KeyValue("Not like this!"));

       // assertTrue(book.getField(BibTeXEntry.KEY_HOWPUBLISHED) == null);
    }

}
