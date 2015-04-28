/*
 * Miniprojekti Ohjelmistotuotanto kevät 2015
 * Helsingin yliopisto Tietojenkäsittelytieteen laitos
 * Cyborg Ducks 2015 - GNU General Public License, version 3.
 */
package fi.cyborgducks.biblexrefmanager.helpers;

import fi.cyborgducks.biblexrefmanager.ui.FileChooser;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.jbibtex.BibTeXDatabase;
import org.jbibtex.BibTeXEntry;
import org.jbibtex.BibTeXFormatter;
import org.jbibtex.BibTeXParser;
import org.jbibtex.BibTeXString;
import org.jbibtex.Key;
import org.jbibtex.ObjectResolutionException;
import org.jbibtex.ParseException;

/**
 *
 * This class handles saving/exporting and loading .bib files from/into a local inmemory DB
 * 
 * @author goalaleo
 */
public class BibTexDataTransferHelper {
    
    
    /**
     *
     * Takes the references added by the user, and exports them as a .bib file
     * to the chosen location. When this method is invoked, the program asks for
     * the user to choose a location for the .bib file to be exported. For
     * testing, use the
     * {@link #export(org.jbibtex.BibTeXDatabase, java.lang.String)} method
     *
     * @param database a BibTexDatabase of the added references
     * @throws FileNotFoundException
     * @throws UnsupportedEncodingException
     * @throws IOException
     */
    public static void export( BibTeXDatabase database ) throws FileNotFoundException, UnsupportedEncodingException, IOException {
        String path = FileChooser.chooseFile("Save", "bib");
        if ( path == null ) {
            return;
        }
        export(database, path);
    }

    /**
     *
     * Handles all the exporting logic apart from choosing a file in a UI.
     * This method can be used for testing.
     *
     * @param database a BibTexDatabase of the added references
     * @param path the file path where you wish to export to
     * @throws FileNotFoundException
     * @throws UnsupportedEncodingException
     * @throws IOException
     */
    public static void export( BibTeXDatabase database, String path ) throws FileNotFoundException, UnsupportedEncodingException, IOException {
        if ( !path.endsWith(".bib") ) {
            path += ".bib";
        }

        Writer writer1 = new BufferedWriter(
                new OutputStreamWriter(new FileOutputStream(path), "8859_1"));

        try {
            BibTeXFormatter formatter = new BibTeXFormatter();
            formatter.format(database, writer1);
            
        } finally {
            writer1.close();
            
            String fixedString = ScandCharFixer.fixScandsforExport(path);
            Files.delete(new File(path).toPath());
            
            Writer writer2 = new BufferedWriter(
                new OutputStreamWriter(new FileOutputStream(path), "8859_1"));
            
            writer2.write(fixedString);
            writer2.close();           
        }
        
        
    }
    
    /**
     * 
     * This method is called when the user wants to load/import his saved/exported .bib file into memory.
     *  When this method is invoked, the program asks for
     * the user to choose the .bib file to be imported/loaded. For
     * testing, use the {@link #importFromBib(java.lang.String)} method
     * 
     */ 
    public static BibTeXDatabase importFromBib() throws ObjectResolutionException, ParseException, IOException {
        String filePath = FileChooser.chooseFile("Load", "bib");
        if (filePath == null) {
            return null;
        }
        return importFromBib(filePath);
    }

    /**
     * 
     * Handles all the importing/loadinh logic apart from choosing the file in UI.
     * This method can be used for testig.
     * 
     * @param filePath is the filepath for the file to be loaded/imported
     * @return returns the DB formed from the .bib file that was chosen
     * @throws ObjectResolutionException
     * @throws ParseException
     * @throws IOException 
     */
    public static BibTeXDatabase importFromBib(String filePath) throws ObjectResolutionException, ParseException, IOException {
        String tempFilePath = filePath.replace(".bib", "_temp.bib");
        Writer writer = new BufferedWriter(
                new OutputStreamWriter(new FileOutputStream(tempFilePath), "UTF-8"));
    
        String fileAsFixedString = ScandCharFixer.fixScandsForImport(filePath);
        writer.write(fileAsFixedString);
        writer.close();
        
        File inputFile = new File(tempFilePath);
        BibTeXDatabase importedDB = parseBibTex(inputFile);

        Files.delete(Paths.get(tempFilePath));
        
        return importedDB;
    }

    /**
     * 
     * This method has the logic for parsing a .bib file into a local inmemory DB
     * 
     * @param inputFile is the .bib file which is parsed to a DB
     * @return returns the DB created from the .bib file
     * @throws FileNotFoundException
     * @throws ObjectResolutionException
     * @throws ParseException
     * @throws IOException 
     */
    private static BibTeXDatabase parseBibTex(File inputFile) throws FileNotFoundException, ObjectResolutionException, ParseException, IOException {

        Reader reader = new FileReader(inputFile);
        
      
        BibTeXDatabase db;
        try {
            BibTeXParser parser = new BibTeXParser() {

                @Override
                public void checkStringResolution(Key key, BibTeXString string) {
                }

                @Override
                public void checkCrossReferenceResolution(Key key, BibTeXEntry entry) {
                }
            };
            db = parser.parse(reader);
        } finally {
            reader.close();
        }
        return db;
    }
    
}
