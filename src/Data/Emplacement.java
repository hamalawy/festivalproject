package Data;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Emplacement {
	private int numEmplacement;
	private static int nbEmplacement=0;
	private Rectangle rect;
	private boolean reserve;
	
	public Emplacement(int x, int y, int w, int h)
	{
		rect = new Rectangle(x,y,w,h);
		reserve = false;
		nbEmplacement++;
		numEmplacement = nbEmplacement;
	}
	
	public boolean isReserve(){ return reserve; }
	
	public void dessine(Graphics g)
	{
		if(!isReserve())
			g.setColor(Color.green);
		else	
			g.setColor(Color.red);
		
		g.drawRect(rect.x, rect.y, rect.width, rect.height);
	}
	
	public void setRect(int x, int y, int w, int h)
	{
		rect.height=h;
		rect.width=w;
		rect.x=x;
		rect.y=y;
	}
	
	public Rectangle getRect(){ return rect; }

	public int getNumEmplacement() {
		// TODO Auto-generated method stub
		return this.numEmplacement;
	}
}
