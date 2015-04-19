/*
 * Miniprojekti Ohjelmistotuotanto kevät 2015
 * Helsingin yliopisto Tietojenkäsittelytieteen laitos
 * Cyborg Ducks 2015 - GNU General Public License, version 3.
 */
package fi.cyborgducks.biblexrefmanager.data;

import fi.cyborgducks.biblexrefmanager.references.Reference;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.jbibtex.BibTeXObject;
import org.jbibtex.Key;
import org.jbibtex.Value;

/**
 * Saves directly to formatted database without populating it first.
 *
 * @author kristianw
 */
public class InMemoryDatabase extends Database implements Serializable {

    @Override
    public void saveReference(Reference ref) {
        bibTexDatabase.addObject(ref);
    }

    @Override
    public List<Reference> getAllSavedReferences() {
        List<Reference> refs = new ArrayList<>();
        for (BibTeXObject bo : bibTexDatabase.getObjects()) {
            refs.add((Reference) bo);
        }
        return refs;
    }

    @Override
    public Reference fetchReference(Key id, Key type) {
        Reference fetched = null;
        for (Reference r : getAllSavedReferences()) {
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
        Reference fetched = fetchReference(id, type);
        if (fetched == null) {
            return false;
        }
        bibTexDatabase.removeObject(fetched);
        return true;
    }

    @Override
    public void updateReference(Key id, Key type, Key editKey, Value newInfo) {
        //should also have check for id-key, that can't be edited
        Reference fetchedRef = fetchReference(id, type);
        fetchedRef.addField(editKey, newInfo);
    }

}
