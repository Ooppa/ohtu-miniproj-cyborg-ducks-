/*
 * Miniprojekti Ohjelmistotuotanto kevät 2015
 * Helsingin yliopisto Tietojenkäsittelytieteen laitos
 * Cyborg Ducks 2015 - GNU General Public License, version 3.
 */
package fi.cyborgducks.biblexrefmanager.validators;

import java.util.ArrayList;

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

    public abstract void isValidOptionalFieldFor(String key);

    public abstract void isValidParams(String[] fields);

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

}
