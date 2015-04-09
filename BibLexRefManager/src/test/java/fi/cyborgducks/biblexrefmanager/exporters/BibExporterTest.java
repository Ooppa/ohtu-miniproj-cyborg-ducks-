/*
 * Miniprojekti Ohjelmistotuotanto kevät 2015
 * Helsingin yliopisto Tietojenkäsittelytieteen laitos
 * Cyborg Ducks 2015 - GNU General Public License, version 3.
 */
package fi.cyborgducks.biblexrefmanager.exporters;

import fi.cyborgducks.biblexrefmanager.data.InMemoryDatabase;
import fi.cyborgducks.biblexrefmanager.references.Book;
import fi.cyborgducks.biblexrefmanager.references.Reference;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import org.junit.Test;

/**
 *
 * @author goalaleo
 */
public class BibExporterTest {
    
    InMemoryDatabase imd = new InMemoryDatabase();
    
    
    @Test
    public void exportingDataBaseWorks() throws UnsupportedEncodingException, IOException{
         Reference r = new Book("123", "Samu", "Super book", "Samus publisher", "2015");
        Reference r2 = new Book("321", "Peelo", "Super book", "Peelos publisher", "2012");
        imd.saveReference(r);
        imd.saveReference(r2);
        BibExporter.export(imd.getDB());
    }
}
