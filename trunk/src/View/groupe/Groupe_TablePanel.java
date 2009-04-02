
package View.groupe;

import Business.AllMembresTableModel;
import Controller.Controller;
import Data.MembreGroupe;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
    private GroupeInscriptionPanel groupePanel;
    private Listener actionListener;
    private MouseListener mouseListener;

    public Groupe_TablePanel(GroupeInscriptionPanel groupePanel) {
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
        setMinimumSize(new java.awt.Dimension(450, 175));
        setPreferredSize(new java.awt.Dimension(450, 175));
        setLayout(new java.awt.BorderLayout(5, 5));
    
        mouseListener = new mouseListener();
        dataModel = new AllMembresTableModel(groupePanel.getVectMembreGroupe());
        tableMembre.setAutoCreateRowSorter(true);
        tableMembre.setModel(dataModel);
        tableMembre.setBackground(javax.swing.UIManager.getDefaults().getColor("CheckBox.light"));
        tableMembre.addMouseListener(mouseListener);
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
                //groupePanel.afficherAjoutMembre();
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
                membre = groupePanel.getVectMembreGroupe().elementAt(tableMembre.getSelectedRow());
                System.out.print(membre.getNom());
                Controller.deleteMembreGroupe(membre);
                }
            }
        }

    }
    
    private class mouseListener implements MouseListener{

        @Override
        public void mouseClicked(MouseEvent e) {
            if(e.getSource() == tableMembre) {
                butSupprimer.setEnabled(true);          
            }
            else butSupprimer.setEnabled(false);
                
        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {
   
        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
        
    }
    
}
