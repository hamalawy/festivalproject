/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package View;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

/**
 *
 * @author Cramike
 */
public class GestionFocusTextField implements FocusListener
    {
    	private Color color;
		
    @Override
		public void focusGained(FocusEvent e) {
			// TODO Auto-generated method stub
		}
		
    @Override
		public void focusLost(FocusEvent e) {
			// TODO Auto-generated method stub
			JTextField text = (JTextField)e.getSource();

			if(!verify((JTextField)e.getSource()))
				color = new Color(255,0,0,110);
			else
				color = new Color(0,255,0,110);

			text.setBorder(new LineBorder((color)));
		}
        private boolean verify(JTextField text)
        {
            if(text.getText().isEmpty())
                return false;
            else
                return true;
        }
    }
