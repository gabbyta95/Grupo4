/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author diego
 */
public class Proforma {
    private String id_proforma;
    private Date fecha_recepcion;
    private String estado;
    private Concesionario conces;
    private ArrayList<Detalle_Proforma> detalle;
    private float total;
    private String idConcesionario;

    public String getIdConcesionario() {
        return idConcesionario;
    }

    public void setIdConcesionario(String idConcesionario) {
        this.idConcesionario = idConcesionario;
    }

    public Proforma() {
    }

    public Proforma(String id_proforma, Date fecha_recepcion, String estado, Concesionario conces, ArrayList<Detalle_Proforma> detalle, float total) {
        this.id_proforma = id_proforma;
        this.fecha_recepcion = fecha_recepcion;
        this.estado = estado;
        this.conces = conces;
        this.detalle = detalle;
        this.total = total;
    }

    public String getId_proforma() {
        return id_proforma;
    }

    public void setId_proforma(String id_proforma) {
        this.id_proforma = id_proforma;
    }

    public Date getFecha_recepcion() {
        return fecha_recepcion;
    }

    public void setFecha_recepcion(Date fecha_recepcion) {
        this.fecha_recepcion = fecha_recepcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Concesionario getConces() {
        return conces;
    }

    public void setConces(Concesionario conces) {
        this.conces=conces;
    }

    public ArrayList<Detalle_Proforma> getDetalle() {
        return detalle;
    }

    public void setDetalle(ArrayList<Detalle_Proforma> detalle) {
        this.detalle = detalle;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }
    
    
    
}
