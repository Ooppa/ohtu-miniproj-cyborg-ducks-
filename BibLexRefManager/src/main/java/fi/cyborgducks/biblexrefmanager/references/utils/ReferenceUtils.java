/*
 * Miniprojekti Ohjelmistotuotanto kevät 2015
 * Helsingin yliopisto Tietojenkäsittelytieteen laitos
 * Cyborg Ducks 2015 - GNU General Public License, version 3.
 */
package fi.cyborgducks.biblexrefmanager.references.utils;

import org.jbibtex.BibTeXEntry;
import org.jbibtex.Key;

/**
 *
 * @author kride
 */
public class ReferenceUtils {
    
    public static boolean hasKeySet(BibTeXEntry reference, Key k){
        return reference.getField(k) != null;
    }
    
    
}
