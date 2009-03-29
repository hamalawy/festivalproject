package Business;

import Data.MembreGroupe;
import java.util.GregorianCalendar;
import java.util.Vector;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Gérôme Quentin
 * @author Scaillet Bruno
 */
public class AllMembresTableModel extends AbstractTableModel {

    private Vector<String> columnNames = new Vector<String>();
    private Vector<MembreGroupe> membres = new Vector<MembreGroupe>();

    public AllMembresTableModel(Vector<MembreGroupe> membres) {
        this.membres = membres;
        columnNames.add("Nom");
        columnNames.add("Prénom");
        columnNames.add("Nationalité");
        columnNames.add("Domaine");
        columnNames.add("Instrument");
        columnNames.add("Date naissance");
    }

    @Override
    public int getRowCount() {
        return membres.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.size();
    }
    
    @Override
    public String getColumnName(int col) {return columnNames.elementAt(col); }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        MembreGroupe mem = membres.elementAt(rowIndex);

        switch (columnIndex) {
            case 0:
                return new String(mem.getNom());
            case 1:
                return new String(mem.getPrenom());
            case 2:
                return new String(mem.getNationalite());
            case 3:
                return new String(mem.getDomaine());
            case 4:
                return (mem.getInstrument() != null)?new String(mem.getInstrument()) : null;
            case 5:
                return new String(mem.getDateNaiss().toString());
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
            case 3:
                c = String.class;
                break;
            case 4:
                c = String.class;
                break;
            case 5:
                c = String.class;
                break;
        }
        return c;
    }
}
