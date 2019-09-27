/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author diego
 */
public class Pedido {
    
    private String cod_pedido;
    private String concesionario  ;
    private Date fecha  ;
    private String estado  ;
    private Concesionario concesionario1 ;
    private String idconcesionario;
    private ArrayList<Moto> lista_Motos=new ArrayList<Moto>(); 

    public Pedido(String cod_pedido, String concesionario, Date fecha, String estado, Concesionario concesionario1) {
        this.cod_pedido = cod_pedido;
        this.concesionario = concesionario;
        this.fecha = fecha;
        this.estado = estado;
        this.concesionario1 = concesionario1;
    }

    public Pedido() {
    }

    public String getIdconcesionario() {
        return idconcesionario;
    }

    public void setIdconcesionario(String idconcesionario) {
        this.idconcesionario = idconcesionario;
    }

    public String getCod_pedido() {
        return cod_pedido;
    }

    public void setCod_pedido(String cod_pedido) {
        this.cod_pedido = cod_pedido;
    }

    public String getConcesionario() {
        return concesionario;
    }

    public void setConcesionario(String concesionario) {
        this.concesionario = concesionario;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Concesionario getConcesionario1() {
        return concesionario1;
    }

    public void setConcesionario1(Concesionario concesionario1) {
        this.concesionario1 = concesionario1;
    }

    public ArrayList<Moto> getLista_Motos() {
        return lista_Motos;
    }

    public void setLista_Motos(ArrayList<Moto> lista_Motos) {
        this.lista_Motos = lista_Motos;
    }

    @Override
    public String toString() {
        return "Pedido{" + "cod_pedido=" + cod_pedido + ", concesionario=" + concesionario + ", fecha=" + fecha + ", estado=" + estado + ", concesionario1=" + concesionario1 + ", lista_Motos=" + lista_Motos + '}';
    }
    
}
