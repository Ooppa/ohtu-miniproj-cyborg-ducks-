/*
 * Miniprojekti Ohjelmistotuotanto kevät 2015
 * Helsingin yliopisto Tietojenkäsittelytieteen laitos
 * Cyborg Ducks 2015 - GNU General Public License, version 3.
 */
package fi.cyborgducks.biblexrefmanager.ui;

import fi.cyborgducks.biblexrefmanager.data.*;
import fi.cyborgducks.biblexrefmanager.exporters.BibExporter;
import fi.cyborgducks.biblexrefmanager.exporters.JSONExporter;
import fi.cyborgducks.biblexrefmanager.factory.BookFactory;
import fi.cyborgducks.biblexrefmanager.importers.BibImporter;
import fi.cyborgducks.biblexrefmanager.importers.JSONImporter;
import fi.cyborgducks.biblexrefmanager.references.Book;
import fi.cyborgducks.biblexrefmanager.references.Reference;
import fi.cyborgducks.biblexrefmanager.validators.BookValidator;
import fi.cyborgducks.biblexrefmanager.validators.Validator;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import org.jbibtex.*;
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
        setLocationRelativeTo(null); // Centered to screen

        this.database = new InMemoryDatabase();
        this.bookValidator = new BookValidator();
        //database.saveReference(new Book("123", "Samu", "Super book", "Samus publisher", "2015")); // just a stub to help editing
        updateReferenceList();
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
        labelVolume = new javax.swing.JLabel();
        optionalVolumeField = new javax.swing.JTextField();
        labelSeries = new javax.swing.JLabel();
        optionalSeriesField = new javax.swing.JTextField();
        labelAddress = new javax.swing.JLabel();
        optionalAddressField = new javax.swing.JTextField();
        labelEdition = new javax.swing.JLabel();
        optionalEditionField = new javax.swing.JTextField();
        labelMonth = new javax.swing.JLabel();
        labelNote = new javax.swing.JLabel();
        optionalNoteField = new javax.swing.JTextField();
        optionalMonthCombobox = new javax.swing.JComboBox();
        panelArticle = new javax.swing.JPanel();
        labelComingSoon = new javax.swing.JLabel();
        panelReferenceList = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jListRefereces = new javax.swing.JList();
        buttonDeleteSelected = new javax.swing.JButton();
        buttonEditSelected = new javax.swing.JButton();
        labelSelectedItem = new javax.swing.JLabel();
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

        addButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/reference_add.png"))); // NOI18N
        addButton.setText("Add");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        labelOptionalFieldsHeader.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        labelOptionalFieldsHeader.setText("Optional fields:");

        labelVolume.setText("Volume:");

        labelSeries.setText("Series:");

        labelAddress.setText("Address:");

        labelEdition.setText("Edition:");

        labelMonth.setText("Month:");

        labelNote.setText("Note:");

        optionalMonthCombobox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "NaN", "jan", "feb", "mar", "apr", "may", "jun", "jul", "aug", "sep", "oct", "nov", "dec" }));

        javax.swing.GroupLayout panelBookLayout = new javax.swing.GroupLayout(panelBook);
        panelBook.setLayout(panelBookLayout);
        panelBookLayout.setHorizontalGroup(
            panelBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBookLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelOptionalFieldsHeader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBookLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(addButton))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBookLayout.createSequentialGroup()
                        .addGroup(panelBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelBookLayout.createSequentialGroup()
                                .addGroup(panelBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(labelAuthor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(labelTitle, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(labelKey, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(labelPublisher, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(panelBookLayout.createSequentialGroup()
                                .addComponent(labelYear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(16, 16, 16))
                            .addGroup(panelBookLayout.createSequentialGroup()
                                .addGroup(panelBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(labelVolume, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(labelAddress, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(labelSeries, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(labelEdition, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(labelMonth, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(labelNote, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(panelBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(keyInputTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)
                            .addComponent(authorInputTextField)
                            .addComponent(titleInputTextField)
                            .addComponent(publisherInputTextField)
                            .addComponent(yearInputTextField)
                            .addComponent(optionalVolumeField)
                            .addComponent(optionalSeriesField)
                            .addComponent(optionalAddressField)
                            .addComponent(optionalEditionField)
                            .addComponent(optionalNoteField)
                            .addComponent(optionalMonthCombobox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelOptionalFieldsHeader)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelVolume)
                    .addComponent(optionalVolumeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelSeries)
                    .addComponent(optionalSeriesField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelAddress)
                    .addComponent(optionalAddressField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelEdition)
                    .addComponent(optionalEditionField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelMonth)
                    .addComponent(optionalMonthCombobox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelNote)
                    .addComponent(optionalNoteField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
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
                .addContainerGap(370, Short.MAX_VALUE))
        );

        tabbedPanel.addTab("Article", panelArticle);

        jListRefereces.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "NaN" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jListRefereces.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jListRefereces.setSelectionBackground(new java.awt.Color(153, 153, 153));
        jListRefereces.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jListReferecesValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(jListRefereces);
        jListRefereces.getAccessibleContext().setAccessibleName("");

        buttonDeleteSelected.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/reference_delete.png"))); // NOI18N
        buttonDeleteSelected.setToolTipText("Delete selected reference");
        buttonDeleteSelected.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDeleteSelectedActionPerformed(evt);
            }
        });

        buttonEditSelected.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/reference_edit.png"))); // NOI18N
        buttonEditSelected.setToolTipText("View and Edit selected reference");
        buttonEditSelected.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonEditSelectedActionPerformed(evt);
            }
        });

        labelSelectedItem.setFont(new java.awt.Font("Tahoma", 2, 10)); // NOI18N
        labelSelectedItem.setForeground(new java.awt.Color(153, 153, 153));
        labelSelectedItem.setText("Selected Item");

        javax.swing.GroupLayout panelReferenceListLayout = new javax.swing.GroupLayout(panelReferenceList);
        panelReferenceList.setLayout(panelReferenceListLayout);
        panelReferenceListLayout.setHorizontalGroup(
            panelReferenceListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelReferenceListLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelReferenceListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(panelReferenceListLayout.createSequentialGroup()
                        .addComponent(labelSelectedItem, javax.swing.GroupLayout.DEFAULT_SIZE, 247, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonEditSelected, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonDeleteSelected, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        panelReferenceListLayout.setVerticalGroup(
            panelReferenceListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelReferenceListLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelReferenceListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(buttonDeleteSelected, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonEditSelected, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelSelectedItem, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jMenuFile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/table.png"))); // NOI18N
        jMenuFile.setText("File");

        jMenuItemSave.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/table_save.png"))); // NOI18N
        jMenuItemSave.setText("Save");
        jMenuItemSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemSaveActionPerformed(evt);
            }
        });
        jMenuFile.add(jMenuItemSave);

        jMenuItemLoad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/folder_table.png"))); // NOI18N
        jMenuItemLoad.setText("Load");
        jMenuItemLoad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemLoadActionPerformed(evt);
            }
        });
        jMenuFile.add(jMenuItemLoad);

        jMenuItemExport.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/table_export.png"))); // NOI18N
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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)
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

        String[] bookParams = new String[]{this.key, this.author, this.title, this.publisher, this.year};
        handleOneBook(bookParams);
    }//GEN-LAST:event_addButtonActionPerformed

    private void clearFields() {
        clearTextField(authorInputTextField);
        clearTextField(keyInputTextField);
        clearTextField(publisherInputTextField);
        clearTextField(yearInputTextField);
        clearTextField(titleInputTextField);

        clearTextField(optionalAddressField);
        clearTextField(optionalEditionField);
        clearTextField(optionalNoteField);
        clearTextField(optionalSeriesField);
        clearTextField(optionalVolumeField);
        optionalMonthCombobox.setSelectedIndex(0); // 0 is the index for NaN
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
        try {
            database.setDB(JSONImporter.importFromJSON());
        } catch (ObjectResolutionException | ParseException | IOException ex) {
            System.out.println(ex.getMessage());
        } finally {
            updateReferenceList();
        }
    }//GEN-LAST:event_jMenuItemLoadActionPerformed

    private void jMenuItemSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemSaveActionPerformed
        // kun tallennetaan nykyinen tietokanta
        try {
            JSONExporter.export(database);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(GraphicalUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(GraphicalUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenuItemSaveActionPerformed

    private void buttonEditSelectedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonEditSelectedActionPerformed
        // -1 index indicates that "nothing is selected"
        if (this.jListRefereces.getSelectedIndex() != -1) {
            Reference chosenReference = (Reference) this.jListRefereces.getSelectedValue();
            showEditWindow(chosenReference);
        }

        // TODO - reference type directs you to different kind of forms

    }//GEN-LAST:event_buttonEditSelectedActionPerformed

    private void showEditWindow(final Reference selected) {
        BookEditWindow dialog = new BookEditWindow(this, true, selected);
        dialog.setVisible(true);
    }

    private void buttonDeleteSelectedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDeleteSelectedActionPerformed
        // -1 index indicates that "nothing is selected"
        if (this.jListRefereces.getSelectedIndex() != -1) {
            Reference chosenReference = (Reference) this.jListRefereces.getSelectedValue();
            database.deleteReference(chosenReference.getKey(), chosenReference.getType());
            this.updateReferenceList();
            errorMessageArea.append("\n> Database has now " + database.getAllSavedReferences().size() + " items.");
        }

        // TODO

    }//GEN-LAST:event_buttonDeleteSelectedActionPerformed

    private void jListReferecesValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jListReferecesValueChanged
        if (this.jListRefereces.getSelectedIndex() == -1) {
            this.labelSelectedItem.setText("Selected item");
        } else {
            Reference reference = (Reference) this.jListRefereces.getSelectedValue();
            this.labelSelectedItem.setText("Selected: " + reference.getKey().toString());
        }
    }//GEN-LAST:event_jListReferecesValueChanged

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JTextField authorInputTextField;
    private javax.swing.JButton buttonDeleteSelected;
    private javax.swing.JButton buttonEditSelected;
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
    private javax.swing.JLabel labelAddress;
    private javax.swing.JLabel labelAuthor;
    private javax.swing.JLabel labelComingSoon;
    private javax.swing.JLabel labelEdition;
    private javax.swing.JLabel labelKey;
    private javax.swing.JLabel labelMonth;
    private javax.swing.JLabel labelNote;
    private javax.swing.JLabel labelOptionalFieldsHeader;
    private javax.swing.JLabel labelPublisher;
    private javax.swing.JLabel labelSelectedItem;
    private javax.swing.JLabel labelSeries;
    private javax.swing.JLabel labelTitle;
    private javax.swing.JLabel labelVolume;
    private javax.swing.JLabel labelYear;
    private javax.swing.JTextField optionalAddressField;
    private javax.swing.JTextField optionalEditionField;
    private javax.swing.JComboBox optionalMonthCombobox;
    private javax.swing.JTextField optionalNoteField;
    private javax.swing.JTextField optionalSeriesField;
    private javax.swing.JTextField optionalVolumeField;
    private javax.swing.JPanel panelArticle;
    private javax.swing.JPanel panelBook;
    private javax.swing.JPanel panelReferenceList;
    private javax.swing.JTextField publisherInputTextField;
    private javax.swing.JTabbedPane tabbedPanel;
    private javax.swing.JTextField titleInputTextField;
    private javax.swing.JTextField yearInputTextField;
    // End of variables declaration//GEN-END:variables

    private void clearTextField(JTextField field) {
        field.setText("");
    }

    public void appendToOutput(String text) {
        this.errorMessageArea.append("\n> " + text);
    }

    public void updateReferenceList() {
        List<Reference> allSavedReferences = this.database.getAllSavedReferences();
        jListRefereces.setListData(allSavedReferences.toArray());
    }

    private void handleOneBook(String[] bookParams) {
        bookValidator.isValidParams(bookParams);
        // TODO: Optional fieldeille oma validaattori

        if (!bookValidator.hasErrors()) {
            errorMessageArea.append("\n> Input was valid.");

            Reference addableReference = BookFactory.createBook(bookParams);

            addOptionalBookFields(addableReference);
            database.saveReference(addableReference);

            updateReferenceList();
            clearFields();

            errorMessageArea.append("\n> Database has now " + database.getAllSavedReferences().size() + " items.");
        } else {
            JOptionPane.showMessageDialog(this, bookValidator.fullErrors());
        }

    }

    private void addOptionalBookFields(Reference reference) {
        if (!optionalVolumeField.getText().isEmpty()) {
            reference.addField(BibTeXEntry.KEY_VOLUME,
                    new DigitStringValue(optionalVolumeField.getText())
            );
        }

        if (!optionalSeriesField.getText().isEmpty()) {
            reference.addField(BibTeXEntry.KEY_SERIES,
                    new StringValue(optionalSeriesField.getText(), Style.BRACED)
            );
        }

        if (!optionalAddressField.getText().isEmpty()) {
            reference.addField(BibTeXEntry.KEY_ADDRESS,
                    new StringValue(optionalAddressField.getText(), Style.BRACED)
            );
        }

        if (!optionalEditionField.getText().isEmpty()) {
            reference.addField(BibTeXEntry.KEY_EDITION,
                    new StringValue(optionalEditionField.getText(), Style.BRACED)
            );
        }

        // 0 is the index for NaN
        if (this.optionalMonthCombobox.getSelectedIndex() != 0) {
            reference.addField(BibTeXEntry.KEY_MONTH,
                    new StringValue(optionalMonthCombobox.getSelectedItem().toString(), Style.BRACED)
            );
        }

        if (!optionalNoteField.getText().isEmpty()) {
            reference.addField(BibTeXEntry.KEY_NOTE,
                    new StringValue(optionalNoteField.getText(), Style.BRACED)
            );
        }
    }
}
