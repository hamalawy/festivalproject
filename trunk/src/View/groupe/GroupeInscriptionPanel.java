package View.groupe;

import Data.MembreGroupe;
import View.BarreInfo;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.Vector;
import javax.swing.BorderFactory;
import javax.swing.JPanel;



public class GroupeInscriptionPanel extends JPanel{
    private Groupe_InscriptionMembrePanel membre;
    private Groupe_InscriptionGroupePanel groupe;
    private BarreInfo barreInfo;
    private GridBagConstraints gbc;
    private Vector <MembreGroupe> vectMembreGroupe= new Vector <MembreGroupe>();
    private javax.swing.JButton butEnregistrer;
    private javax.swing.JButton butRetour;
    private JPanel mainAction;

	
	public GroupeInscriptionPanel(BarreInfo barreInfo)
	{
        this.barreInfo = barreInfo;
        this.setLayout(new GridBagLayout());
        setBorder(BorderFactory.createTitledBorder("Inscription d'un groupe"));
        groupe = new Groupe_InscriptionGroupePanel(this);

        //Panel d'action placé en bas de la fenêtre
        butRetour = new javax.swing.JButton();
        butEnregistrer = new javax.swing.JButton();
        mainAction = new JPanel();

        mainAction.setBorder(javax.swing.BorderFactory.createTitledBorder("Actions"));
        mainAction.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));


        butRetour.setText("Retour");
        butRetour.setToolTipText("Retour à la page d'accueil");
        mainAction.add(butRetour);

        butEnregistrer.setText("Enregistrer le groupe");
        butEnregistrer.setToolTipText("Enregistrer le groupe dans la base de données");
        mainAction.add(butEnregistrer);
        afficherAjoutMembre();

    }
    
    public Vector<MembreGroupe> getVectMembreGroupe() {
        return vectMembreGroupe;
    }

    public void setInfoText(String string) {
        barreInfo.setText(string);
    }

    void afficherAjoutMembre() {
        this.removeAll();
        membre = new Groupe_InscriptionMembrePanel(this);
        gbc = new GridBagConstraints();
        gbc.gridx=0;
        gbc.gridy=0;
        gbc.anchor=gbc.CENTER;
        gbc.fill=gbc.HORIZONTAL;

        add(groupe,gbc);
        gbc.gridy=1;
        add(membre,gbc);

        gbc.gridy=2;
        gbc.gridwidth=gbc.REMAINDER;
        add(mainAction, gbc);

        this.validate();
    }

    void afficherTableMembre() {
        this.removeAll();
        gbc = new GridBagConstraints();
        Groupe_TablePanel tableMembre = new Groupe_TablePanel(this);

        gbc.gridx=0;
        gbc.gridy=0;
        gbc.anchor=gbc.CENTER;
        gbc.fill=gbc.HORIZONTAL;

        add(groupe,gbc);
        gbc.gridy=1;
        add(tableMembre,gbc);

        gbc.gridy=2;
        gbc.gridwidth=gbc.REMAINDER;
        add(mainAction, gbc);
        this.validate();
    }


}
