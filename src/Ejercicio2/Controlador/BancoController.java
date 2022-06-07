/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio2.Controlador;

import Ejercicio2.modelo.Banco;
import Ejercicio2.modelo.Oficina;
import controlador.tda.lista.ListaEnlazadaServices;

/**
 *
 * @author Javier
 */
public class BancoController {

    private Banco banco;
    private ListaEnlazadaServices<Banco> listaBanco = new ListaEnlazadaServices<>();

    public Banco getBanco() {
        return banco;
    }

    public void setBanco(Banco banco) {
        this.banco = banco;
    }

    public ListaEnlazadaServices<Banco> getListaBanco() {
        return listaBanco;
    }

    public void setListaBanco(ListaEnlazadaServices<Banco> listaBanco) {
        this.listaBanco = listaBanco;
    }

    public Boolean guardar(String propietario, String direccion, String telefono, String oficina) {
        Banco nuevo = new Banco();
        nuevo.setId(listaBanco.getSize() + 1);
        nuevo.setPropietario(propietario);
        nuevo.setDireccion(direccion);
        listaBanco.insertarAlFinal(banco);

        return true;
    }
}
