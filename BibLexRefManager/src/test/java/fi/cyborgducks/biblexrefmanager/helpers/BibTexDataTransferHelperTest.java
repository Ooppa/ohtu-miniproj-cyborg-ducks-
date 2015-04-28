/*
 * Miniprojekti Ohjelmistotuotanto kevät 2015
 * Helsingin yliopisto Tietojenkäsittelytieteen laitos
 * Cyborg Ducks 2015 - GNU General Public License, version 3.
 */
package fi.cyborgducks.biblexrefmanager.helpers;

import fi.cyborgducks.biblexrefmanager.data.InMemoryDatabase;
import fi.cyborgducks.biblexrefmanager.references.Book;
import fi.cyborgducks.biblexrefmanager.ui.FileChooser;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.Stack;
import org.jbibtex.BibTeXDatabase;
import org.jbibtex.BibTeXEntry;
import org.jbibtex.BibTeXParser;
import org.jbibtex.ObjectResolutionException;
import org.jbibtex.ParseException;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import static org.mockito.Mockito.mock;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

/**
 * 
 * @author goalaleo
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({FileChooser.class, BibTexDataTransferHelper.class})  // Static.class contains static methods
public class BibTexDataTransferHelperTest {

    
     @Test
    public void importingFromBibFile() throws UnsupportedEncodingException, IOException, FileNotFoundException, ObjectResolutionException, ParseException {

        InMemoryDatabase inMemDB = createDbWithTwoEntriesWhichHaveUmlauts();

        String path1 = "src/mybib";
        BibTexDataTransferHelper.export(inMemDB.getDB(), path1);

        path1 += ".bib";
        BibTeXDatabase importedDB = BibTexDataTransferHelper.importFromBib(path1);
        inMemDB.setDB(importedDB);

        String path2 = "src/mybib2";
        BibTexDataTransferHelper.export(inMemDB.getDB(), path2);

        path2 += ".bib";

        String bib1 = bibAsString(path1);
        String bib2 = bibAsString(path2);
        
         System.out.println(bib1);
         System.out.println(bib2);
        
        boolean match = bib1.equals(bib2);
        
        assertEquals(true, match);

        
        Files.delete(Paths.get(path1));
        Files.delete(Paths.get(path2));
    }
    
    @Test
    public void bracketsMatch() throws UnsupportedEncodingException, IOException {
        InMemoryDatabase inMemDB = createDbWithTwoEntriesWhichHaveUmlauts();

        String path = "src/mybib";
        BibTexDataTransferHelper.export(inMemDB.getDB(), path);

        boolean result = bracketsMatchHelper(path);
        assertEquals(true, result);
    }

    @Test
    public void bracketMismatchDetected() throws UnsupportedEncodingException, IOException {
        InMemoryDatabase inMemDB = new InMemoryDatabase();
        BibTeXEntry ref = new Book("kikkelis", "Kokkelis Kiiski", "Häläpiti hoi", "Röllituotanto"+"{", "1789");
        inMemDB.saveReference(ref);

        String path = "src/mybib";
        BibTexDataTransferHelper.export(inMemDB.getDB(), path);

        boolean result = bracketsMatchHelper(path);
        assertEquals(false, result);
    }
    
    @Test
    public void scandsGetReplacedWithBibUmlauts() throws UnsupportedEncodingException, IOException {
        InMemoryDatabase inMemDB = createDbWithTwoEntriesWhichHaveUmlauts();

        String path = "src/scandTest1.bib";

        BibTexDataTransferHelper.export(inMemDB.getDB(), path);

        String fileAsString = ScandCharFixer.readFileToString(path);

        assertEquals(false, fileAsString.contains("ä"));
        assertEquals(false, fileAsString.contains("Ä"));
        assertEquals(false, fileAsString.contains("ö"));
        assertEquals(false, fileAsString.contains("Ö"));

        Files.delete(Paths.get(path));
    }
    
    @Test
    public void bibVersionsOfUmlautsGetReplacedWithRealUmlauts() throws UnsupportedEncodingException, IOException {
        InMemoryDatabase inMemDB = createDbWithTwoEntriesWhichHaveUmlauts();

        String path = "src/scandTest2.bib";

        BibTexDataTransferHelper.export(inMemDB.getDB(), path);

        String fileAsString = ScandCharFixer.readFileToString(path);
        fileAsString = ScandCharFixer.replaceAllBibUmlautsForImport(fileAsString);

        String bibUmlautA = "\\" + "\"{a}";
        String bibCapUmlautA = "\\" + "\"{A}";
        String bibUmlautO = "\\" + "\"{o}";
        String bibCapUmlautO = "\\" + "\"{O}";

        assertEquals(false, fileAsString.contains(bibUmlautA));
        assertEquals(false, fileAsString.contains(bibCapUmlautA));
        assertEquals(false, fileAsString.contains(bibUmlautO));
        assertEquals(false, fileAsString.contains(bibCapUmlautO));

    }  

    @Test
    public void parseBibTexCreatesNewParser() throws ParseException, ObjectResolutionException, IOException {
        BibTeXParser spyParser = Mockito.spy(new BibTeXParser());
        BibTexDataTransferHelper.importFromBib("pölölö");
        Mockito.verify(spyParser);
    }

    private boolean bracketsMatchHelper(String path) throws FileNotFoundException, IOException {

        InputStream streamFromFile = new FileInputStream(path+".bib");
        Scanner scanner = new Scanner(streamFromFile);

        String fileAsString = "";

        while(scanner.hasNextLine()) {
            String lineInBibFile = scanner.nextLine();
            fileAsString += lineInBibFile;
        }
        scanner.close();

        Stack<Character> stackForBrackets = new Stack();

        for(int i = 0; i<fileAsString.length(); i++) {
            char c = fileAsString.charAt(i);

            if(c=='{') {
                stackForBrackets.push(c);
            }

            if(c=='}') {
                if(stackForBrackets.empty()) {
                    stackForBrackets.push(c);
                    break;
                } else if(stackForBrackets.peek()=='{') {
                    stackForBrackets.pop();
                }
            }

        }
        boolean good = stackForBrackets.empty();
        streamFromFile.close();
        File file = new File(path+".bib");
        file.delete();

        return good;
    }

    private InMemoryDatabase createDbWithTwoEntriesWhichHaveUmlauts() {
        InMemoryDatabase inMemDB = new InMemoryDatabase();
        BibTeXEntry r = new Book("hepuli", "Leö Kiiski", "SillikÄlästuksen alkeet", "Kaläpanimo", "1991");
        BibTeXEntry r2 = new Book("hippuli", "PeelÖ", "Super böök", "Peelös publisher", "2012");
        inMemDB.saveReference(r);
        inMemDB.saveReference(r2);
        return inMemDB;
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

