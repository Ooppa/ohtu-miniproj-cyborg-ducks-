/*
 * Miniprojekti Ohjelmistotuotanto kevät 2015
 * Helsingin yliopisto Tietojenkäsittelytieteen laitos
 * Cyborg Ducks 2015 - GNU General Public License, version 3.
 */
package fi.cyborgducks.biblexrefmanager.data;

import fi.cyborgducks.biblexrefmanager.references.Reference;
import java.util.List;
import org.jbibtex.BibTeXDatabase;
import org.jbibtex.Key;

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

    /**
     * Fetches one Reference from the database
     *
     * @param id - ID of the reference (usually key)
     * @param type - type of the reference
     * @return null - if no match, fetched reference else
     */
    public abstract Reference fetchReference(Key id, Key type);

    public abstract List<Reference> getAllSavedReferences();

    public BibTeXDatabase getDB() {
        return bibTexDatabase;
    }

}
