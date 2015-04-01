/*
 * Miniprojekti Ohjelmistotuotanto kevät 2015
 * Helsingin yliopisto Tietojenkäsittelytieteen laitos
 * Cyborg Ducks 2015 - GNU General Public License, version 3.
 */
package fi.cyborgducks.biblexrefmanager.fields;

import fi.cyborgducks.biblexrefmanager.references.Reference;

/**
 * Defines a Book reference
 */
public class Book extends Reference {

    public Book(Author author, Publisher publisher, Year year) {
        super("Book");
        
        this.getRequiredFields().add(author);
        this.getRequiredFields().add(publisher);
        this.getRequiredFields().add(year);
    }
    
}
