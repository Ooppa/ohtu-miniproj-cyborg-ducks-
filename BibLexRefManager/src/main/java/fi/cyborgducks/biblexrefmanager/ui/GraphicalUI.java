/*
 * Miniprojekti Ohjelmistotuotanto kevät 2015
 * Helsingin yliopisto Tietojenkäsittelytieteen laitos
 * Cyborg Ducks 2015 - GNU General Public License, version 3.
 */
package fi.cyborgducks.biblexrefmanager.ui;

import fi.cyborgducks.biblexrefmanager.validators.BookValidator;
import fi.cyborgducks.biblexrefmanager.validators.Validator;
import fi.cyborgducks.biblexrefmanager.data.*;
import fi.cyborgducks.biblexrefmanager.exporters.BibExporter;
import fi.cyborgducks.biblexrefmanager.factory.BookFactory;
import fi.cyborgducks.biblexrefmanager.references.Book;
import fi.cyborgducks.biblexrefmanager.references.Reference;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.jbibtex.Key;
import org.jbibtex.StringValue;
import org.jbibtex.StringValue.Style;

public class GraphicalUI extends javax.swing.JFrame {
    
    private String key;
    private String author;
    private String title;
    private String publisher;
    private String year;
    private String firstOptionalFieldKey;
    private String firstOptionalFieldValue;

    // validators
    private Validator bookValidator;
    
    private Database database;

    /**
     * Creates new form GraphicalUI
     */
    public GraphicalUI() {
        initComponents();
        this.database = new InMemoryDatabase();
        this.bookValidator = new BookValidator();
        this.jListRefereces.setListData(this.database.getAllSavedReferences().toArray());
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        errorMessageArea = new javax.swing.JTextArea();
        tabbedPanel = new javax.swing.JTabbedPane();
        panelBook = new javax.swing.JPanel();
        labelKey = new javax.swing.JLabel();
        keyInputTextField = new javax.swing.JTextField();
        labelAuthor = new javax.swing.JLabel();
        authorInputTextField = new javax.swing.JTextField();
        labelTitle = new javax.swing.JLabel();
        titleInputTextField = new javax.swing.JTextField();
        labelPublisher = new javax.swing.JLabel();
        publisherInputTextField = new javax.swing.JTextField();
        labelYear = new javax.swing.JLabel();
        yearInputTextField = new javax.swing.JTextField();
        addButton = new javax.swing.JButton();
        labelOptionalFieldsHeader = new javax.swing.JLabel();
        labelOptionalKey = new javax.swing.JLabel();
        optionalFieldKey = new javax.swing.JTextField();
        labelOptionalValue = new javax.swing.JLabel();
        optionalFieldValue = new javax.swing.JTextField();
        panelArticle = new javax.swing.JPanel();
        labelComingSoon = new javax.swing.JLabel();
        panelReferenceList = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jListRefereces = new javax.swing.JList();
        jMenuBar = new javax.swing.JMenuBar();
        jMenuFile = new javax.swing.JMenu();
        jMenuItemSave = new javax.swing.JMenuItem();
        jMenuItemLoad = new javax.swing.JMenuItem();
        jMenuItemExport = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        errorMessageArea.setEditable(false);
        errorMessageArea.setColumns(20);
        errorMessageArea.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        errorMessageArea.setRows(5);
        errorMessageArea.setText("> Welcome");
        errorMessageArea.setToolTipText("");
        errorMessageArea.setBorder(javax.swing.BorderFactory.createTitledBorder("Output"));
        jScrollPane1.setViewportView(errorMessageArea);

        labelKey.setText("Key:");

        keyInputTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                keyInputTextFieldActionPerformed(evt);
            }
        });

        labelAuthor.setText("Author:");

        authorInputTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                authorInputTextFieldActionPerformed(evt);
            }
        });

        labelTitle.setText("Title:");

        titleInputTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                titleInputTextFieldActionPerformed(evt);
            }
        });

        labelPublisher.setText("Publisher:");

        publisherInputTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                publisherInputTextFieldActionPerformed(evt);
            }
        });

        labelYear.setText("Year:");

        yearInputTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yearInputTextFieldActionPerformed(evt);
            }
        });

        addButton.setText("Add");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        labelOptionalFieldsHeader.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        labelOptionalFieldsHeader.setText("Optional fields:");

        labelOptionalKey.setText("Key:");

        optionalFieldKey.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                optionalFieldKeyActionPerformed(evt);
            }
        });

        labelOptionalValue.setText("Value:");

        optionalFieldValue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                optionalFieldValueActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelBookLayout = new javax.swing.GroupLayout(panelBook);
        panelBook.setLayout(panelBookLayout);
        panelBookLayout.setHorizontalGroup(
            panelBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBookLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBookLayout.createSequentialGroup()
                        .addGroup(panelBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelBookLayout.createSequentialGroup()
                                .addGroup(panelBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(labelAuthor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(labelTitle, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(labelKey, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(labelPublisher, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(panelBookLayout.createSequentialGroup()
                                .addComponent(labelYear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(16, 16, 16)))
                        .addGroup(panelBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(keyInputTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)
                            .addComponent(authorInputTextField)
                            .addComponent(titleInputTextField)
                            .addComponent(publisherInputTextField)
                            .addComponent(yearInputTextField)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBookLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(addButton))
                    .addGroup(panelBookLayout.createSequentialGroup()
                        .addGroup(panelBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelOptionalFieldsHeader)
                            .addGroup(panelBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(labelOptionalValue, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE)
                                .addComponent(labelOptionalKey, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(16, 16, 16)
                        .addGroup(panelBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(optionalFieldKey, javax.swing.GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)
                            .addComponent(optionalFieldValue))))
                .addContainerGap())
        );
        panelBookLayout.setVerticalGroup(
            panelBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBookLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelKey)
                    .addComponent(keyInputTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelAuthor)
                    .addComponent(authorInputTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelTitle)
                    .addComponent(titleInputTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelPublisher)
                    .addComponent(publisherInputTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelYear)
                    .addComponent(yearInputTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(labelOptionalFieldsHeader)
                .addGap(18, 18, 18)
                .addGroup(panelBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelOptionalKey)
                    .addComponent(optionalFieldKey, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelOptionalValue)
                    .addComponent(optionalFieldValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 72, Short.MAX_VALUE)
                .addComponent(addButton)
                .addContainerGap())
        );

        tabbedPanel.addTab("Book", panelBook);

        labelComingSoon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelComingSoon.setText("Coming soon...");

        javax.swing.GroupLayout panelArticleLayout = new javax.swing.GroupLayout(panelArticle);
        panelArticle.setLayout(panelArticleLayout);
        panelArticleLayout.setHorizontalGroup(
            panelArticleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelArticleLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelComingSoon, javax.swing.GroupLayout.DEFAULT_SIZE, 304, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelArticleLayout.setVerticalGroup(
            panelArticleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelArticleLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelComingSoon, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(323, Short.MAX_VALUE))
        );

        tabbedPanel.addTab("Article", panelArticle);

        jListRefereces.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Will", "be", "implemented", "later" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jListRefereces.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jListRefereces.setSelectionBackground(new java.awt.Color(153, 153, 153));
        jScrollPane2.setViewportView(jListRefereces);
        jListRefereces.getAccessibleContext().setAccessibleName("");

        javax.swing.GroupLayout panelReferenceListLayout = new javax.swing.GroupLayout(panelReferenceList);
        panelReferenceList.setLayout(panelReferenceListLayout);
        panelReferenceListLayout.setHorizontalGroup(
            panelReferenceListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelReferenceListLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 341, Short.MAX_VALUE))
        );
        panelReferenceListLayout.setVerticalGroup(
            panelReferenceListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelReferenceListLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2))
        );

        jMenuFile.setText("File");

        jMenuItemSave.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemSave.setText("Save");
        jMenuItemSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemSaveActionPerformed(evt);
            }
        });
        jMenuFile.add(jMenuItemSave);

        jMenuItemLoad.setText("Load");
        jMenuItemLoad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemLoadActionPerformed(evt);
            }
        });
        jMenuFile.add(jMenuItemLoad);

        jMenuItemExport.setText("Export as .bib");
        jMenuItemExport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemExportActionPerformed(evt);
            }
        });
        jMenuFile.add(jMenuItemExport);

        jMenuBar.add(jMenuFile);

        setJMenuBar(jMenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(tabbedPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panelReferenceList, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tabbedPanel)
                    .addComponent(panelReferenceList, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
                .addContainerGap())
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
        yearInputTextFieldActionPerformed(evt);
        optionalFieldKeyActionPerformed(evt);
        optionalFieldValueActionPerformed(evt);
        
        String[] bookParams = new String[]{this.key, this.author, this.title, this.publisher, this.year};
        handleOneBook(bookParams);
    }//GEN-LAST:event_addButtonActionPerformed
    
    private void clearFields() {
        authorInputTextField.setText("");
        keyInputTextField.setText("");
        publisherInputTextField.setText("");
        yearInputTextField.setText("");
        titleInputTextField.setText("");
        optionalFieldKey.setText("");
        optionalFieldValue.setText("");
    }

    private void publisherInputTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_publisherInputTextFieldActionPerformed
        this.publisher = publisherInputTextField.getText();
    }//GEN-LAST:event_publisherInputTextFieldActionPerformed

    private void yearInputTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yearInputTextFieldActionPerformed
        this.year = yearInputTextField.getText();
    }//GEN-LAST:event_yearInputTextFieldActionPerformed

    private void titleInputTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_titleInputTextFieldActionPerformed
        this.title = titleInputTextField.getText();
    }//GEN-LAST:event_titleInputTextFieldActionPerformed

    private void optionalFieldKeyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_optionalFieldKeyActionPerformed
        this.firstOptionalFieldKey = optionalFieldKey.getText();
    }//GEN-LAST:event_optionalFieldKeyActionPerformed

    private void optionalFieldValueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_optionalFieldValueActionPerformed
        this.firstOptionalFieldValue = optionalFieldValue.getText();
    }//GEN-LAST:event_optionalFieldValueActionPerformed

    private void jMenuItemExportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemExportActionPerformed
        try {
            BibExporter.export(database.getDB());
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(GraphicalUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(GraphicalUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenuItemExportActionPerformed

    private void jMenuItemLoadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemLoadActionPerformed
        // kun loadataan uusi tietokanta
    }//GEN-LAST:event_jMenuItemLoadActionPerformed

    private void jMenuItemSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemSaveActionPerformed
        // kun tallennetaan nykyinen tietokanta
    }//GEN-LAST:event_jMenuItemSaveActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JTextField authorInputTextField;
    private javax.swing.JTextArea errorMessageArea;
    private javax.swing.JList jListRefereces;
    private javax.swing.JMenuBar jMenuBar;
    private javax.swing.JMenu jMenuFile;
    private javax.swing.JMenuItem jMenuItemExport;
    private javax.swing.JMenuItem jMenuItemLoad;
    private javax.swing.JMenuItem jMenuItemSave;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField keyInputTextField;
    private javax.swing.JLabel labelAuthor;
    private javax.swing.JLabel labelComingSoon;
    private javax.swing.JLabel labelKey;
    private javax.swing.JLabel labelOptionalFieldsHeader;
    private javax.swing.JLabel labelOptionalKey;
    private javax.swing.JLabel labelOptionalValue;
    private javax.swing.JLabel labelPublisher;
    private javax.swing.JLabel labelTitle;
    private javax.swing.JLabel labelYear;
    private javax.swing.JTextField optionalFieldKey;
    private javax.swing.JTextField optionalFieldValue;
    private javax.swing.JPanel panelArticle;
    private javax.swing.JPanel panelBook;
    private javax.swing.JPanel panelReferenceList;
    private javax.swing.JTextField publisherInputTextField;
    private javax.swing.JTabbedPane tabbedPanel;
    private javax.swing.JTextField titleInputTextField;
    private javax.swing.JTextField yearInputTextField;
    // End of variables declaration//GEN-END:variables

    private void handleOneBook(String[] bookParams) {
        
        bookValidator.isValidParams(bookParams);
        bookValidator.isValidOptionalFieldFor(firstOptionalFieldKey);
        
        if (!bookValidator.hasErrors()) {
            errorMessageArea.append("\n> Input was valid.");
            Reference r = BookFactory.createBook(bookParams);
            r.addField(new Key(this.firstOptionalFieldKey), new StringValue(this.firstOptionalFieldValue, Style.BRACED));
            database.saveReference(r);
            jListRefereces.setListData(database.getAllSavedReferences().toArray());
            clearFields();
            errorMessageArea.append("\n> Database has now " + database.getAllSavedReferences().size() + " items.");
        } else {
            JOptionPane.showMessageDialog(this, bookValidator.fullErrors());
        }
        
    }
}
