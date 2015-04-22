/*
 * Miniprojekti Ohjelmistotuotanto kevät 2015
 * Helsingin yliopisto Tietojenkäsittelytieteen laitos
 * Cyborg Ducks 2015 - GNU General Public License, version 3.
 */
package fi.cyborgducks.biblexrefmanager.references;

import fi.cyborgducks.biblexrefmanager.references.utils.ReferenceUtils;
import org.jbibtex.BibTeXEntry;
import static org.jbibtex.BibTeXEntry.KEY_TITLE;
import org.jbibtex.Key;
import org.jbibtex.StringValue;

/**
 *
 * @author
 */
public class Article extends BibTeXEntry {

    public Article(String key, String author, String title, String journal, String year, String volume) {
        super(BibTeXEntry.TYPE_BOOK, new Key(key));

        addField(BibTeXEntry.KEY_AUTHOR, new StringValue(author, StringValue.Style.BRACED));
        addField(BibTeXEntry.KEY_TITLE, new StringValue(title, StringValue.Style.BRACED));
        addField(BibTeXEntry.KEY_JOURNAL, new StringValue(journal, StringValue.Style.BRACED));
        addField(BibTeXEntry.KEY_YEAR, new StringValue(year, StringValue.Style.BRACED));
        addField(BibTeXEntry.KEY_VOLUME, new StringValue(volume, StringValue.Style.BRACED));

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
     * type |  key |  (author)
     */
    @Override
    public String toString() {
        return super.getType() + " | " + super.getKey() + " (" + super.getField(KEY_TITLE).toUserString() + ")";
    }

}
