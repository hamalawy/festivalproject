package View.groupe;

import Controller.Controller;
import Data.BDException;
import Data.LoginException;
import Data.MembreGroupe;
import View.BarreInfo;

import View.MainFrame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class GroupeInscriptionPanel extends JPanel {

    private Groupe_InscriptionMembrePanel membre;
    private Groupe_InscriptionGroupePanel groupe;
    private BarreInfo barreInfo;
    private GridBagConstraints gbc;
    private Vector<MembreGroupe> vectMembreGroupe = new Vector<MembreGroupe>();
    private javax.swing.JButton butEnregistrer;
    private javax.swing.JButton butRetour;
    private JPanel mainAction;
    private boolean isTableDisplayed;
    private MainFrame mainFrame;

    public GroupeInscriptionPanel(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        this.setLayout(new GridBagLayout());
        setBorder(BorderFactory.createTitledBorder("Inscription d'un groupe"));
        groupe = new Groupe_InscriptionGroupePanel(this);

        //Panel d'action placé en bas de la fenêtre
        butRetour = new javax.swing.JButton();
        butEnregistrer = new javax.swing.JButton();
        mainAction = new JPanel();

        mainAction.setBorder(javax.swing.BorderFactory.createTitledBorder("Actions"));
        mainAction.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));


        butRetour.setText("Retour");
        butRetour.setToolTipText("Retour à la page d'accueil");
        mainAction.add(butRetour);

        butEnregistrer.setText("Enregistrer le groupe");
        butEnregistrer.setToolTipText("Enregistrer le groupe dans la base de données");
        mainAction.add(butEnregistrer);

        //Affichage du panneau d'ajout membre dés le départ
        afficherAjoutMembre();

    }

    public Vector<MembreGroupe> getVectMembreGroupe() {
        return vectMembreGroupe;
    }

    public void setInfoText(String string) {
        mainFrame.getBarreInfo().setText(string);
    }

    public void afficherAjoutMembre() {
        this.removeAll();
        membre = new Groupe_InscriptionMembrePanel(this);
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        add(groupe, gbc);
        gbc.gridy = 1;
        add(membre, gbc);

        gbc.gridy = 2;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        add(mainAction, gbc);


        isTableDisplayed = false;
        this.validate();
    }

    public void afficherTableMembre() {
        this.removeAll();
        gbc = new GridBagConstraints();
        Groupe_TablePanel tableMembre = new Groupe_TablePanel(this);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        add(groupe, gbc);
        gbc.gridy = 1;
        add(tableMembre, gbc);

        gbc.gridy = 2;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        add(mainAction, gbc);

        isTableDisplayed = true;
        this.validate();
    }

    private class GestionAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == butRetour) {
                if (JOptionPane.showConfirmDialog(null,
                        "Etes-vous sûr de vouloir revenir au menu principal sans sauver? \n<html><br><i>les données seront perdues</i>",
                        "Attention!",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.WARNING_MESSAGE) == JOptionPane.YES_OPTION) {
                    mainFrame.afficherBienvenue();
                }
                else {
                    membre.getButAjouter().requestFocusInWindow();
                }
            } 
            else if(e.getSource() == butEnregistrer) {
                    try {
                        //Enregistrement du groupe
                        Controller.createGroupe(groupe.getGroupe(), vectMembreGroupe);

                    } catch (GroupeNotAcceptedException ex) {
                        setInfoText(ex.toString());
                    } catch (BDException ex) {
                        setInfoText(ex.toString());
                    } catch (LoginException ex) {
                        setInfoText(ex.toString());
                    }
            }
        }
    }
}
