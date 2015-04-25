import fi.cyborgducks.biblexrefmanager.*;
import fi.cyborgducks.biblexrefmanager.data.*;
import fi.cyborgducks.biblexrefmanager.references.*;
import fi.cyborgducks.biblexrefmanager.exporters.*;
import fi.cyborgducks.biblexrefmanager.validators.*;
import org.jbibtex.*;

/* copy this if you want to create scenario for something :)
  
scenario "", {
given "", {
        
}
when "", {
        
}
then "", {
        
}
}
 
 * */


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

scenario "user can save a valid article reference", {
    given "save a new article reference", {
        article = new Article(
            "abc", "kaapo", "aaaa", "kaapos book", "1999", "5"
        )
        database = new InMemoryDatabase()
    }
    when "new article reference is valid", {
        database.saveReference(article)
    }
    then "added article reference is saved to system", {
        database.getAllSavedReferences().size().shouldBe 1
    }
}

scenario "user can save a valid inproceedings reference", {
    given "save a new inproceedings reference", {
        inpro = new Inproceedings(
            "abc", "kaapo", "aaaa", "kaapos book", "1999"
        )
        database = new InMemoryDatabase()
    }
    when "new Inproceedings is valid", {
        database.saveReference(article)
    }
    then "added inproceedings reference is saved to system", {
        database.getAllSavedReferences().size().shouldBe 1
    }
}

scenario "invalid book reference is not getting saved to database", {
    given "invalid book reference", {
        book = new Book(
                "cleancode",
                "",
                "Clean Code: A Handbook of Agile Software Craftsmanship",
                "Prentice Hall",
                "2008")
        database = new InMemoryDatabase()
        bookValidator = new BookValidator()
    }
    when "trying to add invalid book reference", {
        bookValidator.validateReference(book)
        if(!bookValidator.hasErrors()){
            database.saveReference(book)
        }
    }
    then "no new book references are being saved to database", {
        database.getAllSavedReferences().size().shouldBe 0
    }
}

scenario "invalid article reference is not getting saved to database", {
    given "invalid article reference", {
        article = new Article(
             "abc", "", "", "kaapos book", "1999", "5"
        )
        database = new InMemoryDatabase()
        articleValidator = new ArticleValidator()
    }
    when "new article reference is valid", {
        articleValidator.validateReference(article)
        if(!articleValidator.hasErrors()){
            database.saveReference(article)
        }
    }
    then "added article reference is saved to system", {
        database.getAllSavedReferences().size().shouldBe 0
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