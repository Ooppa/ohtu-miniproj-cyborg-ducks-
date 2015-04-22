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
 *
 * @author Ooppa
 */
public class Inproceedings extends BibTeXEntry  {

    public Inproceedings(String key, String title, String bookTitle, String year) {
        super(BibTeXEntry.TYPE_INPROCEEDINGS, new Key(key));

        addField(BibTeXEntry.KEY_TITLE, new StringValue(title, StringValue.Style.BRACED));
        addField(BibTeXEntry.KEY_BOOKTITLE, new StringValue(bookTitle, StringValue.Style.BRACED));
        addField(BibTeXEntry.KEY_YEAR,new DigitStringValue(year));

    }

    boolean isComplete() {

        Key[] req = ReferenceUtils.getRequiredKeysForArticle();

        for (int i = 0; i < req.length; i++) {
            if (getField(req[i]) == null) {
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
