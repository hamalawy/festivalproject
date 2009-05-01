/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * GroupeListingPanel.java
 *
 * Created on 28-mars-2009, 18:23:30
 */
package View.groupe;

import Controller.Controller;
import Data.BDException;
import Data.Groupe;
import Data.GroupeID;
import Data.LoginException;
import Data.MembreGroupe;
import View.BarreInfo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author Cramike
 */
public class GroupeListingPanel extends javax.swing.JPanel {

    private Vector<String> vecGroupe = new Vector<String>();
    private Vector<MembreGroupe> vecMembre = new Vector<MembreGroupe>();
    private Vector<GroupeID> vecGroupeForList = new Vector<GroupeID>();
    private BarreInfo barreInfo;
    private ListeGroupeListener listeListener;
    private ButtonListener boutonListener = new ButtonListener(this);
    private GroupeID groupeEnCours;
    private int choixMembre; //Sert � savoir quel membre est affich� actuellement;

    /** Creates new form GroupeListingPanel */
    public GroupeListingPanel(BarreInfo barreInfo) {
        this.barreInfo = barreInfo;
        listeListener = new ListeGroupeListener();

        initComponents();
        listGroupe.addListSelectionListener(listeListener);
        listGroupe.setSelectedIndex(0);
        comboChoixMembre.addItemListener(new ComboMembreListener());

        //Gestion des boutons
        butPrecedent.addActionListener(boutonListener);
        butPrecedent.setEnabled(false);
        butSuivant.addActionListener(boutonListener);
        butSuivant.setEnabled(false);
        butAjouter.addActionListener(boutonListener);
        butSupprMembre.addActionListener(boutonListener);
        butModifier.addActionListener(boutonListener);
        butModifierGroupe.addActionListener(boutonListener);
        butSupprGroupe.addActionListener(boutonListener);


        //s'il n'y a aucun groupe, on d�sactive le bouton AjouterMembre
        if (listGroupe.getModel() == null) {
            butAjouter.setEnabled(false);
            butModifierGroupe.setEnabled(false);
            butSupprGroupe.setEnabled(false);
        } else {
            try {
                loadGroupe(Controller.getGroupeSelected(groupeEnCours));
            } catch (BDException ex) {
                setInfoText(ex.toString());
            } catch (LoginException ex) {
                setInfoText(ex.toString());
            }
        }
    }

    public BarreInfo getBarreInfo() {
        return barreInfo;
    }

    public void reloadMembres() {
        try {
            comboChoixMembre.setModel(new DefaultComboBoxModel(getMembreForCombo(Controller.getGroupeSelected(groupeEnCours))));
            if (comboChoixMembre.getModel() != null && comboChoixMembre.getModel().getSize() > 0) {
                butSupprMembre.setEnabled(true);
                butModifier.setEnabled(true);
                loadMembre(vecMembre.elementAt(0));
            } else {
                butSupprMembre.setEnabled(false);
                butModifier.setEnabled(false);
            }
        } catch (BDException ex) {
            setInfoText(ex.toString());
        } catch (LoginException ex) {
            setInfoText(ex.toString());
        }
    }

    public void reloadGroupe() {
        listGroupe.setModel(new javax.swing.AbstractListModel() {

            Vector<String> vec = getGroupeForList();

            @Override
            public int getSize() {
                return vec.size();
            }

            @Override
            public Object getElementAt(int i) {
                return vec.elementAt(i);
            }
        });
        if (listGroupe.getModel() != null && listGroupe.getModel().getSize() > 0) {
            try {
                listGroupe.setSelectedIndex(0);
                loadGroupe(Controller.getGroupeSelected(vecGroupeForList.elementAt(listGroupe.getSelectedIndex())));
                butModifierGroupe.setEnabled(true);
                butSupprGroupe.setEnabled(true);
            //bu.setEnabled(true);
            } catch (BDException ex) {
                barreInfo.setText(ex.toString());
            } catch (LoginException ex) {
                barreInfo.setText(ex.toString());
            }
        } else {
            butModifierGroupe.setEnabled(false);
            butSupprGroupe.setEnabled(false);
        }
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        scrollSelectGroupe = new javax.swing.JScrollPane();
        listGroupe = new javax.swing.JList();
        groupePanel = new javax.swing.JPanel();
        labelNomGroupe = new javax.swing.JLabel();
        labelPopularite = new javax.swing.JLabel();
        labelGenreOut = new javax.swing.JLabel();
        labelGenre = new javax.swing.JLabel();
        labelNomGroupeOut = new javax.swing.JLabel();
        labelNationaliteGroupe = new javax.swing.JLabel();
        labelNationaliteGroupeOut = new javax.swing.JLabel();
        labelSite = new javax.swing.JLabel();
        labelSiteOut = new javax.swing.JLabel();
        labelCout = new javax.swing.JLabel();
        labelPopulariteOut = new javax.swing.JLabel();
        labelCoutOut = new javax.swing.JLabel();
        actionGroupePanel = new javax.swing.JPanel();
        butSupprGroupe = new javax.swing.JButton();
        butModifierGroupe = new javax.swing.JButton();
        membrePanel = new javax.swing.JPanel();
        labelNomMembre = new javax.swing.JLabel();
        labelNomMembreOut = new javax.swing.JLabel();
        labelPrenom = new javax.swing.JLabel();
        labelPrenomOut = new javax.swing.JLabel();
        labelPseudo = new javax.swing.JLabel();
        labelPseudoOut = new javax.swing.JLabel();
        labelNationaliteMembre = new javax.swing.JLabel();
        labelNationaliteMembreOut = new javax.swing.JLabel();
        labelInstrument = new javax.swing.JLabel();
        labelDomaineOut = new javax.swing.JLabel();
        labelDomaine = new javax.swing.JLabel();
        labelInstrumentOut = new javax.swing.JLabel();
        labelDateNaissance = new javax.swing.JLabel();
        labelDanteNaissanceOut = new javax.swing.JLabel();
        ChangementPanel = new javax.swing.JPanel();
        butPrecedent = new javax.swing.JButton();
        comboChoixMembre = new javax.swing.JComboBox();
        butSuivant = new javax.swing.JButton();
        actionMembrePanel = new javax.swing.JPanel();
        butSupprMembre = new javax.swing.JButton();
        butModifier = new javax.swing.JButton();
        butAjouter = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createTitledBorder("Lister groupes"));
        setLayout(new java.awt.GridBagLayout());

        scrollSelectGroupe.setBorder(javax.swing.BorderFactory.createTitledBorder("S�lection du Groupe"));
        scrollSelectGroupe.setMinimumSize(new java.awt.Dimension(200, 167));
        scrollSelectGroupe.setPreferredSize(new java.awt.Dimension(200, 167));

        listGroupe.setModel(new javax.swing.AbstractListModel() {
            Vector <String> vec = getGroupeForList();
            public int getSize() { return vec.size(); }
            public Object getElementAt(int i) { return vec.elementAt(i); }
        });
        listGroupe.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        listGroupe.setMaximumSize(new java.awt.Dimension(110, 167));
        listGroupe.setMinimumSize(new java.awt.Dimension(110, 167));
        listGroupe.setPreferredSize(new java.awt.Dimension(110, 167));
        scrollSelectGroupe.setViewportView(listGroupe);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridheight = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 5);
        add(scrollSelectGroupe, gridBagConstraints);

        groupePanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Infos du groupe"));
        groupePanel.setLayout(new java.awt.GridBagLayout());

        labelNomGroupe.setText("Nom :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        groupePanel.add(labelNomGroupe, gridBagConstraints);

        labelPopularite.setText("Popularit� :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(0, 15, 5, 5);
        groupePanel.add(labelPopularite, gridBagConstraints);

        labelGenreOut.setMaximumSize(new java.awt.Dimension(110, 14));
        labelGenreOut.setMinimumSize(new java.awt.Dimension(110, 14));
        labelGenreOut.setPreferredSize(new java.awt.Dimension(110, 14));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 0);
        groupePanel.add(labelGenreOut, gridBagConstraints);

        labelGenre.setText("Genre :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        groupePanel.add(labelGenre, gridBagConstraints);

        labelNomGroupeOut.setMaximumSize(new java.awt.Dimension(110, 14));
        labelNomGroupeOut.setMinimumSize(new java.awt.Dimension(110, 14));
        labelNomGroupeOut.setPreferredSize(new java.awt.Dimension(110, 14));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 0);
        groupePanel.add(labelNomGroupeOut, gridBagConstraints);

        labelNationaliteGroupe.setText("Nationalit� :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(0, 15, 5, 5);
        groupePanel.add(labelNationaliteGroupe, gridBagConstraints);

        labelNationaliteGroupeOut.setMaximumSize(new java.awt.Dimension(110, 14));
        labelNationaliteGroupeOut.setMinimumSize(new java.awt.Dimension(110, 14));
        labelNationaliteGroupeOut.setPreferredSize(new java.awt.Dimension(110, 14));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 0);
        groupePanel.add(labelNationaliteGroupeOut, gridBagConstraints);

        labelSite.setText("Site web :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        groupePanel.add(labelSite, gridBagConstraints);

        labelSiteOut.setMaximumSize(new java.awt.Dimension(110, 14));
        labelSiteOut.setMinimumSize(new java.awt.Dimension(110, 14));
        labelSiteOut.setPreferredSize(new java.awt.Dimension(110, 14));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 0);
        groupePanel.add(labelSiteOut, gridBagConstraints);

        labelCout.setText("Cout :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(0, 15, 5, 5);
        groupePanel.add(labelCout, gridBagConstraints);

        labelPopulariteOut.setMaximumSize(new java.awt.Dimension(110, 14));
        labelPopulariteOut.setMinimumSize(new java.awt.Dimension(110, 14));
        labelPopulariteOut.setPreferredSize(new java.awt.Dimension(110, 14));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 0);
        groupePanel.add(labelPopulariteOut, gridBagConstraints);

        labelCoutOut.setMaximumSize(new java.awt.Dimension(110, 14));
        labelCoutOut.setMinimumSize(new java.awt.Dimension(110, 14));
        labelCoutOut.setPreferredSize(new java.awt.Dimension(110, 14));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 0);
        groupePanel.add(labelCoutOut, gridBagConstraints);

        butSupprGroupe.setText("Supprimer le groupe");
        actionGroupePanel.add(butSupprGroupe);

        butModifierGroupe.setText("Modifier");
        actionGroupePanel.add(butModifierGroupe);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        groupePanel.add(actionGroupePanel, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        add(groupePanel, gridBagConstraints);

        membrePanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Infos des membres"));
        membrePanel.setLayout(new java.awt.GridBagLayout());

        labelNomMembre.setText("Nom :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 5, 5);
        membrePanel.add(labelNomMembre, gridBagConstraints);

        labelNomMembreOut.setMaximumSize(new java.awt.Dimension(110, 14));
        labelNomMembreOut.setMinimumSize(new java.awt.Dimension(110, 14));
        labelNomMembreOut.setPreferredSize(new java.awt.Dimension(110, 14));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 0);
        membrePanel.add(labelNomMembreOut, gridBagConstraints);

        labelPrenom.setText("Pr�nom :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(0, 15, 5, 5);
        membrePanel.add(labelPrenom, gridBagConstraints);

        labelPrenomOut.setMaximumSize(new java.awt.Dimension(110, 14));
        labelPrenomOut.setMinimumSize(new java.awt.Dimension(110, 14));
        labelPrenomOut.setPreferredSize(new java.awt.Dimension(110, 14));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 5);
        membrePanel.add(labelPrenomOut, gridBagConstraints);

        labelPseudo.setText("Pseudo :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 5, 5);
        membrePanel.add(labelPseudo, gridBagConstraints);

        labelPseudoOut.setMaximumSize(new java.awt.Dimension(110, 14));
        labelPseudoOut.setMinimumSize(new java.awt.Dimension(110, 14));
        labelPseudoOut.setPreferredSize(new java.awt.Dimension(110, 14));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 0);
        membrePanel.add(labelPseudoOut, gridBagConstraints);

        labelNationaliteMembre.setText("Nationali� :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(0, 15, 5, 5);
        membrePanel.add(labelNationaliteMembre, gridBagConstraints);

        labelNationaliteMembreOut.setMaximumSize(new java.awt.Dimension(110, 14));
        labelNationaliteMembreOut.setMinimumSize(new java.awt.Dimension(110, 14));
        labelNationaliteMembreOut.setPreferredSize(new java.awt.Dimension(110, 14));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 5);
        membrePanel.add(labelNationaliteMembreOut, gridBagConstraints);

        labelInstrument.setText("Instrument :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 5, 5);
        membrePanel.add(labelInstrument, gridBagConstraints);

        labelDomaineOut.setMaximumSize(new java.awt.Dimension(110, 14));
        labelDomaineOut.setMinimumSize(new java.awt.Dimension(110, 14));
        labelDomaineOut.setPreferredSize(new java.awt.Dimension(110, 14));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 0);
        membrePanel.add(labelDomaineOut, gridBagConstraints);

        labelDomaine.setText("Domaine :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(0, 15, 5, 5);
        membrePanel.add(labelDomaine, gridBagConstraints);

        labelInstrumentOut.setMaximumSize(new java.awt.Dimension(110, 14));
        labelInstrumentOut.setMinimumSize(new java.awt.Dimension(110, 14));
        labelInstrumentOut.setPreferredSize(new java.awt.Dimension(110, 14));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 5);
        membrePanel.add(labelInstrumentOut, gridBagConstraints);

        labelDateNaissance.setText("Date Naissance :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 5, 5);
        membrePanel.add(labelDateNaissance, gridBagConstraints);

        labelDanteNaissanceOut.setMaximumSize(new java.awt.Dimension(110, 14));
        labelDanteNaissanceOut.setMinimumSize(new java.awt.Dimension(110, 14));
        labelDanteNaissanceOut.setPreferredSize(new java.awt.Dimension(110, 14));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 0);
        membrePanel.add(labelDanteNaissanceOut, gridBagConstraints);

        ChangementPanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 30, 5));

        butPrecedent.setText("<");
        ChangementPanel.add(butPrecedent);

        comboChoixMembre.setMinimumSize(new java.awt.Dimension(150, 20));
        comboChoixMembre.setPreferredSize(new java.awt.Dimension(150, 20));
        ChangementPanel.add(comboChoixMembre);

        butSuivant.setText(">");
        ChangementPanel.add(butSuivant);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 10, 0);
        membrePanel.add(ChangementPanel, gridBagConstraints);

        butSupprMembre.setText("Supprimer membre");
        actionMembrePanel.add(butSupprMembre);

        butModifier.setText("Modifier");
        actionMembrePanel.add(butModifier);

        butAjouter.setText("Ajouter membre");
        actionMembrePanel.add(butAjouter);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        membrePanel.add(actionMembrePanel, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        add(membrePanel, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    public void loadGroupe(Groupe groupe) {
        //Affichage des infos groupe
        labelNomGroupeOut.setText(groupe.getNom());
        labelNationaliteGroupeOut.setText(groupe.getNationalite());
        labelGenreOut.setText(groupe.getGenre());
        labelPopulariteOut.setText(groupe.getPopularite());
        labelSiteOut.setText(groupe.getSiteWeb());
        labelCoutOut.setText(groupe.getCout());
        groupePanel.validate();
        groupeEnCours = new GroupeID(groupe.getNom(), groupe.getNationalite());
        //Affichage des infos membres
        comboChoixMembre.setModel(new javax.swing.DefaultComboBoxModel(getMembreForCombo(groupe)));
        if (!vecMembre.isEmpty()) {
            loadMembre(vecMembre.elementAt(0));
            butSupprMembre.setEnabled(true);
            butModifier.setEnabled(true);
        } else {
            butSupprMembre.setEnabled(false);
            butModifier.setEnabled(false);
        }
    }

    private void loadMembre(MembreGroupe membre) {
        labelNomMembreOut.setText(membre.getNom());
        labelPrenomOut.setText(membre.getPrenom());
        labelDomaineOut.setText(membre.getDomaine());
        labelDanteNaissanceOut.setText(membre.getDateNaiss().toString());
        labelNationaliteMembreOut.setText(membre.getNationalite());
        labelInstrumentOut.setText(membre.getInstrument());
        labelPseudoOut.setText(membre.getSurnom());
        membrePanel.validate();

        //Gestion de l'activation des boutons
        if (vecMembre.indexOf(membre) == 0) {
            butPrecedent.setEnabled(false);
        } else {
            butPrecedent.setEnabled(true);
        }
        if (vecMembre.indexOf(membre) == (vecMembre.size() - 1)) {
            butSuivant.setEnabled(false);
        } else {
            butSuivant.setEnabled(true);
        }
    }

    private Vector<String> getGroupeForList() {
        Vector<String> vec = new Vector<String>();
        try {
            this.vecGroupeForList = Controller.getAllGroupeForList();
            for (GroupeID g : vecGroupeForList) {
                vec.add(g.getNom() + " [" + g.getNationalite().substring(0, 3) + "]");
            }

        } catch (BDException ex) {
            barreInfo.setText(ex.toString());
        } catch (LoginException ex) {
            barreInfo.setText(ex.toString());
        } finally {
            return vec;
        }
    }

    private Vector<String> getMembreForCombo(Groupe groupe) {
        Vector<String> vec = new Vector<String>();
        try {
            vecMembre = Controller.getAllMembreGroupe(new GroupeID(groupe.getNom(), groupe.getNationalite()));
        } catch (BDException ex) {
            barreInfo.setText(ex.toString());
        } catch (LoginException ex) {
            barreInfo.setText(ex.toString());
        }
        for (MembreGroupe m : vecMembre) {
            vec.add(m.getNom() + " " + m.getPrenom());
        }
        return vec;

    }

    public void setInfoText(String string) {
        barreInfo.setText(string);
    }

    private class ListeGroupeListener implements ListSelectionListener {

        @Override
        public void valueChanged(ListSelectionEvent e) {
            Groupe groupeSelected;
            try {
                if (listGroupe.getModel() != null && listGroupe.getSelectedIndex()>=0) {
                    groupeSelected = Controller.getGroupeSelected(vecGroupeForList.elementAt(listGroupe.getSelectedIndex()));
                    loadGroupe(groupeSelected);
                }
            } catch (BDException ex) {
                barreInfo.setText(ex.toString());
            } catch (LoginException ex) {
                barreInfo.setText(ex.toString());
            }
        }
    }

    private class ComboMembreListener implements ItemListener {

        @Override
        public void itemStateChanged(ItemEvent e) {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                choixMembre = comboChoixMembre.getSelectedIndex();
                loadMembre(vecMembre.elementAt(choixMembre));
            }
        }
    }

    private class ButtonListener implements ActionListener {

        private GroupeListingPanel groupeListing;

        public ButtonListener(GroupeListingPanel groupeListing) {
            this.groupeListing = groupeListing;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == butPrecedent) {
                loadMembre(vecMembre.elementAt(comboChoixMembre.getSelectedIndex() - 1));
                comboChoixMembre.setSelectedIndex(comboChoixMembre.getSelectedIndex() - 1);
            } else if (e.getSource() == butSuivant) {
                loadMembre(vecMembre.elementAt(comboChoixMembre.getSelectedIndex() + 1));
                comboChoixMembre.setSelectedIndex(comboChoixMembre.getSelectedIndex() + 1);
            } else if (e.getSource() == butAjouter) {
                AjouterMembreDialog ajoutMembre = new AjouterMembreDialog(groupeListing, groupeEnCours);
            } else if (e.getSource() == butSupprMembre) {
                if (JOptionPane.showConfirmDialog(null,
                        "<html>Etes-vous s�r de vouloir supprimer " + ((String) comboChoixMembre.getSelectedItem()) + "<html>?<br><br><i>Il vous sera apr�s impossible de le r�cup�rer</i>",
                        "Attention!",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.WARNING_MESSAGE) == JOptionPane.YES_OPTION) {
                    try {
                        Controller.deleteMembreGroupe(vecMembre.elementAt(comboChoixMembre.getSelectedIndex()), groupeEnCours);
                        reloadMembres();
                        setInfoText("Suppression effectu�e avec succ�s");
                    } catch (BDException ex) {
                        setInfoText(ex.toString());
                    }
                }
            } else if (e.getSource() == butModifier) {
                ModifierMembreDialog modifier = new ModifierMembreDialog(groupeListing, groupeEnCours, vecMembre.elementAt(comboChoixMembre.getSelectedIndex()));
            } else if (e.getSource() == butModifierGroupe) {
                try {
                    ModifierGroupeDialog modifier = new ModifierGroupeDialog(groupeListing, Controller.getGroupeSelected(groupeEnCours));
                } catch (BDException ex) {
                    setInfoText(ex.toString());
                } catch (LoginException ex) {
                    setInfoText(ex.toString());
                }
            } else if (e.getSource() == butSupprGroupe) {
                 if (JOptionPane.showConfirmDialog(null,
                        "<html>Etes-vous s�r de vouloir supprimer " + ((String)listGroupe.getSelectedValue()) + "<html>?<br><br><i>Il vous sera apr�s impossible de le r�cup�rer</i>",
                        "Attention!",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.WARNING_MESSAGE) == JOptionPane.YES_OPTION) {
                    try {
                        Controller.deleteGroupe(vecGroupeForList.elementAt(listGroupe.getSelectedIndex()));
                        reloadGroupe();
                        setInfoText("Suppression effectu�e avec succ�s");
                    } catch (BDException ex) {
                        setInfoText(ex.toString());
                    }
            }

        }
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ChangementPanel;
    private javax.swing.JPanel actionGroupePanel;
    private javax.swing.JPanel actionMembrePanel;
    private javax.swing.JButton butAjouter;
    private javax.swing.JButton butModifier;
    private javax.swing.JButton butModifierGroupe;
    private javax.swing.JButton butPrecedent;
    private javax.swing.JButton butSuivant;
    private javax.swing.JButton butSupprGroupe;
    private javax.swing.JButton butSupprMembre;
    private javax.swing.JComboBox comboChoixMembre;
    private javax.swing.JPanel groupePanel;
    private javax.swing.JLabel labelCout;
    private javax.swing.JLabel labelCoutOut;
    private javax.swing.JLabel labelDanteNaissanceOut;
    private javax.swing.JLabel labelDateNaissance;
    private javax.swing.JLabel labelDomaine;
    private javax.swing.JLabel labelDomaineOut;
    private javax.swing.JLabel labelGenre;
    private javax.swing.JLabel labelGenreOut;
    private javax.swing.JLabel labelInstrument;
    private javax.swing.JLabel labelInstrumentOut;
    private javax.swing.JLabel labelNationaliteGroupe;
    private javax.swing.JLabel labelNationaliteGroupeOut;
    private javax.swing.JLabel labelNationaliteMembre;
    private javax.swing.JLabel labelNationaliteMembreOut;
    private javax.swing.JLabel labelNomGroupe;
    private javax.swing.JLabel labelNomGroupeOut;
    private javax.swing.JLabel labelNomMembre;
    private javax.swing.JLabel labelNomMembreOut;
    private javax.swing.JLabel labelPopularite;
    private javax.swing.JLabel labelPopulariteOut;
    private javax.swing.JLabel labelPrenom;
    private javax.swing.JLabel labelPrenomOut;
    private javax.swing.JLabel labelPseudo;
    private javax.swing.JLabel labelPseudoOut;
    private javax.swing.JLabel labelSite;
    private javax.swing.JLabel labelSiteOut;
    private javax.swing.JList listGroupe;
    private javax.swing.JPanel membrePanel;
    private javax.swing.JScrollPane scrollSelectGroupe;
    // End of variables declaration//GEN-END:variables
}
