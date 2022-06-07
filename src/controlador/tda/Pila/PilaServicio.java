/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.tda.Pila;

import controlador.tda.lista.exception.EstructuraVaciaException;
import controlador.tda.lista.exception.PosicionException;

/**
 *
 * @author Gigabyte
 */
public class PilaServicio<E> {

    private Pila<E> pila;

    public PilaServicio(Integer tope) {
        if (tope == 0) {
            pila = new Pila<>();
        } else {
            pila = new Pila<>();
        }
    }

    public Boolean push(E dato) {
        try {
            pila.push(dato);
            return true;
        } catch (Exception e) {
        }
        return false;
    }

    public E pop(Integer pos) {
        try {
            return pila.pop(pos);

        } catch (EstructuraVaciaException | PosicionException e) {
        }
        return null;
    }
    public Integer getSize(){
    return pila.getSize();
    }
    
    public Integer getTope(){
    return pila.getTope();
    }
}
