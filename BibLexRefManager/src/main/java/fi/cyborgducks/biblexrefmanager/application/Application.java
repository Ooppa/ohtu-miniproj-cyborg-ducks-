/*
 * Miniprojekti Ohjelmistotuotanto kevät 2015
 * Helsingin yliopisto Tietojenkäsittelytieteen laitos
 * Cyborg Ducks 2015 - GNU General Public License, version 3.
 */
package fi.cyborgducks.biblexrefmanager.application;

import fi.cyborgducks.biblexrefmanager.ui.GraphicalUI;
import fi.cyborgducks.biblexrefmanager.validators.BookValidator;

/**
 * Starting point for the application.
 */
public class Application {

    public static void main(String[] args) {
        
         new BookValidator().isValidParams(new String[]{
            "cleandcode",
            "Robert C. Martinnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnn",
            "Clean Code: A Handbook of Agile Software Craftsmanship",
            "Prentice Hall",
            "2008"
        });
        
//
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            @Override
//            public void run() {
//                new GraphicalUI().setVisible(true);
//            }
//        });

    }
}
