package View.groupe;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 *
 * @author Gérôme Quentin
 * @author Scaillet Bruno
 */
public class InscriptionMembreActionPanel extends JPanel{

    private javax.swing.JButton butAnnuler;
    private javax.swing.JButton butAjouterNouveau;
    private javax.swing.JButton butReinit;
    private javax.swing.JButton butAjouter;
    private GroupeInscrMembrePanel panelInscription;
    private GestionAction actionListener;

    public InscriptionMembreActionPanel(GroupeInscrMembrePanel panelInscription) {
        this.panelInscription = panelInscription;
        actionListener = new GestionAction();

        butReinit = new javax.swing.JButton();
        butAjouter = new javax.swing.JButton();
        butAnnuler = new javax.swing.JButton();
        butAjouterNouveau = new javax.swing.JButton();
        butAnnuler.setText("Retour");
        butAnnuler.addActionListener(actionListener);
        butAnnuler.setMaximumSize(new java.awt.Dimension(90, 23));
        butAnnuler.setMinimumSize(new java.awt.Dimension(90, 23));
        butAnnuler.setPreferredSize(new java.awt.Dimension(90, 23));
        add(butAnnuler);

        butReinit.setText("Réinitialiser");
        butReinit.addActionListener(actionListener);
        butReinit.setAlignmentX(0.5F);
        butReinit.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        butReinit.setMaximumSize(new java.awt.Dimension(110, 23));
        butReinit.setMinimumSize(new java.awt.Dimension(110, 23));
        butReinit.setPreferredSize(new java.awt.Dimension(110, 23));
        add(butReinit);

        butAjouterNouveau.setText("Ajouter nouv.");
        butAjouterNouveau.addActionListener(actionListener);
        butAjouterNouveau.setAlignmentX(0.5F);
        butAjouterNouveau.setMaximumSize(new java.awt.Dimension(110, 23));
        butAjouterNouveau.setMinimumSize(new java.awt.Dimension(110, 23));
        butAjouterNouveau.setPreferredSize(new java.awt.Dimension(110, 23));
        add(butAjouterNouveau);

        butAjouter.setText("Sauver");
        butAjouter.addActionListener(actionListener);
        butAjouter.setHorizontalTextPosition(SwingConstants.CENTER);
        butAjouter.setMaximumSize(new java.awt.Dimension(100, 23));
        butAjouter.setMinimumSize(new java.awt.Dimension(100, 23));
        butAjouter.setPreferredSize(new java.awt.Dimension(100, 23));
        add(butAjouter);
    }

        public JButton getButAjouter() {
        return butAjouter;
    }

    public JButton getButAjouterNouveau() {
        return butAjouterNouveau;
    }

    public JButton getButAnnuler() {
        return butAnnuler;
    }

    public JButton getButReinit() {
        return butReinit;
    }

    private class GestionAction implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == butAjouter) {
                panelInscription.getTextNom().requestFocus();
                if(panelInscription.verify())
                    panelInscription.actionButAjouter();
                else {
                   panelInscription.getGroupePanel().setInfoText("Veuillez compléter tous les champs");
                }
            }
            else if(e.getSource() == butAjouterNouveau) {
                panelInscription.getTextNom().requestFocus();
                if(panelInscription.verify())
                    panelInscription.actionButAjouterNouveau();
                else {
                    panelInscription.getGroupePanel().setInfoText("Veuillez compléter tous les champs");
                }
            }
            else if(e.getSource() == butAnnuler)
                panelInscription.getGroupePanel().afficherTableMembre();
            else if(e.getSource() == butReinit)
                panelInscription.reinit();
        }

    }
}
