import fi.cyborgducks.biblexrefmanager.*;
import fi.cyborgducks.biblexrefmanager.data.*;
import fi.cyborgducks.biblexrefmanager.references.*;
import fi.cyborgducks.biblexrefmanager.references.utils.*;
import fi.cyborgducks.biblexrefmanager.exporters.*;
import fi.cyborgducks.biblexrefmanager.validators.*;
import org.jbibtex.*;

description 'User can import and then export bib and the data stays intact.'

scenario "User can import and the export data whilist the data stays the same", {
    given 'user saves a bib', {
        String[] bookParams = new String[] {
            "dabook",
            "Ooppa",
            "Book of Knowledge",
            "Ooppa Publishings inc.",
            "2015"
        };

        BibTeXEntry addableReference = ReferenceFactory.createBook(bookParams);

        database = new InMemoryDatabase();
        database.saveReference(addableReference);

        BibTeXFormatter formatter = new BibTeXFormatter();

        OutputStream output = new OutputStream() {
            private StringBuilder string = new StringBuilder();

            @Override
            public void write(int b) throws IOException {
                this.string.append((char) b);
            }

            @Override
            public String toString() {
                return this.string.toString();
            }
        };

        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(output, "8859_1");
        formatter.format(database.getDB(), outputStreamWriter);
    }
    when 'user exports the data', {
        StringReader reader = new StringReader(output.toString());
        BibTeXParser parser = new BibTeXParser();
        BibTeXDatabase parsed = parser.parse(reader);
    }
    then 'the data is still the same', {
        Map<Key, BibTeXEntry> entriesForParsed = parsed.getEntries();
        Map<Key, BibTeXEntry> entriesForDatabase = database.getDB().getEntries();
        
        BibTeXEntry first = entriesForParsed.get(new Key("dabook"));
        BibTeXEntry second = entriesForDatabase.get(new Key("dabook"));
        
        first.getField(BibTeXEntry.KEY_AUTHOR).toUserString().shouldBe second.getField(BibTeXEntry.KEY_AUTHOR).toUserString()
        first.getField(BibTeXEntry.KEY_TITLE).toUserString().shouldBe second.getField(BibTeXEntry.KEY_TITLE).toUserString()
        first.getField(BibTeXEntry.KEY_PUBLISHER).toUserString().shouldBe second.getField(BibTeXEntry.KEY_PUBLISHER).toUserString()
        first.getField(BibTeXEntry.KEY_YEAR).toUserString().shouldBe second.getField(BibTeXEntry.KEY_YEAR).toUserString()
    }
    
}