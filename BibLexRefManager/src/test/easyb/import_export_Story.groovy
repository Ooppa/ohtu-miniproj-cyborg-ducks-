import fi.cyborgducks.biblexrefmanager.*;
import fi.cyborgducks.biblexrefmanager.data.*;
import fi.cyborgducks.biblexrefmanager.references.*;
import fi.cyborgducks.biblexrefmanager.references.utils.*;
import fi.cyborgducks.biblexrefmanager.exporters.*;
import fi.cyborgducks.biblexrefmanager.validators.*;
import fi.cyborgducks.biblexrefmanager.factory.*;
import fi.cyborgducks.biblexrefmanager.helpers.*;
import org.jbibtex.*;

description 'User can import and then export bib and the data stays intact.'

scenario "User can import and the export data while list the data stays the same", {
    given 'user saves a bib', {
        String[] bookParams = [
            "dabook",
            "Ooppa",
            "Book of Knowledge",
            "Ooppa Publishings inc.",
            "2015"
        ];

        addableReference = ReferenceFactory.createBook(bookParams);

        database = new InMemoryDatabase();
        database.saveReference(addableReference);

        formatter = new BibTeXFormatter();

        outputStreamWriter = new OutputStreamWriter(output, "8859_1");
        formatter.format(database.getDB(), outputStreamWriter);
    }
    when 'user exports the data', {
        reader = new StringReader(output.toString());
        parser = new BibTeXParser();
        parsed = parser.parse(reader);
    }
    then 'the data is still the same', {
        entriesForParsed = parsed.getEntries();
        entriesForDatabase = database.getDB().getEntries();
        
        first = entriesForParsed.get(new Key("dabook"));
        second = entriesForDatabase.get(new Key("dabook"));
        
        first.getField(BibTeXEntry.KEY_AUTHOR).toUserString().shouldBe second.getField(BibTeXEntry.KEY_AUTHOR).toUserString()
        first.getField(BibTeXEntry.KEY_TITLE).toUserString().shouldBe second.getField(BibTeXEntry.KEY_TITLE).toUserString()
        first.getField(BibTeXEntry.KEY_PUBLISHER).toUserString().shouldBe second.getField(BibTeXEntry.KEY_PUBLISHER).toUserString()
        first.getField(BibTeXEntry.KEY_YEAR).toUserString().shouldBe second.getField(BibTeXEntry.KEY_YEAR).toUserString()
    }
    
}