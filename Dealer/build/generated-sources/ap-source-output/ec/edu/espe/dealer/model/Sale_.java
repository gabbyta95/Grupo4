package ec.edu.espe.dealer.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-09-30T02:05:57")
@StaticMetamodel(Sale.class)
public class Sale_ { 

    public static volatile SingularAttribute<Sale, Date> fecha;
    public static volatile SingularAttribute<Sale, String> estado;
    public static volatile SingularAttribute<Sale, String> idUsuario;
    public static volatile SingularAttribute<Sale, String> codPedido;
    public static volatile SingularAttribute<Sale, String> codFactura;
    public static volatile SingularAttribute<Sale, String> idVenta;

}