/*
 * Miniprojekti Ohjelmistotuotanto kevät 2015
 * Helsingin yliopisto Tietojenkäsittelytieteen laitos
 * Cyborg Ducks 2015 - GNU General Public License, version 3.
 */
package fi.cyborgducks.biblexrefmanager.data;

import fi.cyborgducks.biblexrefmanager.references.Reference;
import java.util.List;
import org.jbibtex.BibTeXDatabase;

/**
 *
 * @author kristianw
 */
public class InMemoryDatabase implements Database {

    BibTeXDatabase bibTexDatabase;

    public InMemoryDatabase() {
        this.bibTexDatabase = new BibTeXDatabase();
    }

    @Override
    public void saveReference(Reference ref) {
        bibTexDatabase.addObject(ref);
    }

    @Override
    public List<Reference> getAllSavedReferences() {
        return (List<Reference>) (Reference) bibTexDatabase.getObjects();
    }

    @Override
    public void removeReference(Reference ref) {
        bibTexDatabase.removeObject(ref);
    }

}
