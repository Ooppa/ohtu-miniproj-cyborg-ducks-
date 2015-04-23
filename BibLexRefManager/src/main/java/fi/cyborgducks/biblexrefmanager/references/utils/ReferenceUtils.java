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

    public static Key[] getRequiredKeysForInProceedings() {
        return new Key[]{
            BibTeXEntry.KEY_AUTHOR,
            BibTeXEntry.KEY_TITLE,
            BibTeXEntry.KEY_BOOKTITLE,
            BibTeXEntry.KEY_YEAR
        };

    }

    /**
     * Returns the matching Key for component name 
     */
    public static Key resolveKey(String componentName) {
        String lastPart = componentName.replaceAll("jTextField", "");

        if (lastPart.length() >= componentName.length()) { // must be comboBox
            lastPart = componentName.replaceAll("jCombo", "");
        }

        Key key = null;

        switch (lastPart) {

            case "Title":
                key = BibTeXEntry.KEY_TITLE;
                break;
            case "Author":
                key = BibTeXEntry.KEY_AUTHOR;
                break;
            case "BookTitle":
                key = BibTeXEntry.KEY_BOOKTITLE;
                break;
            case "Year":
                key = BibTeXEntry.KEY_YEAR;
                break;
            case "Volume":
                key = BibTeXEntry.KEY_VOLUME;
                break;
            case "Number":
                key = BibTeXEntry.KEY_NUMBER;
                break;
            case "Pages":
                key = BibTeXEntry.KEY_PAGES;
                break;
            case "Note":
                key = BibTeXEntry.KEY_NOTE;
                break;
            case "Month":
                key = BibTeXEntry.KEY_MONTH;
                break;
            case "Series":
                key = BibTeXEntry.KEY_SERIES;
                break;
            case "Address":
                key = BibTeXEntry.KEY_ADDRESS;
                break;
            case "Organization":
                key = BibTeXEntry.KEY_ORGANIZATION;
                break;
            case "Publisher":
                key = BibTeXEntry.KEY_PUBLISHER;
                break;
            case "Editor":
                key = BibTeXEntry.KEY_EDITOR;
                break;
            case "Edition":
                key = BibTeXEntry.KEY_EDITION;
                break;
            case "Journal":
                key = BibTeXEntry.KEY_JOURNAL;
                break;

        }

        return key;
    }

}
