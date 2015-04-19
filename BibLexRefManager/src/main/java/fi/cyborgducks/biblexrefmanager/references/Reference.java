/*
 * Miniprojekti Ohjelmistotuotanto kevät 2015
 * Helsingin yliopisto Tietojenkäsittelytieteen laitos
 * Cyborg Ducks 2015 - GNU General Public License, version 3.
 */
package fi.cyborgducks.biblexrefmanager.references;

import java.util.Arrays;
import org.jbibtex.BibTeXEntry;
import org.jbibtex.Key;
import org.jbibtex.Value;

/**
 *
 * @author Ooppa
 */
public abstract class Reference extends BibTeXEntry implements java.io.Serializable {

    private Key[] requiredFields = {};

    private Key[] optionalFields = {BibTeXEntry.KEY_NOTE, BibTeXEntry.KEY_KEY};

    public Reference() {
        super(null, null);
    }

    public Reference(Key type, Key key) {
        super(type, key);
    }
    

    /**
     * Adds a new field to the Reference given that it's listed as required of
     * optional field.
     *
     * @param key Type of the Field
     * @param value KeyValue of the field
     */
    @Override
    public void addField(Key key, Value value) {
        if (Arrays.asList(getRequiredFields()).contains(key)) {
            super.addField(key, value);
        } else if (Arrays.asList(getOptionalFields()).contains(key)) {
            super.addField(key, value);
        }
    }

    /**
     * Returns an array of required fields for this Field.
     *
     * @return Array of Required key-types
     */
    public Key[] getRequiredFields() {
        return requiredFields;
    }

    /**
     * Set new required key-types for this field.
     *
     * @param requiredFields Keys-types to accept
     */
    public void setRequiredFields(Key[] requiredFields) {
        this.requiredFields = requiredFields;
    }

    /**
     * Returns an array of optional key-types for this Field.
     *
     * @return Array of Optional key-types
     */
    public Key[] getOptionalFields() {
        return optionalFields;
    }

    /**
     * Set new optional key-types for this field.
     *
     * @param optionalFields Key-types to accept
     */
    public void setOptionalFields(Key[] optionalFields) {
        this.optionalFields = optionalFields;
    }

    /**
     * Asks if specific key has already been inserted for this reference
     * @param askedKey wanted key
     * @return true - if key has been set, false otherwise
     */
    
    public boolean hasKeySet(Key askedKey) {
        return super.getField(askedKey) != null;
    }

    /**
     * Returns true if all required fields are present in the field.
     *
     * @return Boolean
     */
    public boolean isComplete() {
        for (int i = 0; i < requiredFields.length; i++) {
            if (getField(requiredFields[i]) == null) {
                return false;
            }
        }

        return true;
    }

}
