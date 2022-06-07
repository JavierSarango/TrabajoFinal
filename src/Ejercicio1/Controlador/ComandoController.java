/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio1.Controlador;

import Ejercicio1.modelo.Comando;
import controlador.tda.Cola.ColaService;
import controlador.tda.Pila.PilaServicio;
import controlador.tda.lista.ListaEnlazadaServices;

/**
 *
 * @author Gigabyte
 */
public class ComandoController<E> {

    private Comando c;
    private ColaService<Comando> colaServicio = new ColaService<>(10);

    private ListaEnlazadaServices<Comando> listaComando = new ListaEnlazadaServices<Comando>();

    public Comando getC() {
        if (c == null) {
            c = new Comando();
        }
        return c;
    }

    public void setC(Comando c) {
        this.c = c;
    }

    public ColaService<Comando> getColaServicio() {
        return colaServicio;
    }

    public void setColaServicio(ColaService<Comando> colaServicio) {
        this.colaServicio = colaServicio;
    }

    public Boolean guardar(E dato, String fecha) {

        if (colaServicio.getSize() < colaServicio.getTope()) {
            Comando comando = new Comando();
            comando.setComando(dato.toString());
            comando.setFecha(fecha);
            c = comando;
            colaServicio.Queue(comando);
            listaComando.insertarAlFinal(comando);

        } else {

            colaServicio.Dequeue(0);
            listaComando.eliminarCabecera();
            Comando comando = new Comando();
            comando.setComando(dato.toString());
            comando.setFecha(fecha);
            c = comando;
            colaServicio.Queue(comando);
            listaComando.insertarAlFinal(comando);

        }

        return true;
    }

    

    public Integer topeCola() {
        return colaServicio.getTope();
    }

 

    public ListaEnlazadaServices<Comando> getListaComando() {
        return listaComando;
    }

    public void setListaComando(ListaEnlazadaServices<Comando> listaComando) {
        this.listaComando = listaComando;
    }

}
