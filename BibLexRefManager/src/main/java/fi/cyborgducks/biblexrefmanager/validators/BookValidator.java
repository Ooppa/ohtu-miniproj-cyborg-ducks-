/*
 * Miniprojekti Ohjelmistotuotanto kevät 2015
 * Helsingin yliopisto Tietojenkäsittelytieteen laitos
 * Cyborg Ducks 2015 - GNU General Public License, version 3.
 */
package fi.cyborgducks.biblexrefmanager.validators;

import fi.cyborgducks.biblexrefmanager.references.Book;
import java.util.Calendar;
import org.jbibtex.BibTeXEntry;

/**
 * Validates a Book type reference.
 *
 * @author kride
 */
public class BookValidator extends Validator {

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
        } catch(Exception ex) {
            super.addError("Unable to find correct year");
        }

        if(stringLengthNotBetween(key, 2, 16)) {
            super.addError("Key length is wrong! Should be more than 2 and less than 16");
        }

        if(stringLengthNotBetween(author, 3, 40)) {
            super.addError("Author name should be more than 2 and less than 100");
        }

        if(stringLengthNotBetween(title, 3, 40)) {
            super.addError("Title lenght should be more than 2 and less than 100");
        }

        if(stringLengthNotBetween(publisher, 3, 40)) {

            super.addError("Publisher length is wrong! Should be more than 2 and less than 100");
        }

        if(year<1000||year>Calendar.getInstance().get(Calendar.YEAR)) {
            super.addError("Year should be more than 1000 and less or equal than current year");
        }

    }

    @Override
    public void validateReference(BibTeXEntry toBeValidated) {
        // would be type of book
        if(toBeValidated instanceof Book) {

            String[] fieldsOfTheBook = new String[] {
                toBeValidated.getKey().getValue(),
                toBeValidated.getField(BibTeXEntry.KEY_AUTHOR).toUserString(),
                toBeValidated.getField(BibTeXEntry.KEY_TITLE).toUserString(),
                toBeValidated.getField(BibTeXEntry.KEY_PUBLISHER).toUserString(),
                toBeValidated.getField(BibTeXEntry.KEY_YEAR).toUserString()};
            isValidParams(fieldsOfTheBook);
        }
    }
}
