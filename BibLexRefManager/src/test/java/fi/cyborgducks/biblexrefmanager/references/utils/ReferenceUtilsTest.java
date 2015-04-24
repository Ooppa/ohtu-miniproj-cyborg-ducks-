/*
 * Miniprojekti Ohjelmistotuotanto kevät 2015
 * Helsingin yliopisto Tietojenkäsittelytieteen laitos
 * Cyborg Ducks 2015 - GNU General Public License, version 3.
 */
package fi.cyborgducks.biblexrefmanager.references.utils;

import fi.cyborgducks.biblexrefmanager.references.Article;
import org.jbibtex.BibTeXEntry;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author kristianw
 */
public class ReferenceUtilsTest {

    private String stub;

    @Before
    public void setUp() {
        stub = "jTextField";
    }

    @Test
    public void keySetFunctionReturnsCorrectIfKeyHasBeenSet() {
        Article a = new Article("abc", "kaapo", "aaaa", "kaapos book", "1999", "5");

        assertTrue(ReferenceUtils.hasKeySet(a, BibTeXEntry.KEY_TITLE));
    }

    @Test
    public void returnsRightComponentTitle() {
        stub += "Title";
        assertEquals(BibTeXEntry.KEY_TITLE, ReferenceUtils.resolveKey(stub));
    }

    @Test
    public void returnsRightComponentAddress() {
        stub += "Address";
        assertEquals(BibTeXEntry.KEY_ADDRESS, ReferenceUtils.resolveKey(stub));
    }

    @Test
    public void returnsRightComponentYear() {
        stub += "Year";
        assertEquals(BibTeXEntry.KEY_YEAR, ReferenceUtils.resolveKey(stub));
    }

    @Test
    public void returnsRightComponentJournal() {
        stub += "Journal";
        assertEquals(BibTeXEntry.KEY_JOURNAL, ReferenceUtils.resolveKey(stub));
    }
    @Test
    public void returnsRightComponentBookTitle() {
        stub += "BookTitle";
        assertEquals(BibTeXEntry.KEY_BOOKTITLE, ReferenceUtils.resolveKey(stub));
    }
    @Test
    public void returnsRightComponentVolume() {
        stub += "Volume";
        assertEquals(BibTeXEntry.KEY_VOLUME, ReferenceUtils.resolveKey(stub));
    }
    @Test
    public void returnsRightComponentNumber() {
        stub += "Number";
        assertEquals(BibTeXEntry.KEY_NUMBER, ReferenceUtils.resolveKey(stub));
    }
    @Test
    public void returnsRightComponentPages() {
        stub += "Pages";
        assertEquals(BibTeXEntry.KEY_PAGES, ReferenceUtils.resolveKey(stub));
    }
    @Test
    public void returnsRightComponentNote() {
        stub += "Note";
        assertEquals(BibTeXEntry.KEY_NOTE, ReferenceUtils.resolveKey(stub));
    }
    @Test
    public void returnsRightComponentMonth() {
        stub += "Month";
        assertEquals(BibTeXEntry.KEY_MONTH, ReferenceUtils.resolveKey(stub));
    }
    @Test
    public void returnsRightComponentSeries() {
        stub += "Series";
        assertEquals(BibTeXEntry.KEY_SERIES, ReferenceUtils.resolveKey(stub));
    }
    @Test
    public void returnsRightComponentOrganization() {
        stub += "Organization";
        assertEquals(BibTeXEntry.KEY_ORGANIZATION, ReferenceUtils.resolveKey(stub));
    }
    @Test
    public void returnsRightComponentPublisher() {
        stub += "Publisher";
        assertEquals(BibTeXEntry.KEY_PUBLISHER, ReferenceUtils.resolveKey(stub));
    }
    @Test
    public void returnsRightComponentEditor() {
        stub += "Editor";
        assertEquals(BibTeXEntry.KEY_EDITOR, ReferenceUtils.resolveKey(stub));
    }
    @Test
    public void returnsRightComponentEdition() {
        stub += "Edition";
        assertEquals(BibTeXEntry.KEY_EDITION, ReferenceUtils.resolveKey(stub));
    }

}
