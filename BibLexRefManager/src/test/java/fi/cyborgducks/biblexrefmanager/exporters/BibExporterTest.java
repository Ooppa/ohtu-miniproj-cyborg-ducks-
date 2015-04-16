/*
 * Miniprojekti Ohjelmistotuotanto kevät 2015
 * Helsingin yliopisto Tietojenkäsittelytieteen laitos
 * Cyborg Ducks 2015 - GNU General Public License, version 3.
 */
package fi.cyborgducks.biblexrefmanager.exporters;

import fi.cyborgducks.biblexrefmanager.data.InMemoryDatabase;
import fi.cyborgducks.biblexrefmanager.references.Book;
import fi.cyborgducks.biblexrefmanager.references.Reference;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;
import java.util.Stack;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author goalaleo
 */
public class BibExporterTest {

    @Test
    public void bracketsMatch() throws UnsupportedEncodingException, IOException {
        InMemoryDatabase inMemDB = constructDataBaseWithTwoRefereces();

        String path = "src/mybib";
        BibExporter.export(inMemDB.getDB(), path);

        boolean result = bracketsMatchHelper(path);
        assertEquals(true, result);
    }

    @Test
    public void bracketMismatchDetected() throws UnsupportedEncodingException, IOException {
        InMemoryDatabase inMemDB = new InMemoryDatabase();
        Reference ref = new Book("kikkelis", "Kokkelis Kiiski", "Häläpiti hoi", "Röllituotanto" + "{", "1789");
        inMemDB.saveReference(ref);

        String path = "src/mybib";
        BibExporter.export(inMemDB.getDB(), path);

        boolean result = bracketsMatchHelper(path);
        assertEquals(false, result);
    }

    public static InMemoryDatabase constructDataBaseWithTwoRefereces() {
        InMemoryDatabase inMemDB = new InMemoryDatabase();
        Reference r = new Book("hepuli", "Leo Kiiski", "Sillikalastuksen alkeet", "Kalapanimo", "1991");
        Reference r2 = new Book("hippuli", "Peelo", "Super book", "Peelos publisher", "2012");
        inMemDB.saveReference(r);
        inMemDB.saveReference(r2);
        return inMemDB;
    }

    private boolean bracketsMatchHelper(String path) throws FileNotFoundException, IOException {

        InputStream streamFromFile = new FileInputStream(path + ".bib");
        Scanner scanner = new Scanner(streamFromFile);

        String fileAsString = "";

        while (scanner.hasNextLine()) {
            String lineInBibFile = scanner.nextLine();
            fileAsString += lineInBibFile;
        }
        scanner.close();

        Stack<Character> stackForBrackets = new Stack();

        for (int i = 0; i < fileAsString.length(); i++) {
            char c = fileAsString.charAt(i);

            if (c == '{') {
                stackForBrackets.push(c);
            }

            if (c == '}') {
                if (stackForBrackets.empty()) {
                    stackForBrackets.push(c);
                    break;
                } else if (stackForBrackets.peek() == '{') {
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
}
