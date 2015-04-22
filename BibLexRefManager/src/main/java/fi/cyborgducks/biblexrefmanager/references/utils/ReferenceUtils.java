/*
 * Miniprojekti Ohjelmistotuotanto kevät 2015
 * Helsingin yliopisto Tietojenkäsittelytieteen laitos
 * Cyborg Ducks 2015 - GNU General Public License, version 3.
 */
package fi.cyborgducks.biblexrefmanager.references.utils;

import fi.cyborgducks.biblexrefmanager.references.Book;
import java.util.ArrayList;
import org.jbibtex.BibTeXEntry;
import org.jbibtex.Key;

/**
 *
 * @author kride
 */
public class ReferenceUtils {

    public static boolean hasKeySet(BibTeXEntry reference, Key k) {
        return reference.getField(k) != null;
    }

    public static Key[] getOptionalKeysForBook() {
        return new Key[]{
            BibTeXEntry.KEY_VOLUME,
            BibTeXEntry.KEY_SERIES,
            BibTeXEntry.KEY_ADDRESS,
            BibTeXEntry.KEY_EDITION,
            BibTeXEntry.KEY_MONTH,
            BibTeXEntry.KEY_NOTE,
            BibTeXEntry.KEY_KEY
        };
    }

    public static Key[] getRequiredKeysForBook() {
        return new Key[]{
            BibTeXEntry.KEY_AUTHOR,
            BibTeXEntry.KEY_TITLE,
            BibTeXEntry.KEY_PUBLISHER,
            BibTeXEntry.KEY_YEAR
        };
    }

    public static Key[] getRequiredKeysForArticle() {
        return new Key[]{
            BibTeXEntry.KEY_AUTHOR,
            BibTeXEntry.KEY_TITLE,
            BibTeXEntry.KEY_JOURNAL,
            BibTeXEntry.KEY_YEAR,
            BibTeXEntry.KEY_VOLUME

        };

    }

}
