/*
 * Miniprojekti Ohjelmistotuotanto kevät 2015
 * Helsingin yliopisto Tietojenkäsittelytieteen laitos
 * Cyborg Ducks 2015 - GNU General Public License, version 3.
 */
package fi.cyborgducks.biblexrefmanager.validators;

import fi.cyborgducks.biblexrefmanager.references.Article;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author kristianw
 */
public class ArticleValidatorTest {

    private ArticleValidator articleValidator;

    @Before
    public void setUp() {
        articleValidator = new ArticleValidator();
    }

    @Test
    public void validArticleShouldNotCreateAnyErrors() {
        articleValidator.validateReference(
                new Article("abc", "kaapo", "aaaa", "kaapos book", "1999", "5")
        );

        assertFalse(articleValidator.hasErrors());
    }

    @Test
    public void invalidArticleShouldCreateErrors() {
        articleValidator.validateReference(
                new Article("abc", "kaapo", "aaaa", "kaapos book", "1999", "wrongnumber")
        );

        assertTrue(articleValidator.hasErrors());
    }
    
    @Test
    public void articleInvalidIfKeyTooShort() {
        articleValidator.validateReference(
                new Article("a", "kaapo", "aaaa", "kaapos book", "1999", "wrongnumber")
        );

        assertTrue(articleValidator.hasErrors());
    }

    @Test
    public void articleInvalidIfBadAuthor() {
        articleValidator.validateReference(
                new Article("abc", "k", "aaaa", "kaapos book", "1999", "5")
        );

        assertEquals("Author name should be more than 2 and less than 100\n", articleValidator.fullErrors());
    }

    @Test
    public void articleInvalidIfBadTitle() {
        articleValidator.validateReference(
                new Article("abc", "kaapo", "", "kaapos book", "1999", "5")
        );

        assertEquals("Title lenght should be more than 2 and less than 100\n", articleValidator.fullErrors());
    }

    @Test
    public void articleInvalidIfBadJournal() {
        articleValidator.validateReference(
                new Article("abc", "kaapo", "aaaa", "", "1999", "5")
        );

        assertEquals("Journal length is wrong! Should be more than 2 and less than 100\n", articleValidator.fullErrors());
    }

    @Test
    public void articleInvalidIfBadYear() {
        articleValidator.validateReference(
                new Article("abc", "kaapo", "aaaa", "kaapos book", "19999", "5")
        );

        assertEquals("Year should be more than 1000 and less or equal than current year\n", articleValidator.fullErrors());
    }
    
    @Test
    public void articleInvalidIfYearContainsAlphabets() {
        articleValidator.validateReference(
                new Article("abc", "kaapo", "aaaa", "kaapos book", "199o", "5")
        );

        assertTrue(articleValidator.hasErrors());
    }

    @Test
    public void articleInvalidIfBadVolume() {
        articleValidator.validateReference(
                new Article("abc", "kaapo", "aaaa", "kaapos book", "1999", "-1")
        );

        assertEquals("Volume should be between 0 and 9999.\n", articleValidator.fullErrors());
    }

}
