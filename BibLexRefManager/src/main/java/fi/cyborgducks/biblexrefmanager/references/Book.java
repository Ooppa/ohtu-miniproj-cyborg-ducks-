/*
 * Miniprojekti Ohjelmistotuotanto kevät 2015
 * Helsingin yliopisto Tietojenkäsittelytieteen laitos
 * Cyborg Ducks 2015 - GNU General Public License, version 3.
 */
package fi.cyborgducks.biblexrefmanager.references;

import org.jbibtex.BibTeXEntry;
import org.jbibtex.Key;
import org.jbibtex.KeyValue;

/**
 * Defines a Book reference
 */
public class Book extends Reference {

    public Book(String key, String author, String publisher, String year) {
        super(BibTeXEntry.TYPE_BOOK, new Key(author));

        addField(BibTeXEntry.KEY_AUTHOR, new KeyValue(key));
        addField(BibTeXEntry.KEY_TITLE, new KeyValue(author));
        addField(BibTeXEntry.KEY_PUBLISHER, new KeyValue(publisher));
        addField(BibTeXEntry.KEY_YEAR, new KeyValue(year));

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
