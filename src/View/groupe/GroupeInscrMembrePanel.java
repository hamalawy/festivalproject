/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package View.groupe;

import Business.MembreGroupe;
import Data.LoginException;
import View.DateException;
import View.GestionFocusTextField;
import Controller.Controller;
import Data.BDException;
import View.DatePanel;

import java.awt.Dimension;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Cramike
 */
public class GroupeInscrMembrePanel extends InscrMembrePanel {

    private InscriptionMembreActionPanel actionPanel;
    private GroupeInscriptionMainPanel groupePanel;

    public GroupeInscrMembrePanel(GroupeInscriptionMainPanel groupePanel) {
        super(groupePanel.getBarreInfo());
        this.groupePanel = groupePanel;
        actionPanel = new InscriptionMembreActionPanel(this);
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        add(actionPanel, gridBagConstraints);

        comboNationalite.setEditable(true);
        try {
            comboNationalite.setModel(new javax.swing.DefaultComboBoxModel(Controller.getAllMembreGroupeNationalite()));
        } catch (BDException ex) {
            groupePanel.setInfoText(ex.toString());
        } catch (LoginException le) {
            groupePanel.setInfoText(le.toString());
        }

        comboNationalite.setMaximumSize(new java.awt.Dimension(110, 20));
        comboNationalite.setMinimumSize(new java.awt.Dimension(110, 20));
        comboNationalite.setPreferredSize(new java.awt.Dimension(110, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 5);
        add(comboNationalite, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 10);
        add(datePanel, gridBagConstraints);

        comboInstrument.setEditable(true);
        try {
            comboInstrument.setModel(new javax.swing.DefaultComboBoxModel(Controller.getAllInstruments()));
        } catch (BDException ex) {
            groupePanel.setInfoText(ex.toString());
        } catch (LoginException le) {
            groupePanel.setInfoText(le.toString());
        }
        comboInstrument.setMinimumSize(new java.awt.Dimension(110, 20));
        comboInstrument.setPreferredSize(new java.awt.Dimension(110, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 10);
        add(comboInstrument, gridBagConstraints);

        comboDomaine.setModel(new javax.swing.DefaultComboBoxModel(new String[]{"Technicien", "Musicien"}));
        comboDomaine.setMinimumSize(new java.awt.Dimension(110, 20));
        comboDomaine.setPreferredSize(new java.awt.Dimension(110, 20));
        comboDomaine.setSelectedIndex(1);
        comboDomaine.addItemListener(comboListener);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 5);
        add(comboDomaine, gridBagConstraints);
    }

    public JComboBox getComboNationalite() {
        return comboNationalite;
    }

    public JButton getButAjouter() {
        return actionPanel.getButAjouter();
    }

    void actionButAjouterNouveau() {
        MembreGroupe newMembre = this.getMembre();
        if (newMembre != null) {
        groupePanel.getVectMembreGroupe().add(newMembre);
        groupePanel.afficherAjoutMembre();
        } else {
            barreInfo.setText("Membre incorrect, veuillez recommencer");

        }
    }

    public void actionButAjouter() {
        MembreGroupe newMembre = this.getMembre();
        if (newMembre != null) {
            groupePanel.getVectMembreGroupe().add(newMembre);
            groupePanel.afficherTableMembre();
        } else {
            barreInfo.setText("Membre incorrect, veuillez recommencer");
            
        }
    }

    public GroupeInscriptionMainPanel getGroupePanel() {
        return groupePanel;
    }
}
