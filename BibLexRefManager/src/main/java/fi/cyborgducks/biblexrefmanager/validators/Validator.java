/*
 * Miniprojekti Ohjelmistotuotanto kevät 2015
 * Helsingin yliopisto Tietojenkäsittelytieteen laitos
 * Cyborg Ducks 2015 - GNU General Public License, version 3.
 */
package fi.cyborgducks.biblexrefmanager.validators;


import java.util.ArrayList;
import java.util.regex.Pattern;
import org.jbibtex.BibTeXEntry;

public abstract class Validator {

    private class ErrorMessage {

        private String error;

        public ErrorMessage(String error) {
            this.error = error;
        }

        @Override
        public String toString() {
            return error;
        }

    }

    private final ArrayList<ErrorMessage> errors;

    public Validator() {
        this.errors = new ArrayList<>();
    }


    public abstract void isValidParams(String[] fields);

    public abstract void validateReference(BibTeXEntry toBeValidated);

    protected void addError(String message) {
        errors.add(new ErrorMessage(message));
    }

    public boolean hasErrors() {
        return !errors.isEmpty();
    }

    /**
     * @return all errors separated by a new line and empties the errors
     */
    public String fullErrors() {

        StringBuilder errorBuilder = new StringBuilder();

        for (ErrorMessage error : errors) {
            errorBuilder.append(error);
            errorBuilder.append("\n");
        }

        errors.clear();
        return errorBuilder.toString();
    }
    
    protected boolean stringLengthNotBetween(String string, int minLength, int maxLength) {
        Pattern p = Pattern.compile("^.{" + minLength + "," + maxLength + "}$");
        return  !p.matcher(string).matches();

    }

}
