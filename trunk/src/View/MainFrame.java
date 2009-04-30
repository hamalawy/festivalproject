package View;

import View.groupe.GroupeInscriptionMainPanel;
import View.groupe.GroupeListingPanel;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

import View.stand.StandInscriptionPanel;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JPanel;


public class MainFrame extends JFrame{
	private Container cont;
	private BarreMenu menuBar;
	private BarreInfo barreInfo;
    private Dimension frameSize, screenSize;

	/**
	 * the principal constructor of the MainFrame used to launch the application
	 * 
	 */
	public MainFrame()
	{
		this.setTitle("Festival");
		cont = this.getContentPane();
		this.setLayout(new BorderLayout());

        //Taille
        frameSize = new Dimension(700, 500);
        this.setSize(frameSize);
        screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        if(frameSize.width>screenSize.width)
            frameSize.width = screenSize.width;
        if(frameSize.height>screenSize.height)
            frameSize.height = screenSize.height;
        this.setLocation((screenSize.width-frameSize.width)/2,(screenSize.height-frameSize.height)/2);

		//Menu
		menuBar = new BarreMenu(this);
		this.setJMenuBar(menuBar);
		
		barreInfo = new BarreInfo();
        menuBar.setVisible(false);
		afficherPanel(new ConnexPanel(this));
		
		//Fermeture de fen�tre
		this.addWindowListener(new WindowAdapter()
		{
			@Override
            public void windowClosing(WindowEvent e)
			{
				System.exit(0);
			}
		});
		
		//Affichage de l'accueil
		afficherPanel(new ConnexPanel(this));
		
		//Active la fen�tre
		this.setVisible(true);
	}
	
	public BarreInfo getBarreInfo() {
		return barreInfo;
	}




    public void afficherPanel(JPanel panel) {
        this.cont.removeAll();
		this.cont.add(barreInfo,BorderLayout.SOUTH);
        this.cont.add(panel);
        this.cont.validate();
    }
		
}
