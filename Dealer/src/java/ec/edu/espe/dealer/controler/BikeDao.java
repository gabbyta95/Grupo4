/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.dealer.controler;

import ec.edu.espe.dealer.model.Bike;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.swing.JOptionPane;

/**
 *
 * @author kevinquiroga
 */
public class BikeDao {
     public void registrarMoto(Bike bike)
    {
       Conexion con = new Conexion();      
       Connection accesoBD = con.getConnection();
       try{
           PreparedStatement ps = accesoBD.prepareCall("call insertarMoto(?,?,?,?)");           
           ps.setString(1, bike.getId_moto());
           ps.setString(2, bike.getModelo() );
           ps.setString(3, bike.getCilindraje());    
           ps.setFloat(4, bike.getPrecio());    
           int res = ps.executeUpdate();
           if(res == 1)
               System.out.println("Registro exitoso");
       }
       catch(Exception e)
       {
           JOptionPane.showMessageDialog(null,e.getMessage());
       }    
    } 
    
    public Bike buscarMotos(String id)
    {
        Conexion con = new Conexion();        
        Bike bike = new Bike(); 
        Connection accesoBD = con.getConnection();
        
        try{
            PreparedStatement ps = accesoBD.prepareCall("call buscarMoto(?)");
            ps.setString(1, id);
            ResultSet res = ps.executeQuery();
            while (res.next())
                {                    
                    bike.setId_moto(res.getString("id_moto"));  
                    bike.setModelo(res.getString("modelo"));
                    bike.setCilindraje(res.getString("cilindraje"));
                }
            res.close();
            //con.desconectar();
       }
       catch(Exception e)
       {
            JOptionPane.showMessageDialog(null,e.getMessage());
            System.out.println("No se pudo encontrar la motocicleta");
       }
       
        return bike;
    }
    private final List<Bike> listBikes = new ArrayList<Bike>();
      public List<Bike> searchAllBikes()
    {
       
        
        Conexion con = new Conexion();        
        Bike bike = new Bike(); 
        Connection accesoBD = con.getConnection();
        String sql = "SELECT * FROM vehicle";
        try{
        
            Statement st = accesoBD .createStatement();
            ResultSet res = st.executeQuery(sql);
            while (res.next())
                {    String id_bike=res.getString("id_moto");
                     String model_bike=res.getString("modelo");
                     String cilindraje= res.getString("cilindraje");       
                    
                    Bike bk =  new Bike(id_bike, model_bike, cilindraje);
                    listBikes.add(bk);
                }
            res.close();
            //con.desconectar();
            return listBikes;
       }
       catch(Exception e)
       {
            JOptionPane.showMessageDialog(null,e.getMessage());
            System.out.println("Vacio");
             return null;
       }
       

    }
     public String buscarMoto(String id)
    {
        Conexion con = new Conexion();        
        Bike moto = new Bike(); 
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
    
    public void modificarMoto(String id, Bike bike)
    {
        Conexion con = new Conexion();       
        Connection accesoBD = con.getConnection(); 
        id = buscarMoto(id);
        try{            
            PreparedStatement ps2 = accesoBD.prepareCall("call modificarMoto(?,?,?,?)");
            ps2.setString(1,id) ;            
            ps2.setString(2, bike.getModelo());
            ps2.setString(3, bike.getCilindraje());
            ps2.setFloat(4, bike.getPrecio());
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
