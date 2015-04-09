/*
 * Miniprojekti Ohjelmistotuotanto kevät 2015
 * Helsingin yliopisto Tietojenkäsittelytieteen laitos
 * Cyborg Ducks 2015 - GNU General Public License, version 3.
 */
package fi.cyborgducks.biblexrefmanager.data;

import fi.cyborgducks.biblexrefmanager.references.Reference;
import java.util.List;

/**
 *
 * @author kristianw
 */
public interface Database {

    public void saveReference(Reference ref);
    public List<Reference> getAllSavedReferences();

}
