/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio2.modelo;

/**
 *
 * @author Javier
 */
public class Oficina {
    private Integer id;
    private String nomEncargado;
    private String apeEncargado;
    private String servicio;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomEncargado() {
        return nomEncargado;
    }

    public void setNomEncargado(String nomEncargado) {
        this.nomEncargado = nomEncargado;
    }

    public String getApeEncargado() {
        return apeEncargado;
    }

    public void setApeEncargado(String apeEncargado) {
        this.apeEncargado = apeEncargado;
    }

   

    public String getServicio() {
        return servicio;
    }

    public void setServicio(String servicio) {
        this.servicio = servicio;
    }

    @Override
    public String toString() {
        return nomEncargado + " "+ apeEncargado + " "+ servicio+ " ";
                
    }
    
    
    
}
