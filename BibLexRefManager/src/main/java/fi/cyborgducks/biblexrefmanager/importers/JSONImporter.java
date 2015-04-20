/*
 * Miniprojekti Ohjelmistotuotanto kevät 2015
 * Helsingin yliopisto Tietojenkäsittelytieteen laitos
 * Cyborg Ducks 2015 - GNU General Public License, version 3.
 */
package fi.cyborgducks.biblexrefmanager.importers;

import fi.cyborgducks.biblexrefmanager.references.Book;

import fi.cyborgducks.biblexrefmanager.ui.FileChooser;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.List;
import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.jbibtex.BibTeXDatabase;
import org.jbibtex.BibTeXEntry;
import org.jbibtex.ObjectResolutionException;
import org.jbibtex.ParseException;

/**
 *
 * @author samutamm
 */
public class JSONImporter {

    public static BibTeXDatabase importFromJSON() throws ObjectResolutionException, ParseException, IOException {
        String filePath = FileChooser.chooseFile("Load", "json");
        if (filePath == null) {
            return null;
        }
        return importFromJSON(filePath);
    }

    public static BibTeXDatabase importFromJSON(String filePath) throws ObjectResolutionException, ParseException, IOException {
        File inputFile = new File(filePath);
        BibTeXDatabase importedDB = parseBibTex(inputFile);
        return importedDB;
    }

    private static BibTeXDatabase parseBibTex(File inputFile) throws FileNotFoundException, ObjectResolutionException, ParseException, IOException {
        Reader reader = new FileReader(inputFile);

        JsonFactory factory = new JsonFactory();
        ObjectMapper mapper = new ObjectMapper(factory);
        mapper.registerSubtypes(Book.class);
        TypeReference<List<BibTeXEntry>> typeRef
                = new TypeReference<List<BibTeXEntry>>() {
                };

        try {

            List<BibTeXEntry> objects = mapper.readValue(reader, typeRef);
            for (BibTeXEntry r : objects) {
                //System.out.println("KEY: " + key + ", VALUE: " + objects.get(key));
                System.out.println(r);
            }
            return null;
        } finally {
            reader.close();
        }
    }
}
