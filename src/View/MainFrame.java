package View;

import View.groupe.GroupeInscriptionPanel;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

import View.stand.StandInscriptionPanel;


public class MainFrame extends JFrame{
	private Container cont;
	private BarreMenu menuBar;
	private BarreInfo barreInfo;
	/**
	 * the principal constructor of the MainFrame used to launch the application
	 * 
	 */
	public MainFrame()
	{
		this.setSize(600, 500);
		this.setTitle("Festival");
		this.setLocation(100, 100);
		cont = this.getContentPane();
		this.setLayout(new BorderLayout());
		//Menu
		menuBar = new BarreMenu(this);
		this.setJMenuBar(menuBar);
		
		barreInfo = new BarreInfo();
		
		
		//Fermeture de fen�tre
		this.addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{
				System.exit(0);
			}
		});
		
		//Affichage de l'accueil
		afficherBienvenue();
		
		//Active la fen�tre
		this.setVisible(true);
	}
	
	public BarreInfo getBarreInfo() {
		return barreInfo;
	}

	public void afficherBienvenue()
	{
		this.cont.removeAll();
		this.cont.add(barreInfo,BorderLayout.SOUTH);
		this.cont.add(new BienvenuePanel(),BorderLayout.CENTER);
		this.cont.validate();
	}
	
	public void afficherStandInscription() {
		this.cont.removeAll();
		this.cont.add(barreInfo,BorderLayout.SOUTH);
		this.cont.add(new StandInscriptionPanel(barreInfo), BorderLayout.CENTER);
		this.cont.validate();
	}
	public void afficherStandListing() {
		this.cont.removeAll();
		this.cont.add(barreInfo,BorderLayout.SOUTH);
		//this.cont.add(new StandInscriptionPanel());
		this.cont.validate();
	}
	public void afficherStandRecherche() {
		this.cont.removeAll();
		this.cont.add(barreInfo,BorderLayout.SOUTH);
		//this.cont.add(new StandInscriptionPanel());
		this.cont.validate();
	}
	public void afficherGroupeInscription() {
		this.cont.removeAll();
		this.cont.add(barreInfo,BorderLayout.SOUTH);
		this.cont.add(new GroupeInscriptionPanel(this),BorderLayout.CENTER);
		this.cont.validate();
	}
	public void afficherGroupeAnnulation() {
		this.cont.removeAll();
		this.cont.add(barreInfo,BorderLayout.SOUTH);
		//this.cont.add(new StandInscriptionPanel());
		this.cont.validate();
	}
	public void afficherGroupeListing() {
		this.cont.removeAll();
		this.cont.add(barreInfo,BorderLayout.SOUTH);
		//this.cont.add(new StandInscriptionPanel());
		this.cont.validate();
	}
	public void afficherGroupeRecherche() {
		this.cont.removeAll();
		this.cont.add(barreInfo,BorderLayout.SOUTH);
		//this.cont.add(new StandInscriptionPanel());
		this.cont.validate();
	}
	public void afficherPersonnelAjout() {
		this.cont.removeAll();
		this.cont.add(barreInfo,BorderLayout.SOUTH);
		//this.cont.add(new StandInscriptionPanel());
		this.cont.validate();
	}
	public void afficherPersonnelHoraire() {
		this.cont.removeAll();
		this.cont.add(barreInfo,BorderLayout.SOUTH);
		//this.cont.add(new StandInscriptionPanel());
		this.cont.validate();
	}
	public void afficherPersonnelListing() {
		this.cont.removeAll();
		this.cont.add(barreInfo,BorderLayout.SOUTH);
		//this.cont.add(new StandInscriptionPanel());
		this.cont.validate();
	}
	public void afficherPersonnelRecherche() {
		this.cont.removeAll();
		this.cont.add(barreInfo,BorderLayout.SOUTH);
		//this.cont.add(new StandInscriptionPanel());
		this.cont.validate();
	}
	public void afficherSceneHoraireConcerts() {
		this.cont.removeAll();
		this.cont.add(barreInfo,BorderLayout.SOUTH);
		//this.cont.add(new StandInscriptionPanel());
		this.cont.validate();
	}
	public void afficherSceneEnregCarac() {
		this.cont.removeAll();
		this.cont.add(barreInfo,BorderLayout.SOUTH);
		//this.cont.add(new StandInscriptionPanel());
		this.cont.validate();
	}
	public void afficherSceneListing() {
		this.cont.removeAll();
		this.cont.add(barreInfo,BorderLayout.SOUTH);
		//this.cont.add(new StandInscriptionPanel());
		this.cont.validate();
	}
		
}
