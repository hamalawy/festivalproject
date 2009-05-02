package Business;

import Business.MembreGroupe;
import java.util.Vector;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Gérôme Quentin
 * @author Scaillet Bruno
 */
public class AllResultMembreTableModel extends AbstractTableModel {

    private Vector<String> columnNames = new Vector<String>();
    private Vector<MembreGroupeAgrandi> membres = new Vector<MembreGroupeAgrandi>();

    public AllResultMembreTableModel() {
        columnNames.add("Groupe");
        columnNames.add("Nation. Gr.");
        columnNames.add("Genre");
        columnNames.add("Nom");
        columnNames.add("Prénom");
        columnNames.add("Nation.");
        columnNames.add("Domaine");
        columnNames.add("Instrument");
    }

    public AllResultMembreTableModel(Vector<MembreGroupeAgrandi> membres) {
        this();
        this.membres = membres;
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
    public String getColumnName(int col) {
        return columnNames.elementAt(col);
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        MembreGroupeAgrandi mem = membres.elementAt(rowIndex);

        switch (columnIndex) {
            case 0:
                return new String(mem.getNomGroupe());
            case 1:
                return new String(mem.getNationaliteGroupe());
            case 2:
                return new String(mem.getGenre());
            case 3:
                return new String(mem.getNom());
            case 4:
                return new String(mem.getPrenom());
            case 5:
                return new String(mem.getNationalite());
            case 6:
                return new String(mem.getDomaine());
            case 7:
                return (mem.getInstrument() != null) ? new String(mem.getInstrument()) : null;
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
            case 6:
                c = String.class;
                break;
            case 7:
                c = String.class;
                break;
        }
        return c;
    }
}
