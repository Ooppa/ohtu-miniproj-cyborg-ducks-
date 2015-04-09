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
 *
 * @author kristianw
 */
public abstract class Database {

    protected BibTeXDatabase bibTexDatabase;

    public Database() {
        this.bibTexDatabase = new BibTeXDatabase();
    }

    public abstract void saveReference(Reference ref);

    public abstract void removeReference(Reference ref);

    public abstract List<Reference> getAllSavedReferences();

    public BibTeXDatabase getDB() {
        return bibTexDatabase;
    }

}
