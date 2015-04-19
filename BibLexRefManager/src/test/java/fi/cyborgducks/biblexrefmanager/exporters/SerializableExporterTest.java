/*
 * Miniprojekti Ohjelmistotuotanto kevät 2015
 * Helsingin yliopisto Tietojenkäsittelytieteen laitos
 * Cyborg Ducks 2015 - GNU General Public License, version 3.
 */
package fi.cyborgducks.biblexrefmanager.exporters;

import fi.cyborgducks.biblexrefmanager.data.Database;
import fi.cyborgducks.biblexrefmanager.data.InMemoryDatabase;
import fi.cyborgducks.biblexrefmanager.references.Book;
import fi.cyborgducks.biblexrefmanager.references.Reference;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Lepa
 */
public class SerializableExporterTest {
    
   @Test
   public void producesSerFileFromDB() throws UnsupportedEncodingException, IOException{
    
       Database inMemoryDB = new InMemoryDatabase();
        Reference r = new Book("123", "Samu", "Megakivakirja", "Samus publisher", "2015");
        Reference r2 = new Book("321", "Peelo", "Hessun hauskat kuvat", "Peelos publisher", "2012");
        inMemoryDB.saveReference(r);
        inMemoryDB.saveReference(r2);
        
        String path = "src/testSer";
        
        System.out.println(inMemoryDB.getAllSavedReferences());
        
        SerializableExporter.export(inMemoryDB, path);
       
}
}
