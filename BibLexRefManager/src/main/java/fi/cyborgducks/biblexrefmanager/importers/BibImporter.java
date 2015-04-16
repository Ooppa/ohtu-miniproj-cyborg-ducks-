/*
 * Miniprojekti Ohjelmistotuotanto kevät 2015
 * Helsingin yliopisto Tietojenkäsittelytieteen laitos
 * Cyborg Ducks 2015 - GNU General Public License, version 3.
 */
package fi.cyborgducks.biblexrefmanager.importers;

import org.jbibtex.BibTeXDatabase;
import fi.cyborgducks.biblexrefmanager.ui.FileChooser;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import org.jbibtex.BibTeXEntry;
import org.jbibtex.BibTeXParser;
import org.jbibtex.BibTeXString;
import org.jbibtex.Key;
import org.jbibtex.ObjectResolutionException;
import org.jbibtex.ParseException;

/**
 *
 * @author goalaleo
 */
public class BibImporter {
    
    public static BibTeXDatabase importFromBib() throws ObjectResolutionException, ParseException, IOException{
    String filePath = FileChooser.chooseFile();
        if ( filePath == null ) {
            return null;
        }
        return importFromBib(filePath);
}
    
    public static BibTeXDatabase importFromBib(String filePath) throws ObjectResolutionException, ParseException, IOException{
    
        File inputFile = new File(filePath);
        BibTeXDatabase importedDB = parseBibTex(inputFile);
        
        return importedDB;
}
    
    private static BibTeXDatabase parseBibTex(File inputFile) throws FileNotFoundException, ObjectResolutionException, ParseException, IOException {
        
        Reader reader = new FileReader(inputFile);

		try {
			BibTeXParser parser = new BibTeXParser(){

				@Override
				public void checkStringResolution(Key key, BibTeXString string){

					if(string == null){
						System.err.println("Unresolved string: \"" + key.getValue() + "\"");
					}
				}

				@Override
				public void checkCrossReferenceResolution(Key key, BibTeXEntry entry){

					if(entry == null){
						System.err.println("Unresolved cross-reference: \"" + key.getValue() + "\"");
					}
				}
			};
                        
			return parser.parse(reader);
		} finally {
			reader.close();
		}
    }
    
}
