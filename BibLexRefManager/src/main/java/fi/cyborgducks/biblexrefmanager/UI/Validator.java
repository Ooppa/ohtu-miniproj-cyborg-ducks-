/*
 * Miniprojekti Ohjelmistotuotanto kevät 2015
 * Helsingin yliopisto Tietojenkäsittelytieteen laitos
 * Cyborg Ducks 2015 - GNU General Public License, version 3.
 */
package fi.cyborgducks.biblexrefmanager.UI;

import fi.cyborgducks.biblexrefmanager.references.Book;
import fi.cyborgducks.biblexrefmanager.references.Reference;
import java.util.Calendar;
import java.util.Date;

public class Validator {

    /**
     * @param fields - key, author, title, publisher, year
     * @return true if book has valid constructor params
     */
    public static boolean isValidBookParams(String[] fields) {

        String key = fields[0];
        String author = fields[1];
        String title = fields[2];
        String publisher = fields[3];
        int year = Integer.parseInt(fields[4]);

        if (key.length() > 15) {
            return false;
        }

        if (author.length() < 2 || author.length() > 20) {
            return false;
        }

        if (title.length() < 2 || title.length() > 20) {
            return false;
        }

        if (publisher.length() < 2 || publisher.length() > 20) {
            return false;
        }

        if (year < 1000 || year > Calendar.getInstance().get(Calendar.YEAR)) {
            return false;
        }

        return true;
    }

}
