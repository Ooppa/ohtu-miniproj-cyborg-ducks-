/*
 * Miniprojekti Ohjelmistotuotanto kevät 2015
 * Helsingin yliopisto Tietojenkäsittelytieteen laitos
 * Cyborg Ducks 2015 - GNU General Public License, version 3.
 */
package fi.cyborgducks.biblexrefmanager.references;

import org.jbibtex.*;
import org.jbibtex.StringValue.Style;

/**
 * Defines a Book reference
 */
public class Book extends Reference {

    /**
     * Creates a new Book Reference
     *
     * @param key       Key to identify the reference by
     * @param author    Author of the Book
     * @param title     Title of the Book
     * @param publisher Publisher of the Book
     * @param year      Publishing year of the Book
     */
    public Book(String key, String author, String title, String publisher, String year) {
        super(BibTeXEntry.TYPE_BOOK, new Key(key));

        setRequiredAndOptionalFields();

        addField(BibTeXEntry.KEY_AUTHOR, new StringValue(author, Style.BRACED));
        addField(BibTeXEntry.KEY_TITLE, new StringValue(title, Style.BRACED));
        addField(BibTeXEntry.KEY_PUBLISHER, new StringValue(publisher, Style.BRACED));
        addField(BibTeXEntry.KEY_YEAR, new DigitStringValue(year));
    }

    private void setRequiredAndOptionalFields() {
        setRequiredFields(new Key[] {
            BibTeXEntry.KEY_AUTHOR,
            BibTeXEntry.KEY_TITLE,
            BibTeXEntry.KEY_PUBLISHER,
            BibTeXEntry.KEY_YEAR
        });

        setOptionalFields(new Key[] {
            BibTeXEntry.KEY_VOLUME,
            BibTeXEntry.KEY_SERIES,
            BibTeXEntry.KEY_ADDRESS,
            BibTeXEntry.KEY_EDITION,
            BibTeXEntry.KEY_MONTH,
            BibTeXEntry.KEY_NOTE,
            BibTeXEntry.KEY_KEY
        });
    }

}
