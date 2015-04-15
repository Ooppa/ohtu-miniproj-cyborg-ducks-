/*
 * Miniprojekti Ohjelmistotuotanto kevät 2015
 * Helsingin yliopisto Tietojenkäsittelytieteen laitos
 * Cyborg Ducks 2015 - GNU General Public License, version 3.
 */
package fi.cyborgducks.biblexrefmanager.validators;

import fi.cyborgducks.biblexrefmanager.references.Book;
import fi.cyborgducks.biblexrefmanager.references.Reference;
import java.util.Calendar;
import org.jbibtex.Key;

/**
 *
 * @author kride
 */
public class BookValidator extends Validator {

    @Override
    public void isValidOptionalFieldFor(String key) {
        if (key == null || key.isEmpty()) {
            return;
        }
        key = key.toLowerCase();
        Book stub = new Book("", "", "", "", "");
        Key[] Optionals = stub.getOptionalFields();

        for (Key k : Optionals) {
            if (k.getValue().equals(key)) {
                return;
            }
        }
        super.addError(key + " was not a correct key for Book reference");
    }

    /**
     * @param fields - key, author, title, publisher, year
     */
    @Override
    public void isValidParams(String[] fields) {
        String key = fields[0];
        String author = fields[1];
        String title = fields[2];
        String publisher = fields[3];
        int year = 0;
        try {
            year = Integer.parseInt(fields[4]);
        } catch (Exception ex) {
            super.addError("Unable to find correct year");
        }

        if (key.length() <= 2 || key.length() >= 15) {
            super.addError("Key length is wrong! Should be more than 2 and less than 16");
        }

        if (author.length() < 2 || author.length() > 20) {
            super.addError("Author name should be more than 2 and less than 20");
        }

        if (title.length() < 2 || title.length() > 20) {
            super.addError("Title lenght should be more than 2 and less than 20");
        }

        if (publisher.length() < 2 || publisher.length() > 20) {
            super.addError("Publisher should be more than 2 and less than 20");
        }

        if (year < 1000 || year > Calendar.getInstance().get(Calendar.YEAR)) {
            super.addError("Year should be more than 1000 and less or equal than current year");
        }

    }

    @Override
    public void validateReference(Reference toBeValidated) {
        // would be type of book
        if (toBeValidated instanceof Book) {
            
        }
    }

}
