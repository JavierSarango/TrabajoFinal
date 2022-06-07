/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio1.Vista.Modelotabla;

import Ejercicio1.modelo.Comando;
import controlador.tda.lista.ListaEnlazada;
import controlador.tda.lista.exception.PosicionException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;


/**
 *
 * @author Gigabyte
 */
public class ModeloTablaComandos extends AbstractTableModel {
    private ListaEnlazada<Comando> lista;

    public ListaEnlazada<Comando> getLista() {
        return lista;
    }

    public void setLista(ListaEnlazada<Comando> lista) {
        this.lista = lista;
    }

  
    
    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public int getRowCount() {
        return lista.getSize();
    }

    @Override
    public String getColumnName(int column) {
        switch(column) {
            case 0: return "Historial";
            case 1: return "Fecha";
            default: return null;
        }
    }


    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        try {
            Comando dp = lista.obtenerDato(rowIndex);
             
            switch (columnIndex) {
//                
                case 0: return dp.getComando();  
                case 1: return dp.getFecha();
                    
                default: return null;
            }
        } catch (PosicionException ex) {
            Logger.getLogger(ModeloTablaComandos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    
}
