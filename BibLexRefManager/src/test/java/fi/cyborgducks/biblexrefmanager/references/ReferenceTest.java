/*
 * Miniprojekti Ohjelmistotuotanto kevät 2015
 * Helsingin yliopisto Tietojenkäsittelytieteen laitos
 * Cyborg Ducks 2015 - GNU General Public License, version 3.
 */
package fi.cyborgducks.biblexrefmanager.references;

import org.jbibtex.BibTeXEntry;
import org.jbibtex.Key;
import org.jbibtex.KeyValue;
import org.junit.*;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 *
 * @author Ooppa
 */
public class ReferenceTest {

    private GenericReferenceImpl genericTestReference;

    public ReferenceTest() {
    }

    @Before
    public void setUp() {
        genericTestReference = new GenericReferenceImpl("Teemo", "How to Scout");
    }

    @After
    public void tearDown() {
        genericTestReference = null;
    }

    @Test
    public void testAddField() {
        KeyValue value = new KeyValue("Generic Note");
        genericTestReference.addField(BibTeXEntry.KEY_NOTE, value);

        assertTrue(genericTestReference.getField(BibTeXEntry.KEY_NOTE).equals(value));
    }

    @Test
    public void testAddFieldWithWrongKey() {
        KeyValue value = new KeyValue("Generic Chapter");
        genericTestReference.addField(BibTeXEntry.KEY_CHAPTER, value);

        assertTrue(genericTestReference.getField(BibTeXEntry.KEY_NOTE)==null);
    }

    @Test
    public void testFieldIsCompleteAfterCreation() {
        assertTrue(genericTestReference.isComplete());
    }

    @Test
    public void testIsCompleteWhenContainsOptionalFields() {
        KeyValue value = new KeyValue("Generic Note");
        genericTestReference.addField(BibTeXEntry.KEY_NOTE, value);

        assertTrue(genericTestReference.isComplete());
    }

    @Test
    public void testIsNotComplete() {
        genericTestReference.setRequiredFields(
                new Key[] {
                    BibTeXEntry.KEY_AUTHOR,
                    BibTeXEntry.KEY_TITLE,
                    BibTeXEntry.KEY_YEAR
                }
        );

        assertFalse(genericTestReference.isComplete());
    }

    /*
     * Creates a generic Reference implementation that we can test.
     */
    public class GenericReferenceImpl extends Reference {

        public GenericReferenceImpl(String author, String title) {
            super(BibTeXEntry.TYPE_MISC, new Key("Generic Reference"));
            setRequiredFields(new Key[] {BibTeXEntry.KEY_AUTHOR, BibTeXEntry.KEY_TITLE});
            setOptionalFields(new Key[] {BibTeXEntry.KEY_NOTE, BibTeXEntry.KEY_KEY});

            addField(BibTeXEntry.KEY_AUTHOR, new KeyValue(author));
            addField(BibTeXEntry.KEY_TITLE, new KeyValue(title));
        }
    }

}
