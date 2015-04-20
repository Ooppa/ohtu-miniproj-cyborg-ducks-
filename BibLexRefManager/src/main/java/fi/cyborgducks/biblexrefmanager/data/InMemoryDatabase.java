/*
 * Miniprojekti Ohjelmistotuotanto kevät 2015
 * Helsingin yliopisto Tietojenkäsittelytieteen laitos
 * Cyborg Ducks 2015 - GNU General Public License, version 3.
 */
package fi.cyborgducks.biblexrefmanager.data;


import java.util.ArrayList;
import java.util.List;
import org.jbibtex.BibTeXEntry;
import org.jbibtex.BibTeXObject;
import org.jbibtex.Key;
import org.jbibtex.Value;

/**
 * Saves directly to formatted database without populating it first.
 *
 * @author kristianw
 */
public class InMemoryDatabase extends Database {

    @Override
    public void saveReference(BibTeXEntry ref) {
        bibTexDatabase.addObject(ref);
    }

    @Override
    public List<BibTeXEntry> getAllSavedReferences() {
        List<BibTeXEntry> refs = new ArrayList<>();
        for (BibTeXObject bo : bibTexDatabase.getObjects()) {
            refs.add((BibTeXEntry) bo);
        }
        return refs;
    }

    @Override
    public BibTeXEntry fetchReference(Key id, Key type) {
        BibTeXEntry fetched = null;
        for (BibTeXEntry r : getAllSavedReferences()) {
            if (r.getType().equals(type)
                    && r.getKey().equals(id)) {
                fetched = r;
                break;
            }
        }
        return fetched;
    }

    @Override
    public boolean deleteReference(Key id, Key type) {
        BibTeXEntry fetched = fetchReference(id, type);
        if (fetched == null) {
            return false;
        }
        bibTexDatabase.removeObject(fetched);
        return true;
    }

    @Override
    public void updateReference(Key id, Key type, Key editKey, Value newInfo) {
        //should also have check for id-key, that can't be edited
        BibTeXEntry fetchedRef = fetchReference(id, type);
        fetchedRef.addField(editKey, newInfo);
    }

}
