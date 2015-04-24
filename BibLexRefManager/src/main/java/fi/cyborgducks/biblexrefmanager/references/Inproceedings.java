/*
 * Miniprojekti Ohjelmistotuotanto kevät 2015
 * Helsingin yliopisto Tietojenkäsittelytieteen laitos
 * Cyborg Ducks 2015 - GNU General Public License, version 3.
 */
package fi.cyborgducks.biblexrefmanager.references;

import fi.cyborgducks.biblexrefmanager.references.utils.ReferenceUtils;
import org.jbibtex.BibTeXEntry;
import static org.jbibtex.BibTeXEntry.KEY_TITLE;
import org.jbibtex.DigitStringValue;
import org.jbibtex.Key;
import org.jbibtex.StringValue;

/**
 * Defines an Inproceedings reference.
 */
public class Inproceedings extends BibTeXEntry {

    /**
     * Creates a new Inproceedings object.
     *
     * @param key Key to identify the reference by
     * @param author Author of the inproceedings
     * @param title Title of the Inproceedings
     * @param bookTitle Book title of the Inproceedings
     * @param year Year of the Inproceedings
     */
    public Inproceedings(String key, String author, String title, String bookTitle, String year) {
        super(BibTeXEntry.TYPE_INPROCEEDINGS, new Key(key));

        addField(BibTeXEntry.KEY_AUTHOR, new StringValue(author, StringValue.Style.BRACED));
        addField(BibTeXEntry.KEY_TITLE, new StringValue(title, StringValue.Style.BRACED));
        addField(BibTeXEntry.KEY_BOOKTITLE, new StringValue(bookTitle, StringValue.Style.BRACED));
        addField(BibTeXEntry.KEY_YEAR, new DigitStringValue(year));

    }

    /**
     * Returns the status of the Inproceedings.
     *
     * @return true if complete, false if not
     */
    public boolean isComplete() {
        Key[] req = ReferenceUtils.getRequiredKeysForInProceedings();

        if (this.getKey() == null) {
            return false;
        }

        for (int i = 0; i < req.length; i++) {
            if (this.getField(req[i]) == null || getField(req[i]).toUserString().isEmpty()) {
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
        return super.getType() + " | " + super.getKey() + " (" + super.getField(KEY_TITLE).toUserString() + ")";
    }

}
