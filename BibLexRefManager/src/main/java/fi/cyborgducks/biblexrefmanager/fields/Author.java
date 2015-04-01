/*
 * Miniprojekti Ohjelmistotuotanto kevät 2015
 * Helsingin yliopisto Tietojenkäsittelytieteen laitos
 * Cyborg Ducks 2015 - GNU General Public License, version 3.
 */
package fi.cyborgducks.biblexrefmanager.fields;

/**
 * Defines a Field in a Reference that contains an author as a String.
 */
public class Author extends SimpleStringField {

    // TODO, multiple names, von van der... {} etc
    
    public Author(String data) {
        super("author", data);
    }

}
