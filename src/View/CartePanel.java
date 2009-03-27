package View;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Iterator;
import java.util.Vector;

import javax.swing.JPanel;

import Data.Emplacement;

public class CartePanel extends JPanel {
	
	private Vector <Emplacement> vectEmplacement = new Vector <Emplacement>();
	
	public CartePanel()
	{
		this.setBackground(Color.black);
		this.setSize(400, 400);
		vectEmplacement.add(new Emplacement(50,100,90,50));
		vectEmplacement.add(new Emplacement(150,200,40,40));
		vectEmplacement.add(new Emplacement(250,250,50,50));
		this.addMouseListener(new GestionAction());
		
	}
	
	public void paint(Graphics g)
	{
		super.paint(g);
		
		for(Emplacement empl: vectEmplacement)
		{
			empl.dessine(g);
		}
	}

	
	private class GestionAction implements MouseListener
	{

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			boolean trouve=false;
			int i=0;
			while(i<vectEmplacement.size() && !trouve)
			{
				if(vectEmplacement.get(i).getRect().contains(e.getPoint()))
					trouve=true;
				i++;
			}
			i--;
			System.out.println("Size : "+vectEmplacement.size()+"\ni : "+i+"\nTrouve : "+trouve);

			if(trouve == true)
				System.out.println(vectEmplacement.get(i).isReserve());
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
}