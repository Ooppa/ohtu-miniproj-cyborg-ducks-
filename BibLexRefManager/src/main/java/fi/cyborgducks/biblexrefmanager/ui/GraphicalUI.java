/*
 * Miniprojekti Ohjelmistotuotanto kevät 2015
 * Helsingin yliopisto Tietojenkäsittelytieteen laitos
 * Cyborg Ducks 2015 - GNU General Public License, version 3.
 */
package fi.cyborgducks.biblexrefmanager.ui;

import fi.cyborgducks.biblexrefmanager.data.*;
import fi.cyborgducks.biblexrefmanager.exporters.BibExporter;
import fi.cyborgducks.biblexrefmanager.factory.BookFactory;
import fi.cyborgducks.biblexrefmanager.importers.BibImporter;
import fi.cyborgducks.biblexrefmanager.validators.BookValidator;
import fi.cyborgducks.biblexrefmanager.validators.Validator;
import java.awt.Color;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import org.jbibtex.*;
import org.jbibtex.StringValue.Style;

public class GraphicalUI extends javax.swing.JFrame {

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
        updateReferenceList();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        errorMessageArea = new javax.swing.JTextArea();
        tabbedPanel = new javax.swing.JTabbedPane();
        panelBook = new javax.swing.JPanel();
        labelKey = new javax.swing.JLabel();
        bookKeyInputTextField = new javax.swing.JTextField();
        labelAuthor = new javax.swing.JLabel();
        bookAuthorInputTextField = new javax.swing.JTextField();
        labelTitle = new javax.swing.JLabel();
        bookTitleInputTextField = new javax.swing.JTextField();
        labelPublisher = new javax.swing.JLabel();
        bookPublisherInputTextField = new javax.swing.JTextField();
        labelYear = new javax.swing.JLabel();
        bookYearInputTextField = new javax.swing.JTextField();
        bookAddButton = new javax.swing.JButton();
        labelOptionalFieldsHeader = new javax.swing.JLabel();
        labelVolume = new javax.swing.JLabel();
        bookOptionalVolumeField = new javax.swing.JTextField();
        labelSeries = new javax.swing.JLabel();
        bookOptionalSeriesField = new javax.swing.JTextField();
        labelAddress = new javax.swing.JLabel();
        bookOptionalAddressField = new javax.swing.JTextField();
        labelEdition = new javax.swing.JLabel();
        bookOptionalEditionField = new javax.swing.JTextField();
        labelMonth = new javax.swing.JLabel();
        labelNote = new javax.swing.JLabel();
        bookOptionalNoteField = new javax.swing.JTextField();
        bookOptionalMonthCombobox = new javax.swing.JComboBox();
        panelArticle = new javax.swing.JPanel();
        labelKey1 = new javax.swing.JLabel();
        articleKeyInputTextField = new javax.swing.JTextField();
        labelAuthor1 = new javax.swing.JLabel();
        articleAuthorInputTextField = new javax.swing.JTextField();
        labelTitle1 = new javax.swing.JLabel();
        articleTitleInputTextField = new javax.swing.JTextField();
        articleJournalInputTextField = new javax.swing.JTextField();
        labelPublisher1 = new javax.swing.JLabel();
        labelYear1 = new javax.swing.JLabel();
        articleYearInputTextField = new javax.swing.JTextField();
        articleVolumeField = new javax.swing.JTextField();
        labelOptionalFieldsHeader1 = new javax.swing.JLabel();
        labelVolume1 = new javax.swing.JLabel();
        labelSeries1 = new javax.swing.JLabel();
        articleOptionalNumberField = new javax.swing.JTextField();
        articleOptionalPagesField = new javax.swing.JTextField();
        labelAddress1 = new javax.swing.JLabel();
        articleOptionalMonthCombobox = new javax.swing.JComboBox();
        labelMonth1 = new javax.swing.JLabel();
        labelNote1 = new javax.swing.JLabel();
        articleOptionalNoteField = new javax.swing.JTextField();
        articleAddButton = new javax.swing.JButton();
        panelInproceedings = new javax.swing.JPanel();
        inproceedingsIncoming = new javax.swing.JLabel();
        inproceedingsAddButton = new javax.swing.JButton();
        panelReferenceList = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        listRefereces = new javax.swing.JList();
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

        labelAuthor.setText("Author:");

        labelTitle.setText("Title:");

        labelPublisher.setText("Publisher:");

        labelYear.setText("Year:");

        bookAddButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/reference_add.png"))); // NOI18N
        bookAddButton.setText("Add");
        bookAddButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bookAddButtonActionPerformed(evt);
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

        bookOptionalMonthCombobox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "NaN", "jan", "feb", "mar", "apr", "may", "jun", "jul", "aug", "sep", "oct", "nov", "dec" }));

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
                        .addComponent(bookAddButton))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBookLayout.createSequentialGroup()
                        .addGroup(panelBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelBookLayout.createSequentialGroup()
                                .addGroup(panelBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(labelAuthor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(labelTitle, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(labelKey, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(labelPublisher, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE))
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
                            .addComponent(bookKeyInputTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)
                            .addComponent(bookAuthorInputTextField)
                            .addComponent(bookTitleInputTextField)
                            .addComponent(bookPublisherInputTextField)
                            .addComponent(bookYearInputTextField)
                            .addComponent(bookOptionalVolumeField)
                            .addComponent(bookOptionalSeriesField)
                            .addComponent(bookOptionalAddressField)
                            .addComponent(bookOptionalEditionField)
                            .addComponent(bookOptionalNoteField)
                            .addComponent(bookOptionalMonthCombobox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        panelBookLayout.setVerticalGroup(
            panelBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBookLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelKey)
                    .addComponent(bookKeyInputTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelAuthor)
                    .addComponent(bookAuthorInputTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelTitle)
                    .addComponent(bookTitleInputTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelPublisher)
                    .addComponent(bookPublisherInputTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelYear)
                    .addComponent(bookYearInputTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelOptionalFieldsHeader)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelVolume)
                    .addComponent(bookOptionalVolumeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelSeries)
                    .addComponent(bookOptionalSeriesField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelAddress)
                    .addComponent(bookOptionalAddressField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelEdition)
                    .addComponent(bookOptionalEditionField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelMonth)
                    .addComponent(bookOptionalMonthCombobox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelNote)
                    .addComponent(bookOptionalNoteField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                .addComponent(bookAddButton)
                .addContainerGap())
        );

        tabbedPanel.addTab("Book", panelBook);

        labelKey1.setText("Key:");

        labelAuthor1.setText("Author:");

        labelTitle1.setText("Title:");

        labelPublisher1.setText("Journal:");

        labelYear1.setText("Year:");

        labelOptionalFieldsHeader1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        labelOptionalFieldsHeader1.setText("Optional fields:");

        labelVolume1.setText("Volume:");

        labelSeries1.setText("Number");

        labelAddress1.setText("Pages:");

        articleOptionalMonthCombobox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "NaN", "jan", "feb", "mar", "apr", "may", "jun", "jul", "aug", "sep", "oct", "nov", "dec" }));

        labelMonth1.setText("Month:");

        labelNote1.setText("Note:");

        articleAddButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/reference_add.png"))); // NOI18N
        articleAddButton.setText("Add");
        articleAddButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                articleAddButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelArticleLayout = new javax.swing.GroupLayout(panelArticle);
        panelArticle.setLayout(panelArticleLayout);
        panelArticleLayout.setHorizontalGroup(
            panelArticleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelArticleLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelArticleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelOptionalFieldsHeader1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelArticleLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(articleAddButton))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelArticleLayout.createSequentialGroup()
                        .addGroup(panelArticleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelArticleLayout.createSequentialGroup()
                                .addGroup(panelArticleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(labelAuthor1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(labelTitle1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(labelKey1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(labelPublisher1, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(panelArticleLayout.createSequentialGroup()
                                .addComponent(labelYear1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(16, 16, 16))
                            .addGroup(panelArticleLayout.createSequentialGroup()
                                .addGroup(panelArticleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(labelVolume1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(labelAddress1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(labelSeries1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(labelMonth1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(labelNote1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(panelArticleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(articleKeyInputTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)
                            .addComponent(articleAuthorInputTextField)
                            .addComponent(articleTitleInputTextField)
                            .addComponent(articleJournalInputTextField)
                            .addComponent(articleYearInputTextField)
                            .addComponent(articleVolumeField)
                            .addComponent(articleOptionalNumberField)
                            .addComponent(articleOptionalPagesField)
                            .addComponent(articleOptionalNoteField)
                            .addComponent(articleOptionalMonthCombobox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        panelArticleLayout.setVerticalGroup(
            panelArticleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelArticleLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelArticleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelKey1)
                    .addComponent(articleKeyInputTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelArticleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelAuthor1)
                    .addComponent(articleAuthorInputTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelArticleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelTitle1)
                    .addComponent(articleTitleInputTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelArticleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelPublisher1)
                    .addComponent(articleJournalInputTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelArticleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelYear1)
                    .addComponent(articleYearInputTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelArticleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelVolume1)
                    .addComponent(articleVolumeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelOptionalFieldsHeader1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelArticleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelSeries1)
                    .addComponent(articleOptionalNumberField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelArticleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelAddress1)
                    .addComponent(articleOptionalPagesField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelArticleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelMonth1)
                    .addComponent(articleOptionalMonthCombobox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelArticleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelNote1)
                    .addComponent(articleOptionalNoteField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 82, Short.MAX_VALUE)
                .addComponent(articleAddButton)
                .addContainerGap())
        );

        tabbedPanel.addTab("Article", panelArticle);

        inproceedingsIncoming.setText("Coming soon...");

        inproceedingsAddButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/reference_add.png"))); // NOI18N
        inproceedingsAddButton.setText("Add");
        inproceedingsAddButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inproceedingsAddButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelInproceedingsLayout = new javax.swing.GroupLayout(panelInproceedings);
        panelInproceedings.setLayout(panelInproceedingsLayout);
        panelInproceedingsLayout.setHorizontalGroup(
            panelInproceedingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInproceedingsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(inproceedingsIncoming)
                .addContainerGap(280, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelInproceedingsLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(inproceedingsAddButton)
                .addContainerGap())
        );
        panelInproceedingsLayout.setVerticalGroup(
            panelInproceedingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInproceedingsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(inproceedingsIncoming)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 387, Short.MAX_VALUE)
                .addComponent(inproceedingsAddButton)
                .addContainerGap())
        );

        tabbedPanel.addTab("Inproceedings", panelInproceedings);

        listRefereces.setModel(new DefaultListModel<>()

        );
        listRefereces.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        listRefereces.setCellRenderer(new BibTeXEntryListRenderer());
        listRefereces.setFixedCellHeight(25);
        listRefereces.setSelectionBackground(new Color(204, 217, 244));
        listRefereces.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listReferecesValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(listRefereces);
        listRefereces.getAccessibleContext().setAccessibleName("");

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
                        .addComponent(labelSelectedItem, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
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
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 435, Short.MAX_VALUE)
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelReferenceList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tabbedPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 476, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bookAddButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bookAddButtonActionPerformed
        String[] bookParams = new String[] {
            getTextFromField(this.bookKeyInputTextField),
            getTextFromField(this.bookAuthorInputTextField),
            getTextFromField(this.bookTitleInputTextField),
            getTextFromField(this.bookPublisherInputTextField),
            getTextFromField(this.bookYearInputTextField)
        };

        handleOneBook(bookParams);
    }//GEN-LAST:event_bookAddButtonActionPerformed

    private void clearFields() {
        clearTextField(bookAuthorInputTextField);
        clearTextField(bookKeyInputTextField);
        clearTextField(bookPublisherInputTextField);
        clearTextField(bookYearInputTextField);
        clearTextField(bookTitleInputTextField);

        clearTextField(bookOptionalAddressField);
        clearTextField(bookOptionalEditionField);
        clearTextField(bookOptionalNoteField);
        clearTextField(bookOptionalSeriesField);
        clearTextField(bookOptionalVolumeField);

        bookOptionalMonthCombobox.setSelectedIndex(0); // 0 is the index for NaN

        clearTextField(articleKeyInputTextField);
        clearTextField(articleAuthorInputTextField);
        clearTextField(articleTitleInputTextField);
        clearTextField(articleJournalInputTextField);
        clearTextField(articleYearInputTextField);
        clearTextField(articleVolumeField);

        clearTextField(articleOptionalPagesField);
        clearTextField(articleOptionalNumberField);
        clearTextField(articleOptionalNoteField);

        articleOptionalMonthCombobox.setSelectedIndex(0); // 0 is the index for NaN
    }

    private void jMenuItemExportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemExportActionPerformed
        try {
            BibExporter.export(database.getDB());
        } catch(UnsupportedEncodingException ex) {
            appendToOutput("UnsupportedEncoding: Failed to export");
        } catch(IOException ex) {
            appendToOutput("IOException: Failed to export");
        }
    }//GEN-LAST:event_jMenuItemExportActionPerformed

    private void jMenuItemLoadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemLoadActionPerformed
        try {
            database.setDB(BibImporter.importFromBib());
        } catch(ObjectResolutionException|ParseException|IOException ex) {
            appendToOutput("Could not load the database.");
        } finally {
            updateReferenceList();
        }
    }//GEN-LAST:event_jMenuItemLoadActionPerformed

    private void jMenuItemSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemSaveActionPerformed
        // kun tallennetaan nykyinen tietokanta
        try {
            BibExporter.export(database.getDB());
        } catch(UnsupportedEncodingException ex) {
            appendToOutput("UnsupportedEncoding: Failed to save");
        } catch(IOException ex) {
            appendToOutput("IOException: Failed to save");
        }
    }//GEN-LAST:event_jMenuItemSaveActionPerformed

    private void buttonEditSelectedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonEditSelectedActionPerformed
        // -1 index indicates that "nothing is selected"
        if(this.listRefereces.getSelectedIndex()!=-1) {
            BibTeXEntry chosenReference = (BibTeXEntry) this.listRefereces.getSelectedValue();
            showEditWindow(chosenReference);
        }

        // TODO - reference type directs you to different kind of forms

    }//GEN-LAST:event_buttonEditSelectedActionPerformed

    private void showEditWindow(final BibTeXEntry selected) {
        BookEditWindow dialog = new BookEditWindow(this, true, selected);
        dialog.setVisible(true);
    }

    private void buttonDeleteSelectedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDeleteSelectedActionPerformed
        // -1 index indicates that "nothing is selected"
        if(this.listRefereces.getSelectedIndex()!=-1) {
            BibTeXEntry chosenReference = (BibTeXEntry) this.listRefereces.getSelectedValue();
            database.deleteReference(chosenReference.getKey(), chosenReference.getType());
            this.updateReferenceList();
            errorMessageArea.append("\n> Database has now "+database.getAllSavedReferences().size()+" items.");
        }
    }//GEN-LAST:event_buttonDeleteSelectedActionPerformed

    private void listReferecesValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listReferecesValueChanged
        if(this.listRefereces.getSelectedIndex()==-1) {
            this.labelSelectedItem.setText("Selected item");
        } else {
            BibTeXEntry reference = (BibTeXEntry) this.listRefereces.getSelectedValue();
            this.labelSelectedItem.setText("Selected: "+reference.getKey().toString());
        }
    }//GEN-LAST:event_listReferecesValueChanged

    private void articleAddButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_articleAddButtonActionPerformed
        String[] articleParams = new String[] {
            getTextFromField(this.articleKeyInputTextField),
            getTextFromField(this.articleAuthorInputTextField),
            getTextFromField(this.articleTitleInputTextField),
            getTextFromField(this.articleJournalInputTextField),
            getTextFromField(this.articleYearInputTextField),
            getTextFromField(this.articleVolumeField)
        };

        handleOneArticle(articleParams);
    }//GEN-LAST:event_articleAddButtonActionPerformed

    private void inproceedingsAddButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inproceedingsAddButtonActionPerformed
        // TODO inproceedings, tulee myöhemmin kun article voidaan oikeasti lisätä
    }//GEN-LAST:event_inproceedingsAddButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton articleAddButton;
    private javax.swing.JTextField articleAuthorInputTextField;
    private javax.swing.JTextField articleJournalInputTextField;
    private javax.swing.JTextField articleKeyInputTextField;
    private javax.swing.JComboBox articleOptionalMonthCombobox;
    private javax.swing.JTextField articleOptionalNoteField;
    private javax.swing.JTextField articleOptionalNumberField;
    private javax.swing.JTextField articleOptionalPagesField;
    private javax.swing.JTextField articleTitleInputTextField;
    private javax.swing.JTextField articleVolumeField;
    private javax.swing.JTextField articleYearInputTextField;
    private javax.swing.JButton bookAddButton;
    private javax.swing.JTextField bookAuthorInputTextField;
    private javax.swing.JTextField bookKeyInputTextField;
    private javax.swing.JTextField bookOptionalAddressField;
    private javax.swing.JTextField bookOptionalEditionField;
    private javax.swing.JComboBox bookOptionalMonthCombobox;
    private javax.swing.JTextField bookOptionalNoteField;
    private javax.swing.JTextField bookOptionalSeriesField;
    private javax.swing.JTextField bookOptionalVolumeField;
    private javax.swing.JTextField bookPublisherInputTextField;
    private javax.swing.JTextField bookTitleInputTextField;
    private javax.swing.JTextField bookYearInputTextField;
    private javax.swing.JButton buttonDeleteSelected;
    private javax.swing.JButton buttonEditSelected;
    private javax.swing.JTextArea errorMessageArea;
    private javax.swing.JButton inproceedingsAddButton;
    private javax.swing.JLabel inproceedingsIncoming;
    private javax.swing.JMenuBar jMenuBar;
    private javax.swing.JMenu jMenuFile;
    private javax.swing.JMenuItem jMenuItemExport;
    private javax.swing.JMenuItem jMenuItemLoad;
    private javax.swing.JMenuItem jMenuItemSave;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel labelAddress;
    private javax.swing.JLabel labelAddress1;
    private javax.swing.JLabel labelAuthor;
    private javax.swing.JLabel labelAuthor1;
    private javax.swing.JLabel labelEdition;
    private javax.swing.JLabel labelKey;
    private javax.swing.JLabel labelKey1;
    private javax.swing.JLabel labelMonth;
    private javax.swing.JLabel labelMonth1;
    private javax.swing.JLabel labelNote;
    private javax.swing.JLabel labelNote1;
    private javax.swing.JLabel labelOptionalFieldsHeader;
    private javax.swing.JLabel labelOptionalFieldsHeader1;
    private javax.swing.JLabel labelPublisher;
    private javax.swing.JLabel labelPublisher1;
    private javax.swing.JLabel labelSelectedItem;
    private javax.swing.JLabel labelSeries;
    private javax.swing.JLabel labelSeries1;
    private javax.swing.JLabel labelTitle;
    private javax.swing.JLabel labelTitle1;
    private javax.swing.JLabel labelVolume;
    private javax.swing.JLabel labelVolume1;
    private javax.swing.JLabel labelYear;
    private javax.swing.JLabel labelYear1;
    private javax.swing.JList listRefereces;
    private javax.swing.JPanel panelArticle;
    private javax.swing.JPanel panelBook;
    private javax.swing.JPanel panelInproceedings;
    private javax.swing.JPanel panelReferenceList;
    private javax.swing.JTabbedPane tabbedPanel;
    // End of variables declaration//GEN-END:variables

    private void clearTextField(JTextField field) {
        field.setText("");
    }

    public void appendToOutput(String text) {
        this.errorMessageArea.append("\n> "+text);
    }

    public void updateReferenceList() {
        List<BibTeXEntry> allSavedReferences = this.database.getAllSavedReferences();
        listRefereces.setListData(allSavedReferences.toArray());
    }

    private void handleOneArticle(String[] articleParams) {
        // TODO

        this.appendToOutput("Handle one article with params: "+Arrays.toString(articleParams));
    }

    private void handleOneBook(String[] bookParams) {
        bookValidator.isValidParams(bookParams);
        // TODO: Optional fieldeille oma validaattori

        if(!bookValidator.hasErrors()) {
            errorMessageArea.append("\n> Input was valid.");

            BibTeXEntry addableReference = BookFactory.createBook(bookParams);

            addOptionalBookFields(addableReference);
            database.saveReference(addableReference);

            updateReferenceList();
            clearFields();

            errorMessageArea.append("\n> Database has now "+database.getAllSavedReferences().size()+" items.");
        } else {
            JOptionPane.showMessageDialog(this, bookValidator.fullErrors());
        }

    }

    private String getTextFromField(JTextField field) {
        return field.getText();
    }

    private void addOptionalBookFields(BibTeXEntry reference) {
        if(!bookOptionalVolumeField.getText().isEmpty()) {
            reference.addField(BibTeXEntry.KEY_VOLUME,
                    new DigitStringValue(bookOptionalVolumeField.getText())
            );
        }

        if(!bookOptionalSeriesField.getText().isEmpty()) {
            reference.addField(BibTeXEntry.KEY_SERIES,
                    new StringValue(bookOptionalSeriesField.getText(), Style.BRACED)
            );
        }

        if(!bookOptionalAddressField.getText().isEmpty()) {
            reference.addField(BibTeXEntry.KEY_ADDRESS,
                    new StringValue(bookOptionalAddressField.getText(), Style.BRACED)
            );
        }

        if(!bookOptionalEditionField.getText().isEmpty()) {
            reference.addField(BibTeXEntry.KEY_EDITION,
                    new StringValue(bookOptionalEditionField.getText(), Style.BRACED)
            );
        }

        // 0 is the index for NaN
        if(this.bookOptionalMonthCombobox.getSelectedIndex()!=0) {
            reference.addField(BibTeXEntry.KEY_MONTH,
                    new StringValue(bookOptionalMonthCombobox.getSelectedItem().toString(), Style.BRACED)
            );
        }

        if(!bookOptionalNoteField.getText().isEmpty()) {
            reference.addField(BibTeXEntry.KEY_NOTE,
                    new StringValue(bookOptionalNoteField.getText(), Style.BRACED)
            );
        }
    }
}
