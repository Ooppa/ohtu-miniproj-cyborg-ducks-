import fi.cyborgducks.biblexrefmanager.*;


description 'User can add a reference, which is saved to database'

scenario "user can save a valid book reference", {
    given 'save a new book reference'
    when 'new book reference is valid'
    then 'added book reference is saved to system'
}

scenario "multiple references are saved correctly", {
    given 'multiple book references being saved'
    when 'all book references were valid'
    then 'all saved book references can be found'
}