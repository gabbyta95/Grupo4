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
public class Factura {
    private String cod_factura;
    private String fecha;
    private Venta venta;
    private float subtotal;
    private float imp;
    private float total;

    public Factura() {
    }

    public String getCod_factura() {
        return cod_factura;
    }

    public void setCod_factura(String cod_factura) {
        this.cod_factura = cod_factura;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    public float getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(float subtotal) {
        this.subtotal = subtotal;
    }

    public float getImp() {
        return imp;
    }

    public void setImp(float imp) {
        this.imp = imp;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }
    
}
