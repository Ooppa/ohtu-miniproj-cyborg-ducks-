/*
 * Miniprojekti Ohjelmistotuotanto kevät 2015
 * Helsingin yliopisto Tietojenkäsittelytieteen laitos
 * Cyborg Ducks 2015 - GNU General Public License, version 3.
 */
package fi.cyborgducks.biblexrefmanager.references;

import static org.jbibtex.BibTeXEntry.KEY_TITLE;
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
public class InproceedingsTest {

    private Inproceedings ins;

    @Before
    public void setUp() {
        ins = new Inproceedings("abc", "kaapo", "aaaa", "kaapos book", "1999");
    }

    @Test
    public void isValidWhenCreatedWithValidParametersInitially() {
        assertTrue(ins.isComplete());
    }

    @Test(expected = IllegalArgumentException.class)
    public void notValidWhenConstructorHasNulls() {
        ins = new Inproceedings(null, "", "aaaa", "kaapos book", "1999");
        assertFalse(ins.isComplete());
    }

    @Test
    public void toStringFormatIsCorrect() {

        String string = "inproceedings" + " | " + "abc" + " (" + "aaaa" + ")";

        assertEquals(string, ins.toString());
    }
}
