/*
 * Miniprojekti Ohjelmistotuotanto kevät 2015
 * Helsingin yliopisto Tietojenkäsittelytieteen laitos
 * Cyborg Ducks 2015 - GNU General Public License, version 3.
 */
package fi.cyborgducks.biblexrefmanager.helpers;

import fi.cyborgducks.biblexrefmanager.data.InMemoryDatabase;
import fi.cyborgducks.biblexrefmanager.references.Book;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.jbibtex.BibTeXEntry;
import org.jbibtex.BibTeXParser;
import org.jbibtex.ObjectResolutionException;
import org.jbibtex.ParseException;
import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.Mockito;

/**
 *
 * @author goalaleo
 */
public class BibTexDataTransferHelperTest {

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

    private InMemoryDatabase createDbWithTwoEntriesWhichHaveUmlauts() {
        InMemoryDatabase inMemDB = new InMemoryDatabase();
        BibTeXEntry r = new Book("hepuli", "Leö Kiiski", "SillikÄlästuksen alkeet", "Kaläpanimo", "1991");
        BibTeXEntry r2 = new Book("hippuli", "PeelÖ", "Super böök", "Peelös publisher", "2012");
        inMemDB.saveReference(r);
        inMemDB.saveReference(r2);
        return inMemDB;
    }
}
