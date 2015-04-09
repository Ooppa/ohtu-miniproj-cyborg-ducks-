
package fi.cyborgducks.biblexrefmanager.exporters;

import java.awt.Component;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
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

        Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(path + ".bib"),
                "8859_1"));

        try {
            BibTeXFormatter formatter = new BibTeXFormatter();
            formatter.format(db, writer);
        } finally {
            writer.close();
        }
    }

    private static String ChooseFile() {
JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "bib files", "bib");
        chooser.setFileFilter(filter);
        Component parent = new Component() {};
        int returnVal = chooser.showOpenDialog(parent);
        if(returnVal == JFileChooser.APPROVE_OPTION) {
            System.out.println("You chose to open this file: " +
                    chooser.getSelectedFile().getName());
            return chooser.getSelectedFile().getAbsolutePath();
        }
        return null;    }
}
