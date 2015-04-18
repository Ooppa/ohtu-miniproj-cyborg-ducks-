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
import org.jbibtex.Value;

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
     * Updates the wanted reference with the given data
     *
     * @param id id of the wanted reference
     * @param type type of the wanted reference
     * @param editKey Key of the wanted field to be edited
     * @param newInfo New value for the field
     */
    public abstract void updateReference(Key id, Key type, Key editKey, Value newInfo);

    public abstract boolean deleteReference(Key id, Key type);

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

    public void setDB(BibTeXDatabase db) {
        this.bibTexDatabase = db;
    }

}
