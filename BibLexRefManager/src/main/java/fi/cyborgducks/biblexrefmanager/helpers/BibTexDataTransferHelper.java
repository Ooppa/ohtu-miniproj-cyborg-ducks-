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
import java.io.PrintWriter;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.nio.file.Files;
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
     * Handles all the exporting logic apart from choosing a file in a UI. This
     * method can be used for testing.
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
            
            String fixedString = ScandCharFixer.fixScands(path);
            System.out.println(fixedString);
            Files.delete(new File(path).toPath());
            
            Writer writer2 = new BufferedWriter(
                new OutputStreamWriter(new FileOutputStream(path), "8859_1"));
            
            writer2.write(fixedString);
            writer2.close();           
        }
        
        
    }
    
    public static BibTeXDatabase importFromBib() throws ObjectResolutionException, ParseException, IOException {
        String filePath = FileChooser.chooseFile("Load", "bib");
        if (filePath == null) {
            return null;
        }
        return importFromBib(filePath);
    }

    public static BibTeXDatabase importFromBib(String filePath) throws ObjectResolutionException, ParseException, IOException {

        File inputFile = new File(filePath);
        BibTeXDatabase importedDB = parseBibTex(inputFile);

        return importedDB;
    }

    private static BibTeXDatabase parseBibTex(File inputFile) throws FileNotFoundException, ObjectResolutionException, ParseException, IOException {

        Reader reader = new FileReader(inputFile);

        try {
            BibTeXParser parser = new BibTeXParser() {

                @Override
                public void checkStringResolution(Key key, BibTeXString string) {

                    if (string == null) {
                        System.err.println("Unresolved string: \"" + key.getValue() + "\"");
                    }
                }

                @Override
                public void checkCrossReferenceResolution(Key key, BibTeXEntry entry) {

                    if (entry == null) {
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
