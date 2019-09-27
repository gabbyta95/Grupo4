/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Detalle_Proforma;
import Modelo.Proforma;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Erick
 */
public class ProformaDetalleDAO {
    public void registrarDetalleProforma(Detalle_Proforma pro)
    {
        Conexion con = new Conexion();      
        Connection accesoBD = con.getConnection();
        try{
           PreparedStatement ps = accesoBD.prepareCall("call insertarDetalleProforma(?,?,?,?,?)");           
           ps.setString(1, pro.getIdDetalleProforma());
           ps.setString(2, pro.getIdProforma());
           ps.setString(3, pro.getIdmoto());
           ps.setInt(4, pro.getCantidad());
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
    
    public String buscarProforma(String id)
    {
        Conexion con = new Conexion();        
        Proforma pro = new Proforma(); 
        Connection accesoBD = con.getConnection();
        
        try{
            PreparedStatement ps = accesoBD.prepareCall("call buscarDetalleProforma(?)");
            ps.setString(1, id);
            ResultSet res = ps.executeQuery();
            while (res.next())
                {                    
                    pro.setId_proforma(res.getString("id_proforma"));                                   
                }
            res.close();
            //con.desconectar();
       }
       catch(Exception e)
       {
            JOptionPane.showMessageDialog(null,e.getMessage());
            System.out.println("No se pudo encontrar la proforma");
       }
       
        return pro.getId_proforma();
    }
    
    public void modificarProforma(String id, Detalle_Proforma pro)
    {
        Conexion con = new Conexion();       
        Connection accesoBD = con.getConnection(); 
        id = buscarProforma(id);
        try{            
            PreparedStatement ps2 = accesoBD.prepareCall("call modificarDetalleProforma(?,?,?,?,?)");
            ps2.setString(1, pro.getIdDetalleProforma());
            ps2.setString(2, id);
            ps2.setString(3,pro.getIdmoto());
            ps2.setInt(4, pro.getCantidad());
            ps2.setString(5, pro.getColor());  
            ps2.executeUpdate();
            System.out.println("Actualización exitosa");            
            //con.desconectar();  
        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("No se pudo modificar El detalle Proforma");
        }
    }
    
   
    public void eliminarProforma(String id)
    {
        Conexion con = new Conexion();       
        Connection accesoBD = con.getConnection(); 
        id = buscarProforma(id);
        try{                     
            PreparedStatement eliminar = accesoBD.prepareCall("call eliminarDetalleProforma(?)");
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
