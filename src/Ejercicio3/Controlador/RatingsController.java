/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio3.Controlador;

import Ejercicio3.modelo.Ratings;
import controlador.DAO.AdaptadorDao;
import controlador.tda.lista.ListaEnlazadaServices;
import java.awt.RadialGradientPaint;

/**
 *
 * @author Gigabyte
 */
public class RatingsController extends AdaptadorDao<Ratings> {

    private Ratings ratings;
    private ListaEnlazadaServices<Ratings> listaRatings = new ListaEnlazadaServices<>();

    public RatingsController() {
        super(Ratings.class);
    }

    public Ratings getRatings() {
        if (ratings == null) {
            ratings = new Ratings();
        }
        return ratings;
    }

    public void setRatings(Ratings ratings) {
        this.ratings = ratings;
    }

    public ListaEnlazadaServices<Ratings> getListaRatings() {
        return listaRatings;
    }

    public void setListaRatings(ListaEnlazadaServices<Ratings> listaRatings) {
        this.listaRatings = listaRatings;
    }

    public Boolean guardar() {
        try {
            getRatings().setId(listaRatings.getSize() + 1);
            guardar(getRatings());
        } catch (Exception e) {
        }

        return true;
    }

    public Boolean modificar(Integer pos) {
        try {

            modificar(getRatings(), pos);
            return true;
        } catch (Exception e) {
            System.out.println("Error en modificar Cinema" + e);
        }
        return false;
    }

    public ListaEnlazadaServices<Ratings> listado() {
        setListaRatings(listar());

        return listaRatings;
    }


}
