/*
 * Miniprojekti Ohjelmistotuotanto kevät 2015
 * Helsingin yliopisto Tietojenkäsittelytieteen laitos
 * Cyborg Ducks 2015 - GNU General Public License, version 3.
 */
package fi.cyborgducks.biblexrefmanager.exporters;

import fi.cyborgducks.biblexrefmanager.data.Database;
import fi.cyborgducks.biblexrefmanager.references.Book;
import fi.cyborgducks.biblexrefmanager.references.Reference;
import fi.cyborgducks.biblexrefmanager.ui.FileChooser;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.List;
import org.codehaus.jackson.JsonGenerator;
import org.jbibtex.BibTeXDatabase;
import org.codehaus.jackson.map.ObjectMapper;
import org.jbibtex.BibTeXObject;

/**
 *
 * This class handles exporting references to a .json file
 *
 * @author (mostly) goalaleo
 */
public class JSONExporter {

    /**
     *
     * Takes the references added by the user, and exports them as a .json file
     * to the chosen location. When this method is invoked, the program asks for
     * the user to choose a location for the .json file to be exported.
     *
     * @param database a BibTexDatabase of the added references
     * @throws FileNotFoundException
     * @throws UnsupportedEncodingException
     * @throws IOException
     */
    public static void export(Database database) throws FileNotFoundException, UnsupportedEncodingException, IOException {
        String path = FileChooser.chooseFile("Save", "json");
        if (path == null) {
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
    public static void export(Database database, String path) throws FileNotFoundException, UnsupportedEncodingException, IOException {
        if (!path.endsWith(".json")) {
            path += ".json";
        }

        Writer writer = new BufferedWriter(
                new OutputStreamWriter(new FileOutputStream(path), "UTF-8")
        );

        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.configure(JsonGenerator.Feature.AUTO_CLOSE_TARGET, false);
            mapper.registerSubtypes(Book.class);
            //mapper.writeValue(new File("c:\\user.json"), user);
            List<Reference> objects = database.getAllSavedReferences();
            mapper.writeValue(writer, objects);

        } finally {
            writer.close();
        }
    }
}
