/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.dealer.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author DANIELAROSERO
 */
@Entity
@Table(name = "pedido")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pedido.findAll", query = "SELECT p FROM Pedido p")
    , @NamedQuery(name = "Pedido.findByCodPedido", query = "SELECT p FROM Pedido p WHERE p.codPedido = :codPedido")
    , @NamedQuery(name = "Pedido.findByFechaRecepcion", query = "SELECT p FROM Pedido p WHERE p.fechaRecepcion = :fechaRecepcion")
    , @NamedQuery(name = "Pedido.findByEstado", query = "SELECT p FROM Pedido p WHERE p.estado = :estado")
    , @NamedQuery(name = "Pedido.findByIdConcesionario", query = "SELECT p FROM Pedido p WHERE p.idConcesionario = :idConcesionario")})
public class Pedido implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "cod_pedido")
    private String codPedido;
    @Column(name = "fecha_recepcion")
    @Temporal(TemporalType.DATE)
    private Date fechaRecepcion;
    @Column(name = "estado")
    private String estado;
    @Basic(optional = false)
    @Column(name = "id_concesionario")
    private String idConcesionario;

    public Pedido() {
    }

    public Pedido(String codPedido) {
        this.codPedido = codPedido;
    }

    public Pedido(String codPedido, String idConcesionario) {
        this.codPedido = codPedido;
        this.idConcesionario = idConcesionario;
    }

    public String getCodPedido() {
        return codPedido;
    }

    public void setCodPedido(String codPedido) {
        this.codPedido = codPedido;
    }

    public Date getFechaRecepcion() {
        return fechaRecepcion;
    }

    public void setFechaRecepcion(Date fechaRecepcion) {
        this.fechaRecepcion = fechaRecepcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getIdConcesionario() {
        return idConcesionario;
    }

    public void setIdConcesionario(String idConcesionario) {
        this.idConcesionario = idConcesionario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codPedido != null ? codPedido.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pedido)) {
            return false;
        }
        Pedido other = (Pedido) object;
        if ((this.codPedido == null && other.codPedido != null) || (this.codPedido != null && !this.codPedido.equals(other.codPedido))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.dealer.model.Pedido[ codPedido=" + codPedido + " ]";
    }
    
}
