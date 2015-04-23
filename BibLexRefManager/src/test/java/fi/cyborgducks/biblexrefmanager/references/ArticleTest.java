/*
 * Miniprojekti Ohjelmistotuotanto kevät 2015
 * Helsingin yliopisto Tietojenkäsittelytieteen laitos
 * Cyborg Ducks 2015 - GNU General Public License, version 3.
 */
package fi.cyborgducks.biblexrefmanager.references;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author kride
 */
public class ArticleTest {

    private Article article;

    @Before
    public void setUp() {
        article = new Article("abc", "kaapo", "aaaa", "kaapos book", "1999", "5");
    }

    @Test
    public void isValidWhenCreatedWithValidParametersInitially() {
        assertTrue(article.isComplete());
    }

    @Test(expected = IllegalArgumentException.class)
    public void notValidWhenConstructorHasNulls() {
        article = new Article(null, "", "aaaa", "kaapos book", "1999", "5");
        assertFalse(article.isComplete());
    }

    @Test
    public void toStringFormatIsCorrect() {

        String string = "article" + " | " + "abc" + " (" + "aaaa" + ")";

        assertEquals(string, article.toString());
    }
}
