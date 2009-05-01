package View.groupe;

import Controller.Controller;
import Data.BDException;
import Data.Groupe;
import Data.LoginException;
import Data.MembreGroupe;
import View.BarreInfo;

import View.BienvenuePanel;
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

public class GroupeInscriptionMainPanel extends JPanel {

    private GroupeInscrMembrePanel membrePanel;
    private InscrGroupePanel groupePanel;
    private BarreInfo barreInfo;
    private GridBagConstraints gbc;
    private Vector<MembreGroupe> vectMembreGroupe = new Vector<MembreGroupe>();
    private javax.swing.JButton butEnregistrer;
    private javax.swing.JButton butRetour;
    private JPanel mainAction;
    private boolean isTableDisplayed;
    private MainFrame mainFrame;
    private GestionAction gestionAction;

    public GroupeInscriptionMainPanel(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        this.setLayout(new GridBagLayout());
        setBorder(BorderFactory.createTitledBorder("Inscription d'un groupe"));

        gestionAction = new GestionAction();
        groupePanel = new InscrGroupePanel(this.barreInfo);

        //Panel d'action placé en bas de la fenêtre
        butRetour = new javax.swing.JButton();
        butEnregistrer = new javax.swing.JButton();
        mainAction = new JPanel();

        mainAction.setBorder(javax.swing.BorderFactory.createTitledBorder("Actions"));
        mainAction.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));


        butRetour.setText("Retour");
        butRetour.setToolTipText("Retour à la page d'accueil");
        butRetour.addActionListener(gestionAction);
        mainAction.add(butRetour);

        butEnregistrer.setText("Enregistrer le groupe");
        butEnregistrer.setToolTipText("Enregistrer le groupe dans la base de données");
        butEnregistrer.addActionListener(gestionAction);
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
    public BarreInfo getBarreInfo() {
        return barreInfo;
    }
    public void afficherAjoutMembre() {
        this.removeAll();
        membrePanel = new GroupeInscrMembrePanel(this);
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        add(groupePanel, gbc);
        gbc.gridy = 1;
        add(membrePanel, gbc);

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

        add(groupePanel, gbc);
        gbc.gridy = 1;
        add(tableMembre, gbc);

        gbc.gridy = 2;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        add(mainAction, gbc);

        isTableDisplayed = true;
        this.validate();
    }

    public void afficherModifMembre(MembreGroupe membreToModify) {


        afficherAjoutMembre();
        membrePanel.setToModify(membreToModify);

    }

    private class GestionAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == butRetour) {
                if (!groupePanel.isEmpty() || !membrePanel.isEmpty() || !vectMembreGroupe.isEmpty()) {
                    if (JOptionPane.showConfirmDialog(null,
                            "<html>Etes-vous sûr de vouloir revenir au menu principal sans sauver?<br><br><i>les données inscrites seront perdues</i>",
                            "Attention!",
                            JOptionPane.YES_NO_OPTION,
                            JOptionPane.WARNING_MESSAGE) == JOptionPane.YES_OPTION) {
                        mainFrame.afficherPanel(new BienvenuePanel());
                    } else {
                        if (!isTableDisplayed)
                            membrePanel.getButAjouter().requestFocusInWindow();
                    }
                } else {
                    mainFrame.afficherPanel(new BienvenuePanel());
                }

            }
            else if (e.getSource() == butEnregistrer) {
                try {
                    //Enregistrement du groupe
                    Groupe newGroupe = groupePanel.getGroupe();
                    newGroupe.setVecMembres(vectMembreGroupe);
                    Controller.createGroupe(newGroupe);
                    mainFrame.afficherPanel(new BienvenuePanel());
                    setInfoText("Ajout du groupe réussi");
                } catch (GroupeNotAcceptedException ex) {
                    setInfoText(ex.toString());
                }
            }
        }
    }
}
