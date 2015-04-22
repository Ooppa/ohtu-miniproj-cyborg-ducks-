/*
 * Miniprojekti Ohjelmistotuotanto kevät 2015
 * Helsingin yliopisto Tietojenkäsittelytieteen laitos
 * Cyborg Ducks 2015 - GNU General Public License, version 3.
 */
package fi.cyborgducks.biblexrefmanager.validators;

import fi.cyborgducks.biblexrefmanager.references.Inproceedings;
import java.util.Calendar;
import org.jbibtex.BibTeXEntry;

/**
 * Validates an Inproceedings type reference.
 *
 * @author Ooppa
 */
public class InproceedingsValidator extends Validator {

    @Override
    public void isValidParams(String[] fields) {
        String key = fields[0];
        String title = fields[1];
        String bookTitle = fields[2];
        int year = 0;

        try {
            year = Integer.parseInt(fields[3]);
        } catch(Exception ex) {
            super.addError("Unable to find correct year");
        }

        if(stringLengthNotBetween(key, 2, 16)) {
            super.addError("Key length is wrong! Should be more than 2 and less than 16");
        }

        if(stringLengthNotBetween(title, 3, 100)) {
            super.addError("Title lenght should be more than 2 and less than 100");
        }

        if(stringLengthNotBetween(bookTitle, 3, 100)) {
            super.addError("Book title lenght should be more than 2 and less than 100");
        }

        if(year<1000||year>Calendar.getInstance().get(Calendar.YEAR)) {
            super.addError("Year should be more than 1000 and less or equal than current year");
        }
    }

    @Override
    public void validateReference(BibTeXEntry toBeValidated) {
        if(toBeValidated instanceof Inproceedings) {
            String[] fieldsOfTheInproceedings = new String[] {
                toBeValidated.getKey().getValue(),
                toBeValidated.getField(BibTeXEntry.KEY_TITLE).toUserString(),
                toBeValidated.getField(BibTeXEntry.KEY_BOOKTITLE).toUserString(),
                toBeValidated.getField(BibTeXEntry.KEY_YEAR).toUserString()};
            isValidParams(fieldsOfTheInproceedings);
        }
    }

}
