/*
 * Miniprojekti Ohjelmistotuotanto kevät 2015
 * Helsingin yliopisto Tietojenkäsittelytieteen laitos
 * Cyborg Ducks 2015 - GNU General Public License, version 3.
 */
package fi.cyborgducks.biblexrefmanager.importers;

import fi.cyborgducks.biblexrefmanager.data.Database;
import fi.cyborgducks.biblexrefmanager.ui.FileChooser;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import org.jbibtex.ObjectResolutionException;
import org.jbibtex.ParseException;

/**
 *
 * @author Lepa
 */
public class SerializableImporter {

    public static Database importFromSer() throws ObjectResolutionException, ParseException, IOException {
        String filePath = FileChooser.chooseFile("Load", "ser");
        if(filePath==null) {
            return null;
        }
        return importFromSer(filePath);
    }

    public static Database importFromSer(String filePath) {

        Database database = null;
        
        try {
            FileInputStream fileIn = new FileInputStream(filePath);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            database = (Database) in.readObject();
            in.close();
            fileIn.close();
        } catch(IOException i) {
            i.printStackTrace();
        } catch(ClassNotFoundException c) {
            c.printStackTrace();
        }

        return database;
    }

}
