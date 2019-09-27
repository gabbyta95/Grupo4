
package Controlador;

import Modelo.Moto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class MotoDAO {
    
    public void registrarMoto(Moto moto)
    {
       Conexion con = new Conexion();      
       Connection accesoBD = con.getConnection();
       try{
           PreparedStatement ps = accesoBD.prepareCall("call insertarMoto(?,?,?,?)");           
           ps.setString(1, moto.getId_moto());
           ps.setString(2,moto.getModelo() );
           ps.setString(3, moto.getCilindraje());    
           ps.setFloat(4, moto.getPrecio());    
           int res = ps.executeUpdate();
           if(res == 1)
               System.out.println("Registro exitoso");
       }
       catch(Exception e)
       {
           JOptionPane.showMessageDialog(null,e.getMessage());
       }    
    } 
    
    public String buscarMoto(String id)
    {
        Conexion con = new Conexion();        
        Moto moto = new Moto(); 
        Connection accesoBD = con.getConnection();
        
        try{
            PreparedStatement ps = accesoBD.prepareCall("call buscarMoto(?)");
            ps.setString(1, id);
            ResultSet res = ps.executeQuery();
            while (res.next())
                {                    
                    moto.setId_moto(res.getString("id_moto"));                                   
                }
            res.close();
            //con.desconectar();
       }
       catch(Exception e)
       {
            JOptionPane.showMessageDialog(null,e.getMessage());
            System.out.println("No se pudo encontrar la motocicleta");
       }
       
        return moto.getId_moto();
    }
    
    public void modificarMoto(String id, Moto moto)
    {
        Conexion con = new Conexion();       
        Connection accesoBD = con.getConnection(); 
        id = buscarMoto(id);
        try{            
            PreparedStatement ps2 = accesoBD.prepareCall("call modificarMoto(?,?,?,?)");
            ps2.setString(1,id) ;            
            ps2.setString(2, moto.getModelo());
            ps2.setString(3, moto.getCilindraje());
            ps2.setFloat(4, moto.getPrecio());
            ps2.executeUpdate();
            System.out.println("Actualización exitosa");            
            //con.desconectar();  
        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("No se pudo modificar la motocicleta");
        }
    }
    
   
    public void eliminarMoto(String id)
    {
        Conexion con = new Conexion();       
        Connection accesoBD = con.getConnection(); 
        id = buscarMoto(id);
        try{                     
            PreparedStatement eliminar = accesoBD.prepareCall("call eliminarMoto(?)");
            eliminar.setString(1,id) ;           
            eliminar.executeUpdate();
            System.out.println("Eliminación exitosa");
            JOptionPane.showMessageDialog(null, "Motocicleta Eliminada Con exito");
            //con.desconectar();            
        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("No se pudo eliminar la motocicleta del registro");
        }
    }

    
}