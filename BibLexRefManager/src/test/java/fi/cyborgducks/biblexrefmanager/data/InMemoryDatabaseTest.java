/*
 * Miniprojekti Ohjelmistotuotanto kevät 2015
 * Helsingin yliopisto Tietojenkäsittelytieteen laitos
 * Cyborg Ducks 2015 - GNU General Public License, version 3.
 */
package fi.cyborgducks.biblexrefmanager.data;

import fi.cyborgducks.biblexrefmanager.references.Book;
import fi.cyborgducks.biblexrefmanager.references.Reference;
import org.jbibtex.BibTeXEntry;
import org.jbibtex.Key;
import org.jbibtex.StringValue;
import org.jbibtex.Value;
import org.junit.*;
import static org.junit.Assert.assertEquals;

/**
 *
 * @author kristianw
 */
public class InMemoryDatabaseTest {

    Database imd;

    @Before
    public void setUp() {
        imd = new InMemoryDatabase();
    }

    @Test
    public void initiallyDatabaseIsEmpty() {
        assertEquals(true, imd.getAllSavedReferences().isEmpty());
    }

    @Test
    public void addedReferenceIncreasesCountAtDatabase() {
        Reference r = new Book("123", "Samu", "Super book", "Samus publisher", "2015");
        imd.saveReference(r);
        assertEquals(1, imd.getAllSavedReferences().size());
    }

    @Test
    public void twoAddedReferencesIncreasesCountProperly() {
        Reference r = new Book("123", "Samu", "Super book", "Samus publisher", "2015");
        Reference r2 = new Book("321", "Peelo", "Super book", "Peelos publisher", "2012");
        imd.saveReference(r);
        imd.saveReference(r2);
        assertEquals(2, imd.getAllSavedReferences().size());

    }

    @Test
    public void multipleAddedReferencesIncreasesCountProperly() {
        for (int i = 0; i < 5; i++) {
            Reference r = new Book("123" + i, "Samu" + i, "Super Book " + i, "Samus publisher" + i, "2015" + i);
            imd.saveReference(r);
        }
        assertEquals(5, imd.getAllSavedReferences().size());
    }

    @Test
    public void TheReferenceIsValidWhenFetched() {
        Reference r = new Book("123", "Samu", "Super Book", "Samus publisher", "2015");
        imd.saveReference(r);
        Reference fetched = imd.getAllSavedReferences().get(0);
        assertEquals(true, fetched.isComplete());
    }

    @Test
    public void dataOfTheReferenceIsRightAfterFetched() {
        Reference r = new Book("123", "Samu", "Super Book", "Samus publisher", "2015");
        imd.saveReference(r);
        Reference fetched = imd.getAllSavedReferences().get(0);
        assertEquals("Samu", fetched.getField(BibTeXEntry.KEY_AUTHOR).toUserString());
    }

    @Test
    public void referenceCanBeFetchedIfItsSaved() {
        Reference r = new Book("123", "Samu", "Super Book", "Samus publisher", "2015");
        imd.saveReference(r);
        Reference fetched = imd.fetchReference(r.getKey(), r.getType());
        assertEquals("Samu", fetched.getField(BibTeXEntry.KEY_AUTHOR).toUserString());
    }

    @Test
    public void ifReferenceNotFoundItWhileFetchingItReturnsNull() {
        Reference r = imd.fetchReference(BibTeXEntry.TYPE_BOOK, new Key("123"));
        assertEquals(null, r);
    }

    @Test
    public void deleteReducesTheCountByOneInDatabase() {
        Reference r = new Book("123", "Samu", "Super book", "Samus publisher", "2015");
        imd.saveReference(r);
        imd.deleteReference(r.getKey(), r.getType());
        assertEquals(0, imd.getAllSavedReferences().size());
    }

    @Test
    public void deleteRetunsFalseIfDeletingNonExistentReference() {
        assertEquals(false, imd.deleteReference(null, null));
    }

    @Test
    public void referenceCanBeEdited() {
        Reference r = new Book("123", "Samu", "Super book", "Samus publisher", "2015");
        imd.saveReference(r);
        imd.updateReference(r.getKey(), r.getType(), BibTeXEntry.KEY_AUTHOR, new StringValue("Kaapo", StringValue.Style.BRACED));
        Reference fetched = imd.fetchReference(new Key("123"), BibTeXEntry.TYPE_BOOK);
        assertEquals("Kaapo", fetched.getField(BibTeXEntry.KEY_AUTHOR).toUserString());
    }
}
