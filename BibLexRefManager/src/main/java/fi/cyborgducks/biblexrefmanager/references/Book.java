/*
 * Miniprojekti Ohjelmistotuotanto kevät 2015
 * Helsingin yliopisto Tietojenkäsittelytieteen laitos
 * Cyborg Ducks 2015 - GNU General Public License, version 3.
 */
package fi.cyborgducks.biblexrefmanager.references;

import fi.cyborgducks.biblexrefmanager.references.utils.ReferenceUtils;
import org.jbibtex.*;
import org.jbibtex.StringValue.Style;

/**
 * Defines a Book reference.
 */
public class Book extends BibTeXEntry {

    /**
     * Creates a new Book BibTeXEntry
     *
     * @param key       Key to identify the reference by
     * @param author    Author of the Book
     * @param title     Title of the Book
     * @param publisher Publisher of the Book
     * @param year      Publishing year of the Book
     */
    public Book(String key, String author, String title, String publisher, String year) {
        super(BibTeXEntry.TYPE_BOOK, new Key(key));

        addField(BibTeXEntry.KEY_AUTHOR, new StringValue(author, Style.BRACED));
        addField(BibTeXEntry.KEY_TITLE, new StringValue(title, Style.BRACED));
        addField(BibTeXEntry.KEY_PUBLISHER, new StringValue(publisher, Style.BRACED));
        addField(BibTeXEntry.KEY_YEAR, new DigitStringValue(year));
    }

    /**
     * Returns the status of the Book.
     *
     * @return true if complete, false if not
     */
    public boolean isComplete() {
        Key[] req = ReferenceUtils.getRequiredKeysForBook();

        for(int i = 0; i<req.length; i++) {
            if(getField(req[i])==null) {
                return false;
            }
        }

        return true;
    }

    /**
     * type |  key |  (title)
     */
    @Override
    public String toString() {
        return super.getType()+" | "+super.getKey()+" ("+super.getField(KEY_TITLE).toUserString()+")";
    }

}
