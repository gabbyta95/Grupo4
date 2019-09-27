/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Concesionario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Erick
 */
public class ConcesionarioDAO {
    public void registrarConcesionario(Concesionario conc)
    {
       Conexion con = new Conexion();      
       Connection accesoBD = con.getConnection();
       try{
           PreparedStatement ps = accesoBD.prepareCall("call insertarConcesionario(?,?,?,?)");           
           ps.setString(1, conc.getIdConcesionario());
           ps.setString(2, conc.getName());
           ps.setString(3, conc.getDirecciont());
           ps.setString(4, conc.getTelefono());    
           int res = ps.executeUpdate();
           if(res == 1)
               System.out.println("Registro exitoso");
       }
       catch(Exception e)
       {
           JOptionPane.showMessageDialog(null,e.getMessage());
       }    
    } 
    
    public String buscarConcesionario(String id)
    {
        Conexion con = new Conexion();        
        Concesionario conc = new Concesionario(); 
        Connection accesoBD = con.getConnection();
        
        try{
            PreparedStatement ps = accesoBD.prepareCall("call buscarConcesionario(?)");
            ps.setString(1, id);
            ResultSet res = ps.executeQuery();
            while (res.next())
                {                    
                    conc.setIdConcesionario(res.getString("id_concesionario"));                                   
                }
            res.close();
            //con.desconectar();
       }
       catch(Exception e)
       {
            JOptionPane.showMessageDialog(null,e.getMessage());
            System.out.println("No se pudo encontrar el concesionario");
       }
       
        return conc.getIdConcesionario();
    }
    
    public void modificarConcesionario(String id, Concesionario conc)
    {
        Conexion con = new Conexion();       
        Connection accesoBD = con.getConnection(); 
        id = buscarConcesionario(id);
        try{            
            PreparedStatement ps2 = accesoBD.prepareCall("call modificarConcesionario(?,?,?,?)");
            ps2.setString(1,id) ;            
            ps2.setString(2, conc.getName());
            ps2.setString(3, conc.getDirecciont());
            ps2.setString(4, conc.getTelefono());
            ps2.executeUpdate();
            System.out.println("Actualización exitosa");            
            //con.desconectar();  
        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("No se pudo modificar el concesionario");
        }
    }
    
   
    public void eliminarConcesionario(String id)
    {
        Conexion con = new Conexion();       
        Connection accesoBD = con.getConnection(); 
        id = buscarConcesionario(id);
        try{                     
            PreparedStatement eliminar = accesoBD.prepareCall("call eliminarConcesionario(?)");
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
