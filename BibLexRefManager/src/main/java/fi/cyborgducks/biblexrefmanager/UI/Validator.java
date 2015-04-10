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
import org.jbibtex.Key;

public class Validator {

    /**
     * @param fields - key, author, title, publisher, year
     * @return a empty string if book has valid constructor parameters
     */
    public static String isValidBookParams(String[] fields) {

        String key = fields[0];
        String author = fields[1];
        String title = fields[2];
        String publisher = fields[3];
        int year = 0;
        try {
            year = Integer.parseInt(fields[4]);
        } catch (Exception ex) {
            return ex.getMessage();
        }

        if (key.length() <= 2 || key.length() >= 15) {
            return "Key length is wrong! Should be more than 2 and less than 16";
        }

        if (author.length() < 2 || author.length() > 20) {
            return "Author name should be more than 2 and less than 20";
        }

        if (title.length() < 2 || title.length() > 20) {
            return "Title lenght should be more than 2 and less than 20";
        }

        if (publisher.length() < 2 || publisher.length() > 20) {
            return "Publisher should be more than 2 and less than 20";
        }

        if (year < 1000 || year > Calendar.getInstance().get(Calendar.YEAR)) {
            return "Year should be more than 1000 and less or equal than current year";
        }

        return "";
    }

    /**
     * Empty if key was found
     */
    public static String isValidOptionalFieldForBook(String key) {
        if (key == null || key.isEmpty()) {
            return "";
        }
        Book stub = new Book("", "", "", "", "");
        Key[] Optionals = stub.getOptionalFields();

        for (Key k : Optionals) {
            if (k.getValue().equals(key)) {
                return "";
            }
        }

        return key + " was not a correct key for Book reference";
    }

}
