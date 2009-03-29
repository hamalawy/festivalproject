package View.groupe;

import Controller.Controller;
import Data.BDException;
import Data.Groupe;
import Data.LoginException;
import View.GestionFocusTextField;
import View.VerifyData;
import View.VerifyDataException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import javax.swing.border.Border;


public class Groupe_InscriptionGroupePanel extends JPanel {

    private javax.swing.JPanel ActionPanel;
    private javax.swing.JButton butReinit;
    private javax.swing.JComboBox comboPopularite;
    private javax.swing.JLabel labelCout;
    private javax.swing.JLabel labelGenreGroupe;
    private javax.swing.JLabel labelNationaliteGroupe;
    private javax.swing.JLabel labelNomGroupe;
    private javax.swing.JLabel labelPopularite;
    private javax.swing.JLabel labelSiteWeb;
    private javax.swing.JTextField textCout;
    private javax.swing.JComboBox comboGenre;
    private javax.swing.JComboBox  comboNationalite;
    private javax.swing.JTextField textNomGroupe;
    private javax.swing.JTextField textSiteWeb;
    private java.awt.GridBagConstraints gridBagConstraints;
    private GestionFocusTextField gestionFocus;
    private GestionAction gestionAction;
    private GroupeInscriptionPanel groupePanel;
    private Border bordureDeBase;

    public Groupe_InscriptionGroupePanel(GroupeInscriptionPanel groupePanel) {
        this.groupePanel = groupePanel;
        setBorder(javax.swing.BorderFactory.createTitledBorder("Groupe"));

        gestionFocus = new GestionFocusTextField();
        gestionAction = new GestionAction();

        labelNomGroupe = new javax.swing.JLabel();
        textNomGroupe = new javax.swing.JTextField();
        labelNationaliteGroupe = new javax.swing.JLabel();
        comboNationalite = new javax.swing.JComboBox();
        labelGenreGroupe = new javax.swing.JLabel();
        comboGenre = new javax.swing.JComboBox();
        labelPopularite = new javax.swing.JLabel();
        labelSiteWeb = new javax.swing.JLabel();
        textSiteWeb = new javax.swing.JTextField();
        labelCout = new javax.swing.JLabel();
        textCout = new javax.swing.JTextField();
        ActionPanel = new javax.swing.JPanel();
        butReinit = new javax.swing.JButton();
        comboPopularite = new javax.swing.JComboBox();

        bordureDeBase = textNomGroupe.getBorder();

        setLayout(new java.awt.GridBagLayout());

        labelNomGroupe.setText("Nom :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        add(labelNomGroupe, gridBagConstraints);

        textNomGroupe.setMinimumSize(new java.awt.Dimension(110, 20));
        textNomGroupe.setPreferredSize(new java.awt.Dimension(110, 20));
        textNomGroupe.addFocusListener(gestionFocus);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LAST_LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        add(textNomGroupe, gridBagConstraints);

        labelNationaliteGroupe.setText("Nationalit� :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(5, 20, 5, 5);
        add(labelNationaliteGroupe, gridBagConstraints);

        comboNationalite.setMinimumSize(new java.awt.Dimension(110, 20));
        comboNationalite.setPreferredSize(new java.awt.Dimension(110, 20));
        comboNationalite.setEditable(true);
        try {
            comboNationalite.setModel(new javax.swing.DefaultComboBoxModel(Controller.getAllGroupeNationalite()));
        } catch (BDException ex) {
            groupePanel.setInfoText(ex.toString());
        } catch (LoginException le) {
            groupePanel.setInfoText(le.toString());
        }

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LAST_LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 5);
        add(comboNationalite, gridBagConstraints);

        labelGenreGroupe.setText("Genre :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        add(labelGenreGroupe, gridBagConstraints);

        comboGenre.setMinimumSize(new java.awt.Dimension(110, 20));
        comboGenre.setPreferredSize(new java.awt.Dimension(110, 20));
        comboGenre.setEditable(true);
        try {
            comboGenre.setModel(new javax.swing.DefaultComboBoxModel(Controller.getAllGenre()));
        } catch (BDException ex) {
            groupePanel.setInfoText(ex.toString());
        } catch (LoginException le) {
            groupePanel.setInfoText(le.toString());
        }
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 0);
        add(comboGenre, gridBagConstraints);

        labelPopularite.setText("Popularit� :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 5, 5);
        add(labelPopularite, gridBagConstraints);

        labelSiteWeb.setText("Site web :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        add(labelSiteWeb, gridBagConstraints);

        textSiteWeb.setMinimumSize(new java.awt.Dimension(110, 20));
        textSiteWeb.setPreferredSize(new java.awt.Dimension(110, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 0);
        add(textSiteWeb, gridBagConstraints);

        labelCout.setText("Cout :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 5, 5);
        add(labelCout, gridBagConstraints);

        textCout.setMinimumSize(new java.awt.Dimension(110, 20));
        textCout.setPreferredSize(new java.awt.Dimension(110, 20));
        textCout.addFocusListener(gestionFocus);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 5);
        add(textCout, gridBagConstraints);

        ActionPanel.setMinimumSize(new java.awt.Dimension(30, 30));

        butReinit.setText("Reinitialiser");
        butReinit.setMaximumSize(new java.awt.Dimension(140, 23));
        butReinit.setMinimumSize(new java.awt.Dimension(140, 23));
        butReinit.setPreferredSize(new java.awt.Dimension(140, 23));
        butReinit.addActionListener(gestionAction);
        ActionPanel.add(butReinit);


        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        add(ActionPanel, gridBagConstraints);

        comboPopularite.setModel(new javax.swing.DefaultComboBoxModel(new String[]{"Local", "National", "Mondial"}));
        comboPopularite.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        comboPopularite.setMinimumSize(new java.awt.Dimension(110, 20));
        comboPopularite.setPreferredSize(new java.awt.Dimension(110, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 5);
        add(comboPopularite, gridBagConstraints);
    }

    private boolean verify() {
        if (this.textCout.getText().isEmpty() ||
                ((String)this.comboGenre.getSelectedItem()).isEmpty() ||
                ((String)this.comboNationalite.getSelectedItem()).isEmpty() ||
                this.textNomGroupe.getText().isEmpty() ||
                ((String)this.comboPopularite.getSelectedItem()).isEmpty()) {
            return false;
        } else {
            return true;
        }
    }

    public Groupe getGroupe() throws GroupeNotAcceptedException {
        VerifyData v;
        if(verify()) {
            try {
                v = new VerifyData();
                Groupe newGroupe = new Groupe(v.getSQLString(textNomGroupe.getText()), v.getSQLString((String) comboNationalite.getSelectedItem()), v.getSQLString((String) comboGenre.getSelectedItem()), v.getSQLString((String) comboPopularite.getSelectedItem()), v.getSQLString(textSiteWeb.getText()), v.getSQLDouble(textCout.getText(), true));
                return newGroupe;
            } catch (VerifyDataException ex) {
                throw new GroupeNotAcceptedException();
            }
        } else
            throw new GroupeNotAcceptedException();
    }

    private void reinit() {
        this.textCout.setText(null);
        this.textCout.setBorder(bordureDeBase);
        this.comboGenre.setSelectedIndex(0);
        this.comboGenre.setBorder(bordureDeBase);
        this.comboNationalite.setSelectedIndex(0);
        this.comboNationalite.setBorder(bordureDeBase);
        this.textNomGroupe.setText(null);
        this.textNomGroupe.setBorder(bordureDeBase);
        this.textSiteWeb.setText(null);
        this.comboPopularite.setSelectedIndex(0);
    }

    private class GestionAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == butReinit) {
                    reinit();
                }
            }
        }
    //}
}
