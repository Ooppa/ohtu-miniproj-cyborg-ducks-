/*
 * Miniprojekti Ohjelmistotuotanto kevät 2015
 * Helsingin yliopisto Tietojenkäsittelytieteen laitos
 * Cyborg Ducks 2015 - GNU General Public License, version 3.
 */
package fi.cyborgducks.biblexrefmanager.ui;

import fi.cyborgducks.biblexrefmanager.references.Article;
import fi.cyborgducks.biblexrefmanager.references.Book;
import fi.cyborgducks.biblexrefmanager.references.utils.ReferenceUtils;
import fi.cyborgducks.biblexrefmanager.validators.ArticleValidator;

import fi.cyborgducks.biblexrefmanager.validators.BookValidator;
import java.awt.Component;
import java.util.HashSet;
import java.util.Set;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import org.jbibtex.*;
import org.jbibtex.StringValue.Style;

/**
 *
 * @author kristianw
 */
public class ArticleEditWindow extends javax.swing.JDialog {

    private BibTeXEntry editedAtm, copyEditedAtm;
    private final GraphicalUI parent;
    private final ArticleValidator articleValidator;
    private Set<Key> startKeys;

    /**
     * Creates new form EditWindow
     *
     * @param parent
     * @param modal
     * @param selected
     */
    public ArticleEditWindow(GraphicalUI parent, boolean modal, BibTeXEntry selected) {
        super(parent, modal);
        setLocationRelativeTo(parent);
        this.editedAtm = selected;

        copyEditedAtm = new Article(selected.getKey().getValue(),
                selected.getField(BibTeXEntry.KEY_AUTHOR).toUserString(),
                selected.getField(BibTeXEntry.KEY_TITLE).toUserString(),
                selected.getField(BibTeXEntry.KEY_JOURNAL).toUserString(),
                selected.getField(BibTeXEntry.KEY_YEAR).toUserString(),
                selected.getField(BibTeXEntry.KEY_VOLUME).toUserString()
        );
        copyEditedAtm.addAllFields(editedAtm.getFields());
        startKeys = new HashSet<>();
        for (Key k : copyEditedAtm.getFields().keySet()) {
            startKeys.add(k);
        }

        this.articleValidator = new ArticleValidator();
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
        jTextFieldJournal = new javax.swing.JTextField();
        jTextFieldYear = new javax.swing.JTextField();
        jLabelVolume = new javax.swing.JLabel();
        jTextFieldVolume = new javax.swing.JTextField();
        jLabelSeries = new javax.swing.JLabel();
        jTextFieldNumber = new javax.swing.JTextField();
        jLabelAddress = new javax.swing.JLabel();
        jTextFieldPages = new javax.swing.JTextField();
        jLabelMonth = new javax.swing.JLabel();
        jLabelNote = new javax.swing.JLabel();
        jTextFieldNote = new javax.swing.JTextField();
        jComboMonth = new javax.swing.JComboBox();
        jLabelInfo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jLabelReferenceTitle.setText("Title:");

        jLabelAuthorName.setText("Author:");

        jLabel3.setText("Journal:");

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

        jLabelSeries.setText("Number:");

        jLabelAddress.setText("Pages:");

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
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelAuthorName)
                            .addComponent(jLabel3)
                            .addComponent(jLabelYear)
                            .addComponent(jLabelReferenceTitle)
                            .addComponent(jLabelVolume)
                            .addComponent(jLabelSeries)
                            .addComponent(jLabelAddress)
                            .addComponent(jLabelMonth)
                            .addComponent(jLabelNote))
                        .addGap(79, 79, 79)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldAuthor, javax.swing.GroupLayout.DEFAULT_SIZE, 637, Short.MAX_VALUE)
                            .addComponent(jTextFieldJournal)
                            .addComponent(jTextFieldYear)
                            .addComponent(jTextFieldVolume)
                            .addComponent(jTextFieldNumber)
                            .addComponent(jTextFieldPages)
                            .addComponent(jTextFieldNote)
                            .addComponent(jTextFieldTitle)
                            .addComponent(jComboMonth, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelInfo)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonCancel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonAccept)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
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
                    .addComponent(jTextFieldJournal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                    .addComponent(jTextFieldNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelAddress)
                    .addComponent(jTextFieldPages, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelMonth)
                    .addComponent(jComboMonth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelNote)
                    .addComponent(jTextFieldNote, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(63, 63, 63)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAccept)
                    .addComponent(jButtonCancel))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelActionPerformed

        this.dispose();
    }//GEN-LAST:event_jButtonCancelActionPerformed

    private void jButtonAcceptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAcceptActionPerformed
        getAllChangedFields();

        isValidNewReference(copyEditedAtm);

        if (articleValidator.hasErrors()) {
            JOptionPane.showMessageDialog(this, articleValidator.fullErrors());
            return;
        }

        copyAllFieldsToEdited();
        parent.appendToOutput("Successfully edited reference " + editedAtm.getKey());

        parent.updateReferenceList(); // updates the list in main window
        dispose(); // Dispose the window after editing is done
    }//GEN-LAST:event_jButtonAcceptActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAccept;
    private javax.swing.JButton jButtonCancel;
    private javax.swing.JComboBox jComboMonth;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabelAddress;
    private javax.swing.JLabel jLabelAuthorName;
    private javax.swing.JLabel jLabelInfo;
    private javax.swing.JLabel jLabelMonth;
    private javax.swing.JLabel jLabelNote;
    private javax.swing.JLabel jLabelReferenceTitle;
    private javax.swing.JLabel jLabelSeries;
    private javax.swing.JLabel jLabelVolume;
    private javax.swing.JLabel jLabelYear;
    private javax.swing.JTextField jTextFieldAuthor;
    private javax.swing.JTextField jTextFieldJournal;
    private javax.swing.JTextField jTextFieldNote;
    private javax.swing.JTextField jTextFieldNumber;
    private javax.swing.JTextField jTextFieldPages;
    private javax.swing.JTextField jTextFieldTitle;
    private javax.swing.JTextField jTextFieldVolume;
    private javax.swing.JTextField jTextFieldYear;
    // End of variables declaration//GEN-END:variables

    private void initializeFields() {
        jComboMonth.setSelectedIndex(0);
        jTextFieldAuthor.setText(editedAtm.getField(BibTeXEntry.KEY_AUTHOR).toUserString());
        jTextFieldJournal.setText(editedAtm.getField(BibTeXEntry.KEY_JOURNAL).toUserString());
        jTextFieldTitle.setText(editedAtm.getField(BibTeXEntry.KEY_TITLE).toUserString());
        jTextFieldYear.setText(editedAtm.getField(BibTeXEntry.KEY_YEAR).toUserString());
        jTextFieldVolume.setText(editedAtm.getField(BibTeXEntry.KEY_VOLUME).toUserString());

        jTextFieldPages.setName("jTextFieldPages");
        jTextFieldAuthor.setName("jTextFieldAuthor");
        jTextFieldNote.setName("jTextFieldNote");
        jTextFieldJournal.setName("jTextFieldJournal");
        jTextFieldNumber.setName("jTextFieldNumber");
        jTextFieldTitle.setName("jTextFieldTitle");
        jTextFieldVolume.setName("jTextFieldVolume");
        jTextFieldYear.setName("jTextFieldYear");
        jComboMonth.setName("jComboMonth");

        // optional fields
        showOptionalFields();
    }

    private void showOptionalFields() {

        if (ReferenceUtils.hasKeySet(editedAtm, BibTeXEntry.KEY_NUMBER)) {
            jTextFieldNumber.setText(editedAtm.getField(BibTeXEntry.KEY_NUMBER).toUserString());
        }
        if (ReferenceUtils.hasKeySet(editedAtm, BibTeXEntry.KEY_PAGES)) {
            jTextFieldPages.setText(editedAtm.getField(BibTeXEntry.KEY_PAGES).toUserString());
        }
        if (ReferenceUtils.hasKeySet(editedAtm, BibTeXEntry.KEY_MONTH)) {
            jComboMonth.setSelectedItem(editedAtm.getField(BibTeXEntry.KEY_MONTH).toUserString());
        }
        if (ReferenceUtils.hasKeySet(editedAtm, BibTeXEntry.KEY_NOTE)) {
            jTextFieldNote.setText(editedAtm.getField(BibTeXEntry.KEY_NOTE).toUserString());
        }
    }

    //gets all field-inputs
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

    // adds a new field or removes depending if field is empty
    private void addOrRemoveFromComboBox(JComboBox inputField) {
        Key keyAssociatedToInput = resolveKey(inputField.getName());

        if (((String) inputField.getSelectedItem()).equals("NaN") && ReferenceUtils.hasKeySet(copyEditedAtm, keyAssociatedToInput)) {
            copyEditedAtm.removeField(keyAssociatedToInput);
        } else if (!((String) inputField.getSelectedItem()).equals("NaN")) {
            addFromComboBox(inputField, keyAssociatedToInput);
        }
    }

    private void addOrRemoveFromTextField(JTextField inputField) {
        Key keyAssociatedToInput = resolveKey(inputField.getName());

        if (inputField.getText().isEmpty() && ReferenceUtils.hasKeySet(copyEditedAtm, keyAssociatedToInput)) {
            copyEditedAtm.removeField(keyAssociatedToInput);
        } else if (!inputField.getText().isEmpty()) {
            addFromTextField(inputField, keyAssociatedToInput);
        }
    }

    // direct add from field
    private void addFromTextField(JTextField inputField, Key keyAssociatedToInput) {
        String newStringValue = inputField.getText();
        Value newValue = resolveValue(keyAssociatedToInput, newStringValue);

        copyEditedAtm.addField(keyAssociatedToInput, newValue);
    }

    private void addFromComboBox(JComboBox inputField, Key keyAssociatedToInput) {
        String newStringValue = (String) inputField.getSelectedItem();
        Value newValue = resolveValue(keyAssociatedToInput, newStringValue);

        copyEditedAtm.addField(keyAssociatedToInput, newValue);
    }

    // find the key via componentname
    private Key resolveKey(String componentName) {
          return ReferenceUtils.resolveKey(componentName);
    }

    private Value resolveValue(Key keyAssociatedToInput, String valueOfKey) {
        Value v = null;
        v = new StringValue(valueOfKey, Style.BRACED);
        return v;
    }

    private boolean isValidNewReference(BibTeXEntry toBeValidated) {

        Key[] required = ReferenceUtils.getRequiredKeysForArticle();

        String[] toBeValidatedFields = new String[]{toBeValidated.getKey().getValue(), "", "", "", "", ""};

        for (int i = 1; i <= required.length; i++) {
            Key key = required[i - 1];
            try {
                toBeValidatedFields[i] = toBeValidated.getField(key).toUserString();
            } catch (Exception ex) {
                // y u no throw null pointer
            }
        }

        String[] newFields = new String[toBeValidatedFields.length];
        System.arraycopy(toBeValidatedFields, 0, newFields, 0, toBeValidatedFields.length);
        articleValidator.isValidParams(newFields);

        if (articleValidator.hasErrors()) {
            return false;
        }
        return true;
    }

    private void copyAllFieldsToEdited() {

        for (Key k : startKeys) {
            this.editedAtm.removeField(k);
        }

        this.editedAtm.addAllFields(copyEditedAtm.getFields());
    }
}
