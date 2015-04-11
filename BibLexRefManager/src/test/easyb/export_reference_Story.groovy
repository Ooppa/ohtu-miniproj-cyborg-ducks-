import fi.cyborgducks.biblexrefmanager.*;



description 'User can export all saved references'

scenario "all exported book references can be found from the created file", {
    given 'export as .bib'
    when 'book references have been saved to database'
    then 'all book references are being exported to .bib-file'
}

scenario "file contains as many @book-blocks as there were book references saved to db", {
    given 'export as .bib'
    when 'all book references were valid'
    then 'all saved book references can be found from the file'
}