/*
 * Miniprojekti Ohjelmistotuotanto kevät 2015
 * Helsingin yliopisto Tietojenkäsittelytieteen laitos
 * Cyborg Ducks 2015 - GNU General Public License, version 3.
 */
package fi.cyborgducks.biblexrefmanager.application;

import fi.cyborgducks.biblexrefmanager.UI.GraphicalUI;

/**
 * Starting point for the application.
 */
public class Application {

    public static void main(String[] args) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GraphicalUI().setVisible(true);
            }
        });

    }
}
