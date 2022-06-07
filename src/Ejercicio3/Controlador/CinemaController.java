/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio3.Controlador;

import Ejercicio3.modelo.Cinema;
import Ejercicio3.modelo.Enum.Type;
import controlador.DAO.AdaptadorDao;
import controlador.tda.lista.ListaEnlazadaServices;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Gigabyte
 */
@XmlRootElement
public class CinemaController extends AdaptadorDao<Cinema> {

    private Cinema cinema;
    private ListaEnlazadaServices<Cinema> listaCinema = new ListaEnlazadaServices<>();

    public CinemaController() {
        super(Cinema.class);
        listado();
    }
 @XmlElement
    public Cinema getCinema() {
        if (cinema == null) {
            cinema = new Cinema();
        }
        return cinema;
    }

    public void setCinema(Cinema cinema) {
        this.cinema = cinema;
    }

    public ListaEnlazadaServices<Cinema> getListaCinema() {
        return listaCinema;
    }

    public void setListaCinema(ListaEnlazadaServices<Cinema> listaCinema) {
        this.listaCinema = listaCinema;
    }

    public Boolean guardar() {
        try {
            getCinema().setId(listaCinema.getSize() + 1);
            guardar(getCinema());
        } catch (Exception e) {
        }

        return true;
    }

    public Boolean modificar(Integer pos) {
        try {

            modificar(getCinema(), pos);
            return true;
        } catch (Exception e) {
            System.out.println("Error en modificar Cinema" + e);
        }
        return false;
    }

    public ListaEnlazadaServices<Cinema> listado() {
        setListaCinema(listar());
        return listaCinema;
    }

    public static void main(String[] args) {
        CinemaController rc = new CinemaController();
        rc.getCinema().setTitle("Guardians of the Galaxy Vol.2");
        rc.getCinema().setYear(2017);
        rc.getCinema().setRated("PG-13");
        rc.getCinema().setReleased("05 May 2017");
        rc.getCinema().setRuntime("136 min");
        rc.getCinema().setGenere("Action, Adventure, Comedy");
        rc.getCinema().setDirector("James Gunn");
        rc.getCinema().setWritter("James Gunn, Dan Abnett, Andy Lanning");
        rc.getCinema().setActors("Cris Pratt, Zoe Saldana, Dave Bautista");
        rc.getCinema().setPlot("The Guardians struggle to keep together as a team while dealing with their personal family issues, notably Star-Lord's encounter with his father the ambitious celestial being Ego");
        rc.getCinema().setLenguage("English");
        rc.getCinema().setCountry("UnitedStates");
        rc.getCinema().setAwards("Nominated for 1 Oscar. 15 wins & 59 nominations total");
        rc.getCinema().setPoster("https://m.media-amazon.com/images/M/MV5BNjM0NTc0NzItM2FlYS00YzEwLWE0YmUtNTA2ZWIzODc2OTgxXkEyXkFqcGdeQXVyNTgwNzIyNzg@._V1_SX300.jpg");
        rc.getCinema().setMetascore("67");
        rc.getCinema().setImdbRating(7.6);
        rc.getCinema().setImdbVotes(650.596);
        rc.getCinema().setImdbID("tt3896198");
        rc.getCinema().setTipo(Type.MOVIE);
        rc.getCinema().setDVD("22 Aug 2017");
        rc.getCinema().setBoxOffice(389813.101);
        rc.getCinema().setProduction("N/A");
        rc.getCinema().setWebsite("N/A");
        rc.getCinema().setResponse(Boolean.TRUE);
        rc.guardar();
     

    }
}
