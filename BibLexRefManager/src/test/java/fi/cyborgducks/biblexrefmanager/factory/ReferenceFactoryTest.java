package fi.cyborgducks.biblexrefmanager.factory;

import fi.cyborgducks.biblexrefmanager.references.Article;
import fi.cyborgducks.biblexrefmanager.references.Book;
import fi.cyborgducks.biblexrefmanager.references.Inproceedings;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import org.jbibtex.BibTeXEntry;
import org.jbibtex.Key;
import org.jbibtex.Value;
import org.junit.*;
import static org.junit.Assert.*;

public class ReferenceFactoryTest {

    @Test
    public void factoryCreatesBook() {
        Book b = ReferenceFactory.createBook(
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

    @Test
    public void factoryCreatesArticle() {
        Article a = ReferenceFactory.createArticle(
                new String[]{
                    "key",
                    "author",
                    "title",
                    "journal",
                    "1999",
                    "5"
                }
        );

        assertTrue(a != null);
    }

    @Test
    public void factoryCreatesInproceedings() {
        Inproceedings i = ReferenceFactory.createInproceedings(
                new String[]{
                    "key",
                    "author",
                    "title",
                    "bookTitle",
                    "1999"
                }
        );

        assertTrue(i != null);
    }

    @Test(expected = IllegalStateException.class)
    public void factoryThrowsErrorOnBookIfTooFewParams() {
        ReferenceFactory.createBook(new String[]{});
    }

    @Test(expected = IllegalStateException.class)
    public void factoryThrowsErrorOnArticleIfTooFewParams() {
        ReferenceFactory.createArticle(new String[]{});
    }

    @Test(expected = IllegalStateException.class)
    public void factoryThrowsErrorOnInproceedingsIfTooFewParams() {
        ReferenceFactory.createInproceedings(new String[]{});
    }

}
