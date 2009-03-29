package View;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class BarreInfo extends JPanel {

    private JLabel texte;
    private boolean requestReceived;
    private ThreadBarreInfo thread = new ThreadBarreInfo(this);

    public BarreInfo() {
        thread.start();
        this.setLayout(new GridLayout(1, 2));
        this.setPreferredSize(new Dimension(20,30));
        texte = new JLabel();
        add(texte);
    }

    public boolean isRequestReceived() {
        return requestReceived;
    }

    public JLabel getText() {
        return texte;
    }

    public void setText(String str) {
        this.texte.setText(str);
        requestReceived = true;

    }

    public void setThreadText() {
        setText("");
    }
}
