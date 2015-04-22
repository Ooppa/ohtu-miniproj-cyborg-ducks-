package fi.cyborgducks.biblexrefmanager.factory;

import fi.cyborgducks.biblexrefmanager.references.Book;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import org.jbibtex.BibTeXEntry;
import org.jbibtex.Key;
import org.jbibtex.Value;
import org.junit.*;
import static org.junit.Assert.*;

public class BookFactoryTest {

    private ReferenceFactory factory;

    @Before
    public void setUp() {
        factory = new ReferenceFactory();
    }

    @Test
    public void factoryCreatesBook() {
        Book b = factory.createBook(
                new String[]{
                    "keyValue",
                    "authorValue",
                    "titleValue",
                    "publisherValue",
                    "yearValue"
                }
        );

        assertEquals(b.getField(BibTeXEntry.KEY_AUTHOR).toUserString(), "authorValue");
        assertEquals(b.getField(BibTeXEntry.KEY_TITLE).toUserString(), "titleValue");
        assertEquals(b.getField(BibTeXEntry.KEY_PUBLISHER).toUserString(), "publisherValue");
        assertEquals(b.getField(BibTeXEntry.KEY_YEAR).toUserString(), "yearValue");
    }
}
