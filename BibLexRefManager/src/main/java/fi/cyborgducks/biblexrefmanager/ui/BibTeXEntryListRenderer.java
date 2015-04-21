/*
 * Miniprojekti Ohjelmistotuotanto kevät 2015
 * Helsingin yliopisto Tietojenkäsittelytieteen laitos
 * Cyborg Ducks 2015 - GNU General Public License, version 3.
 */
package fi.cyborgducks.biblexrefmanager.ui;

import java.awt.Component;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import org.jbibtex.BibTeXEntry;

/**
 * Custom BibTeXEntryListRenderer for listing BibTeXEntries in GraphicalUI.
 * Uses JLabel to present the BibTeXEntry objects.
 *
 * @author Ooppa
 * @see GrpahicalUI
 */
public class BibTeXEntryListRenderer extends JLabel implements ListCellRenderer<BibTeXEntry> {

    /**
     * Creates a new BibTeXEntryListRenderer and sets it opaque.
     */
    public BibTeXEntryListRenderer() {
        setOpaque(true);
    }

    @Override
    public Component getListCellRendererComponent(JList<? extends BibTeXEntry> list, BibTeXEntry value, int index, boolean isSelected, boolean cellHasFocus) {

        if(isSelected) {
            setBackground(list.getSelectionBackground());
            setForeground(list.getSelectionForeground());
        } else {
            setBackground(list.getBackground());
            setForeground(list.getForeground());
        }

        setText(getBibTeXEntryAsString(value));
        setIcon(getIconForBibTeXEntry(value));

        return this; // returns a JLabel
    }

    /*
     * Returns an image representation of BibTeXEntry
     */
    private ImageIcon getIconForBibTeXEntry(BibTeXEntry value) {
        if(value.getType().equals(BibTeXEntry.TYPE_BOOK)) {
            return new ImageIcon(getClass().getResource("/images/book.png"));
        }

        if(value.getType().equals(BibTeXEntry.TYPE_ARTICLE)) {
            return new ImageIcon(getClass().getResource("/images/article.png"));
        }

        if(value.getType().equals(BibTeXEntry.TYPE_INPROCEEDINGS)) {
            return new ImageIcon(getClass().getResource("/images/proceeding.png"));
        }

        // Defaults to...
        return new ImageIcon(getClass().getResource("/images/no_picture_found.png"));
    }

    /*
     * Returns a text representation of BibTeXEntry
     */
    private String getBibTeXEntryAsString(BibTeXEntry value) {
        return value.getType().toString().toUpperCase()+": "+value.getKey().toString()+" ("+value.getField(BibTeXEntry.KEY_TITLE).toUserString()+")";
    }

}
