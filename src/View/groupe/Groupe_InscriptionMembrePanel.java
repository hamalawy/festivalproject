/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package View.groupe;

import Data.MembreGroupe;
import Data.LoginException;
import View.DateException;
import View.GestionFocusTextField;
import Controller.Controller;
import Data.BDException;
import View.DatePanel;
import View.VerifyData;
import View.VerifyDataException;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 *
 * @author Cramike
 */
public class Groupe_InscriptionMembrePanel extends JPanel {

    private javax.swing.JPanel actionPanel;
    private javax.swing.JButton butReinit;
    private javax.swing.JButton butAjouter;
    private javax.swing.JComboBox comboDomaine;
    private javax.swing.JComboBox comboInstrument;
    private javax.swing.JComboBox comboNationalite;
    private DatePanel datePanel;
    private javax.swing.JLabel labelDateNaiss;
    private javax.swing.JLabel labelDomaine;
    private javax.swing.JLabel labelInstrument;
    private javax.swing.JLabel labelNationalite;
    private javax.swing.JLabel labelNom;
    private javax.swing.JLabel labelPrenom;
    private javax.swing.JLabel labelPseudo;
    private javax.swing.JTextField textNom;
    private javax.swing.JTextField textPrenom;
    private javax.swing.JTextField textPseudo;
    private java.awt.GridBagConstraints gridBagConstraints;
    private GroupeInscriptionPanel groupePanel;
    private GestionFocusTextField gestionFocusTextField;
    private ComboListener comboListener;
    private javax.swing.JButton butAnnuler;
    private javax.swing.JButton butAjouterNouveau;
    private ActionPanelListener actionListener;

    public Groupe_InscriptionMembrePanel(GroupeInscriptionPanel groupePanel) {
        this.groupePanel = groupePanel;
        gestionFocusTextField = new GestionFocusTextField();
        comboListener = new ComboListener();
        actionListener = new ActionPanelListener();
        this.setPreferredSize(new Dimension(450, 175));
        this.setMinimumSize(this.getPreferredSize());

        labelNom = new javax.swing.JLabel();
        textNom = new javax.swing.JTextField();
        labelPrenom = new javax.swing.JLabel();
        textPrenom = new javax.swing.JTextField();
        labelPseudo = new javax.swing.JLabel();
        textPseudo = new javax.swing.JTextField();
        labelNationalite = new javax.swing.JLabel();
        labelDateNaiss = new javax.swing.JLabel();
        labelDomaine = new javax.swing.JLabel();
        labelInstrument = new javax.swing.JLabel();
        actionPanel = new javax.swing.JPanel();
        butReinit = new javax.swing.JButton();
        butAjouter = new javax.swing.JButton();
        butAnnuler = new javax.swing.JButton();
        butAjouterNouveau = new javax.swing.JButton();
        comboNationalite = new javax.swing.JComboBox();
        datePanel = new DatePanel();
        comboInstrument = new javax.swing.JComboBox();
        comboDomaine = new javax.swing.JComboBox();

        this.setBorder(javax.swing.BorderFactory.createTitledBorder("Membre"));
        this.setLayout(new java.awt.GridBagLayout());

        labelNom.setText("Nom :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        add(labelNom, gridBagConstraints);

        textNom.setMinimumSize(new java.awt.Dimension(110, 20));
        textNom.setPreferredSize(new java.awt.Dimension(110, 20));
        textNom.addFocusListener(gestionFocusTextField);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 10);
        add(textNom, gridBagConstraints);

        labelPrenom.setText("Prénom :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        add(labelPrenom, gridBagConstraints);

        textPrenom.setMaximumSize(new java.awt.Dimension(110, 20));
        textPrenom.setMinimumSize(new java.awt.Dimension(110, 20));
        textPrenom.setPreferredSize(new java.awt.Dimension(110, 20));
        textPrenom.addFocusListener(gestionFocusTextField);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 5);
        add(textPrenom, gridBagConstraints);

        labelPseudo.setText("Pseudo :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        add(labelPseudo, gridBagConstraints);

        textPseudo.setMinimumSize(new java.awt.Dimension(110, 20));
        textPseudo.setPreferredSize(new java.awt.Dimension(110, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 10);
        add(textPseudo, gridBagConstraints);

        labelNationalite.setText("Nationalité :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        add(labelNationalite, gridBagConstraints);

        labelDateNaiss.setText("Date naissance :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        add(labelDateNaiss, gridBagConstraints);

        labelDomaine.setText("Domaine :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        add(labelDomaine, gridBagConstraints);

        labelInstrument.setText("Instrument :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        add(labelInstrument, gridBagConstraints);


        butAnnuler.setText("Retour");
        butAnnuler.addActionListener(actionListener);
        butAnnuler.setMaximumSize(new java.awt.Dimension(90, 23));
        butAnnuler.setMinimumSize(new java.awt.Dimension(90, 23));
        butAnnuler.setPreferredSize(new java.awt.Dimension(90, 23));
        actionPanel.add(butAnnuler);

        butReinit.setText("Réinitialiser");
        butReinit.addActionListener(actionListener);
        butReinit.setAlignmentX(0.5F);
        butReinit.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        butReinit.setMaximumSize(new java.awt.Dimension(110, 23));
        butReinit.setMinimumSize(new java.awt.Dimension(110, 23));
        butReinit.setPreferredSize(new java.awt.Dimension(110, 23));
        actionPanel.add(butReinit);

        butAjouterNouveau.setText("Ajouter nouv.");
        butAjouterNouveau.addActionListener(actionListener);
        butAjouterNouveau.setAlignmentX(0.5F);
        butAjouterNouveau.setMaximumSize(new java.awt.Dimension(110, 23));
        butAjouterNouveau.setMinimumSize(new java.awt.Dimension(110, 23));
        butAjouterNouveau.setPreferredSize(new java.awt.Dimension(110, 23));
        actionPanel.add(butAjouterNouveau);

        butAjouter.setText("Sauver");
        butAjouter.addActionListener(actionListener);
        butAjouter.setHorizontalTextPosition(SwingConstants.CENTER);
        butAjouter.setMaximumSize(new java.awt.Dimension(100, 23));
        butAjouter.setMinimumSize(new java.awt.Dimension(100, 23));
        butAjouter.setPreferredSize(new java.awt.Dimension(100, 23));
        actionPanel.add(butAjouter);

        gridBagConstraints = new java.awt.GridBagConstraints();
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
        comboInstrument.setModel(new javax.swing.DefaultComboBoxModel(new String[]{"Item 1", "Item 2", "Item 3", "Item 4"}));
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

    public JButton getButAjouter() {
        return butAjouter;
    }

    public void reinit() {
        textNom.setText(null);
        textPrenom.setText(null);
        textPseudo.setText(null);
        comboDomaine.setSelectedIndex(1);
        comboInstrument.setSelectedIndex(0);
        comboNationalite.setSelectedIndex(0);
        datePanel.reinit();
    }

    public boolean verify() {
        if(textNom.getText().isEmpty() ||
                textPrenom.getText().isEmpty() ||
                textPseudo.getText().isEmpty() ||
                //(((String)comboInstrument.getSelectedItem()).isEmpty() && comboDomaine.getSelectedIndex()==1) ||
                ((String)comboNationalite.getSelectedItem()).isEmpty())
            return false;
        else
            return true;
    }


    private class ActionPanelListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == butAnnuler) {
                groupePanel.afficherTableMembre();
            } else if (e.getSource() == butReinit) {
                reinit();
            } else if (e.getSource() == butAjouterNouveau) {
                reinit();

            } else if (e.getSource() == butAjouter) {
                VerifyData v = new VerifyData();
               
                if (verify()) {
                    try {
                        java.sql.Date date = new java.sql.Date(datePanel.getDate().getTimeInMillis());
                        System.out.println(date.toString());
                        System.out.println("Instrument : " + (String) comboInstrument.getModel().getSelectedItem());
                        MembreGroupe membre = new MembreGroupe(
                                v.getSQLString(textNom.getText()),
                                v.getSQLString(textPrenom.getText()),
                                v.getSQLString(textPseudo.getText()),
                                v.getSQLString((String) comboNationalite.getModel().getSelectedItem()),
                                v.getSQLString((String) comboDomaine.getModel().getSelectedItem()),
                                (comboInstrument.isEnabled()) ? v.getSQLString((String) comboInstrument.getModel().getSelectedItem()) : null,
                                date);
                        groupePanel.getVectMembreGroupe().add(membre);
                        groupePanel.afficherTableMembre();
                    } catch (DateException ex) {
                        groupePanel.setInfoText("Date incorrecte");
                    } catch (VerifyDataException ex) {
                        System.out.println("Erreur lors de l'ajout du membre");
                        /*} catch (DateException de) {
                        System.out.println("erreur de date");*/
                    }
                }
                else {
                    groupePanel.setInfoText("Tuuuuuuuutttt");
                }
            }
        }
    }

    private class ComboListener implements ItemListener {

        @Override
        public void itemStateChanged(ItemEvent e) {
            if (e.getSource() == comboDomaine) {
                if (e.getStateChange() == ItemEvent.SELECTED && comboDomaine.getSelectedIndex() == 0) {
                    comboInstrument.setSelectedIndex(0);
                    comboInstrument.setEnabled(false);
                } else if (e.getStateChange() == ItemEvent.SELECTED && comboDomaine.getSelectedIndex() != 0) {
                    comboInstrument.setEnabled(true);
                }
            }
        }
    }
}
    
