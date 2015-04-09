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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Reference> getAllSavedReferences() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
