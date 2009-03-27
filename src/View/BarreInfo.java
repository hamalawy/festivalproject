package View;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;


public class BarreInfo extends JPanel {
	private JLabel texte;
	public BarreInfo()
	{
		this.setLayout(new GridLayout(1,2));
		texte = new JLabel();
		add(texte);
        setLancement();
	}
	
	
	public JLabel getText()
	{
		return texte;
	}
	
	
	public void setText(String str)
	{
        this.texte.setText(str);

	}
    public void setLancement()
    {
        this.texte.setText("Lancement...");

    }

}
