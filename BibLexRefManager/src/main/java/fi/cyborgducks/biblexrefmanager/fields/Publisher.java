/*
 * Miniprojekti Ohjelmistotuotanto kevät 2015
 * Helsingin yliopisto Tietojenkäsittelytieteen laitos
 * Cyborg Ducks 2015 - GNU General Public License, version 3.
 */
package fi.cyborgducks.biblexrefmanager.fields;

/**
 * Defines a Field in a Reference that contains a publisher as a String.
 */
public class Publisher extends SimpleStringField {

    public Publisher(String data) {
        super("publisher", data);
    }

}
