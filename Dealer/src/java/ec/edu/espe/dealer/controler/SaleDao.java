/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.dealer.controler;

import ec.edu.espe.dealer.model.Sale;
import ec.edu.espe.dealer.model.Usuario;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author DANIELAROSERO
 */
public class SaleDao {
    
    

private Conexion conexion = new Conexion();
        public Sale getVentaEstado(String estado){
        Connection con = conexion.getConnection();
        Statement st;
        ResultSet rs;
        String sql="SELECT * from venta where estado='"+estado+"'";
        Sale venta = new Sale();
        try {
            st = con.createStatement();
            rs=st.executeQuery(sql);
            while(rs.next()){
                venta.setIdVenta("idVenta");
                venta.setEstado(rs.getString("estado"));
                Usuario user = new Usuario();
                user.setIdUsuario(rs.getString("id_usuario"));
            }
            //JOptionPane.showMessageDialog(null,"Registro creado!!!");
            //Cerramos las conexiones 
            st.close();
            con.close();
        }//Permite determinar los errores 
        catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error no se encontro la factura");
        }
        return venta;
    }
}
