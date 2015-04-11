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
 * @author wadror
 */
public class BibExporterTest {

    @Test
    public void bracketsMatch() throws UnsupportedEncodingException, IOException {
        InMemoryDatabase imd = constructDataBaseWithTwoRefereces();

        String path = "src/mybib";
        BibExporter.exportStub(imd.getDB(), path);

        boolean result = bracketsMatchHelper(path);
        assertEquals(true, result);
        System.out.println("BracketsMatch() ended");
    }

    @Test
    public void bracketMismatchDetected() throws UnsupportedEncodingException, IOException {
        System.out.println("BracketMismatchDetected() Started");
        InMemoryDatabase imd = new InMemoryDatabase();
        Reference ref = new Book("kikkelis", "Kokkelis Kiiski", "Häläpiti hoi", "Röllituotanto" + "{", "1789");
        imd.saveReference(ref);
        System.out.println("Number or References in DB: " + imd.getAllSavedReferences().size());

        String path = "src/mybib";
        BibExporter.exportStub(imd.getDB(), path);

        boolean result = bracketsMatchHelper(path);
        assertEquals(false, result);
    }

    private InMemoryDatabase constructDataBaseWithTwoRefereces() {
        InMemoryDatabase db = new InMemoryDatabase();
        Reference r = new Book("hepuli", "Leo Kiiski", "Sillikalastuksen alkeet", "Kalapanimo", "1991");
        Reference r2 = new Book("hippuli", "Peelo", "Super book", "Peelos publisher", "2012");
        db.saveReference(r);
        db.saveReference(r2);
        return db;
    }

    private boolean bracketsMatchHelper(String path) throws FileNotFoundException, IOException {

        InputStream file = new FileInputStream(path + ".bib");
        Scanner scanner = new Scanner(file);

        String fileAsString = "";

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            fileAsString += line;
        }
        scanner.close();
        System.out.println(fileAsString);

        Stack<Character> pino = new Stack();

        for (int i = 0; i < fileAsString.length(); i++) {
            char c = fileAsString.charAt(i);

            if (c == '{') {
                System.out.println(c);
                pino.push(c);
            }

            if (c == '}') {
                System.out.println(c);
                if (pino.empty()) {
                    pino.push(c);
                    break;
                } else if (pino.peek() == '{') {
                    pino.pop();
                }
            }

        }
        boolean good = pino.empty();
        file.close();

        return good;
    }
}
