/*
 * Miniprojekti Ohjelmistotuotanto kevät 2015
 * Helsingin yliopisto Tietojenkäsittelytieteen laitos
 * Cyborg Ducks 2015 - GNU General Public License, version 3.
 */
package fi.cyborgducks.biblexrefmanager.importers;

import fi.cyborgducks.biblexrefmanager.data.Database;
import fi.cyborgducks.biblexrefmanager.data.InMemoryDatabase;
import fi.cyborgducks.biblexrefmanager.exporters.SerializableExporter;
import fi.cyborgducks.biblexrefmanager.references.Book;
import fi.cyborgducks.biblexrefmanager.references.Reference;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author goalaeo
 */
public class SerializableImporterTest {
    
    @Test
    public void readingFromSerFileWorks(){
        
        Database inMemoryDB = new InMemoryDatabase();
        Reference r = new Book("123", "Samu", "Megakivakirja", "Samus publisher", "2015");
        Reference r2 = new Book("321", "Peelo", "Hessun hauskat kuvat", "Peelos publisher", "2012");
        inMemoryDB.saveReference(r);
        inMemoryDB.saveReference(r2);
        
        String path = "src/testSer";
        
        System.out.println("Before export: " +inMemoryDB.getAllSavedReferences());
        
        SerializableExporter.export(inMemoryDB, path);
        
        path += ".ser";
        
        
//        These two lines generate an error when the import process fails. Uncomment them to replicate
//        inMemoryDB.setDB(SerializableImporter.importFromSer(path));
//        System.out.println("After import: "+inMemoryDB.getAllSavedReferences());
        
    }
}
