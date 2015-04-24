/*
 * Miniprojekti Ohjelmistotuotanto kevät 2015
 * Helsingin yliopisto Tietojenkäsittelytieteen laitos
 * Cyborg Ducks 2015 - GNU General Public License, version 3.
 */
package fi.cyborgducks.biblexrefmanager.validators;

import fi.cyborgducks.biblexrefmanager.references.Inproceedings;
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
        validator.validateReference(createInproceedings("", -1));
        assertFalse(validator.hasErrors());
    }
    
    @Test
    public void tooShortKeyIsNotAccepted() {
        validator.validateReference(createInproceedings("A", 0));
        assertTrue(validator.hasErrors());
    }
    
    @Test
    public void tooShortAuthorIsNotAccepted() {
        Inproceedings ip = createInproceedings("i", 1);
        validator.validateReference(ip);
        assertTrue(validator.hasErrors());
    }
    
    @Test
    public void tooShortInproceedingsTitleIsNotAccepted() {
        validator.validateReference(createInproceedings("i", 2));
        assertTrue(validator.hasErrors());
    }
    
    @Test
    public void tooShortBookTitleIsNotAccepted() {
        validator.validateReference(createInproceedings("i", 3));
        assertTrue(validator.hasErrors());
    }
    
    @Test
    public void yearAfterCurrentDateIsNotAccepted() {
        validator.validateReference(createInproceedings((Calendar.getInstance().get(Calendar.YEAR) + 1) + "", 4));
        assertTrue(validator.hasErrors());
    }
    
    @Test
    public void alphabetsInYearFieldRaisesError() {
        validator.validateReference(createInproceedings("vannabbevuos", 4));
        assertTrue(validator.hasErrors());
    }
    
    private Inproceedings createInproceedings(String newValue, int index) {
        String[] params = new String[]{
            "Avain",
            "kirjoittaja",
            "inpro otsikko",
            "book title",
            "1765"};
        if (index >= 0 && index < params.length) {
            params[index] = newValue;
        }
        return new Inproceedings(params[0], params[1], params[2], params[3], params[4]);
    }
}
