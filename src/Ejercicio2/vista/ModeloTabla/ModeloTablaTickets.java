/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio2.vista.ModeloTabla;


import Ejercicio2.modelo.Ticket;
import controlador.tda.lista.ListaEnlazada;
import controlador.tda.lista.exception.PosicionException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;


/**
 *
 * @author Gigabyte
 */
public class ModeloTablaTickets extends AbstractTableModel {
    private ListaEnlazada<Ticket> lista;

    public ListaEnlazada<Ticket> getLista() {
        return lista;
    }

    public void setLista(ListaEnlazada<Ticket> lista) {
        this.lista = lista;
    }

  
    
    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public int getRowCount() {
        return lista.getSize();
    }

    @Override
    public String getColumnName(int column) {
        switch(column) {
            case 0: return "ID";
            case 1: return "N.Cliente";
            case 2: return "A.Apellido";
            case 3: return "Fecha";
            case 4: return "Tramite";
            case 5: return "Pecio";
            
            default: return null;
        }
    }


    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        try {
            Ticket dp = lista.obtenerDato(rowIndex);
             
            switch (columnIndex) {
//                
                case 0: return dp.getId();  
                case 1: return dp.getNomCliente();
                case 2: return dp.getApeCliente();
                case 3: return dp.getFecha();
                case 4: return dp.getServicio();
                case 5: return dp.getPrecio().toString();
                    
                default: return null;
            }
        } catch (PosicionException ex) {
            Logger.getLogger(ModeloTablaTickets.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    
}
