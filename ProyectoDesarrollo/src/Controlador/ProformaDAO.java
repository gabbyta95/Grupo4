/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Concesionario;
import Modelo.Proforma;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Erick
 */
public class ProformaDAO {
   public void registrarProforma(Proforma pro)
    {
        java.sql.Date date2=new java.sql.Date(pro.getFecha_recepcion().getTime());
        Conexion con = new Conexion();      
        Connection accesoBD = con.getConnection();
        try{
           PreparedStatement ps = accesoBD.prepareCall("call insertarProforma(?,?,?,?)");           
           ps.setString(1, pro.getId_proforma());
           ps.setDate(2, date2);
           ps.setString(3, pro.getEstado());
           ps.setString(4, pro.getIdConcesionario());    
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
            PreparedStatement ps = accesoBD.prepareCall("call buscarProforma(?)");
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
    
    public void modificarProforma(String id, Proforma pro)
    {
        java.sql.Date date2=new java.sql.Date(pro.getFecha_recepcion().getTime());
        Conexion con = new Conexion();       
        Connection accesoBD = con.getConnection(); 
        id = buscarProforma(id);
        try{            
            PreparedStatement ps2 = accesoBD.prepareCall("call modificarProforma(?,?,?,?)");
            ps2.setString(1,id) ;            
            ps2.setDate(2, date2);
            ps2.setString(3, pro.getEstado());
            ps2.setString(4, pro.getIdConcesionario()); 
            ps2.executeUpdate();
            System.out.println("Actualización exitosa");            
            //con.desconectar();  
        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("No se pudo modificar el concesionario");
        }
    }
    
   
    public void eliminarProforma(String id)
    {
        Conexion con = new Conexion();       
        Connection accesoBD = con.getConnection(); 
        id = buscarProforma(id);
        try{                     
            PreparedStatement eliminar = accesoBD.prepareCall("call eliminarProforma(?)");
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
