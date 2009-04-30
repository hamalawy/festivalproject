
package View.groupe;

import Business.AllMembresTableModel;
import Controller.Controller;
import Data.MembreGroupe;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Gérôme Quentin
 * @author Scaillet Bruno
 */
public class Groupe_TablePanel extends JPanel{

    private javax.swing.JPanel actionPanel;
    private javax.swing.JButton butAjouter;
    private javax.swing.JButton butModifier;
    private javax.swing.JButton butSupprimer;  
    private javax.swing.JScrollPane scrollTable;
    private javax.swing.JTable tableMembre;
    private AllMembresTableModel dataModel;
    private GroupeInscriptionMainPanel groupePanel;
    private Listener actionListener;
    private ActionTable actionTable;

    public Groupe_TablePanel(GroupeInscriptionMainPanel groupePanel) {
        this.groupePanel = groupePanel;
        initComponents();
    }

    private void initComponents() {

        scrollTable = new javax.swing.JScrollPane();
        tableMembre = new javax.swing.JTable();
        actionPanel = new javax.swing.JPanel();
        butModifier = new javax.swing.JButton();
        butAjouter = new javax.swing.JButton();
        butSupprimer = new javax.swing.JButton();
        

        setBorder(javax.swing.BorderFactory.createTitledBorder("Liste des membres"));
        setMinimumSize(new java.awt.Dimension(540, 175));
        setPreferredSize(new java.awt.Dimension(540, 175));
        setLayout(new java.awt.BorderLayout(5, 5));
    
        actionTable = new ActionTable();
        dataModel = new AllMembresTableModel(groupePanel.getVectMembreGroupe());
        tableMembre.setAutoCreateRowSorter(true);
        tableMembre.setModel(dataModel);
        tableMembre.setBackground(javax.swing.UIManager.getDefaults().getColor("CheckBox.light"));
        tableMembre.addFocusListener(actionTable);
        scrollTable.setViewportView(tableMembre);

        add(scrollTable, java.awt.BorderLayout.CENTER);

        actionPanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));
        actionListener = new Listener();
        
        butSupprimer.setText("Supprimer");
        butSupprimer.addActionListener(actionListener);
        butSupprimer.setEnabled(false);
        actionPanel.add(butSupprimer);
        
        butModifier.setText("Modifier");
        butModifier.addActionListener(actionListener);
        butModifier.setEnabled(false);
        actionPanel.add(butModifier);

        butAjouter.setText("Ajouter");
        butAjouter.addActionListener(actionListener);
        actionPanel.add(butAjouter);

        add(actionPanel, java.awt.BorderLayout.PAGE_END);
    }

    private class Listener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == butModifier)
            {
                MembreGroupe membre = groupePanel.getVectMembreGroupe().elementAt(tableMembre.getSelectedRow());
                groupePanel.afficherModifMembre(membre);
                groupePanel.getVectMembreGroupe().removeElementAt(tableMembre.getSelectedRow());
                butSupprimer.setEnabled(false);
                butModifier.setEnabled(false);
            }
            else if(e.getSource() == butAjouter)
            {
                groupePanel.afficherAjoutMembre();
            }
            else if(e.getSource() == butSupprimer)
            {
                if(JOptionPane.showConfirmDialog(null, "Etes-vous sûr de vouloir supprimer ce membre?","Suppression"
                        ,JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE) == JOptionPane.YES_OPTION){
                      
                MembreGroupe membre;
                membre = groupePanel.getVectMembreGroupe().remove(tableMembre.getSelectedRow());
                
                butSupprimer.setEnabled(false);
                butModifier.setEnabled(false);

                tableMembre.repaint();
                }
            }
        }

    }
    
    private class ActionTable implements FocusListener{


        @Override
        public void focusGained(FocusEvent e) {
            butModifier.setEnabled(true);
            butSupprimer.setEnabled(true);
        }

        @Override
        public void focusLost(FocusEvent e) {
            if(e.getOppositeComponent() != butModifier && e.getOppositeComponent() != butSupprimer) {
                butModifier.setEnabled(false);
                butSupprimer.setEnabled(false);
            }

        }
        
    }
    
}
