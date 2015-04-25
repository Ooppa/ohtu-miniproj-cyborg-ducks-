import fi.cyborgducks.biblexrefmanager.*;
import fi.cyborgducks.biblexrefmanager.data.*;
import fi.cyborgducks.biblexrefmanager.references.*;
import fi.cyborgducks.biblexrefmanager.exporters.*;
import fi.cyborgducks.biblexrefmanager.validators.*;
import org.jbibtex.*;


description 'User can remove a saved reference' 

scenario "after removing a saved reference, it is removed also from database", {
    given "save a valid reference", {
        book = new Book(
                "cleancode",
                "",
                "Clean Code: A Handbook of Agile Software Craftsmanship",
                "Prentice Hall",
                "2008")
        database = new InMemoryDatabase()
    }
    when "reference has been removed", {
        database.deleteReference(book.getKey(), book.getType());
    }
    then "reference can't be found from the database", {
          database.getAllSavedReferences().size().shouldBe 0
    }
}