package View.stand;

import Data.LoginException;
import View.VerifyDataException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;

import Controller.Controller;
import Data.BDException;
import Data.Stand;
import View.BarreInfo;
import View.GestionFocusTextField;
import View.VerifyData;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class StandInscriptionPanel extends JPanel {
	
    private javax.swing.JPanel actionPanel;
    private javax.swing.JTextArea areaDescription;
    private javax.swing.JButton butReinit;
    private javax.swing.JButton butSauver;
    private javax.swing.JComboBox comboType;
    private javax.swing.JLabel labelDescription;
    private javax.swing.JLabel labelNbEmploye;
    private javax.swing.JLabel labelSouscripteur;
    private javax.swing.JLabel labelType;
    private javax.swing.JScrollPane scrollDescription;
    private javax.swing.JTextField textNbEmploye;
    private javax.swing.JTextField textSouscripteur;
    private BarreInfo barreInfo;
    private GestionFocusTextField gestionFocusTextField;

	public StandInscriptionPanel(BarreInfo barreInfo)
	{
        this.barreInfo = barreInfo;
		java.awt.GridBagConstraints gridBagConstraints;
        gestionFocusTextField = new GestionFocusTextField();

        labelType = new javax.swing.JLabel();
        comboType = new javax.swing.JComboBox();
        labelNbEmploye = new javax.swing.JLabel();
        textNbEmploye = new javax.swing.JTextField();
        labelDescription = new javax.swing.JLabel();
        scrollDescription = new javax.swing.JScrollPane();
        areaDescription = new javax.swing.JTextArea();
        labelSouscripteur = new javax.swing.JLabel();
        textSouscripteur = new javax.swing.JTextField();
        actionPanel = new javax.swing.JPanel();
        butReinit = new javax.swing.JButton();
        butSauver = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createTitledBorder("Réservation d'un stand"));
        setLayout(new java.awt.GridBagLayout());

        labelType.setText("Type :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 0);
        add(labelType, gridBagConstraints);

        comboType.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Alimentaire", "Commercial" }));
        comboType.setMinimumSize(new java.awt.Dimension(110, 20));
        comboType.setPreferredSize(new java.awt.Dimension(110, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.RELATIVE;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 5, 5);
        add(comboType, gridBagConstraints);

        labelNbEmploye.setText("Nombre d'employés :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 0);
        add(labelNbEmploye, gridBagConstraints);

        textNbEmploye.setMinimumSize(new java.awt.Dimension(110, 20));
        textNbEmploye.setPreferredSize(new java.awt.Dimension(110, 20));
        textNbEmploye.addFocusListener(gestionFocusTextField);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.RELATIVE;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 5, 5);
        add(textNbEmploye, gridBagConstraints);

        labelDescription.setText("Description :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 0);
        add(labelDescription, gridBagConstraints);

        scrollDescription.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollDescription.setMinimumSize(new java.awt.Dimension(166, 96));

        areaDescription.setColumns(20);
        areaDescription.setLineWrap(true);
        areaDescription.setRows(5);
        scrollDescription.addFocusListener(new java.awt.event.FocusAdapter() {
            @Override
            public void focusLost(java.awt.event.FocusEvent e) {
			// TODO Auto-generated method stub
			JScrollPane scroll = (JScrollPane)e.getSource();
            Color color;
			if(!verify((areaDescription)))
				color = new Color(255,0,0,110);
			else
				color = new Color(0,255,0,110);
			scroll.setBorder(javax.swing.BorderFactory.createLineBorder(color));
            }
            private boolean verify(JTextArea text)
            {
                if(text.getText().isEmpty())
                    return false;
                else
                    return true;
            }
        });
        scrollDescription.setViewportView(areaDescription);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 5, 5);
        add(scrollDescription, gridBagConstraints);

        labelSouscripteur.setText("Souscripteur :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 0);
        add(labelSouscripteur, gridBagConstraints);

        textSouscripteur.setMinimumSize(new java.awt.Dimension(110, 20));
        textSouscripteur.setPreferredSize(new java.awt.Dimension(110, 20));
        textSouscripteur.addFocusListener(gestionFocusTextField);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 5, 5);
        add(textSouscripteur, gridBagConstraints);

        butReinit.setText("Rï¿½initialiser");
        butReinit.setAlignmentX(0.5F);
        butReinit.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        butReinit.setMaximumSize(new java.awt.Dimension(140, 23));
        butReinit.setMinimumSize(new java.awt.Dimension(140, 23));
        butReinit.setPreferredSize(new java.awt.Dimension(140, 23));
        butReinit.setMargin(new java.awt.Insets(2, 18, 2, 14));
        actionPanel.add(butReinit);
        butReinit.getAccessibleContext().setAccessibleName("butReinit");

        butSauver.setText("Sauver");
        butSauver.setAlignmentX(0.5F);
        butSauver.setMaximumSize(new java.awt.Dimension(140, 23));
        butSauver.setMinimumSize(new java.awt.Dimension(140, 23));
        butSauver.setPreferredSize(new java.awt.Dimension(140, 23));
        actionPanel.add(butSauver);
        butSauver.getAccessibleContext().setAccessibleName("butSauver");

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        add(actionPanel, gridBagConstraints);
        setInfoText("Stand");
		setVisible(true);
	}

	public void reinit() {
		// TODO Auto-generated method stub
		this.textNbEmploye.setText(null);
        this.textSouscripteur.setText(null);
        this.areaDescription.setText(null);
        this.comboType.setSelectedIndex(0);
	}
	
	public boolean verify()
	{
        if(textNbEmploye.getText().isEmpty() ||
           textNbEmploye.getText().isEmpty() ||
           textSouscripteur.getText().isEmpty() ||
           areaDescription.getText().isEmpty())
            return false;
        else
            return true;
	}

	public void createStand() {
	
		try {
            VerifyData v = new VerifyData();

            int nbPers = v.getSQLInt(textNbEmploye.getText());
            Stand newStand = new Stand(new String((String)comboType.getModel().getSelectedItem()),
								   nbPers,
								   textSouscripteur.getText(),
								   areaDescription.getText());

			Controller.createStand(newStand);
			setInfoText("Ajout du stand effectué avec succès");
            reinit();
        } catch (LoginException le) {
            setInfoText(le.toString());
        } catch (VerifyDataException ex) {
            setInfoText(ex.toString());
        } catch (NumberFormatException nbe){
            setInfoText(nbe.toString());
        } catch (BDException e) {
			setInfoText(e.toString());
		}
	}
    public void setInfoText(String string) {
        barreInfo.setText(string);
    }
}
