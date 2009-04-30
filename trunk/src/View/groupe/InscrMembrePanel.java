package View.groupe;

import Controller.Controller;
import Data.BDException;
import Data.LoginException;
import Data.MembreGroupe;
import View.BarreInfo;
import View.DateException;
import View.DatePanel;
import View.GestionFocusTextField;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Gérôme Quentin
 * @author Scaillet Bruno
 */
public class InscrMembrePanel extends JPanel {

    protected GestionFocusTextField gestionFocusTextField;
    protected ComboListener comboListener;
    protected JLabel labelNom;
    protected JTextField textNom;
    protected JComboBox comboDomaine;
    protected JComboBox comboInstrument;
    protected DatePanel datePanel;
    protected JComboBox comboNationalite;
    protected JLabel labelInstrument;
    protected JLabel labelDomaine;
    protected JLabel labelDateNaiss;
    protected JLabel labelNationalite;
    protected JTextField textPseudo;
    protected JLabel labelPseudo;
    protected JTextField textPrenom;
    protected JLabel labelPrenom;
    protected GridBagConstraints gridBagConstraints;
    protected BarreInfo barreInfo;

    public InscrMembrePanel(BarreInfo barreInfo) {
        this.barreInfo = barreInfo;
        gestionFocusTextField = new GestionFocusTextField();
        comboListener = new ComboListener();

        this.setPreferredSize(new Dimension(540, 175));
        this.setMinimumSize(this.getPreferredSize());

        labelNom = new javax.swing.JLabel();
        textNom = new javax.swing.JTextField();
        labelPrenom = new javax.swing.JLabel();
        textPrenom = new javax.swing.JTextField();
        labelPseudo = new javax.swing.JLabel();
        textPseudo = new javax.swing.JTextField();
        labelNationalite = new javax.swing.JLabel();
        labelDateNaiss = new javax.swing.JLabel();
        labelDomaine = new javax.swing.JLabel();
        labelInstrument = new javax.swing.JLabel();

        comboNationalite = new javax.swing.JComboBox();
        datePanel = new DatePanel();
        comboInstrument = new javax.swing.JComboBox();
        comboDomaine = new javax.swing.JComboBox();

        this.setBorder(javax.swing.BorderFactory.createTitledBorder("Membre"));
        this.setLayout(new java.awt.GridBagLayout());

        labelNom.setText("Nom :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        add(labelNom, gridBagConstraints);

        textNom.setMinimumSize(new java.awt.Dimension(110, 20));
        textNom.setPreferredSize(new java.awt.Dimension(110, 20));
        textNom.addFocusListener(gestionFocusTextField);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 10);
        add(textNom, gridBagConstraints);


        labelPrenom.setText("Prénom :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        add(labelPrenom, gridBagConstraints);

        textPrenom.setMaximumSize(new java.awt.Dimension(110, 20));
        textPrenom.setMinimumSize(new java.awt.Dimension(110, 20));
        textPrenom.setPreferredSize(new java.awt.Dimension(110, 20));
        textPrenom.addFocusListener(gestionFocusTextField);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 5);
        add(textPrenom, gridBagConstraints);

        labelPseudo.setText("Pseudo :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        add(labelPseudo, gridBagConstraints);

        textPseudo.setMinimumSize(new java.awt.Dimension(110, 20));
        textPseudo.setPreferredSize(new java.awt.Dimension(110, 20));
        textPseudo.addFocusListener(gestionFocusTextField);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 10);
        add(textPseudo, gridBagConstraints);

        labelNationalite.setText("Nationalité :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        add(labelNationalite, gridBagConstraints);

        labelDateNaiss.setText("Date naissance :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        add(labelDateNaiss, gridBagConstraints);

        labelDomaine.setText("Domaine :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        add(labelDomaine, gridBagConstraints);

        labelInstrument.setText("Instrument :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        add(labelInstrument, gridBagConstraints);

        comboNationalite.setEditable(true);
        try {
            comboNationalite.setModel(new javax.swing.DefaultComboBoxModel(Controller.getAllMembreGroupeNationalite()));
        } catch (BDException ex) {
            barreInfo.setText(ex.toString());
        } catch (LoginException le) {
            barreInfo.setText(le.toString());
        }

        comboNationalite.setMaximumSize(new java.awt.Dimension(110, 20));
        comboNationalite.setMinimumSize(new java.awt.Dimension(110, 20));
        comboNationalite.setPreferredSize(new java.awt.Dimension(110, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 5);
        add(comboNationalite, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 10);
        add(datePanel, gridBagConstraints);

        comboInstrument.setEditable(true);
        try {
            comboInstrument.setModel(new javax.swing.DefaultComboBoxModel(Controller.getAllInstruments()));
        } catch (BDException ex) {
            barreInfo.setText(ex.toString());
        } catch (LoginException le) {
            barreInfo.setText(le.toString());
        }
        comboInstrument.setMinimumSize(new java.awt.Dimension(110, 20));
        comboInstrument.setPreferredSize(new java.awt.Dimension(110, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 10);
        add(comboInstrument, gridBagConstraints);

        comboDomaine.setModel(new javax.swing.DefaultComboBoxModel(new String[]{"Technicien", "Musicien"}));
        comboDomaine.setMinimumSize(new java.awt.Dimension(110, 20));
        comboDomaine.setPreferredSize(new java.awt.Dimension(110, 20));
        comboDomaine.setSelectedIndex(1);
        comboDomaine.addItemListener(comboListener);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 5);
        add(comboDomaine, gridBagConstraints);
    }

    public JTextField getTextNom() {
        return textNom;
    }

    public MembreGroupe getMembre() throws DateException {
        if (verify()) {
            java.sql.Date date = new java.sql.Date(datePanel.getDate().getTimeInMillis());

            MembreGroupe membre = new MembreGroupe(
                    textNom.getText(),
                    textPrenom.getText(),
                    textPseudo.getText(),
                    (String) comboNationalite.getModel().getSelectedItem(),
                    (String) comboDomaine.getModel().getSelectedItem(),
                    (comboInstrument.isEnabled()) ? (String) comboInstrument.getModel().getSelectedItem() : null,
                    date);
            return membre;
        } else {
            barreInfo.setText("Champ(s) incorrect(s) ou incomplet(s)");
            return null;
        }

    }

    public void reinit() {
        JTextField textDeBase = new JTextField();

        textNom.setText(null);
        textNom.setBorder(textDeBase.getBorder());
        textPrenom.setText(null);
        textPrenom.setBorder(textDeBase.getBorder());
        textPseudo.setText(null);
        textPseudo.setBorder(textDeBase.getBorder());
        comboInstrument.setSelectedIndex(0);
        comboNationalite.setSelectedIndex(0);
        datePanel.reinit();
    }

    public boolean verify() {
        if (textNom.getText().isEmpty() ||
                textPrenom.getText().isEmpty() ||
                textPseudo.getText().isEmpty() ||
                (comboInstrument.getSelectedItem() == null && comboDomaine.getSelectedIndex() == 1) ||
                comboNationalite.getSelectedItem() == null) {
            return false;
        } else {
            return true;
        }
    }

    public boolean isEmpty() {
        if (textNom.getText().isEmpty() &&
                textPrenom.getText().isEmpty() &&
                textPseudo.getText().isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    void setToModify(MembreGroupe membre) {
        textNom.setText(membre.getNom());
        textPrenom.setText(membre.getPrenom());
        textPseudo.setText(membre.getSurnom());
        if (membre.getDomaine().equals("Technicien")) {
            comboDomaine.setSelectedIndex(0);
        } else {
            comboDomaine.setSelectedIndex(1);
        }

        comboInstrument.setSelectedItem(membre.getInstrument());
        comboNationalite.setSelectedItem(membre.getNationalite());

    }

    private class ComboListener implements ItemListener {

        @Override
        public void itemStateChanged(ItemEvent e) {
            if (e.getSource() == comboDomaine) {
                if (e.getStateChange() == ItemEvent.SELECTED && comboDomaine.getSelectedIndex() == 0) {
                    comboInstrument.setSelectedIndex(0);
                    comboInstrument.setEnabled(false);
                } else if (e.getStateChange() == ItemEvent.SELECTED && comboDomaine.getSelectedIndex() != 0) {
                    comboInstrument.setEnabled(true);
                }
            }
        }
    }
}
