/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.detalle_Pedido;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Erick
 */
public class PedidoDetalleDADO {
    public void registrarDetallePedido(detalle_Pedido pro)
    {
        Conexion con = new Conexion();      
        Connection accesoBD = con.getConnection();
        try{
           PreparedStatement ps = accesoBD.prepareCall("call insertarDetallePedido(?,?,?,?,?)");           
           ps.setString(1, pro.getId_detalle());
           ps.setString(2, pro.getCod_pedido());
           ps.setString(3, pro.getId_moto());
           ps.setInt(4, pro.getCant());
           ps.setString(5, pro.getColor()); 
           int res = ps.executeUpdate();
           if(res == 1)
               System.out.println("Registro exitoso");
        }
        catch(Exception e)
        {
           JOptionPane.showMessageDialog(null,e.getMessage());
        }    
    } 
    
    public String buscarDetallePedido(String id)
    {
        Conexion con = new Conexion();        
        detalle_Pedido pro = new detalle_Pedido(); 
        Connection accesoBD = con.getConnection();
        
        try{
            PreparedStatement ps = accesoBD.prepareCall("call buscarDetallePedido(?)");
            ps.setString(1, id);
            ResultSet res = ps.executeQuery();
            while (res.next())
                {                    
                    pro.setId_detalle(res.getString("cod_pedido"));                                   
                }
            res.close();
            //con.desconectar();
       }
       catch(Exception e)
       {
            JOptionPane.showMessageDialog(null,e.getMessage());
            System.out.println("No se pudo encontrar la proforma");
       }
       
        return pro.getId_detalle();
    }
    
    public void modificarDetallePedido(String id, detalle_Pedido pro)
    {
        Conexion con = new Conexion();       
        Connection accesoBD = con.getConnection(); 
        id = buscarDetallePedido(id);
        try{            
            PreparedStatement ps2 = accesoBD.prepareCall("call modificarPedidoDetalle(?,?,?,?,?)");
            ps2.setString(1, pro.getId_detalle());
            ps2.setString(2, id);
            ps2.setString(3, pro.getId_moto());
            ps2.setInt(4, pro.getCant());
            ps2.setString(5, pro.getColor());   
            ps2.executeUpdate();
            System.out.println("Actualización exitosa");            
            //con.desconectar();  
        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("No se pudo modificar El detalle Proforma");
        }
    }
    
   
    public void eliminarDetallePedido(String id)
    {
        Conexion con = new Conexion();       
        Connection accesoBD = con.getConnection(); 
        id = buscarDetallePedido(id);
        try{                     
            PreparedStatement eliminar = accesoBD.prepareCall("call eliminarDetallePedido(?)");
            eliminar.setString(1,id) ;           
            eliminar.executeUpdate();
            System.out.println("Eliminación exitosa");
            //con.desconectar();            
        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("No se pudo eliminar el concesionario del registro");
        }
    }   
    
    public float getValorDetalle(String id_pedido){
        Conexion conexion = new Conexion();
        Connection con = conexion.getConnection();
        float total = 0.0f;
        Statement st;
        ResultSet rs;
        String sql="select sum(m.precio * det.cantidad) as total from detalle_pedido det,moto m where det.id_moto = m.id_moto and det.cod_pedido='"+id_pedido+"'";
        try {
            st = con.createStatement();
            rs=st.executeQuery(sql);
            while(rs.next()){
                total = rs.getFloat("total");
            }
            //Cerramos las conexiones 
            st.close();
            con.close();
        }//Permite determinar los errores 
        catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error no se encontro la factura");
        }
        return total;
    }
}
