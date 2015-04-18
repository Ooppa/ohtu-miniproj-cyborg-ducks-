import fi.cyborgducks.biblexrefmanager.*;
import fi.cyborgducks.biblexrefmanager.data.*;
import fi.cyborgducks.biblexrefmanager.references.*;
import fi.cyborgducks.biblexrefmanager.exporters.*;
import fi.cyborgducks.biblexrefmanager.validators.*;
import org.jbibtex.*;

description 'User can list all valid saved references'

scenario "user can retrieve all valid references", {
    
    given 'save a new book reference', {
        book = new Book(
                "abc",
                "Robert",
                "Clean Code",
                "Prentice",
                "2008")
        book2 = new Book(
                "cba",
                "Robert",
                "Clean Code",
                "Prentice",
                "2008")
        book3 = new Book(
                "ccc",
                "Robert",
                "Clean Codeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee",
                "Prentice",
                "2008")
        books = [book, book2, book3]
        database = new InMemoryDatabase()
        bookValidator = new BookValidator()
        
    }
    when 'new book references are valid', {
        for(book in books){
            bookValidator.validateReference(book)
            if(!bookValidator.hasErrors()){
                database.saveReference(book)
            }
            else{
                bookValidator.fullErrors() //resets the errors
            }
        }
    }
    then 'all valid book references can be fetchd', {
        database.getAllSavedReferences().size().shouldBe 2
    }
    
}

scenario "fetched references has correct data", {
    
    given 'save a new book reference', {
        book = new Book(
                "abc",
                "Robert",
                "Clean Code",
                "Prentice",
                "2008")
        book2 = new Book(
                "cba",
                "Robert",
                "Clean Code",
                "Prentice",
                "2008")
        book3 = new Book(
                "ccc",
                "Robert",
                "Clean Codeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee",
                "Prentice",
                "2008")
        books = [book, book2, book3]
        database = new InMemoryDatabase()
        bookValidator = new BookValidator()
        
    }
    when 'new book references are valid', {
        for(book in books){
            bookValidator.validateReference(book)
            if(!bookValidator.hasErrors()){
                database.saveReference(book)
            }
            else{
                bookValidator.fullErrors() //resets the errors
            }
        }
    }
    then 'all valid book references can be fetchd', {
        fetchedData = database.getAllSavedReferences()
        found = 0
        for(book in fetchedData){
            if(book.getKey().getValue().equals("cba") ||book.getKey().getValue().equals("abc")){
                found++
            }
        }
        found.shouldBe 2
    }
    
}