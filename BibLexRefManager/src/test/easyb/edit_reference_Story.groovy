import fi.cyborgducks.biblexrefmanager.*;
import fi.cyborgducks.biblexrefmanager.data.*;
import fi.cyborgducks.biblexrefmanager.references.*;
import fi.cyborgducks.biblexrefmanager.exporters.*;
import fi.cyborgducks.biblexrefmanager.validators.*;
import org.jbibtex.*;

description 'User can edit a reference'

scenario "user can fetch one reference and edited info will be saved to database", {
    
    given 'save a new book reference', {
        book = new Book(
                "abc",
                "Robert",
                "Clean Code",
                "Prentice",
                "2008")
        database = new InMemoryDatabase()
        database.saveReference(book)
        
    }
    when 'new book references are also updated', {
        database.updateReference(book.getKey(), book.getType(), BibTeXEntry.KEY_AUTHOR, new StringValue("Kaapo", StringValue.Style.BRACED))
    }
    then 'updated reference can be fetched', {
        fetched = database.fetchReference(book.getKey(), BibTeXEntry.TYPE_BOOK)
        fetched.getField(BibTeXEntry.KEY_AUTHOR).toUserString().shouldBe new String("Kaapo")
    }
    
}