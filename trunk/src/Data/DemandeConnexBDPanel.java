package Data;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import java.util.Vector;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class DemandeConnexBDPanel extends JPanel {
	private JPasswordField password;
	private JLabel labelPass, labelUser;
	private JTextField textUser;
	private GridBagConstraints gbc = new GridBagConstraints();
    private Vector <String> vecUser = new Vector <String> ();
	
	public DemandeConnexBDPanel()
	{
		this.setLayout(new GridBagLayout());
		//labelUser
		gbc.gridx=0;
		gbc.gridy=0;
		gbc.gridwidth=GridBagConstraints.RELATIVE;
		gbc.gridheight=1;
		gbc.insets= new Insets(2,2,2,2);
		
		labelUser = new JLabel("Utilisateur : ");
		add(labelUser, gbc);
		
		//textUser
		gbc.gridx=1;
		gbc.gridwidth=GridBagConstraints.REMAINDER;
		
		textUser = new JTextField();
        textUser.setMinimumSize(new java.awt.Dimension(110, 20));
        textUser.setPreferredSize(new java.awt.Dimension(110, 20));
        textUser.requestFocusInWindow();
		add(textUser, gbc);
		
		//labelPass
		gbc.gridx=0;
		gbc.gridy=1;
		gbc.gridwidth=GridBagConstraints.RELATIVE;
		
		labelPass = new JLabel("Password : ");
		labelPass.setHorizontalAlignment(SwingConstants.RIGHT);

		add(labelPass, gbc);
		
		//password
		gbc.gridx=1;
		gbc.gridwidth=GridBagConstraints.REMAINDER;
		
		password = new JPasswordField();
        password.setMinimumSize(new java.awt.Dimension(110, 20));
        password.setPreferredSize(new java.awt.Dimension(110, 20));
		add(password, gbc);

        vecUser.add("cramike");
        vecUser.add("cail");
	}
	
	public String getPassword()
	{
		return new String(password.getPassword());
	}
	
	public String getUser()
	{
            return textUser.getText();        
	}

    public boolean isCorrectUser() throws LoginException
    {
        if(vecUser.contains((String)getUser().toLowerCase()))
            return true;
        else
            throw new LoginException();
    }

}

