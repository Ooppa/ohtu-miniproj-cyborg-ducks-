/*
 * Miniprojekti Ohjelmistotuotanto kevät 2015
 * Helsingin yliopisto Tietojenkäsittelytieteen laitos
 * Cyborg Ducks 2015 - GNU General Public License, version 3.
 */
package fi.cyborgducks.biblexrefmanager.validators;

import fi.cyborgducks.biblexrefmanager.references.Book;
import org.jbibtex.BibTeXEntry;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author kride
 */
public class BookValidatorTest {

    private Validator bookValidator;

    @Before
    public void setUp() {
        bookValidator = new BookValidator();
    }

    @Test
    public void initiallyHasNoErrors() {
        assertEquals(false, bookValidator.hasErrors());
    }

    @Test
    public void notValidIfInvalidKey() {
        bookValidator.isValidParams(new String[]{
            "c",
            "Robert C. Martin",
            "Clean Code: A Handbook of Agile Software Craftsmanship",
            "Prentice Hall",
            "2008"
        });
        assertEquals(true, bookValidator.hasErrors());
    }

    @Test
    public void notValidIfInvalidYear() {
        bookValidator.isValidParams(new String[]{
            "cleancode",
            "Robert C. Martin",
            "Clean Code: A Handbook of Agile Software Craftsmanship",
            "Prentice Hall",
            "asd"
        });
        assertEquals(true, bookValidator.hasErrors());
    }

    @Test
    public void notValidIfInvalidAuthor() {
        bookValidator.isValidParams(new String[]{
            "cleandcode",
            "Robert C. Martinnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnn"
            + "nnnnnMartinnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnn"
            + "nnnnnnnnMartinnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnn"
            + "nnnnnnnnnnMartinnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnn"
            + "nnnnnnnnnnnnnMartinnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnn"
            + "nnnnnnnnnnnnnMartinnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnn"
            + "nnnnnnnnnnnnnnMartinnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnn"
            + "nnnnnnnnnnnnnnnMartinnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnn"
            + "nnnnnnnnnnnnnnnnMartinnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnn"
            + "nnnnnnnnnnnnnnnnnMartinnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnn"
            + "nnnnnnnnnnnnnnnnnMartinnnnnnnnnnnnnnnnnnnnnnnnnnnnnnn"
            + "nnnnnnnnnnnnnnnnnnnMartinnnnnnnnnnnnnnnnnnnnnnnnnnnnn"
            + "nnnnnnnnnnnnnnnnnnnnnMartinnnnnnnnnnnnnnnnnnnnnnnnnnnnn"
            + "nnnnnnnnnnnnnnnnnnnnnMartinnnnnnnnnnnnnnnnnnnnnnnnnnnn"
            + "nnnnnnnnnnnnnnnnnnnnnnMartinnnnnnnnnnnnnnnnnnnnnnnnnnnn"
            + "nnnnnnnnnnnnnnnnnnnnnnMartinnnnnnnnnnnnnnnnnnnnnnnnnn"
            + "nnnnnnnnnnnnnnnnnnnnnnnnMartinnnnnnnnnnnnnnnnnnnnnnnn"
            + "nnnnnnnnnnnnnnnnnnnnnnnnnnMartinnnnnnnnnnnnnnnnnnnnn"
            + "nnnnnnnnnnnnnnnnnnnnnnnnnnnnnMartinnnnnnnnnnnnnnnnnn"
            + "nnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnMartinnnnnnnnnnnnnnnn"
            + "nnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnMartinnnnnnnnnnnnnn"
            + "nnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnMartinnnnnnnnnnnn"
            + "nnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnMartinnnnnnnnnn",
            "Clean Code: A Handbook of Agile Software Craftsmanship",
            "Prentice Hall",
            "2008"
        });
        assertEquals(true, bookValidator.hasErrors());
    }

    @Test
    public void notValidIfInvalidTitle() {
        bookValidator.isValidParams(new String[]{
            "cleancode",
            "Robert C. Martin",
            "e",
            "Prentice Hall",
            "2008"
        });
        assertEquals(true, bookValidator.hasErrors());
    }

    @Test
    public void validBookShouldBeValid() {
        BibTeXEntry e = new Book(
                "abc",
                "Robert",
                "Clean Code",
                "Prentice",
                "2008");

        bookValidator.validateReference(e);
        assertEquals("", bookValidator.fullErrors());
    }

    @Test
    public void notValidIfInvalidPublisher() {
        bookValidator.isValidParams(new String[]{
            "cleancode",
            "Robert C. Martin",
            "Clean Code: A Handbook of Agile Software Craftsmanship",
            "P",
            "2008"
        });
        assertEquals(true, bookValidator.hasErrors());
    }

}
