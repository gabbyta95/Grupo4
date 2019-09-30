/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.dealer.controler;

import ec.edu.espe.dealer.model.Concessionaire;
import ec.edu.espe.dealer.model.Order;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Erick
 */
public class ConcessionerDAO {
    public void registrarConcesionario(Concessionaire conc)
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
    
    public Concessionaire SearchConcessionaire(String id)
    {
        Conexion con = new Conexion();        
        Concessionaire conc = new Concessionaire(); 
        Connection accesoBD = con.getConnection();
        
        try{
            PreparedStatement ps = accesoBD.prepareCall("call buscarConcesionario(?)");
            ps.setString(1, id);
            ResultSet res = ps.executeQuery();
            while (res.next())
                {                    
                    conc.setIdConcesionario(res.getString("id_concesionario"));
                    conc.setDirecciont(res.getString("direccion"));
                    conc.setName(res.getString("nombre_concesionario"));
                    conc.setTelefono(res.getString("telefono"));
                }
            res.close();
            //con.desconectar();
       }
       catch(Exception e)
       {
            JOptionPane.showMessageDialog(null,e.getMessage());
            System.out.println("No se pudo encontrar el concesionario");
       }
       
        return conc;
    }
    
    private final List<Concessionaire> listConcessionaire = new ArrayList<Concessionaire>();
    public List<Concessionaire> searchAllConcessionaire() {

        Conexion con = new Conexion();
        Connection accesoBD = con.getConnection();
        String sql = "SELECT * FROM concesionario";
        try {

            Statement st = accesoBD.createStatement();
            ResultSet res = st.executeQuery(sql);
            while (res.next()) {
                String id_concessionaire = res.getString("id_concesionario");
                String name = res.getString("nombre_concesionario");
                String direction = res.getString("direccion");
                String phone = res.getString("telefono");
                Concessionaire conce = new Concessionaire(name,direction,phone,id_concessionaire);
                listConcessionaire.add(conce);
            }
            res.close();
            //con.desconectar();
            return listConcessionaire;
        } catch (Exception e) {

            System.out.println("Vacio");
            return null;
        }
    }

}
