/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * RechMembrePanel.java
 *
 * Created on 01-mai-2009, 14:03:24
 */

package View.groupe;

import View.BienvenuePanel;
import View.MainFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/**
 *
 * @author Cramike
 */
public class RechMembrePanel extends javax.swing.JPanel {
    private MainFrame mainFrame;

    /** Creates new form RechMembrePanel */
    public RechMembrePanel(MainFrame mainFrame) {
        initComponents();

        this.mainFrame = mainFrame;
        //Gestion des checkBox
        GestionCheckBox gestionCheck = new GestionCheckBox();
        checkNationaliteGroupe.addItemListener(gestionCheck);
        checkNomGroupe.addItemListener(gestionCheck);
        checkNomMembre.addItemListener(gestionCheck);
        checkPrenomMembre.addItemListener(gestionCheck);
        checkPseudoMembre.addItemListener(gestionCheck);

        butRechercher.addActionListener(new GestionButton());

    }

    public CriteresRecherche getCriteres() {
        CriteresRecherche c = new CriteresRecherche();
        if(!checkNationaliteGroupe.isEnabled()) {
            c.setNationaliteGroupe(null);
        } else
            c.setNationaliteGroupe(textNationaliteGroupe.getText());
        if(!checkNomGroupe.isEnabled()) {
            c.setNomGroupe(null);
        } else
            c.setNomGroupe(textNomGroupe.getText());
        if(!checkNomMembre.isEnabled()) {
            c.setNomMembre(null);
        } else
            c.setNomMembre(textNomMembre.getText());
        if(!checkPrenomMembre.isEnabled()) {
            c.setPrenomMembre(null);
        } else
            c.setPrenomMembre(textPrenomMembre.getText());
        if(!checkPseudoMembre.isEnabled()) {
            c.setPseudoMembre(null);
        } else
            c.setPseudoMembre(textPseudoMembre.getText());

        return c;
    }

    private class GestionButton implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == butRechercher) {
                CriteresRecherche c = getCriteres();
                resultSearchMembrePanel.actualiser(c);
            }
        }

    }

    private class GestionCheckBox implements ItemListener {

        @Override
        public void itemStateChanged(ItemEvent e) {
            if (e.getSource() == checkNomGroupe) {
                if(e.getStateChange()== ItemEvent.SELECTED) {
                   textNomGroupe.setEditable(true);
                } else {
                    textNomGroupe.setEditable(false);
                    textNomGroupe.setText("");
                }
            } else if (e.getSource() == checkNationaliteGroupe) {
                if(e.getStateChange() == ItemEvent.SELECTED) {
                    textNationaliteGroupe.setEditable(true);
                } else {
                    textNationaliteGroupe.setEditable(false);
                    textNationaliteGroupe.setText("");
                }
            } else if (e.getSource() == checkNomMembre) {
                if(e.getStateChange() == ItemEvent.SELECTED) {
                    textNomMembre.setEditable(true);
                } else {
                    textNomMembre.setEditable(false);
                    textNomMembre.setText("");
                }
            } else if (e.getSource() == checkPrenomMembre) {
                if(e.getStateChange() == ItemEvent.SELECTED) {
                    textPrenomMembre.setEditable(true);
                } else {
                    textPrenomMembre.setEditable(false);
                    textPrenomMembre.setText("");
                }
            } else if (e.getSource() == checkPseudoMembre) {
                if(e.getStateChange() == ItemEvent.SELECTED) {
                    textPseudoMembre.setEditable(true);
                } else {
                    textPseudoMembre.setEditable(false);
                    textPseudoMembre.setText("");
                }
            }
        }

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

        criteresPanel = new javax.swing.JPanel();
        checkNomGroupe = new javax.swing.JCheckBox();
        checkNationaliteGroupe = new javax.swing.JCheckBox();
        checkPrenomMembre = new javax.swing.JCheckBox();
        checkNomMembre = new javax.swing.JCheckBox();
        checkPseudoMembre = new javax.swing.JCheckBox();
        rechPanel = new javax.swing.JPanel();
        textNomGroupe = new javax.swing.JTextField();
        textPseudoMembre = new javax.swing.JTextField();
        textNationaliteGroupe = new javax.swing.JTextField();
        textPrenomMembre = new javax.swing.JTextField();
        textNomMembre = new javax.swing.JTextField();
        labelNomGroupe = new javax.swing.JLabel();
        labelNationaliteGroupe = new javax.swing.JLabel();
        labelPrenomMembre = new javax.swing.JLabel();
        labelPseudoMembre = new javax.swing.JLabel();
        labelNomMembre = new javax.swing.JLabel();
        butRechercher = new javax.swing.JButton();
        resultSearchMembrePanel = new View.groupe.ResultSearchMembrePanel();
        butRetour = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createTitledBorder("Rechercher un membre"));
        setLayout(new java.awt.GridBagLayout());

        criteresPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Choix des crit�res"));
        criteresPanel.setMinimumSize(new java.awt.Dimension(460, 85));
        criteresPanel.setPreferredSize(new java.awt.Dimension(460, 85));
        criteresPanel.setRequestFocusEnabled(false);
        criteresPanel.setLayout(new java.awt.GridLayout(2, 4));

        checkNomGroupe.setSelected(true);
        checkNomGroupe.setText("Nom du groupe");
        criteresPanel.add(checkNomGroupe);

        checkNationaliteGroupe.setSelected(true);
        checkNationaliteGroupe.setText("Nationalit� du groupe");
        criteresPanel.add(checkNationaliteGroupe);

        checkPrenomMembre.setSelected(true);
        checkPrenomMembre.setText("Pr�nom du membre");
        criteresPanel.add(checkPrenomMembre);

        checkNomMembre.setSelected(true);
        checkNomMembre.setText("Nom du membre");
        checkNomMembre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkNomMembreActionPerformed(evt);
            }
        });
        criteresPanel.add(checkNomMembre);

        checkPseudoMembre.setSelected(true);
        checkPseudoMembre.setText("Pseudo du membre");
        criteresPanel.add(checkPseudoMembre);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 10, 0);
        add(criteresPanel, gridBagConstraints);

        rechPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Compl�ter les champs"));
        rechPanel.setLayout(new java.awt.GridBagLayout());

        textNomGroupe.setMinimumSize(new java.awt.Dimension(110, 20));
        textNomGroupe.setPreferredSize(new java.awt.Dimension(110, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 2, 10, 11);
        rechPanel.add(textNomGroupe, gridBagConstraints);

        textPseudoMembre.setMinimumSize(new java.awt.Dimension(110, 20));
        textPseudoMembre.setPreferredSize(new java.awt.Dimension(110, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 2, 5, 11);
        rechPanel.add(textPseudoMembre, gridBagConstraints);

        textNationaliteGroupe.setMinimumSize(new java.awt.Dimension(110, 20));
        textNationaliteGroupe.setPreferredSize(new java.awt.Dimension(110, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 10, 11);
        rechPanel.add(textNationaliteGroupe, gridBagConstraints);

        textPrenomMembre.setMinimumSize(new java.awt.Dimension(110, 20));
        textPrenomMembre.setPreferredSize(new java.awt.Dimension(110, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 10, 11);
        rechPanel.add(textPrenomMembre, gridBagConstraints);

        textNomMembre.setMinimumSize(new java.awt.Dimension(110, 20));
        textNomMembre.setPreferredSize(new java.awt.Dimension(110, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 10, 10);
        rechPanel.add(textNomMembre, gridBagConstraints);

        labelNomGroupe.setText("Nom du groupe");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 2, 0, 11);
        rechPanel.add(labelNomGroupe, gridBagConstraints);

        labelNationaliteGroupe.setText("Nationalit� du groupe");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 11);
        rechPanel.add(labelNationaliteGroupe, gridBagConstraints);

        labelPrenomMembre.setText("Pr�nom du membre");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 11);
        rechPanel.add(labelPrenomMembre, gridBagConstraints);

        labelPseudoMembre.setText("Pseudo du membre");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 2, 0, 11);
        rechPanel.add(labelPseudoMembre, gridBagConstraints);

        labelNomMembre.setText("Nom du membre");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 10);
        rechPanel.add(labelNomMembre, gridBagConstraints);

        butRechercher.setText("Rechercher");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 10);
        rechPanel.add(butRechercher, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 10, 0);
        add(rechPanel, gridBagConstraints);

        resultSearchMembrePanel.setMinimumSize(new java.awt.Dimension(477, 200));
        resultSearchMembrePanel.setPreferredSize(new java.awt.Dimension(477, 200));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 0);
        add(resultSearchMembrePanel, gridBagConstraints);

        butRetour.setText("Retour");
        butRetour.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butRetourActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 14;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 5);
        add(butRetour, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void checkNomMembreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkNomMembreActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_checkNomMembreActionPerformed

    private void butRetourActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butRetourActionPerformed
        mainFrame.afficherPanel(new BienvenuePanel());
    }//GEN-LAST:event_butRetourActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton butRechercher;
    private javax.swing.JButton butRetour;
    private javax.swing.JCheckBox checkNationaliteGroupe;
    private javax.swing.JCheckBox checkNomGroupe;
    private javax.swing.JCheckBox checkNomMembre;
    private javax.swing.JCheckBox checkPrenomMembre;
    private javax.swing.JCheckBox checkPseudoMembre;
    private javax.swing.JPanel criteresPanel;
    private javax.swing.JLabel labelNationaliteGroupe;
    private javax.swing.JLabel labelNomGroupe;
    private javax.swing.JLabel labelNomMembre;
    private javax.swing.JLabel labelPrenomMembre;
    private javax.swing.JLabel labelPseudoMembre;
    private javax.swing.JPanel rechPanel;
    private View.groupe.ResultSearchMembrePanel resultSearchMembrePanel;
    private javax.swing.JTextField textNationaliteGroupe;
    private javax.swing.JTextField textNomGroupe;
    private javax.swing.JTextField textNomMembre;
    private javax.swing.JTextField textPrenomMembre;
    private javax.swing.JTextField textPseudoMembre;
    // End of variables declaration//GEN-END:variables

}
