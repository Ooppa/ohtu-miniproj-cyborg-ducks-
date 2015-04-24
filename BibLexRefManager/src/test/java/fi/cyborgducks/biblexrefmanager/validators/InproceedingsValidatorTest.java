/*
 * Miniprojekti Ohjelmistotuotanto kevät 2015
 * Helsingin yliopisto Tietojenkäsittelytieteen laitos
 * Cyborg Ducks 2015 - GNU General Public License, version 3.
 */
package fi.cyborgducks.biblexrefmanager.validators;

import java.util.Calendar;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author samutamm
 */
public class InproceedingsValidatorTest {

    private Validator validator;

    @Before
    public void setUp() {
        this.validator = new InproceedingsValidator();
    }

    @Test
    public void validInPoceedingIsAccepted() {
        validator.isValidParams(createStringParameters("", -1));
        assertFalse(validator.hasErrors());
    }
    
    @Test
    public void tooShortKeyIsNotAccepted() {
        validator.isValidParams(createStringParameters("A", 0));
        assertTrue(validator.hasErrors());
    }
    
    @Test
    public void tooLongtKeyIsNotAccepted() {
        validator.isValidParams(createStringParameters("Avain joka on aivan liian pitkäääääääääää. Liiiiiiaaan pitkäääääää.", 0));
        assertTrue(validator.hasErrors());
    }
    
    @Test
    public void tooShortAuthorIsNotAccepted() {
        validator.isValidParams(createStringParameters("i", 1));
        assertTrue(validator.hasErrors());
    }
    
    @Test
    public void tooShortInproceedingsTitleIsNotAccepted() {
        validator.isValidParams(createStringParameters("i", 2));
        assertTrue(validator.hasErrors());
    }
    
    @Test
    public void tooShortBookTitleIsNotAccepted() {
        validator.isValidParams(createStringParameters("i", 3));
        assertTrue(validator.hasErrors());
    }
    
    @Test
    public void yearAfterCurrentDateIsNotAccepted() {
        validator.isValidParams(createStringParameters((Calendar.getInstance().get(Calendar.YEAR) + 1) + "", 4));
        assertTrue(validator.hasErrors());
    }
    
    private String[] createStringParameters(String newValue, int index) {
        String[] inproceedingsParams = new String[]{
            "Avain",
            "kirjoittaja",
            "inpro otsikko",
            "book title",
            "1765"};
        if (index >= 0 && index < inproceedingsParams.length) {
            inproceedingsParams[index] = newValue;
        }
        return inproceedingsParams;
    }
}
