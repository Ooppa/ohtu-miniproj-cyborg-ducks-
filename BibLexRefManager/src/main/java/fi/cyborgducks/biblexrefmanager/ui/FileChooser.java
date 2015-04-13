/*
 * Miniprojekti Ohjelmistotuotanto kevät 2015
 * Helsingin yliopisto Tietojenkäsittelytieteen laitos
 * Cyborg Ducks 2015 - GNU General Public License, version 3.
 */
package fi.cyborgducks.biblexrefmanager.ui;

import java.awt.Component;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * Userd for choosing a file
 * 
 * @author goalaleo
 */
public class FileChooser {
    
    /**
     * 
     * Creates a pop up window for choosing a location.
     * 
     * @return returns the chosen directory path + file name as an absolute path. If cancel is pressed, returns null.
     */
    public static String chooseFile() {
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("bib files", "bib");
        chooser.setFileFilter(filter);

        Component parent = new Component() {
        };
        int returnVal = chooser.showOpenDialog(parent);

        if (returnVal == JFileChooser.APPROVE_OPTION) {
            return chooser.getSelectedFile().getAbsolutePath();
        } 
        
        return null;
    }
}
