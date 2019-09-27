/* and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author diego
 */
public class Detalle_Proforma {
    
    private String idDetalleProforma;
    private Moto moto;
    private int cantidad;
    private String color;
    private float valor_detalle;
    private String idProforma;
    private String idmoto;

    public String getIdmoto() {
        return idmoto;
    }

    public void setIdmoto(String idmoto) {
        this.idmoto = idmoto;
    }

    public String getIdProforma() {
        return idProforma;
    }

    public void setIdProforma(String idProforma) {
        this.idProforma = idProforma;
    }
    
    public String getIdDetalleProforma() {
        return idDetalleProforma;
    }

    public void setIdDetalleProforma(String idDetalleProforma) {
        this.idDetalleProforma = idDetalleProforma;
    }

    public Detalle_Proforma() {
    }

    public Moto getMoto() {
        return moto;
    }

    public void setMoto(Moto moto) {
        this.moto = moto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public float getValor_detalle() {
        return valor_detalle;
    }

    public void setValor_detalle(float valor_detalle) {
        this.valor_detalle = valor_detalle;
    }
    
    
    
    
}
