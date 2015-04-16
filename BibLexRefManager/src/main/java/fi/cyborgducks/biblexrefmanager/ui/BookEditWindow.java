/*
 * Miniprojekti Ohjelmistotuotanto kevät 2015
 * Helsingin yliopisto Tietojenkäsittelytieteen laitos
 * Cyborg Ducks 2015 - GNU General Public License, version 3.
 */
package fi.cyborgducks.biblexrefmanager.ui;

import fi.cyborgducks.biblexrefmanager.references.Reference;
import fi.cyborgducks.biblexrefmanager.validators.BookValidator;
import java.awt.Component;
import java.util.Map;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import org.jbibtex.BibTeXEntry;
import org.jbibtex.DigitStringValue;
import org.jbibtex.Key;
import org.jbibtex.StringValue;
import org.jbibtex.StringValue.Style;
import org.jbibtex.Value;

/**
 *
 * @author kristianw
 */
public class BookEditWindow extends javax.swing.JDialog {

    private Reference editedAtm;
    private final JFrame parent;
    private final BookValidator bookValidator;

    /**
     * Creates new form EditWindow
     *
     * @param parent
     * @param modal
     * @param selected
     */
    public BookEditWindow(JFrame parent, boolean modal, Reference selected) {
        super(parent, modal);
        setLocationRelativeTo(parent);
        this.editedAtm = selected;
        this.bookValidator = new BookValidator();
        this.parent = parent;

        initComponents();
        setTitle("Editing reference with key: " + selected.getKey());
        initializeFields();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelReferenceTitle = new javax.swing.JLabel();
        jLabelAuthorName = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabelYear = new javax.swing.JLabel();
        jButtonCancel = new javax.swing.JButton();
        jButtonAccept = new javax.swing.JButton();
        jTextFieldTitle = new javax.swing.JTextField();
        jTextFieldAuthor = new javax.swing.JTextField();
        jTextFieldPublisher = new javax.swing.JTextField();
        jTextFieldYear = new javax.swing.JTextField();
        jLabelVolume = new javax.swing.JLabel();
        jTextFieldVolume = new javax.swing.JTextField();
        jLabelSeries = new javax.swing.JLabel();
        jTextFieldSeries = new javax.swing.JTextField();
        jLabelAddress = new javax.swing.JLabel();
        jTextFieldAddress = new javax.swing.JTextField();
        jTextFieldEdition = new javax.swing.JTextField();
        jLabelEdition = new javax.swing.JLabel();
        jLabelMonth = new javax.swing.JLabel();
        jLabelNote = new javax.swing.JLabel();
        jTextFieldNote = new javax.swing.JTextField();
        jComboMonth = new javax.swing.JComboBox();
        jLabelInfo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jLabelReferenceTitle.setText("Title:");

        jLabelAuthorName.setText("Author:");

        jLabel3.setText("Publisher:");

        jLabelYear.setText("Year:");

        jButtonCancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cross.png"))); // NOI18N
        jButtonCancel.setText("Cancel");
        jButtonCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelActionPerformed(evt);
            }
        });

        jButtonAccept.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/tick.png"))); // NOI18N
        jButtonAccept.setText("Accept Changes");
        jButtonAccept.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAcceptActionPerformed(evt);
            }
        });

        jLabelVolume.setText("Volume:");

        jLabelSeries.setText("Series:");

        jLabelAddress.setText("Address:");

        jLabelEdition.setText("Edition:");

        jLabelMonth.setText("Month:");

        jLabelNote.setText("Note:");

        jComboMonth.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "NaN", "jan", "feb", "mar", "apr", "may", "jun", "jul", "aug", "sep", "oct", "nov", "dec" }));

        jLabelInfo.setBackground(new java.awt.Color(138, 138, 138));
        jLabelInfo.setFont(new java.awt.Font("Droid Sans", 1, 12)); // NOI18N
        jLabelInfo.setText("If the field is left empty it will be removed from keys.");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelInfo)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButtonCancel)
                                .addGap(201, 201, 201)
                                .addComponent(jButtonAccept)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelAuthorName)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabelYear)
                                    .addComponent(jLabelReferenceTitle)
                                    .addComponent(jLabelVolume)
                                    .addComponent(jLabelSeries)
                                    .addComponent(jLabelAddress)
                                    .addComponent(jLabelEdition)
                                    .addComponent(jLabelMonth)
                                    .addComponent(jLabelNote))
                                .addGap(79, 79, 79)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextFieldTitle)
                                    .addComponent(jTextFieldAuthor)
                                    .addComponent(jTextFieldPublisher)
                                    .addComponent(jTextFieldYear)
                                    .addComponent(jTextFieldVolume)
                                    .addComponent(jTextFieldSeries)
                                    .addComponent(jTextFieldAddress)
                                    .addComponent(jTextFieldEdition)
                                    .addComponent(jTextFieldNote)
                                    .addComponent(jComboMonth, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelInfo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelReferenceTitle)
                    .addComponent(jTextFieldTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelAuthorName)
                    .addComponent(jTextFieldAuthor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextFieldPublisher, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelYear)
                    .addComponent(jTextFieldYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelVolume)
                    .addComponent(jTextFieldVolume, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelSeries)
                    .addComponent(jTextFieldSeries, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelAddress)
                    .addComponent(jTextFieldAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelEdition)
                    .addComponent(jTextFieldEdition, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelMonth)
                    .addComponent(jComboMonth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelNote)
                    .addComponent(jTextFieldNote, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAccept)
                    .addComponent(jButtonCancel))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButtonCancelActionPerformed

    private void jButtonAcceptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAcceptActionPerformed
        getAllChangedFields();

        isValidNewReference();

        if (bookValidator.hasErrors()) {
            JOptionPane.showMessageDialog(this, bookValidator.fullErrors());
            return;
        }

        parent.update(null); // updates the list in main window
        dispose(); // Dispose the window after editing is done
    }//GEN-LAST:event_jButtonAcceptActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAccept;
    private javax.swing.JButton jButtonCancel;
    private javax.swing.JComboBox jComboMonth;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabelAddress;
    private javax.swing.JLabel jLabelAuthorName;
    private javax.swing.JLabel jLabelEdition;
    private javax.swing.JLabel jLabelInfo;
    private javax.swing.JLabel jLabelMonth;
    private javax.swing.JLabel jLabelNote;
    private javax.swing.JLabel jLabelReferenceTitle;
    private javax.swing.JLabel jLabelSeries;
    private javax.swing.JLabel jLabelVolume;
    private javax.swing.JLabel jLabelYear;
    private javax.swing.JTextField jTextFieldAddress;
    private javax.swing.JTextField jTextFieldAuthor;
    private javax.swing.JTextField jTextFieldEdition;
    private javax.swing.JTextField jTextFieldNote;
    private javax.swing.JTextField jTextFieldPublisher;
    private javax.swing.JTextField jTextFieldSeries;
    private javax.swing.JTextField jTextFieldTitle;
    private javax.swing.JTextField jTextFieldVolume;
    private javax.swing.JTextField jTextFieldYear;
    // End of variables declaration//GEN-END:variables

    private void initializeFields() {
        jComboMonth.setSelectedIndex(0);
        jTextFieldAuthor.setText(editedAtm.getField(BibTeXEntry.KEY_AUTHOR).toUserString());
        jTextFieldPublisher.setText(editedAtm.getField(BibTeXEntry.KEY_PUBLISHER).toUserString());
        jTextFieldTitle.setText(editedAtm.getField(BibTeXEntry.KEY_TITLE).toUserString());
        jTextFieldYear.setText(editedAtm.getField(BibTeXEntry.KEY_YEAR).toUserString());

        jTextFieldAddress.setName("jTextFieldAddress");
        jTextFieldAuthor.setName("jTextFieldAuthor");
        jTextFieldEdition.setName("jTextFieldEdition");
        jTextFieldNote.setName("jTextFieldNote");
        jTextFieldPublisher.setName("jTextFieldPublisher");
        jTextFieldSeries.setName("jTextFieldSeries");
        jTextFieldTitle.setName("jTextFieldTitle");
        jTextFieldVolume.setName("jTextFieldVolume");
        jTextFieldYear.setName("jTextFieldYear");
        jComboMonth.setName("jComboMonth");

        // optional fields
        showOptionalFields();
    }

    private void showOptionalFields() {

        if (editedAtm.hasKeySet(BibTeXEntry.KEY_VOLUME)) {
            jTextFieldVolume.setText(editedAtm.getField(BibTeXEntry.KEY_VOLUME).toUserString());
        }
        if (editedAtm.hasKeySet(BibTeXEntry.KEY_SERIES)) {
            jTextFieldSeries.setText(editedAtm.getField(BibTeXEntry.KEY_SERIES).toUserString());
        }
        if (editedAtm.hasKeySet(BibTeXEntry.KEY_ADDRESS)) {
            jTextFieldAddress.setText(editedAtm.getField(BibTeXEntry.KEY_ADDRESS).toUserString());
        }
        if (editedAtm.hasKeySet(BibTeXEntry.KEY_EDITION)) {
            jTextFieldEdition.setText(editedAtm.getField(BibTeXEntry.KEY_EDITION).toUserString());
        }
        if (editedAtm.hasKeySet(BibTeXEntry.KEY_MONTH)) {
            jComboMonth.setSelectedItem(editedAtm.getField(BibTeXEntry.KEY_MONTH).toUserString());
        }
        if (editedAtm.hasKeySet(BibTeXEntry.KEY_NOTE)) {
            jTextFieldNote.setText(editedAtm.getField(BibTeXEntry.KEY_NOTE).toUserString());
        }
    }

    private void getAllChangedFields() {

        for (Component component : getContentPane().getComponents()) {

            if (component instanceof JTextField) {
                JTextField inputField = (JTextField) component;
                addOrRemoveFromTextField(inputField);

            } else if (component instanceof JComboBox) {
                JComboBox inputField = (JComboBox) component;
                addOrRemoveFromComboBox(inputField);
            }
        }

    }

    private void addOrRemoveFromComboBox(JComboBox inputField) {
        Key keyAssociatedToInput = resolveKey(inputField.getName());

        if (((String) inputField.getSelectedItem()).equals("NaN") && editedAtm.hasKeySet(keyAssociatedToInput)) {
            editedAtm.removeField(keyAssociatedToInput);
        } else if (!((String) inputField.getSelectedItem()).equals("NaN") && !editedAtm.hasKeySet(keyAssociatedToInput)) {
            addFromComboBox(inputField, keyAssociatedToInput);
        }
    }

    private void addOrRemoveFromTextField(JTextField inputField) {
        Key keyAssociatedToInput = resolveKey(inputField.getName());

        if (inputField.getText().isEmpty() && editedAtm.hasKeySet(keyAssociatedToInput)) {
            editedAtm.removeField(keyAssociatedToInput);
        } else if (!inputField.getText().isEmpty() && !editedAtm.hasKeySet(keyAssociatedToInput)) {
            addFromTextField(inputField, keyAssociatedToInput);
        }
    }

    private void addFromTextField(JTextField inputField, Key keyAssociatedToInput) {
        String newStringValue = inputField.getText();
        Value newValue = resolveValue(keyAssociatedToInput, newStringValue);

        if (!isValidNewReference()) {
            return;
        }

        editedAtm.addField(keyAssociatedToInput, newValue);
    }

    private void addFromComboBox(JComboBox inputField, Key keyAssociatedToInput) {
        String newStringValue = (String) inputField.getSelectedItem();
        Value newValue = resolveValue(keyAssociatedToInput, newStringValue);

        if (!isValidNewReference()) {
            return;
        }

        editedAtm.addField(keyAssociatedToInput, newValue);
    }

    private Key resolveKey(String componentName) {
        String lastPart = componentName.replaceAll("jTextField", "");

        if (lastPart.length() >= componentName.length()) { // must be comboBox
            lastPart = componentName.replaceAll("jCombo", "");
        }

        Key key = null;

        switch (lastPart) {

            case "Title":
                key = BibTeXEntry.KEY_TITLE;
                break;
            case "Author":
                key = BibTeXEntry.KEY_AUTHOR;
                break;
            case "Publisher":
                key = BibTeXEntry.KEY_PUBLISHER;
                break;
            case "Year":
                key = BibTeXEntry.KEY_YEAR;
                break;
            case "Volume":
                key = BibTeXEntry.KEY_VOLUME;
                break;
            case "Series":
                key = BibTeXEntry.KEY_SERIES;
                break;
            case "Address":
                key = BibTeXEntry.KEY_ADDRESS;
                break;
            case "Edition":
                key = BibTeXEntry.KEY_EDITION;
                break;
            case "Note":
                key = BibTeXEntry.KEY_NOTE;
                break;
            case "Month":
                key = BibTeXEntry.KEY_MONTH;
                break;

        }

        return key;
    }

    private Value resolveValue(Key keyAssociatedToInput, String valueOfKey) {
        Value v = null;
        if (keyAssociatedToInput == BibTeXEntry.KEY_VOLUME || keyAssociatedToInput == BibTeXEntry.KEY_YEAR) { // digit field
            v = new DigitStringValue(valueOfKey);
        } else {
            v = new StringValue(valueOfKey, Style.BRACED);
        }
        return v;
    }

    private boolean isValidNewReference() {

        Key[] required = new Key[]{BibTeXEntry.KEY_AUTHOR,
            BibTeXEntry.KEY_TITLE,
            BibTeXEntry.KEY_PUBLISHER,
            BibTeXEntry.KEY_YEAR};

        String[] toBeValidatedFields = new String[]{editedAtm.getKey().getValue(), "", "", "", ""};

        for (int i = 1; i < required.length; i++) {
            Key key = required[i - 1];
            try {
                toBeValidatedFields[i] = editedAtm.getField(key).toUserString();
            } catch (Exception ex) {
                // y u no throw null pointer
            }
        }

        String[] newFields = new String[toBeValidatedFields.length];
        System.arraycopy(toBeValidatedFields, 0, newFields, 0, toBeValidatedFields.length);
        bookValidator.isValidParams(newFields);

        if (bookValidator.hasErrors()) {
            return false;
        }
        return true;
    }
}
