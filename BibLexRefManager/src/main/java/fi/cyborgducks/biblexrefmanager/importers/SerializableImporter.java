/*
 * Miniprojekti Ohjelmistotuotanto kevät 2015
 * Helsingin yliopisto Tietojenkäsittelytieteen laitos
 * Cyborg Ducks 2015 - GNU General Public License, version 3.
 */
package fi.cyborgducks.biblexrefmanager.importers;

import fi.cyborgducks.biblexrefmanager.references.Reference;
import fi.cyborgducks.biblexrefmanager.ui.FileChooser;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.jbibtex.BibTeXDatabase;
import org.jbibtex.ObjectResolutionException;
import org.jbibtex.ParseException;

/**
 *
 * @author Lepa
 */
public class SerializableImporter {

    public static BibTeXDatabase importFromSer() throws ObjectResolutionException, ParseException, IOException {
        String filePath = FileChooser.chooseFile("Load", "ser");
        if (filePath == null) {
            return null;
        }
        return importFromSer(filePath);
    }

    public static BibTeXDatabase importFromSer(String filePath) {
        
        
        
        ArrayList<Reference> importedReferences = null;
        try {
            FileInputStream fileIn = new FileInputStream(filePath);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            importedReferences = (ArrayList<Reference>) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException i) {
            i.printStackTrace();
        } catch (ClassNotFoundException c) {
            System.out.println("Employee class not found");
            System.out.println(Arrays.toString(c.getStackTrace()));
        }
        BibTeXDatabase importsAsDB = new BibTeXDatabase();
        for (Reference ref : importedReferences) {
            importsAsDB.addObject(ref);
        }
        
        return importsAsDB;
    }

}
