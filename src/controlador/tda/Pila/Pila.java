/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.tda.Pila;

import controlador.tda.lista.ListaEnlazada;
import controlador.tda.lista.exception.EstructuraVaciaException;
import controlador.tda.lista.exception.PosicionException;
import controlador.tda.lista.exception.TopeException;

/**
 *
 * @author Gigabyte
 */
public class Pila<E> extends ListaEnlazada<E> {

    private Integer tope;

    public Integer getTope() {
        return tope;
    }

    public Pila(Integer tope) {
        this.tope = tope;
    }

    public Pila() {
        this.tope = 0;
    }

    public Boolean estaLLeno() {
        if (tope == 0) {
            return false;
        } else if (tope == getSize().intValue()) {
            return true;
        } else {
            return false;
        }
    }

    public void push(E dato) throws TopeException {
        if (!estaLLeno()) {
            insertarCabecera(dato);
        } else {
            throw new TopeException("La pila está llena");
        }

    }

    public E pop(Integer pos) throws EstructuraVaciaException, PosicionException {
        E auxDato = null;
        if (!estaVacia()) {

            if (pos >= 0 && pos < getSize()) {
                for (int i = 0; i <= pos; i++) {
                    auxDato = eliminarDato(0);
                }
                return auxDato;
            } else {
                throw new PosicionException("Error al realizar la operaciòn POP. No existe la posicion dada");
            }
        } else {
            throw new EstructuraVaciaException("La pila està vacia");
        }
    }
    
    public static void main(String[] args) {
        Pila<Integer> pila = new Pila<>(5);
        try {
            pila.push(10);
            pila.push(1);
            pila.push(5);
            pila.push(8);
            pila.push(2);
            pila.imprimir();
            System.out.println("Elemento pop "+ pila.pop(2));
            pila.imprimir();
        } catch (Exception e) {
        }
    }
}
