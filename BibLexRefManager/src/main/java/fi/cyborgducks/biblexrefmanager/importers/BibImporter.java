/*
 * Miniprojekti Ohjelmistotuotanto kevät 2015
 * Helsingin yliopisto Tietojenkäsittelytieteen laitos
 * Cyborg Ducks 2015 - GNU General Public License, version 3.
 */
package fi.cyborgducks.biblexrefmanager.importers;

import fi.cyborgducks.biblexrefmanager.ui.FileChooser;
import java.io.*;
import org.jbibtex.*;

/**
 *
 * @author goalaleo
 */
public class BibImporter {

    public static BibTeXDatabase importFromBib() throws ObjectResolutionException, ParseException, IOException {
        return importFromBib(FileChooser.chooseFile("Load", "bib"));
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
                }

                @Override
                public void checkCrossReferenceResolution(Key key, BibTeXEntry entry) {
                }
            };

            return parser.parse(reader);
        } finally {
            reader.close();
        }
    }

}
