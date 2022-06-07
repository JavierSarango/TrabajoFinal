/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio2.Controlador;

import Ejercicio2.modelo.Oficina;
import Ejercicio2.modelo.Ticket;
import controlador.tda.Cola.ColaService;
import controlador.tda.lista.ListaEnlazadaServices;

/**
 *
 * @author Javier
 */
public class TicketController {

    private Ticket ticket;
    private ColaService<Ticket> colaticket = new ColaService<>(20);
    private ListaEnlazadaServices<Ticket> listaTicket = new ListaEnlazadaServices<>();

    public Ticket getTicket() {
        if (ticket == null) {
            ticket = new Ticket();
        }
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public ColaService<Ticket> getColaticket() {
        return colaticket;
    }

    public void setColaticket(ColaService<Ticket> colaticket) {
        this.colaticket = colaticket;
    }

    public ListaEnlazadaServices<Ticket> getListaTicket() {
        return listaTicket;
    }

    public void setListaTicket(ListaEnlazadaServices<Ticket> listaTicket) {
        this.listaTicket = listaTicket;
    }

    public Boolean guardar(String nomCliente, String apeCliente, String fecha, String servicio, Double precio) {

        if (colaticket.getSize() < colaticket.getTope()) {
            Ticket nuevo = new Ticket();
            nuevo.setId(listaTicket.getSize() + 1);
            nuevo.setNomCliente(nomCliente);
            nuevo.setApeCliente(apeCliente);
            nuevo.setFecha(fecha);
            nuevo.setPrecio(precio);
            nuevo.setServicio(servicio);
            colaticket.Queue(nuevo);
            listaTicket.insertarAlFinal(nuevo);
            return true;
        } else {
            System.out.println("Cola llena ");

        }

        return false;
    }

    public Boolean borradoLogico(int pos) {
        colaticket.Dequeue(pos);
        listaTicket.eliminarPosicion(pos);
        return true;
    }
}
