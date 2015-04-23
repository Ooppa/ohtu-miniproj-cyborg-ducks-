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
import org.jbibtex.BibTeXEntry;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author goalaleo
 */
public class BibTexDataTransferHelperTest {
    
    @Test
    public void scandsGetReplaced() throws UnsupportedEncodingException, IOException{
        InMemoryDatabase inMemDB = new InMemoryDatabase();
        BibTeXEntry r = new Book("hepuli", "Leö Kiiski", "SillikÄlästuksen alkeet", "Kaläpanimo", "1991");
        BibTeXEntry r2 = new Book("hippuli", "PeelÖ", "Super böök", "Peelös publisher", "2012");
        inMemDB.saveReference(r);
        inMemDB.saveReference(r2);
        
        BibTexDataTransferHelper.export(inMemDB.getDB(), "src/scandTest");
    }
}
