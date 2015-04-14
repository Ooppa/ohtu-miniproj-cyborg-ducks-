/*
 * Miniprojekti Ohjelmistotuotanto kevät 2015
 * Helsingin yliopisto Tietojenkäsittelytieteen laitos
 * Cyborg Ducks 2015 - GNU General Public License, version 3.
 */
package fi.cyborgducks.biblexrefmanager.ui;

import fi.cyborgducks.biblexrefmanager.factory.BookFactory;
import fi.cyborgducks.biblexrefmanager.references.Reference;
import fi.cyborgducks.biblexrefmanager.data.*;
import fi.cyborgducks.biblexrefmanager.exporters.BibExporter;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import org.jbibtex.Key;
import org.jbibtex.StringValue;
import org.jbibtex.StringValue.Style;
import org.jbibtex.Value;
import sun.security.action.OpenFileInputStreamAction;

public class GraphicalUI extends javax.swing.JFrame {

    private String key;
    private String author;
    private String title;
    private String publisher;
    private String year;
    private String firstOptionalFieldKey;
    private String firstOptionalFieldValue;

    private Database database;

    /**
     * Creates new form GraphicalUI
     */
    public GraphicalUI() {
        initComponents();
        this.database = new InMemoryDatabase();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        authorInputTextField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        keyInputTextField = new javax.swing.JTextField();
        addButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        publisherInputTextField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        YearInputTextField = new javax.swing.JTextField();
        titleInputTextField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        databaseSizeOutput = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        ErrorMessageArea = new javax.swing.JTextArea();
        jLabel8 = new javax.swing.JLabel();
        optionalFieldKey = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        optionalFieldValue = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuFile = new javax.swing.JMenu();
        jmenuExportBibButton = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        authorInputTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                authorInputTextFieldActionPerformed(evt);
            }
        });

        jLabel1.setText("Key");

        jLabel2.setText("Author");

        keyInputTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                keyInputTextFieldActionPerformed(evt);
            }
        });

        addButton.setText("Add");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        jLabel3.setText("Publisher");

        publisherInputTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                publisherInputTextFieldActionPerformed(evt);
            }
        });

        jLabel4.setText("Year");

        YearInputTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                YearInputTextFieldActionPerformed(evt);
            }
        });

        titleInputTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                titleInputTextFieldActionPerformed(evt);
            }
        });

        jLabel5.setText("Title");

        databaseSizeOutput.setText("jTextField7");
        databaseSizeOutput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                databaseSizeOutputActionPerformed(evt);
            }
        });

        ErrorMessageArea.setColumns(20);
        ErrorMessageArea.setRows(5);
        jScrollPane1.setViewportView(ErrorMessageArea);

        jLabel8.setText("Optional field");

        optionalFieldKey.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                optionalFieldKeyActionPerformed(evt);
            }
        });

        jLabel9.setText("Key");

        jLabel10.setText("Value");

        optionalFieldValue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                optionalFieldValueActionPerformed(evt);
            }
        });

        jMenuFile.setText("File");

        jmenuExportBibButton.setText("Export as .bib");
        jmenuExportBibButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmenuExportBibButtonActionPerformed(evt);
            }
        });
        jMenuFile.add(jmenuExportBibButton);

        jMenuBar1.add(jMenuFile);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(245, 245, 245)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addGap(59, 59, 59))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(89, 89, 89)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(YearInputTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(publisherInputTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(titleInputTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel9)
                                                .addGap(18, 18, 18)
                                                .addComponent(optionalFieldKey))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel2)
                                                    .addComponent(jLabel1)
                                                    .addComponent(jLabel5)
                                                    .addComponent(jLabel4))
                                                .addGap(118, 118, 118)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(authorInputTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(keyInputTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addComponent(jLabel10)
                                .addGap(18, 18, 18)
                                .addComponent(optionalFieldValue, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                        .addComponent(addButton)
                        .addGap(143, 143, 143))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(databaseSizeOutput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(140, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(keyInputTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(authorInputTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(titleInputTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addComponent(YearInputTextField))
                            .addComponent(publisherInputTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(optionalFieldKey, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(optionalFieldValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(databaseSizeOutput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(128, 128, 128))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void authorInputTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_authorInputTextFieldActionPerformed
        this.author = authorInputTextField.getText();
    }//GEN-LAST:event_authorInputTextFieldActionPerformed

    private void keyInputTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_keyInputTextFieldActionPerformed
        this.key = keyInputTextField.getText();
    }//GEN-LAST:event_keyInputTextFieldActionPerformed

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        keyInputTextFieldActionPerformed(evt);
        authorInputTextFieldActionPerformed(evt);
        titleInputTextFieldActionPerformed(evt);
        publisherInputTextFieldActionPerformed(evt);
        YearInputTextFieldActionPerformed(evt);
        optionalFieldKeyActionPerformed(evt);
        optionalFieldValueActionPerformed(evt);

        String[] bookParams = new String[]{this.key, this.author, this.title, this.publisher, this.year};
        handleOneBook(bookParams);
    }//GEN-LAST:event_addButtonActionPerformed

    private void clearFields() {
        authorInputTextField.setText("");
        keyInputTextField.setText("");
        publisherInputTextField.setText("");
        YearInputTextField.setText("");
        titleInputTextField.setText("");
        optionalFieldKey.setText("");
        optionalFieldValue.setText("");
    }

    private void publisherInputTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_publisherInputTextFieldActionPerformed
        this.publisher = publisherInputTextField.getText();
    }//GEN-LAST:event_publisherInputTextFieldActionPerformed

    private void YearInputTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_YearInputTextFieldActionPerformed
        this.year = YearInputTextField.getText();
    }//GEN-LAST:event_YearInputTextFieldActionPerformed

    private void titleInputTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_titleInputTextFieldActionPerformed
        this.title = titleInputTextField.getText();
    }//GEN-LAST:event_titleInputTextFieldActionPerformed

    private void databaseSizeOutputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_databaseSizeOutputActionPerformed
        databaseSizeOutput.setText("");    }//GEN-LAST:event_databaseSizeOutputActionPerformed

    private void optionalFieldKeyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_optionalFieldKeyActionPerformed
        this.firstOptionalFieldKey = optionalFieldKey.getText();
    }//GEN-LAST:event_optionalFieldKeyActionPerformed

    private void optionalFieldValueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_optionalFieldValueActionPerformed
        this.firstOptionalFieldValue = optionalFieldValue.getText();
    }//GEN-LAST:event_optionalFieldValueActionPerformed

    private void jmenuExportBibButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmenuExportBibButtonActionPerformed
        try {
            BibExporter.export(database.getDB());
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(GraphicalUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(GraphicalUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jmenuExportBibButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea ErrorMessageArea;
    private javax.swing.JTextField YearInputTextField;
    private javax.swing.JButton addButton;
    private javax.swing.JTextField authorInputTextField;
    private javax.swing.JTextField databaseSizeOutput;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jMenuFile;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenuItem jmenuExportBibButton;
    private javax.swing.JTextField keyInputTextField;
    private javax.swing.JTextField optionalFieldKey;
    private javax.swing.JTextField optionalFieldValue;
    private javax.swing.JTextField publisherInputTextField;
    private javax.swing.JTextField titleInputTextField;
    // End of variables declaration//GEN-END:variables
    private void handleOneBook(String[] bookParams) {
        String errMessage = Validator.isValidBookParams(bookParams);
        errMessage += Validator.isValidOptionalFieldForBook(firstOptionalFieldKey);
        if (errMessage.isEmpty()) {
            ErrorMessageArea.setText("Validi!");
            Reference r = BookFactory.createBook(bookParams);
            r.addField(new Key(this.firstOptionalFieldKey), new StringValue(this.firstOptionalFieldValue, Style.BRACED));
            database.saveReference(r);
            clearFields();
        } else {
            JOptionPane.showMessageDialog(this, errMessage);
        }
        databaseSizeOutput.setText("" + database.getAllSavedReferences().size());
    }
}
