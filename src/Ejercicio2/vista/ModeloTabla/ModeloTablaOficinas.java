/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio2.vista.ModeloTabla;

import Ejercicio1.modelo.Comando;
import Ejercicio2.modelo.Oficina;
import controlador.tda.lista.ListaEnlazada;
import controlador.tda.lista.exception.PosicionException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;


/**
 *
 * @author Gigabyte
 */
public class ModeloTablaOficinas extends AbstractTableModel {
    private ListaEnlazada<Oficina> lista;

    public ListaEnlazada<Oficina> getLista() {
        return lista;
    }

    public void setLista(ListaEnlazada<Oficina> lista) {
        this.lista = lista;
    }

  
    
    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public int getRowCount() {
        return lista.getSize();
    }

    @Override
    public String getColumnName(int column) {
        switch(column) {
            case 0: return "ID";
            case 1: return "N.Encargado";
            case 2: return "A.Encargado";
            case 3: return "Servicio";
            default: return null;
        }
    }


    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        try {
            Oficina dp = lista.obtenerDato(rowIndex);
             
            switch (columnIndex) {
//                
                case 0: return dp.getId();  
                case 1: return dp.getNomEncargado();
                case 2: return dp.getApeEncargado();
                case 3: return dp.getServicio();
                    
                default: return null;
            }
        } catch (PosicionException ex) {
            Logger.getLogger(ModeloTablaOficinas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    
}
