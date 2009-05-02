package Business;

import Controller.Controller;
import Data.BDException;
import Business.GroupeScene;
import View.MainFrame;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Gérôme Quentin
 * @author Scaillet Bruno
 */
public class AllGroupeSceneTableModel extends AbstractTableModel {

    private Vector<String> columnNames = new Vector<String>();
    private Vector<GroupeScene> vecteur = new Vector<GroupeScene>();
    private MainFrame main;
    private Vector<String> vecScenes;

    public AllGroupeSceneTableModel(Vector<GroupeScene> vecteur) {
        this.vecteur = vecteur;
        columnNames.add("Nom");
        columnNames.add("Nationalité");
        columnNames.add("Scène");
    }

    @Override
    public int getRowCount() {
        return vecteur.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.size();
    }

    @Override
    public String getColumnName(int col) {
        return columnNames.elementAt(col);
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        GroupeScene g = vecteur.elementAt(rowIndex);
        switch (columnIndex) {
            case 0:
                return new String(g.getNom());
            case 1:
                return new String(g.getNationalite());
            case 2:
                return new String(g.getLibScene());
            default:
                return null;
        }
    }

    @Override
    public Class<?> getColumnClass(int col) {
        Class c = Integer.class;
        switch (col) {
            case 0:
                c = String.class;
                break;
            case 1:
                c = String.class;
                break;
            case 2:
                c = String.class;
                break;
        }
        return c;
    }
}
