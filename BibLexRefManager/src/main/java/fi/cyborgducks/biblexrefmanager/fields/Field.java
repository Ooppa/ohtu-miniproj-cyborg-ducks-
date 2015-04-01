/*
 * Miniprojekti Ohjelmistotuotanto kevät 2015
 * Helsingin yliopisto Tietojenkäsittelytieteen laitos
 * Cyborg Ducks 2015 - GNU General Public License, version 3.
 */
package fi.cyborgducks.biblexrefmanager.fields;

/**
 * Defines a Field used in Reference
 */
public abstract class Field {
    private final String fieldName;

    public Field(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getName() {
        return fieldName;
    }

    @Override
    public String toString() {
        return fieldName;
    }
    
}
