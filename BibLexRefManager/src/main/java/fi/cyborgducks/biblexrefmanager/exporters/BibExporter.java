package fi.cyborgducks.biblexrefmanager.exporters;

import fi.cyborgducks.biblexrefmanager.ui.FileChooser;
import java.io.*;
import org.jbibtex.BibTeXDatabase;
import org.jbibtex.BibTeXFormatter;

/**
 *
 * This class handles exporting references to a .bib file
 *
 * @author goalaleo
 */
public class BibExporter {

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
        String path = FileChooser.chooseFile();
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

        Writer writer = new BufferedWriter(
                new OutputStreamWriter(new FileOutputStream(path), "8859_1")
        );

        try {
            BibTeXFormatter formatter = new BibTeXFormatter();
            formatter.format(database, writer);
        } finally {
            writer.close();
        }
    }
}
