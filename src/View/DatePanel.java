package View;



import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.GregorianCalendar;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JPanel;

public class DatePanel extends JPanel{
	private JComboBox jour, mois, annee;
	private String tJour[] = new String[31];
	private String tMois[] = new String[12];
	private String tAn[] = new String [70];

	public DatePanel()
	{
		this.initialiseCombobox();
		this.setSize(180, 40);
		//this.setLayout(new BorderLayout());
		this.setLayout(new GridBagLayout());

	}

    public void reinit() {
        mois.setSelectedIndex(0);
        annee.setSelectedIndex(0);
        jour.setSelectedIndex(0);
    }

	private void initialiseCombobox()
	{
		GregorianCalendar today = new GregorianCalendar();

        int anneeNow=today.get(GregorianCalendar.YEAR);

		for(int i = 0;i<31; i++)
		{
			tJour[i]=Integer.toString(i+1);
		}
		for(int i = 0;i<12;i++)
		{
			tMois[i]=Integer.toString(i+1);
		}

		for(int i = 0; i < 70; i++)
		{
			tAn[i]=Integer.toString(anneeNow);
			anneeNow--;
		}


        //Placement
        jour = new JComboBox();
        jour.setModel(new DefaultComboBoxModel(tJour));
		mois = new JComboBox();
        mois.setModel(new DefaultComboBoxModel(tMois));
		annee = new JComboBox();
        annee.setModel(new DefaultComboBoxModel(tAn));

		jour.setEditable(false);
		mois.setEditable(false);
		annee.setEditable(false);

		jour.setMaximumRowCount(6);
		mois.setMaximumRowCount(6);
		annee.setMaximumRowCount(6);

		jour.setSelectedIndex(0);
		mois.setSelectedIndex(0);
		annee.setSelectedIndex(0);

        jour.setMinimumSize(new Dimension(50,20));
		jour.setMaximumSize(jour.getMinimumSize());
        jour.setPreferredSize(jour.getMinimumSize());

		mois.setMaximumSize(jour.getMinimumSize());
        mois.setMinimumSize(jour.getMinimumSize());
        mois.setPreferredSize(jour.getMinimumSize());

		annee.setMinimumSize(new Dimension(70,20));
        annee.setMaximumSize(annee.getMinimumSize());
        annee.setPreferredSize(annee.getMinimumSize());


        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx=0;
        gbc.gridy=0;
		this.add(jour,gbc);

        gbc.gridx=1;
		this.add(mois,gbc);

        gbc.gridx=2;
        gbc.weightx=0;
		this.add(annee,gbc);
	}

    
	public GregorianCalendar getDate() throws DateException
	{
        int anneeStr, moisStr, jourStr;
        anneeStr =Integer.parseInt(annee.getModel().getSelectedItem().toString());
        moisStr = Integer.parseInt(mois.getModel().getSelectedItem().toString())-1;
        jourStr = Integer.parseInt(jour.getModel().getSelectedItem().toString());
		try{
			GregorianCalendar anneeNaiss = new GregorianCalendar();
            anneeNaiss.setLenient(false);
			anneeNaiss.set(anneeStr,moisStr,jourStr);
			return anneeNaiss;
		} catch(Exception e)
		{
			throw new DateException(e);
		}
	}
}