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
public class Venta {
    private String cod_entrega;
    private Concesionario conse;
    private String fecha;
    private String estado;
    private Usuario user;
    private Pedido pedido;
    private Factura fact;

    public Venta() {
    }

    public String getCod_entrega() {
        return cod_entrega;
    }

    public void setCod_entrega(String cod_entrega) {
        this.cod_entrega = cod_entrega;
    }

    public Concesionario getConse() {
        return conse;
    }

    public void setConse(Concesionario conse) {
        this.conse = conse;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Factura getFact() {
        return fact;
    }

    public void setFact(Factura fact) {
        this.fact = fact;
    }
    
    
}
