/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * GestionGroupeAScenePanel.java
 *
 * Created on 02-mai-2009, 14:44:14
 */
package View.scene;

import Business.AllGroupeGenreTableModel;
import Business.AllGroupeSceneTableModel;
import Controller.Controller;
import Data.BDException;
import Business.GroupeScene;
import View.MainFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;

/**
 *
 * @author Cramike
 */
public class GestionGroupeAScenePanel extends javax.swing.JPanel {

    private MainFrame mainFrame;

    /** Creates new form GestionGroupeAScenePanel */
    public GestionGroupeAScenePanel(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        initComponents();

        //Gestion des boutons
        GestionButton gestionButton = new GestionButton();
        butAjouter.addActionListener(gestionButton);
        butSupprimer.addActionListener(gestionButton);

        //Initialisation du tableauGroupeScene
        if (comboChoixScene.getModel() != null && comboChoixScene.getModel().getSize() > 0) {
            comboChoixScene.setSelectedIndex(0);
            loadTableGroupeScene((String) comboChoixScene.getSelectedItem());
        }
        loadTableGroupe();

    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        scrollGroupeScene = new javax.swing.JScrollPane();
        tableGroupeScene = new javax.swing.JTable();
        butAjouter = new javax.swing.JButton();
        labelListeGroupeScene = new javax.swing.JLabel();
        labelListeGroupe = new javax.swing.JLabel();
        choixPanel = new javax.swing.JPanel();
        labelChoixScene = new javax.swing.JLabel();
        comboChoixScene = new javax.swing.JComboBox();
        scrollGroupe = new javax.swing.JScrollPane();
        tableGroupe = new javax.swing.JTable();
        butSupprimer = new javax.swing.JButton();

        setLayout(new java.awt.GridBagLayout());

        scrollGroupeScene.setMinimumSize(new java.awt.Dimension(300, 402));
        scrollGroupeScene.setPreferredSize(new java.awt.Dimension(300, 402));

        tableGroupeScene.setAutoCreateRowSorter(true);
        tableGroupeScene.setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        scrollGroupeScene.setViewportView(tableGroupeScene);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 10);
        add(scrollGroupeScene, gridBagConstraints);

        butAjouter.setText(">>");
        butAjouter.setToolTipText("Ajouter le(s) groupe(s) � la Sc�ne");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        add(butAjouter, gridBagConstraints);

        labelListeGroupeScene.setText("Liste des groupes pour la sc�ne :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 10);
        add(labelListeGroupeScene, gridBagConstraints);

        labelListeGroupe.setText("Liste des groupes � affecter :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 5, 0);
        add(labelListeGroupe, gridBagConstraints);

        labelChoixScene.setText("Sc�ne :");
        choixPanel.add(labelChoixScene);

        comboChoixScene.setModel(new DefaultComboBoxModel(getAllLibScene()));
        comboChoixScene.setMinimumSize(new java.awt.Dimension(110, 20));
        comboChoixScene.setPreferredSize(new java.awt.Dimension(110, 20));
        comboChoixScene.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboChoixSceneActionPerformed(evt);
            }
        });
        choixPanel.add(comboChoixScene);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(2, 10, 10, 10);
        add(choixPanel, gridBagConstraints);

        scrollGroupe.setMinimumSize(new java.awt.Dimension(300, 402));
        scrollGroupe.setPreferredSize(new java.awt.Dimension(300, 402));

        tableGroupe.setAutoCreateRowSorter(true);
        tableGroupe.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tableGroupe.setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        scrollGroupe.setViewportView(tableGroupe);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.insets = new java.awt.Insets(0, 9, 5, 0);
        add(scrollGroupe, gridBagConstraints);

        butSupprimer.setText("<<");
        butSupprimer.setToolTipText("Supprimer le(s) groupe(s) de la Sc�ne");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        add(butSupprimer, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void comboChoixSceneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboChoixSceneActionPerformed
        //Il faut reloader la tableGroupeScene
        loadTableGroupeScene((String) comboChoixScene.getSelectedItem());

    /*if(vide)
    butSuppr.disabled*/
    }//GEN-LAST:event_comboChoixSceneActionPerformed

    private void loadTableGroupeScene(String scene) {
        Vector<GroupeScene> vec = null;
        try {
            vec = Controller.getAllGroupeGenreByScene(scene);
            tableGroupeScene.setModel(new AllGroupeGenreTableModel(vec));
            updateLabels();
        } catch (BDException ex) {
            mainFrame.getBarreInfo().setText(ex.toString());
        }
    }

    private void loadTableGroupe() {
        Vector<GroupeScene> vec = null;
        try {
            vec = Controller.getAllGroupeNoScene();
            tableGroupe.setModel(new AllGroupeGenreTableModel(vec));
            updateLabels();
        } catch (BDException ex) {
            mainFrame.getBarreInfo().setText(ex.toString());
        }
    }

    private Vector<String> getAllLibScene() {
        Vector<String> vec = null;
        try {
            vec = Controller.getAllLibScene();
        } catch (BDException ex) {
            mainFrame.getBarreInfo().setText(ex.toString());
        } finally {
            return vec;
        }
    }

    private void updateRemoveSceneToGroupe(Vector <GroupeScene> vec) {
        try {
            Controller.updateRemoveSceneToGroupe(vec);
        } catch (BDException ex) {
            mainFrame.getBarreInfo().setText(ex.toString());
        }
    }

    private void updateAddGroupeToScene(Vector <GroupeScene> vec) {
        try {
            Controller.updateAddSceneToGroupe(vec);
        } catch (BDException ex) {
            mainFrame.getBarreInfo().setText(ex.toString());
        }
    }

    private void updateLabels() {
        labelListeGroupe.setText("<html>Liste des groupes � affecter <i>("+tableGroupe.getModel().getRowCount()+")</i> :");
        labelListeGroupeScene.setText("<html>Liste des groupes pour la sc�ne <i>("+tableGroupeScene.getModel().getRowCount()+")</i> :");
    }

    private class GestionButton implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == butAjouter) {
                //Update de la sc�ne pour ces membres l�
                updateAddGroupeToScene(getVectFromTable(tableGroupe));
                loadTableGroupe();
                loadTableGroupeScene((String)comboChoixScene.getSelectedItem());
            }
            else if (e.getSource() == butSupprimer) {
               updateRemoveSceneToGroupe(getVectFromTable(tableGroupeScene));
               loadTableGroupe();
               loadTableGroupeScene((String)comboChoixScene.getSelectedItem());
               
            }

        }

        private Vector <GroupeScene> getVectFromTable(JTable table) {
                            //On r�cup�re les lignes s�lectionn�es dans la tableGroupe pour
                //faire un update et puis on r�actualise les 2
            int ligSelected[] = table.getSelectedRows();
                String nom, nationalite, genre;
                Vector<GroupeScene> vec = new Vector<GroupeScene>();
                for (int i = 0; i < ligSelected.length; i++) {
                    nom = (String) table.getModel().getValueAt(ligSelected[i], 0);
                    nationalite = (String) table.getModel().getValueAt(ligSelected[i], 1);
                    genre = (String) table.getModel().getValueAt(ligSelected[i], 2);
                    vec.add(new GroupeScene(nom, nationalite, (String) comboChoixScene.getSelectedItem(), genre));
                }
                return vec;
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton butAjouter;
    private javax.swing.JButton butSupprimer;
    private javax.swing.JPanel choixPanel;
    private javax.swing.JComboBox comboChoixScene;
    private javax.swing.JLabel labelChoixScene;
    private javax.swing.JLabel labelListeGroupe;
    private javax.swing.JLabel labelListeGroupeScene;
    private javax.swing.JScrollPane scrollGroupe;
    private javax.swing.JScrollPane scrollGroupeScene;
    private javax.swing.JTable tableGroupe;
    private javax.swing.JTable tableGroupeScene;
    // End of variables declaration//GEN-END:variables
}