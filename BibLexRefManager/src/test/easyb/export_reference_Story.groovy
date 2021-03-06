import fi.cyborgducks.biblexrefmanager.*;
import fi.cyborgducks.biblexrefmanager.data.*;
import fi.cyborgducks.biblexrefmanager.references.*;
import fi.cyborgducks.biblexrefmanager.references.utils.*;
import fi.cyborgducks.biblexrefmanager.exporters.*;
import fi.cyborgducks.biblexrefmanager.validators.*;
import fi.cyborgducks.biblexrefmanager.helpers.*;
import org.jbibtex.*;

description 'User can export all saved references'

scenario "new .bib file is created", {
    given 'export as .bib', {
        book = new Book(
                "cleancode",
                "Robert C. Martin",
                "Clean Code: A Handbook of Agile Software Craftsmanship",
                "Prentice Hall",
                "2008")
        database = new InMemoryDatabase()
        database.saveReference(book)
    }
    when 'book references have been saved to database', {
        BibTexDataTransferHelper.export(database.getDB(), "src/mybib")
    }
    then 'all book references are being exported to .bib-file',{
        f = new File("src/mybib.bib")
        f.delete().shouldBe true
    }
}

scenario "file contains as many @book-blocks as there were book references saved to db", {
    given 'export as .bib', {
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
        database = new InMemoryDatabase()
        database.saveReference(book)
        database.saveReference(book2)
    }
    when 'all book references were valid', {
        BibTexDataTransferHelper.export(database.getDB(), "src/mybib")
    }
    then 'all saved book references can be found from the file', {
        found = 0
        f = new File("src/mybib.bib")
        br = new BufferedReader(new FileReader(f));
        line = "";
        while ((line = br.readLine()) != null) {
            if(line.contains("@book")){
                found++
            }
        }
        br.close();
        f.delete()
        found.shouldBe 2
    }
}