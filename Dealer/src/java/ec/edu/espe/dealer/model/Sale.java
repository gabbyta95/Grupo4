/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.dealer.model;

import ec.edu.espe.dealer.controler.Conexion;
import static ec.edu.espe.dealer.model.Sale_.estado;
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
@Table(name = "venta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sale.findAll", query = "SELECT s FROM Sale s")
    , @NamedQuery(name = "Sale.findByIdVenta", query = "SELECT s FROM Sale s WHERE s.idVenta = :idVenta")
    , @NamedQuery(name = "Sale.findByIdUsuario", query = "SELECT s FROM Sale s WHERE s.idUsuario = :idUsuario")
    , @NamedQuery(name = "Sale.findByFecha", query = "SELECT s FROM Sale s WHERE s.fecha = :fecha")
    , @NamedQuery(name = "Sale.findByEstado", query = "SELECT s FROM Sale s WHERE s.estado = :estado")
    , @NamedQuery(name = "Sale.findByCodPedido", query = "SELECT s FROM Sale s WHERE s.codPedido = :codPedido")
    , @NamedQuery(name = "Sale.findByCodFactura", query = "SELECT s FROM Sale s WHERE s.codFactura = :codFactura")})
public class Sale implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
        @Column(name = "estado")
    private String estado;
    @Basic(optional = false)
    @Column(name = "id_venta")
    private String idVenta;
    @Basic(optional = false)
    @Column(name = "id_usuario")
    private String idUsuario;
    @Basic(optional = false)
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
 /*   @Column(name = "estado")
    private String estado;*/
    @Basic(optional = false)
    @Column(name = "cod_pedido")
    private String codPedido;
    @Column(name = "cod_factura")
    private String codFactura;

    public Sale() {
    }

    public Sale(String idVenta) {
        this.idVenta = idVenta;
    }

    public Sale(String idVenta, String idUsuario, Date fecha, String codPedido) {
        this.idVenta = idVenta;
        this.idUsuario = idUsuario;
        this.fecha = fecha;
        this.codPedido = codPedido;
    }

    public String getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(String idVenta) {
        this.idVenta = idVenta;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
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

    public String getCodPedido() {
        return codPedido;
    }

    public void setCodPedido(String codPedido) {
        this.codPedido = codPedido;
    }

    public String getCodFactura() {
        return codFactura;
    }

    public void setCodFactura(String codFactura) {
        this.codFactura = codFactura;
    }
    


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idVenta != null ? idVenta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sale)) {
            return false;
        }
        Sale other = (Sale) object;
        if ((this.idVenta == null && other.idVenta != null) || (this.idVenta != null && !this.idVenta.equals(other.idVenta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.dealer.model.Sale[ idVenta=" + idVenta + " ]";
    }
    
}
