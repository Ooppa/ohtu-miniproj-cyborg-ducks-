/*
 * Miniprojekti Ohjelmistotuotanto kevät 2015
 * Helsingin yliopisto Tietojenkäsittelytieteen laitos
 * Cyborg Ducks 2015 - GNU General Public License, version 3.
 */
package fi.cyborgducks.biblexrefmanager.importers;

import fi.cyborgducks.biblexrefmanager.references.Book;
import fi.cyborgducks.biblexrefmanager.references.Reference;
import fi.cyborgducks.biblexrefmanager.ui.FileChooser;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.jbibtex.BibTeXDatabase;
import org.jbibtex.BibTeXEntry;
import org.jbibtex.BibTeXParser;
import org.jbibtex.BibTeXString;
import org.jbibtex.Key;
import org.jbibtex.ObjectResolutionException;
import org.jbibtex.ParseException;

/**
 *
 * @author samutamm
 */
public class JSONImporter {

    public static BibTeXDatabase importFromJSON() throws ObjectResolutionException, ParseException, IOException {
        String filePath = FileChooser.chooseFile("Load");
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
        TypeReference<HashMap<String, Object>> typeRef
                = new TypeReference<HashMap<String, Object>>() {
                };

        try {
//			BibTeXParser parser = new BibTeXParser(){
//				@Override
//				public void checkStringResolution(Key key, BibTeXString string){
//					if(string == null){
//						System.err.println("Unresolved string: \"" + key.getValue() + "\"");
//					}
//				}
//				@Override
//				public void checkCrossReferenceResolution(Key key, BibTeXEntry entry){
//
//					if(entry == null){
//						System.err.println("Unresolved cross-reference: \"" + key.getValue() + "\"");
//					}
//				}
//			};
            //return parser.parse(reader);

            HashMap<String, Object> objects = mapper.readValue(reader, typeRef);
            for (String key : objects.keySet()) {
                System.out.println("KEY: " + key + ", VALUE: " + objects.get(key));
            }
            return null;
        } finally {
            reader.close();
        }
    }
}
