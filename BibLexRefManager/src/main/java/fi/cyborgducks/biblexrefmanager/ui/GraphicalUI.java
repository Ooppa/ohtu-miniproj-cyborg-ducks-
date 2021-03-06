/*
 * Miniprojekti Ohjelmistotuotanto kevät 2015
 * Helsingin yliopisto Tietojenkäsittelytieteen laitos
 * Cyborg Ducks 2015 - GNU General Public License, version 3.
 */
package fi.cyborgducks.biblexrefmanager.ui;

import fi.cyborgducks.biblexrefmanager.data.*;
import fi.cyborgducks.biblexrefmanager.factory.ReferenceFactory;
import fi.cyborgducks.biblexrefmanager.helpers.BibTexDataTransferHelper;
import fi.cyborgducks.biblexrefmanager.validators.ArticleValidator;
import fi.cyborgducks.biblexrefmanager.validators.BookValidator;
import fi.cyborgducks.biblexrefmanager.validators.InproceedingsValidator;
import fi.cyborgducks.biblexrefmanager.validators.Validator;
import java.awt.Color;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import org.jbibtex.*;
import org.jbibtex.StringValue.Style;

public class GraphicalUI extends javax.swing.JFrame {

    private Validator bookValidator;
    private Validator articleValidator;
    private Validator inproceedingsValidator;

    private Database database;

    /**
     * Creates new form GraphicalUI
     */
    public GraphicalUI() {
        initComponents();
        setLocationRelativeTo(null); // Centered to screen

        this.database = new InMemoryDatabase();
        this.bookValidator = new BookValidator();
        this.articleValidator = new ArticleValidator();
        this.inproceedingsValidator = new InproceedingsValidator();
        updateReferenceList();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        outputMessageArea = new javax.swing.JTextArea();
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
        labelOptionalFieldsHeaderForBook = new javax.swing.JLabel();
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
        labelOptionalFieldsHeaderForArticle = new javax.swing.JLabel();
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
        inproceedingsAddButton = new javax.swing.JButton();
        inproceedingsLabelKey = new javax.swing.JLabel();
        inproceedingsLabelAuthor = new javax.swing.JLabel();
        inproceedingsLabelTitle = new javax.swing.JLabel();
        inproceedingsLabelBookTitle = new javax.swing.JLabel();
        inproceedingsLabelYear = new javax.swing.JLabel();
        inproceedingsLabelSeries = new javax.swing.JLabel();
        inproceedingsOptionalFieldsHeader = new javax.swing.JLabel();
        inproceedingsLabelEditor = new javax.swing.JLabel();
        inproceedingsLabelAddress = new javax.swing.JLabel();
        inproceedingsLabelPublisher = new javax.swing.JLabel();
        inproceedingsLabelOrganization = new javax.swing.JLabel();
        inproceedingsLabelMonth = new javax.swing.JLabel();
        inproceedingsLabelVolume = new javax.swing.JLabel();
        inproceedingsLabelPages = new javax.swing.JLabel();
        inproceedingsLabelNote = new javax.swing.JLabel();
        inproceedingsOptionalNoteField = new javax.swing.JTextField();
        inproceedingsOptionalMonthCombobox = new javax.swing.JComboBox();
        inproceedingsOptionalVolumeField = new javax.swing.JTextField();
        inproceedingsOptionalEditorField = new javax.swing.JTextField();
        inproceedingsOptionalSeriesField = new javax.swing.JTextField();
        inproceedingsYearInputTextField = new javax.swing.JTextField();
        inproceedingsBookTitleInputTextField = new javax.swing.JTextField();
        inproceedingsTitleInputTextField = new javax.swing.JTextField();
        inproceedingsAuthorInputTextField = new javax.swing.JTextField();
        inproceedingsKeyInputTextField = new javax.swing.JTextField();
        inproceedingsOptionalPagesField = new javax.swing.JTextField();
        inproceedingsOptionalAddressField = new javax.swing.JTextField();
        inproceedingsOptionalOrganizationField = new javax.swing.JTextField();
        inproceedingsOptionalPublisherField = new javax.swing.JTextField();
        panelReferenceList = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        listRefereces = new javax.swing.JList();
        labelSelectedItem = new javax.swing.JLabel();
        buttonDeleteSelected = new javax.swing.JButton();
        buttonEditSelected = new javax.swing.JButton();
        jMenuBar = new javax.swing.JMenuBar();
        jMenuFile = new javax.swing.JMenu();
        jMenuItemNew = new javax.swing.JMenuItem();
        jMenuItemSave = new javax.swing.JMenuItem();
        jMenuItemLoad = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        outputMessageArea.setEditable(false);
        outputMessageArea.setColumns(20);
        outputMessageArea.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        outputMessageArea.setRows(5);
        outputMessageArea.setText("> Welcome");
        outputMessageArea.setToolTipText("");
        outputMessageArea.setBorder(javax.swing.BorderFactory.createTitledBorder("Output"));
        jScrollPane1.setViewportView(outputMessageArea);

        tabbedPanel.setToolTipText("");

        labelKey.setText("Key:");

        labelAuthor.setText("Author:");

        labelTitle.setText("Title:");

        labelPublisher.setText("Publisher:");
        labelPublisher.setDoubleBuffered(true);

        labelYear.setText("Year:");

        bookAddButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/reference_add.png"))); // NOI18N
        bookAddButton.setText("Add");
        bookAddButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bookAddButtonActionPerformed(evt);
            }
        });

        labelOptionalFieldsHeaderForBook.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        labelOptionalFieldsHeaderForBook.setText("Optional fields:");

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
                    .addComponent(labelOptionalFieldsHeaderForBook, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addComponent(labelOptionalFieldsHeaderForBook)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bookAddButton)
                .addContainerGap())
        );

        tabbedPanel.addTab("Book", panelBook);

        labelKey1.setText("Key:");

        labelAuthor1.setText("Author:");

        labelTitle1.setText("Title:");

        labelPublisher1.setText("Journal:");

        labelYear1.setText("Year:");

        labelOptionalFieldsHeaderForArticle.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        labelOptionalFieldsHeaderForArticle.setText("Optional fields:");

        labelVolume1.setText("Volume:");

        labelSeries1.setText("Number:");

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
                    .addComponent(labelOptionalFieldsHeaderForArticle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                            .addComponent(articleAuthorInputTextField)
                            .addComponent(articleTitleInputTextField)
                            .addComponent(articleJournalInputTextField)
                            .addComponent(articleYearInputTextField)
                            .addComponent(articleVolumeField)
                            .addComponent(articleOptionalNumberField)
                            .addComponent(articleOptionalPagesField)
                            .addComponent(articleOptionalNoteField)
                            .addComponent(articleOptionalMonthCombobox, 0, 205, Short.MAX_VALUE)
                            .addComponent(articleKeyInputTextField, javax.swing.GroupLayout.Alignment.TRAILING))))
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
                .addComponent(labelOptionalFieldsHeaderForArticle)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 152, Short.MAX_VALUE)
                .addComponent(articleAddButton)
                .addContainerGap())
        );

        tabbedPanel.addTab("Article", panelArticle);

        inproceedingsAddButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/reference_add.png"))); // NOI18N
        inproceedingsAddButton.setText("Add");
        inproceedingsAddButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inproceedingsAddButtonActionPerformed(evt);
            }
        });

        inproceedingsLabelKey.setText("Key:");

        inproceedingsLabelAuthor.setText("Author:");

        inproceedingsLabelTitle.setText("Title:");

        inproceedingsLabelBookTitle.setText("Book title:");

        inproceedingsLabelYear.setText("Year:");

        inproceedingsLabelSeries.setText("Series:");

        inproceedingsOptionalFieldsHeader.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        inproceedingsOptionalFieldsHeader.setText("Optional fields:");

        inproceedingsLabelEditor.setText("Editor:");

        inproceedingsLabelAddress.setText("Address:");

        inproceedingsLabelPublisher.setText("Publisher:");

        inproceedingsLabelOrganization.setText("Organization:");

        inproceedingsLabelMonth.setText("Month:");

        inproceedingsLabelVolume.setText("Volume/Number:");

        inproceedingsLabelPages.setText("Pages:");

        inproceedingsLabelNote.setText("Note:");

        inproceedingsOptionalMonthCombobox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "NaN", "jan", "feb", "mar", "apr", "may", "jun", "jul", "aug", "sep", "oct", "nov", "dec" }));

        javax.swing.GroupLayout panelInproceedingsLayout = new javax.swing.GroupLayout(panelInproceedings);
        panelInproceedings.setLayout(panelInproceedingsLayout);
        panelInproceedingsLayout.setHorizontalGroup(
            panelInproceedingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInproceedingsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelInproceedingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(inproceedingsOptionalFieldsHeader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelInproceedingsLayout.createSequentialGroup()
                        .addGroup(panelInproceedingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(inproceedingsLabelYear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(inproceedingsLabelAuthor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(inproceedingsLabelTitle, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(inproceedingsLabelKey, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(inproceedingsLabelBookTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(panelInproceedingsLayout.createSequentialGroup()
                                .addGroup(panelInproceedingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(inproceedingsLabelSeries, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(inproceedingsLabelVolume, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
                                    .addComponent(inproceedingsLabelPages, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(inproceedingsLabelAddress, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(inproceedingsLabelEditor, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelInproceedingsLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(inproceedingsLabelMonth, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelInproceedingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelInproceedingsLayout.createSequentialGroup()
                                .addGap(134, 134, 134)
                                .addComponent(inproceedingsAddButton)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(inproceedingsTitleInputTextField)
                            .addComponent(inproceedingsBookTitleInputTextField)
                            .addComponent(inproceedingsYearInputTextField)
                            .addComponent(inproceedingsOptionalSeriesField)
                            .addComponent(inproceedingsOptionalEditorField)
                            .addComponent(inproceedingsOptionalVolumeField)
                            .addComponent(inproceedingsOptionalMonthCombobox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(inproceedingsOptionalPagesField, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(inproceedingsOptionalAddressField, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(inproceedingsKeyInputTextField, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(inproceedingsAuthorInputTextField, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelInproceedingsLayout.createSequentialGroup()
                        .addComponent(inproceedingsLabelNote, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(inproceedingsOptionalNoteField, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelInproceedingsLayout.createSequentialGroup()
                        .addGroup(panelInproceedingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(inproceedingsLabelOrganization, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(inproceedingsLabelPublisher, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelInproceedingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(inproceedingsOptionalPublisherField)
                            .addComponent(inproceedingsOptionalOrganizationField))))
                .addContainerGap())
        );
        panelInproceedingsLayout.setVerticalGroup(
            panelInproceedingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInproceedingsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelInproceedingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inproceedingsLabelKey)
                    .addComponent(inproceedingsKeyInputTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelInproceedingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inproceedingsLabelAuthor)
                    .addComponent(inproceedingsAuthorInputTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelInproceedingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inproceedingsLabelTitle)
                    .addComponent(inproceedingsTitleInputTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelInproceedingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inproceedingsLabelBookTitle)
                    .addComponent(inproceedingsBookTitleInputTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelInproceedingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inproceedingsLabelYear)
                    .addComponent(inproceedingsYearInputTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(inproceedingsOptionalFieldsHeader)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelInproceedingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelInproceedingsLayout.createSequentialGroup()
                        .addGroup(panelInproceedingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(inproceedingsLabelEditor)
                            .addComponent(inproceedingsOptionalEditorField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelInproceedingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(inproceedingsLabelVolume)
                            .addComponent(inproceedingsOptionalVolumeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelInproceedingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(inproceedingsLabelSeries)
                            .addComponent(inproceedingsOptionalSeriesField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelInproceedingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(inproceedingsOptionalPagesField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(inproceedingsLabelPages))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelInproceedingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(inproceedingsOptionalAddressField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(inproceedingsLabelAddress))
                        .addGap(29, 29, 29))
                    .addGroup(panelInproceedingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(inproceedingsOptionalMonthCombobox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(inproceedingsLabelMonth)))
                .addGroup(panelInproceedingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(inproceedingsLabelOrganization)
                    .addGroup(panelInproceedingsLayout.createSequentialGroup()
                        .addComponent(inproceedingsOptionalOrganizationField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelInproceedingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(inproceedingsOptionalPublisherField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(inproceedingsLabelPublisher))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelInproceedingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inproceedingsOptionalNoteField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inproceedingsLabelNote))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
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

        javax.swing.GroupLayout panelReferenceListLayout = new javax.swing.GroupLayout(panelReferenceList);
        panelReferenceList.setLayout(panelReferenceListLayout);
        panelReferenceListLayout.setHorizontalGroup(
            panelReferenceListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelReferenceListLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 309, Short.MAX_VALUE))
        );
        panelReferenceListLayout.setVerticalGroup(
            panelReferenceListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelReferenceListLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 477, Short.MAX_VALUE))
        );

        labelSelectedItem.setFont(new java.awt.Font("Tahoma", 2, 10)); // NOI18N
        labelSelectedItem.setForeground(new java.awt.Color(153, 153, 153));
        labelSelectedItem.setText("Selected Item");

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

        jMenuFile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/table.png"))); // NOI18N
        jMenuFile.setText("File");

        jMenuItemNew.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/table_add.png"))); // NOI18N
        jMenuItemNew.setText("New Database");
        jMenuItemNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemNewActionPerformed(evt);
            }
        });
        jMenuFile.add(jMenuItemNew);

        jMenuItemSave.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/table_save.png"))); // NOI18N
        jMenuItemSave.setText("Export as .bib");
        jMenuItemSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemSaveActionPerformed(evt);
            }
        });
        jMenuFile.add(jMenuItemSave);

        jMenuItemLoad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/folder_table.png"))); // NOI18N
        jMenuItemLoad.setText("Import as .bib");
        jMenuItemLoad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemLoadActionPerformed(evt);
            }
        });
        jMenuFile.add(jMenuItemLoad);

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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(panelReferenceList, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(labelSelectedItem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(buttonEditSelected, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(buttonDeleteSelected, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panelReferenceList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelSelectedItem, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buttonEditSelected)
                            .addComponent(buttonDeleteSelected)))
                    .addComponent(tabbedPanel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
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

        clearTextField(inproceedingsKeyInputTextField);
        clearTextField(inproceedingsAuthorInputTextField);
        clearTextField(inproceedingsBookTitleInputTextField);
        clearTextField(inproceedingsYearInputTextField);
        clearTextField(inproceedingsTitleInputTextField);

        clearTextField(inproceedingsOptionalAddressField);
        clearTextField(inproceedingsOptionalEditorField);
        clearTextField(inproceedingsOptionalNoteField);
        clearTextField(inproceedingsOptionalOrganizationField);
        clearTextField(inproceedingsOptionalPagesField);
        clearTextField(inproceedingsOptionalPublisherField);
        clearTextField(inproceedingsOptionalSeriesField);
        clearTextField(inproceedingsOptionalVolumeField);

        inproceedingsOptionalMonthCombobox.setSelectedIndex(0); // 0 is the index for NaN
    }

    private void jMenuItemLoadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemLoadActionPerformed
        try {
            BibTeXDatabase db = BibTexDataTransferHelper.importFromBib();
            if(db!=null) {
                database.setDB(db);
            }
        } catch(ObjectResolutionException|ParseException|IOException ex) {
            appendToOutput("Could not load the database.");
        } finally {
            updateReferenceList();
        }
    }//GEN-LAST:event_jMenuItemLoadActionPerformed

    private void jMenuItemSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemSaveActionPerformed
        // kun tallennetaan nykyinen tietokanta
        try {
            BibTexDataTransferHelper.export(database.getDB());
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

    }//GEN-LAST:event_buttonEditSelectedActionPerformed

    private void showEditWindow(final BibTeXEntry selected) {

        if(selected.getType().equals(BibTeXEntry.TYPE_BOOK)) {
            BookEditWindow dialog = new BookEditWindow(this, true, selected);
            dialog.setVisible(true);
        }
        if(selected.getType().equals(BibTeXEntry.TYPE_ARTICLE)) {
            ArticleEditWindow dialog = new ArticleEditWindow(this, true, selected);
            dialog.setVisible(true);
        }
        if(selected.getType().equals(BibTeXEntry.TYPE_INPROCEEDINGS)) {
            InproceedingEditWindow dialog = new InproceedingEditWindow(this, rootPaneCheckingEnabled, selected);
            dialog.setVisible(true);
        }

    }

    private void buttonDeleteSelectedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDeleteSelectedActionPerformed
        // -1 index indicates that "nothing is selected"
        if(this.listRefereces.getSelectedIndex()!=-1) {
            BibTeXEntry chosenReference = (BibTeXEntry) this.listRefereces.getSelectedValue();
            database.deleteReference(chosenReference.getKey(), chosenReference.getType());
            this.updateReferenceList();
            appendDatabaseStatusToOutput();
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
            getTextFromField(articleKeyInputTextField),
            getTextFromField(articleAuthorInputTextField),
            getTextFromField(articleTitleInputTextField),
            getTextFromField(articleJournalInputTextField),
            getTextFromField(articleYearInputTextField),
            getTextFromField(articleVolumeField)
        };

        handleOneArticle(articleParams);
    }//GEN-LAST:event_articleAddButtonActionPerformed

    private void inproceedingsAddButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inproceedingsAddButtonActionPerformed
        String[] inproceedingsParams = new String[] {
            getTextFromField(inproceedingsKeyInputTextField),
            getTextFromField(inproceedingsTitleInputTextField),
            getTextFromField(inproceedingsBookTitleInputTextField),
            getTextFromField(inproceedingsYearInputTextField),};

        handleOneInproceeding(inproceedingsParams);
    }//GEN-LAST:event_inproceedingsAddButtonActionPerformed

    private void jMenuItemNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemNewActionPerformed
        // TODO: Add "Are you sure" dialog
        this.database = new InMemoryDatabase();
        updateReferenceList();
    }//GEN-LAST:event_jMenuItemNewActionPerformed

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
    private javax.swing.JButton inproceedingsAddButton;
    private javax.swing.JTextField inproceedingsAuthorInputTextField;
    private javax.swing.JTextField inproceedingsBookTitleInputTextField;
    private javax.swing.JTextField inproceedingsKeyInputTextField;
    private javax.swing.JLabel inproceedingsLabelAddress;
    private javax.swing.JLabel inproceedingsLabelAuthor;
    private javax.swing.JLabel inproceedingsLabelBookTitle;
    private javax.swing.JLabel inproceedingsLabelEditor;
    private javax.swing.JLabel inproceedingsLabelKey;
    private javax.swing.JLabel inproceedingsLabelMonth;
    private javax.swing.JLabel inproceedingsLabelNote;
    private javax.swing.JLabel inproceedingsLabelOrganization;
    private javax.swing.JLabel inproceedingsLabelPages;
    private javax.swing.JLabel inproceedingsLabelPublisher;
    private javax.swing.JLabel inproceedingsLabelSeries;
    private javax.swing.JLabel inproceedingsLabelTitle;
    private javax.swing.JLabel inproceedingsLabelVolume;
    private javax.swing.JLabel inproceedingsLabelYear;
    private javax.swing.JTextField inproceedingsOptionalAddressField;
    private javax.swing.JTextField inproceedingsOptionalEditorField;
    private javax.swing.JLabel inproceedingsOptionalFieldsHeader;
    private javax.swing.JComboBox inproceedingsOptionalMonthCombobox;
    private javax.swing.JTextField inproceedingsOptionalNoteField;
    private javax.swing.JTextField inproceedingsOptionalOrganizationField;
    private javax.swing.JTextField inproceedingsOptionalPagesField;
    private javax.swing.JTextField inproceedingsOptionalPublisherField;
    private javax.swing.JTextField inproceedingsOptionalSeriesField;
    private javax.swing.JTextField inproceedingsOptionalVolumeField;
    private javax.swing.JTextField inproceedingsTitleInputTextField;
    private javax.swing.JTextField inproceedingsYearInputTextField;
    private javax.swing.JMenuBar jMenuBar;
    private javax.swing.JMenu jMenuFile;
    private javax.swing.JMenuItem jMenuItemLoad;
    private javax.swing.JMenuItem jMenuItemNew;
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
    private javax.swing.JLabel labelOptionalFieldsHeaderForArticle;
    private javax.swing.JLabel labelOptionalFieldsHeaderForBook;
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
    private javax.swing.JTextArea outputMessageArea;
    private javax.swing.JPanel panelArticle;
    private javax.swing.JPanel panelBook;
    private javax.swing.JPanel panelInproceedings;
    private javax.swing.JPanel panelReferenceList;
    private javax.swing.JTabbedPane tabbedPanel;
    // End of variables declaration//GEN-END:variables

    private void clearTextField(JTextField field) {
        field.setText("");
    }

    /**
     * Appends to the output field found on the main window.
     *
     * @param text Text to output
     */
    public void appendToOutput(String text) {
        this.outputMessageArea.append("\n> "+text);
    }

    private void appendDatabaseStatusToOutput() {
        outputMessageArea.append("\n> Database has now "+database.getAllSavedReferences().size()+" items.");
    }

    public void updateReferenceList() {
        if(database.getDB()==null) {
            return;
        }

        List<BibTeXEntry> allSavedReferences = this.database.getAllSavedReferences();
        listRefereces.setListData(allSavedReferences.toArray());
    }

    private void handleOneArticle(String[] articleParams) {
        articleValidator.isValidParams(articleParams);
        if(!articleValidator.hasErrors()) {
            outputMessageArea.append("\n> Input was valid.");
            BibTeXEntry addableReference = ReferenceFactory.createArticle(articleParams);
            addOptionalArticleFields(addableReference);
            database.saveReference(addableReference);

            updateReferenceList();
            clearFields();
            appendDatabaseStatusToOutput();
        } else {
            JOptionPane.showMessageDialog(this, articleValidator.fullErrors());
        }
    }

    private void handleOneBook(String[] bookParams) {
        bookValidator.isValidParams(bookParams);

        if(!bookValidator.hasErrors()) {
            outputMessageArea.append("\n> Input was valid.");

            BibTeXEntry addableReference = ReferenceFactory.createBook(bookParams);

            addOptionalBookFields(addableReference);
            database.saveReference(addableReference);

            updateReferenceList();
            clearFields();

            appendDatabaseStatusToOutput();
        } else {
            JOptionPane.showMessageDialog(this, bookValidator.fullErrors());
        }

    }

    private void handleOneInproceeding(String[] inproceedingsParams) {
        inproceedingsValidator.isValidParams(inproceedingsParams);

        if(!inproceedingsValidator.hasErrors()) {
            outputMessageArea.append("\n> Input was valid.");
            BibTeXEntry addableReference = ReferenceFactory.createInproceedings(inproceedingsParams);
            addOptionalInproceedingFields(addableReference);
            database.saveReference(addableReference);

            updateReferenceList();
            clearFields();
            appendDatabaseStatusToOutput();
        } else {
            JOptionPane.showMessageDialog(this, inproceedingsValidator.fullErrors());
        }
    }

    private String getTextFromField(JTextField field) {
        return field.getText();
    }

    private void addOptionalBookFields(BibTeXEntry book) {
        if(!bookOptionalVolumeField.getText().isEmpty()) {
            book.addField(BibTeXEntry.KEY_VOLUME,
                    new DigitStringValue(bookOptionalVolumeField.getText())
            );
        }

        if(!bookOptionalSeriesField.getText().isEmpty()) {
            book.addField(BibTeXEntry.KEY_SERIES,
                    new StringValue(bookOptionalSeriesField.getText(), Style.BRACED)
            );
        }

        if(!bookOptionalAddressField.getText().isEmpty()) {
            book.addField(BibTeXEntry.KEY_ADDRESS,
                    new StringValue(bookOptionalAddressField.getText(), Style.BRACED)
            );
        }

        if(!bookOptionalEditionField.getText().isEmpty()) {
            book.addField(BibTeXEntry.KEY_EDITION,
                    new StringValue(bookOptionalEditionField.getText(), Style.BRACED)
            );
        }

        // 0 is the index for NaN
        if(this.bookOptionalMonthCombobox.getSelectedIndex()!=0) {
            book.addField(BibTeXEntry.KEY_MONTH,
                    new StringValue(bookOptionalMonthCombobox.getSelectedItem().toString(), Style.BRACED)
            );
        }

        if(!bookOptionalNoteField.getText().isEmpty()) {
            book.addField(BibTeXEntry.KEY_NOTE,
                    new StringValue(bookOptionalNoteField.getText(), Style.BRACED)
            );
        }
    }

    private void addOptionalArticleFields(BibTeXEntry article) {
        if(!articleOptionalNumberField.getText().isEmpty()) {
            article.addField(BibTeXEntry.KEY_NUMBER,
                    new StringValue(articleOptionalNumberField.getText(), Style.BRACED)
            );
        }
        if(!articleOptionalPagesField.getText().isEmpty()) {
            article.addField(BibTeXEntry.KEY_PAGES,
                    new StringValue(articleOptionalPagesField.getText(), Style.BRACED)
            );
        }
        if(articleOptionalMonthCombobox.getSelectedIndex()!=0) {
            article.addField(BibTeXEntry.KEY_MONTH,
                    new StringValue(articleOptionalMonthCombobox.getSelectedItem().toString(), Style.BRACED)
            );
        }
        if(!articleOptionalNoteField.getText().isEmpty()) {
            article.addField(BibTeXEntry.KEY_NOTE,
                    new StringValue(articleOptionalNoteField.getText(), Style.BRACED)
            );
        }
    }

    private void addOptionalInproceedingFields(BibTeXEntry inproceedings) {
        if(!inproceedingsOptionalAddressField.getText().isEmpty()) {
            inproceedings.addField(BibTeXEntry.KEY_ADDRESS, new StringValue(
                    inproceedingsOptionalAddressField.getText(), Style.BRACED)
            );
        }
        if(!inproceedingsOptionalEditorField.getText().isEmpty()) {
            inproceedings.addField(BibTeXEntry.KEY_EDITOR, new StringValue(
                    inproceedingsOptionalEditorField.getText(), Style.BRACED)
            );
        }
        if(!inproceedingsOptionalNoteField.getText().isEmpty()) {
            inproceedings.addField(BibTeXEntry.KEY_NOTE, new StringValue(
                    inproceedingsOptionalNoteField.getText(), Style.BRACED)
            );
        }
        if(!inproceedingsOptionalOrganizationField.getText().isEmpty()) {
            inproceedings.addField(BibTeXEntry.KEY_ORGANIZATION, new StringValue(
                    inproceedingsOptionalOrganizationField.getText(), Style.BRACED)
            );
        }
        if(!inproceedingsOptionalPagesField.getText().isEmpty()) {
            inproceedings.addField(BibTeXEntry.KEY_PAGES, new StringValue(
                    inproceedingsOptionalPagesField.getText(), Style.BRACED)
            );
        }
        if(!inproceedingsOptionalPublisherField.getText().isEmpty()) {
            inproceedings.addField(BibTeXEntry.KEY_PUBLISHER, new StringValue(
                    inproceedingsOptionalPublisherField.getText(), Style.BRACED)
            );
        }
        if(!inproceedingsOptionalSeriesField.getText().isEmpty()) {
            inproceedings.addField(BibTeXEntry.KEY_SERIES, new StringValue(
                    inproceedingsOptionalSeriesField.getText(), Style.BRACED)
            );
        }
        if(!inproceedingsOptionalVolumeField.getText().isEmpty()) {
            inproceedings.addField(BibTeXEntry.KEY_VOLUME, new StringValue(
                    inproceedingsOptionalVolumeField.getText(), Style.BRACED)
            );
        }
        if(inproceedingsOptionalMonthCombobox.getSelectedIndex()!=0) {
            inproceedings.addField(BibTeXEntry.KEY_MONTH, new StringValue(
                    inproceedingsOptionalMonthCombobox.getSelectedItem().toString(), Style.BRACED)
            );
        }
    }

}
