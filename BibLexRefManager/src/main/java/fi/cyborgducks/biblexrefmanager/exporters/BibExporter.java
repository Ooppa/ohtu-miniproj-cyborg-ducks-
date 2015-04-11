package fi.cyborgducks.biblexrefmanager.exporters;

import java.awt.Component;
import java.io.*;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.jbibtex.BibTeXDatabase;
import org.jbibtex.BibTeXFormatter;

/**
 *
 * @author goalaleo
 */
public class BibExporter {

    public static void export(BibTeXDatabase db) throws FileNotFoundException, UnsupportedEncodingException, IOException {
        String path = ChooseFile();
        if (path == null){
            return;
        }
        exportStub(db, path);
    }

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

    private static String ChooseFile() {
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("bib files", "bib");
        chooser.setFileFilter(filter);

        Component parent = new Component() {
        };
        int returnVal = chooser.showOpenDialog(parent);

        if (returnVal == JFileChooser.APPROVE_OPTION) {
            return chooser.getSelectedFile().getAbsolutePath();
        } else {
            chooser.cancelSelection();
        }

        return null;
    }
}
