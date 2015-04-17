import fi.cyborgducks.biblexrefmanager.*;
import fi.cyborgducks.biblexrefmanager.data.*;
import fi.cyborgducks.biblexrefmanager.references.*;
import fi.cyborgducks.biblexrefmanager.exporters.*;
import fi.cyborgducks.biblexrefmanager.validators.*;
import org.jbibtex.*;

description 'User can add a reference, which contains multiple fields'

scenario "user can save a valid book reference with multi fields", {
    given 'save a new book reference', {
        book = new Book(
                "abc",
                "Robert",
                "Clean Code",
                "Prentice",
                "2008")
        database = new InMemoryDatabase()
        
       book.addField(new Key("month"), new DigitStringValue("5"))
       book.addField(new Key("volume"), new KeyValue("5"))
        
        bookValidator = new BookValidator()
        bookValidator.validateReference(book)
        
    }
    when 'new book reference is valid', {
        if(!bookValidator.hasErrors()){
            database.saveReference(book)
        }
    }
    then 'added book reference is saved to system', {
        database.getAllSavedReferences().size().shouldBe 1
        reference = database.fetchReference(book.getKey(), book.getType())
        reference.shouldNotBe null
        reference.hasKeySet(new Key("month")).shouldBe true
    }
    
}