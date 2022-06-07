/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio2.Controlador;

import Ejercicio2.modelo.Oficina;
import controlador.tda.lista.ListaEnlazada;
import controlador.tda.lista.ListaEnlazadaServices;

/**
 *
 * @author Javier
 */
public class OficinaController {

    private Oficina oficina;
    private ListaEnlazadaServices<Oficina> listaOficina = new ListaEnlazadaServices<>();

    public Oficina getOficina() {
        if (oficina == null) {
            oficina = new Oficina();

        }
        return oficina;
    }

    public void setOficina(Oficina oficina) {
        this.oficina = oficina;
    }

    public ListaEnlazadaServices<Oficina> getListaOficina() {
        return listaOficina;
    }

    public void setListaOficina(ListaEnlazadaServices<Oficina> listaOficina) {
        this.listaOficina = listaOficina;
    }

    public Boolean guardar(String nomEncargado, String apeEncargado, String Servicio) {

        Oficina nuevo = new Oficina();
        nuevo.setId(listaOficina.getSize()+1);
        nuevo.setNomEncargado(nomEncargado);
        nuevo.setApeEncargado(apeEncargado);
        nuevo.setServicio(Servicio);
        listaOficina.insertar(nuevo, 0);
        listaOficina.imprimir();
//        System.out.println("ID: "+ nuevo.getId());
//        System.out.println(listaOficina.getSize());
        return true;
    }
//
//    public static void main(String[] args) {
//        OficinaController oc = new OficinaController();
//        String nombre = "Josue";
//        String ape = "Villavicencio";
//        String ser = "Apertura Cuenta";
//        String nombre1 = "Maria";
//        String ape1 = "Jiménez";
//        String ser1 = "Generar Tarjeta de Crédito/Debito";
//        String nombre2 = "Luisa";
//        String ape2 = "Ramirez";
//        String ser2 = "Solicitud de Préstamos";
//        oc.guardar(nombre, ape, ser);
//        oc.guardar(nombre1, ape1, ser1);
//        oc.guardar(nombre2, ape2, ser2);
//    }
}
