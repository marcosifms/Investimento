/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

//import hibernatePersistencia.Grupo;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Marcos
 */
public class PesquisarModel extends AbstractTableModel { 

    private List lstGrupos;
    
    public void setList(List lstGrupos) {
        this.lstGrupos = lstGrupos;
        this.fireTableDataChanged();
    }
    
    public Object getGrupo(int linha) {
        return (Object) lstGrupos.get(linha);
    }
    
    @Override
    public int getRowCount() {
        return lstGrupos.size();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
//        Grupo grupo = (Grupo) lstGrupos.get(rowIndex);
//        if (columnIndex == 0) {
//            return grupo.getIdgrupo();         }
//        if (columnIndex == 1) {
//            return grupo.getDescricao();          }     
//        if (columnIndex == 2) {
//            return grupo.getAtivo();          } 
        return null;
    }

    @Override
     public String getColumnName(int column)  {
         if (column == 0) {
             return "Código";
         } else {
             return "Nome";
         }
    }    
}
