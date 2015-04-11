package fi.cyborgducks.biblexrefmanager.exporters;

import java.awt.Component;
import java.io.*;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
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
 * Takes the references added by the user, and exports them as a .bib file to the chosen location.
 * When this method is invoked, the program asks for the user to choose a location for the .bib file
 * to be exported. For testing, use the {@link #exportStub(org.jbibtex.BibTeXDatabase, java.lang.String) } method
 * 
 * @param db a BibTexDatabase of the added references
 * @throws FileNotFoundException
 * @throws UnsupportedEncodingException
 * @throws IOException 
 */
    public static void export(BibTeXDatabase db) throws FileNotFoundException, UnsupportedEncodingException, IOException {
        String path = ChooseFile();
        if (path == null) {
            return;
        }
        exportStub(db, path);
    }

    /**
     * 
     * Handles all the exporting logic apart from choosing a file.
     * This method can be used for testing.
     * 
     * @param db a BibTexDatabase of the added references
     * @param p the file path where you wish to export to
     * @throws FileNotFoundException
     * @throws UnsupportedEncodingException
     * @throws IOException
     */
    public static void exportStub(BibTeXDatabase db, String p) throws FileNotFoundException, UnsupportedEncodingException, IOException {
        String path = p;
        if (!path.endsWith(".bib")){
            path += ".bib";
        }

        Writer writer = new BufferedWriter(
                new OutputStreamWriter(new FileOutputStream(path), "8859_1")
        );
            
        try {
            BibTeXFormatter formatter = new BibTeXFormatter();
            formatter.format(db, writer);
        } finally {
            writer.close();
        }
    }

    /**
     * 
     * Creates a pop up window for choosing the export location.
     * 
     * @return returns the chosen directory path + file name as an absolute path
     */
    private static String ChooseFile() {
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("bib files", "bib");
        chooser.setFileFilter(filter);

        Component parent = new Component() {
        };
        int returnVal = chooser.showOpenDialog(parent);

        if (returnVal == JFileChooser.APPROVE_OPTION) {
            return chooser.getSelectedFile().getAbsolutePath();
        } 
        
        return null;
    }
}
