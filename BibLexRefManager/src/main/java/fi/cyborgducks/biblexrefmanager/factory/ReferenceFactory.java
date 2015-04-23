package fi.cyborgducks.biblexrefmanager.factory;

import fi.cyborgducks.biblexrefmanager.references.*;

public class ReferenceFactory {

    public static Book createBook(String[] bookParameters) {

        if (bookParameters.length < 5) {
            throw new IllegalStateException("Too few parameters to construct a Book object");
        }

        return new Book(bookParameters[0],
                bookParameters[1],
                bookParameters[2],
                bookParameters[3],
                bookParameters[4]);
    }

    public static Article createArticle(String[] articleParameters) {

        if (articleParameters.length < 6) {
            throw new IllegalStateException("Too few parameters to construct an Article object");
        }

        return new Article(
                articleParameters[0],
                articleParameters[1],
                articleParameters[2],
                articleParameters[3],
                articleParameters[4],
                articleParameters[5]);
    }

    public static Inproceedings createInproceedings(String[] inproceedingsParams) {

        if (inproceedingsParams.length < 5) {
            throw new IllegalStateException("Too few parameters to construct an Inproceedings object");
        }

        return new Inproceedings(
                inproceedingsParams[0],
                inproceedingsParams[1],
                inproceedingsParams[2],
                inproceedingsParams[3],
                inproceedingsParams[4]
        );
    }

}
