/*
 * Miniprojekti Ohjelmistotuotanto kevät 2015
 * Helsingin yliopisto Tietojenkäsittelytieteen laitos
 * Cyborg Ducks 2015 - GNU General Public License, version 3.
 */
package fi.cyborgducks.biblexrefmanager.exporters;

import fi.cyborgducks.biblexrefmanager.data.Database;
import fi.cyborgducks.biblexrefmanager.references.Reference;
import fi.cyborgducks.biblexrefmanager.ui.FileChooser;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

/**
 *
 * @author goalaleo
 */
public class SerializableExporter {
    
    public static void export(Database database) throws FileNotFoundException, UnsupportedEncodingException, IOException {
        String path = FileChooser.chooseFile("Save", "ser");
        if (path == null) {
            return;
        }
        export(database, path);
    }

    public static void export(Database database, String path) {  
        if (!path.endsWith(".ser")) {
            path += ".ser";
        }
        ArrayList<Reference> refs = new ArrayList<>(database.getAllSavedReferences());
        
        try
      {
         FileOutputStream fileOut =
         new FileOutputStream(path);
         ObjectOutputStream out = new ObjectOutputStream(fileOut);
         out.writeObject(refs);
         out.close();
            fileOut.close();
            System.out.printf("Serialized data is saved in: " + path);
        } catch (IOException i) {
            System.out.println(i.getMessage());
        }
    }

}
