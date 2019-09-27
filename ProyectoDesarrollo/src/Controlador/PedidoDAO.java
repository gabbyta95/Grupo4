/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Pedido;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Erick
 */
public class PedidoDAO {
  public void registrarPedido(Pedido pro)
    {
        java.sql.Date date2=new java.sql.Date(pro.getFecha().getTime());
        Conexion con = new Conexion();      
        Connection accesoBD = con.getConnection();
        try{
           PreparedStatement ps = accesoBD.prepareCall("call insertarPedido(?,?,?,?)");           
           ps.setString(1, pro.getCod_pedido());
           ps.setDate(2, date2);
           ps.setString(3, pro.getEstado());
           ps.setString(4, pro.getIdconcesionario());    
           int res = ps.executeUpdate();
           if(res == 1)
               System.out.println("Registro exitoso");
        }
        catch(Exception e)
        {
           JOptionPane.showMessageDialog(null,e.getMessage());
        }    
    } 
    
    public String buscarPedido(String id)
    {
        Conexion con = new Conexion();        
        Pedido pro = new Pedido(); 
        Connection accesoBD = con.getConnection();
        
        try{
            PreparedStatement ps = accesoBD.prepareCall("call buscarPedido(?)");
            ps.setString(1, id);
            ResultSet res = ps.executeQuery();
            while (res.next())
                {                    
                    pro.setCod_pedido(res.getString("cod_pedido"));                                   
                }
            res.close();
            //con.desconectar();
       }
       catch(Exception e)
       {
            JOptionPane.showMessageDialog(null,e.getMessage());
            System.out.println("No se pudo encontrar la proforma");
       }
       
        return pro.getCod_pedido();
    }
    
    public void modificarPedido(String id, Pedido pro)
    {
        java.sql.Date date2=new java.sql.Date(pro.getFecha().getTime());
        Conexion con = new Conexion();       
        Connection accesoBD = con.getConnection(); 
        id = buscarPedido(id);
        try{            
            PreparedStatement ps2 = accesoBD.prepareCall("call modificarpedido(?,?,?,?)");
            ps2.setString(1,id) ;            
            ps2.setDate(2, date2);
            ps2.setString(3, pro.getEstado());
            ps2.setString(4, pro.getIdconcesionario()); 
            ps2.executeUpdate();
            System.out.println("Actualización exitosa");            
            //con.desconectar();  
        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("No se pudo modificar el concesionario");
        }
    }
    
   
    public void eliminarPedido(String id)
    {
        Conexion con = new Conexion();       
        Connection accesoBD = con.getConnection(); 
        id = buscarPedido(id);
        try{                     
            PreparedStatement eliminar = accesoBD.prepareCall("call eliminarPedido(?)");
            eliminar.setString(1,id) ;           
            eliminar.executeUpdate();
            System.out.println("Eliminación exitosa");
            //con.desconectar();            
        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("No se pudo eliminar el concesionario del registro");
        }
    }   
}
