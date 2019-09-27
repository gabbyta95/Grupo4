/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author diego
 */
public class Moto {
    
    private String id_moto;
    private String cilindraje;
    private String Modelo;
    private float precio;

    public Moto() {
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public Moto(String id_moto, String cilindraje, String Modelo) {
        this.id_moto = id_moto;
        this.cilindraje = cilindraje;
        this.Modelo = Modelo;
    }

    public String getId_moto() {
        return id_moto;
    }

    public void setId_moto(String id_moto) {
        this.id_moto = id_moto;
    }

    public String getCilindraje() {
        return cilindraje;
    }

    public void setCilindraje(String cilindraje) {
        this.cilindraje = cilindraje;
    }

    public String getModelo() {
        return Modelo;
    }

    public void setModelo(String Modelo) {
        this.Modelo = Modelo;
    }
    
    
    
}
