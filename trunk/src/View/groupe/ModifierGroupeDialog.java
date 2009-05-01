package View.groupe;

import Controller.Controller;
import Data.Groupe;
import View.BarreInfo;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;

/**
 *
 * @author Gérôme Quentin
 * @author Scaillet Bruno
 */
public class ModifierGroupeDialog extends JDialog {

    private InscrGroupePanel groupePanel;
    private JPanel actionPanel;
    private JButton butSauver;
    private JButton butRetour;
    private GroupeListingPanel groupeListing;
    private Groupe ancGroupe;
    private BarreInfo barreInfo;
    private GestionAction actionListener;

    ModifierGroupeDialog(GroupeListingPanel groupeListing, Groupe groupeSelected) {
        this.groupeListing = groupeListing;
        this.barreInfo = groupeListing.getBarreInfo();
        this.ancGroupe = groupeSelected;

        this.setTitle("Modification du groupe");
        this.setSize(480, 220);
        this.setResizable(false);
        this.setLayout(new FlowLayout());
        Dimension frameSize = new Dimension(getSize());
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        if(frameSize.width>screenSize.width)
            frameSize.width = screenSize.width;
        if(frameSize.height>screenSize.height)
            frameSize.height = screenSize.height;
        this.setLocation((screenSize.width-frameSize.width)/2,(screenSize.height-frameSize.height)/2);

        groupePanel = new InscrGroupePanel(barreInfo);
        add(groupePanel);
        groupePanel.setToModify(ancGroupe);

        JPanel actionPanel = new JPanel();
        actionPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        add(actionPanel);

        actionListener = new GestionAction();
        butSauver = new JButton("Enregistrer");
        butSauver.addActionListener(actionListener);
        butRetour = new JButton("Retour");
        butRetour.addActionListener(actionListener);
        actionPanel.add(butRetour);
        actionPanel.add(butSauver);

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
            } else if (e.getSource() == butSauver) {
                try {
                    Groupe newGroupe = groupePanel.getGroupe();
                    Controller.updateGroupe(ancGroupe, newGroupe);

                    barreInfo.setText("Modification du groupe effectuée avec succès");
                    groupeListing.reloadGroupe();
                    dispose();
                } catch (GroupeNotAcceptedException ex) {
                    Logger.getLogger(ModifierGroupeDialog.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }
    }
}
