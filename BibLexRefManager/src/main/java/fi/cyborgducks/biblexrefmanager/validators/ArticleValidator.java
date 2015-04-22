/*
 * Miniprojekti Ohjelmistotuotanto kevät 2015
 * Helsingin yliopisto Tietojenkäsittelytieteen laitos
 * Cyborg Ducks 2015 - GNU General Public License, version 3.
 */
package fi.cyborgducks.biblexrefmanager.validators;

import java.util.Calendar;
import org.jbibtex.BibTeXEntry;

/**
 *
 * @author samutamm
 */
public class ArticleValidator extends Validator {

    /**
     * @param fields - key, author, title, journal, year, volume
     */
    @Override
    public void isValidParams(String[] fields) {
        String key = fields[0];
        String author = fields[1];
        String title = fields[2];
        String journal = fields[3];
        int year = 0;
        int volume = 0;

        try {
            year = Integer.parseInt(fields[4]);
        } catch (Exception ex) {
            super.addError("Unable to find correct year");
        }
        try {
            volume = Integer.parseInt(fields[5]);
        } catch (Exception ex) {
            super.addError("Volume is not an integer.");
        }

        if (stringLengthNotBetween(key, 2, 16)) {
            super.addError("Key length is wrong! Should be more than 2 and less than 16");
        }

        if (stringLengthNotBetween(author, 3, 40)) {
            super.addError("Author name should be more than 2 and less than 100");
        }

        if (stringLengthNotBetween(title, 3, 40)) {
            super.addError("Title lenght should be more than 2 and less than 100");
        }

        if (stringLengthNotBetween(journal, 3, 40)) {

            super.addError("Journal length is wrong! Should be more than 2 and less than 100");
        }

        if (year < 1000 || year > Calendar.getInstance().get(Calendar.YEAR)) {
            super.addError("Year should be more than 1000 and less or equal than current year");
        }
        
        if (volume > 9999 || volume < 0) {
            super.addError("Volume should be between 0 and 9999.");
        }
    }

    @Override
    public void validateReference(BibTeXEntry toBeValidated) {
//        if (toBeValidated instanceof Article) {
//
//            String[] fieldsOfTheBook = new String[]{
//                toBeValidated.getKey().getValue(),
//                toBeValidated.getField(BibTeXEntry.KEY_AUTHOR).toUserString(),
//                toBeValidated.getField(BibTeXEntry.KEY_TITLE).toUserString(),
//                toBeValidated.getField(BibTeXEntry.KEY_PUBLISHER).toUserString(),
//                toBeValidated.getField(BibTeXEntry.KEY_YEAR).toUserString()};
//            isValidParams(fieldsOfTheBook);
//        }
    }
    
}
