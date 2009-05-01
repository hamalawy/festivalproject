package View.groupe;

import Controller.Controller;
import Data.GroupeID;
import View.BarreInfo;
import View.DateException;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;

/**
 *
 * @author Gérôme Quentin
 * @author Scaillet Bruno
 */
public class AjouterMembreDialog extends JDialog {

    private InscrMembrePanel membrePanel;
    private JButton butAjouter, butRetour;
    private GestionAction actionListener;
    private BarreInfo barreInfo;
    private GroupeID groupe;
    private GroupeListingPanel groupeListingPanel;

    public AjouterMembreDialog(GroupeListingPanel groupeListingPanel, GroupeID groupe) {
        this.barreInfo = groupeListingPanel.getBarreInfo();
        this.groupeListingPanel = groupeListingPanel;
        this.groupe = groupe;
        this.setTitle("Ajout d'un membre");
        this.setSize(550, 260);
        this.setResizable(false);
        this.setLayout(new FlowLayout());

        actionListener = new GestionAction();

        membrePanel = new InscrMembrePanel(barreInfo);
        add(membrePanel);

        JPanel actionPanel = new JPanel();
        actionPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        add(actionPanel);

        butAjouter = new JButton("Ajouter");
        butAjouter.addActionListener(actionListener);
        butRetour = new JButton("Retour");
        butRetour.addActionListener(actionListener);
        actionPanel.add(butRetour);
        actionPanel.add(butAjouter);

        
        //Fermeture de fenêtre
        this.addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });
        this.setVisible(true);

    }

    private class GestionAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == butRetour) {
                dispose();
            } else if (e.getSource() == butAjouter) //Ajouter le nouveau membre du groupe
            {       
                    try {
                        Controller.addMembreToGroupe(groupe, membrePanel.getMembre());
                        barreInfo.setText("Ajout du membre effectué");
                        groupeListingPanel.reloadMembres();
                        dispose();
                    } catch (GroupeNotAcceptedException ex) {
                        barreInfo.setText(ex.toString());
                    } 
            } 


        }
    }
}
