package View.groupe;

import Controller.Controller;
import Data.GroupeID;
import Data.MembreGroupe;
import View.BarreInfo;
import View.DateException;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
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
public class ModifierMembreDialog extends JDialog {

    private InscrMembrePanel membrePanel;
    private JButton butModifier,  butRetour;
    private GestionAction actionListener;
    private BarreInfo barreInfo;
    private GroupeID groupe;
    private GroupeListingPanel groupeListingPanel;
    private MembreGroupe ancMembre;

    public ModifierMembreDialog(GroupeListingPanel groupeListingPanel, GroupeID groupe, MembreGroupe ancMembre) {
        this.barreInfo = groupeListingPanel.getBarreInfo();
        this.groupeListingPanel = groupeListingPanel;
        this.ancMembre = ancMembre;
        this.groupe = groupe;
        this.setTitle("Modification d'un membre");
        this.setSize(550, 260);
        this.setResizable(false);
        this.setLayout(new FlowLayout());

        //Position
        Dimension frameSize = new Dimension(getSize());
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        if (frameSize.width > screenSize.width) {
            frameSize.width = screenSize.width;
        }
        if (frameSize.height > screenSize.height) {
            frameSize.height = screenSize.height;
        }
        this.setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);


        actionListener = new GestionAction();

        membrePanel = new InscrMembrePanel(barreInfo);
        add(membrePanel);

        JPanel actionPanel = new JPanel();
        actionPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        add(actionPanel);

        butModifier = new JButton("Enregistrer");
        butModifier.addActionListener(actionListener);
        butRetour = new JButton("Retour");
        butRetour.addActionListener(actionListener);
        actionPanel.add(butRetour);
        actionPanel.add(butModifier);

        //Ajouter le texte dans le formulaire
        membrePanel.setToModify(ancMembre);

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
            } else if (e.getSource() == butModifier) //Modifier le membre du groupe
            {
                try {
                    Controller.updateMembreGroupe(groupe, ancMembre, membrePanel.getMembre());
                    barreInfo.setText("Modification du membre effectué");
                    groupeListingPanel.reloadMembres();
                    dispose();
                } catch (GroupeNotAcceptedException ex) {
                    barreInfo.setText(ex.toString());
                } 
            }


        }
    }
}