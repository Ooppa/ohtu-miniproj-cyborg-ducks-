/*
 * Miniprojekti Ohjelmistotuotanto kevät 2015
 * Helsingin yliopisto Tietojenkäsittelytieteen laitos
 * Cyborg Ducks 2015 - GNU General Public License, version 3.
 */
package fi.cyborgducks.biblexrefmanager.data;

import fi.cyborgducks.biblexrefmanager.references.Book;
import fi.cyborgducks.biblexrefmanager.references.Reference;
import org.junit.*;
import static org.junit.Assert.assertEquals;

/**
 *
 * @author kristianw
 */
public class InMemoryDatabaseTest {

    InMemoryDatabase imd = new InMemoryDatabase();

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
    public void dataOfTheReferenceIsRightWhenFetched() {
        Reference r = new Book("123", "Samu", "Super Book", "Samus publisher", "2015");
        imd.saveReference(r);
        Reference fetched = imd.getAllSavedReferences().get(0);
        assertEquals(true, fetched.isComplete());
    }

}
