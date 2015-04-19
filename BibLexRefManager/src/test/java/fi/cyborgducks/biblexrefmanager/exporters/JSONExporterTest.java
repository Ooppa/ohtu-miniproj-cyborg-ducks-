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
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.List;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;


public class JSONExporterTest {
    
    @Test
    public void createsJSONFile() throws UnsupportedEncodingException, IOException{
        Database inMemoryDB = new InMemoryDatabase();
        Reference r = new Book("123", "Samu", "Super book", "Samus publisher", "2015");
        Reference r2 = new Book("321", "Peelo", "Super book", "Peelos publisher", "2012");
        inMemoryDB.saveReference(r);
        inMemoryDB.saveReference(r2);
        
        String path = "src/testJSON";
        
        DBtoJSON(inMemoryDB, path);

    }
    
    public static void DBtoJSON(Database db, String path) throws FileNotFoundException, UnsupportedEncodingException, IOException{
        if (!path.endsWith(".json")) {
            path += ".json";
        }

        Writer writer = new BufferedWriter(
                new OutputStreamWriter(new FileOutputStream(path), "UTF-8")
        );
        
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.configure(JsonGenerator.Feature.AUTO_CLOSE_TARGET, false);
            //mapper.writeValue(new File("c:\\user.json"), user);
            List<Reference> references = db.getAllSavedReferences();

            mapper.writeValue(writer, references);
        } finally {
            writer.close();
        }
    }
    
}
