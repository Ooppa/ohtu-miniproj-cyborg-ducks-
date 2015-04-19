/*
 * Miniprojekti Ohjelmistotuotanto kevät 2015
 * Helsingin yliopisto Tietojenkäsittelytieteen laitos
 * Cyborg Ducks 2015 - GNU General Public License, version 3.
 */
package fi.cyborgducks.biblexrefmanager.importers;

import fi.cyborgducks.biblexrefmanager.data.InMemoryDatabase;
import fi.cyborgducks.biblexrefmanager.exporters.BibExporter;
import fi.cyborgducks.biblexrefmanager.exporters.BibExporterTest;
import fi.cyborgducks.biblexrefmanager.ui.FileChooser;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;
import org.jbibtex.BibTeXDatabase;
import org.jbibtex.ObjectResolutionException;
import org.jbibtex.ParseException;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import static org.mockito.Mockito.mock;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

/**
 *
 * @author goalaleo
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({FileChooser.class, BibImporter.class})
public class BibImporterTest {
    
    @Test
    public void importingFromBibFile() throws UnsupportedEncodingException, IOException, FileNotFoundException, ObjectResolutionException, ParseException{
        
        InMemoryDatabase inMemDB = BibExporterTest.constructDataBaseWithTwoRefereces();
        
        String path1 = "src/mybib";
        BibExporter.export(inMemDB.getDB(), path1);
        
        path1 += ".bib";
        BibTeXDatabase importedDB = BibImporter.importFromBib(path1); 
        inMemDB.setDB(importedDB);
        
        String path2 = "src/mybib2";
        BibExporter.export(inMemDB.getDB(), path2);

        path2 += ".bib";
        
        String bib1 = bibAsString(path1);
        System.out.println("First file: " + bib1);
        String bib2 = bibAsString(path2);
        System.out.println("Second file: "+ bib2);
        
        assertEquals(bib1, bib2);
        
        File file1 = new File(path1);
        File file2 = new File(path2);
        file1.delete();
        file2.delete();
    }
    
        @Test
    public void importFromBibReturnsNullIfPathIsNull() throws UnsupportedEncodingException, IOException, ObjectResolutionException, ParseException {
        PowerMockito.mockStatic(FileChooser.class);
        BDDMockito.given(FileChooser.chooseFile("Load", "bib")).willReturn(null);
        
        PowerMockito.mockStatic(BibImporter.class);
        
        assertNull(BibImporter.importFromBib());
        
        PowerMockito.verifyStatic();
    }

    private String bibAsString(String filePath) throws FileNotFoundException {
        
        InputStream streamFromFile = new FileInputStream(filePath);
        Scanner scanner = new Scanner(streamFromFile);

        String fileAsString = "";

        while (scanner.hasNextLine()) {
            String lineInBibFile = scanner.nextLine();
            fileAsString += lineInBibFile;
        }
        scanner.close();
        
        return fileAsString;
    }
}
