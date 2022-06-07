/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio1.modelo;

import controlador.tda.lista.ListaEnlazadaServices;

import java.time.temporal.TemporalAccessor;
import java.util.Calendar;
import java.util.Date;
  
/**
 *
 * @author Gigabyte
 */
public class Comando<E> {
    private String comando;
    private String fecha;

    

    public String getComando() {
        return comando;
    }

    public void setComando(String comando) {
        this.comando = comando;
    }

    public String getFecha() {
        
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return comando + " " + fecha + " ";
    }

 
    
}
