package View.groupe;

import View.GestionFocusTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.border.Border;


public class Groupe_InscriptionGroupePanel extends JPanel {

    private javax.swing.JPanel ActionPanel;
    private javax.swing.JButton butReinit;
    private javax.swing.JButton butSauver;
    private javax.swing.JComboBox comboPopularite;
    private javax.swing.JLabel labelCout;
    private javax.swing.JLabel labelGenreGroupe;
    private javax.swing.JLabel labelNationaliteGroupe;
    private javax.swing.JLabel labelNomGroupe;
    private javax.swing.JLabel labelPopularite;
    private javax.swing.JLabel labelSiteWeb;
    private javax.swing.JTextField textCout;
    private javax.swing.JTextField textGenre;
    private javax.swing.JTextField textNationalite;
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
        textNationalite = new javax.swing.JTextField();
        labelGenreGroupe = new javax.swing.JLabel();
        textGenre = new javax.swing.JTextField();
        labelPopularite = new javax.swing.JLabel();
        labelSiteWeb = new javax.swing.JLabel();
        textSiteWeb = new javax.swing.JTextField();
        labelCout = new javax.swing.JLabel();
        textCout = new javax.swing.JTextField();
        ActionPanel = new javax.swing.JPanel();
        butReinit = new javax.swing.JButton();
        butSauver = new javax.swing.JButton();
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

        labelNationaliteGroupe.setText("Nationalité :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(5, 20, 5, 5);
        add(labelNationaliteGroupe, gridBagConstraints);

        textNationalite.setMinimumSize(new java.awt.Dimension(110, 20));
        textNationalite.setPreferredSize(new java.awt.Dimension(110, 20));
        textNationalite.addFocusListener(gestionFocus);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LAST_LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 5);
        add(textNationalite, gridBagConstraints);

        labelGenreGroupe.setText("Genre :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        add(labelGenreGroupe, gridBagConstraints);

        textGenre.setMinimumSize(new java.awt.Dimension(110, 20));
        textGenre.setPreferredSize(new java.awt.Dimension(110, 20));
        textGenre.addFocusListener(gestionFocus);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 0);
        add(textGenre, gridBagConstraints);

        labelPopularite.setText("Popularité :");
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
                this.textGenre.getText().isEmpty() ||
                this.textNationalite.getText().isEmpty() ||
                this.textNomGroupe.getText().isEmpty()) {
            return false;
        } else {
            return true;
        }
    }

    private void reinit() {
        this.textCout.setText(null);
        this.textCout.setBorder(bordureDeBase);
        this.textGenre.setText(null);
        this.textGenre.setBorder(bordureDeBase);
        this.textNationalite.setText(null);
        this.textNationalite.setBorder(bordureDeBase);
        this.textNomGroupe.setText(null);
        this.textNomGroupe.setBorder(bordureDeBase);
        this.textSiteWeb.setText(null);
        this.comboPopularite.setSelectedIndex(0);
    }

    private class GestionAction implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub
          /*if (e.getSource() == butSauver) {
            if (verify()) {
            double coutDouble;
            VerifyData vStr = new VerifyData();
            try {
            coutDouble = vStr.getSQLDouble(textCout.getText(), true);
            String popularite = new String((String) comboPopularite.getModel().getSelectedItem());

            Groupe newGroupe = new Groupe(
            vStr.getSQLString(textNomGroupe.getText()),
            vStr.getSQLString(textNationalite.getText()),
            vStr.getSQLString(textGenre.getText()),
            popularite,
            vStr.getSQLString(textSiteWeb.getText()),
            coutDouble);
            Controller.createGroupe(newGroupe);

            } catch (BDException bde) {
            JOptionPane.showMessageDialog(null, bde);
            bde.printStackTrace();
            } catch (VerifyDataException vde) {
            vde.printStackTrace();
            } catch (Exception exc) {
            JOptionPane.showMessageDialog(null, exc);
            exc.printStackTrace();
            }}*/
            if (e.getSource() == butReinit) {
                    reinit();
                }
            }
        }
    //}
}
