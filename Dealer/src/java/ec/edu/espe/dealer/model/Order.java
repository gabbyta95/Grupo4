/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.dealer.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author diego
 */
public class Order {

    private String cod_order;
    private String concessionaire;
    private Date date;
    private String state;
    private Concessionaire concessionaire1;
    private String idconcessionaire;
    private ArrayList<Bike> listBike = new ArrayList<Bike>();

    public Order(String cod_order, String concesionario, Date fecha, String estado, Concessionaire concesionario1) {
        this.cod_order = cod_order;
        this.concessionaire = concesionario;
        this.date = fecha;
        this.state = estado;
        this.concessionaire1 = concesionario1;
    }
    
    public Order(String cod_order, String concesionario, Date fecha, String estado) {
        this.cod_order = cod_order;
        this.concessionaire = concesionario;
        this.date = fecha;
        this.state = estado;
    }

    public Order() {
    }

    public String getIdconcesionario() {
        return idconcessionaire;
    }

    public void setIdconcesionario(String idconcesionario) {
        this.idconcessionaire = idconcesionario;
    }

    public String getCod_pedido() {
        return cod_order;
    }

    public void setCod_pedido(String cod_pedido) {
        this.cod_order = cod_pedido;
    }

    public String getConcesionario() {
        return concessionaire;
    }

    public void setConcesionario(String concesionario) {
        this.concessionaire = concesionario;
    }

    public Date getFecha() {
        return date;
    }

    public void setFecha(Date fecha) {
        this.date = fecha;
    }

    public String getEstado() {
        return state;
    }

    public void setEstado(String estado) {
        this.state = estado;
    }

    public Concessionaire getConcesionario1() {
        return concessionaire1;
    }

    public void setConcesionario1(Concessionaire concesionario1) {
        this.concessionaire1 = concesionario1;
    }

    public ArrayList<Bike> getLista_Motos() {
        return listBike;
    }

    public void setLista_Motos(ArrayList<Bike> lista_Motos) {
        this.listBike = lista_Motos;
    }

    @Override
    public String toString() {
        return "Pedido{" + "cod_pedido=" + cod_order + ", concesionario=" + concessionaire + ", fecha=" + date + ", estado=" + state + ", concesionario1=" + concessionaire1 + ", lista_Motos=" + listBike + '}';
    }
}
