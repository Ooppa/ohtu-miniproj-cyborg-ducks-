import fi.cyborgducks.biblexrefmanager.*;
import fi.cyborgducks.biblexrefmanager.data.*;
import fi.cyborgducks.biblexrefmanager.references.*;

description 'User can add a reference, which is saved to database'

scenario "user can save a valid book reference", {
    given 'save a new book reference', {
         book = new Book(
                "cleancode",
                "Robert C. Martin",
                "Clean Code: A Handbook of Agile Software Craftsmanship",
                "Prentice Hall",
                "2008")
        database = new InMemoryDatabase()
    }
    when 'new book reference is valid', {
        database.saveReference(book)
    }
    then 'added book reference is saved to system', {
        database.getAllSavedReferences().size().shouldBe 1
    }
}

scenario "multiple references are saved correctly", {
    given 'multiple book references being saved', {
        book = new Book(
                "cleancode",
                "Robert C. Martin",
                "Clean Code: A Handbook of Agile Software Craftsmanship",
                "Prentice Hall",
                "2008")
        book2 = new Book(
                "cleancode2",
                "Robert C. Martin",
                "Clean Code: A Handbook of Agile Software Craftsmanship",
                "Prentice Hall",
                "2008")
        book3 = new Book(
                "cleancode3",
                "Robert C. Martin",
                "Clean Code: A Handbook of Agile Software Craftsmanship",
                "Prentice Hall",
                "2008")
        database = new InMemoryDatabase()
    }
    when 'all book references were valid', {
           database.saveReference(book)
           database.saveReference(book2)
           database.saveReference(book3)
    }
    then 'all saved book references can be found', {
         database.getAllSavedReferences().size().shouldBe 3
    }
}