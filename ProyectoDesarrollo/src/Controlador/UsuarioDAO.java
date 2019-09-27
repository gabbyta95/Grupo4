package Controlador;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import Modelo.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class UsuarioDAO {
    private Conexion conexion = new Conexion();

    public UsuarioDAO() {
    }
    public void AgregarUsuario(Usuario usuario) {
        //Cargar la Conexion
        Connection con = conexion.getConnection();
        Statement st;
        //Creamos las sentenia sql
        String sql = "INSERT INTO usuario (IdUsuario,NombreUsuario,ApellidoUsuario,password,permisos,estado) "
                + "VALUES ('" + usuario.getIdUsuario() + "','" + usuario.getNombreUsuario() + "','" + usuario.getApellidoUsuario()+ "','"+ usuario.getPassword() + "','" + usuario.getPermisos() +"','"+usuario.getEstado()+"')";
        //Ejecutamos la sentencia SQL
        try {
            st = con.createStatement();
            st.executeUpdate(sql);
            JOptionPane.showMessageDialog(null,"Registro creado!!!");
            //Cerramos las conexiones 
            st.close();
            con.close();
        }//Permite determinar los errores 
        catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error no se puede registrar usuario");
        }

    }

    public void ActualizarUsuario(String n, Usuario usuario) {
        Connection con = conexion.getConnection();
        Statement st;
        //Creamos las sentenia sql
        String sql = "UPDATE usuario SET NombreUsuario='" + usuario.getNombreUsuario() + "',ApellidoUsuario='"+ usuario.getApellidoUsuario() + "',password='" + usuario.getPassword() +  "',permisos='" + usuario.getPermisos() + "',estado='"+usuario.getEstado()+"' WHERE IdUsuario='"+ usuario.getIdUsuario()+"'";
        //Ejecutamos la sentencia SQL
        try {
            st = con.createStatement();
            int confirmar = st.executeUpdate(sql);
            if (confirmar == 1) {
                JOptionPane.showMessageDialog(null,"Registro modificado");
            } else {
                JOptionPane.showMessageDialog(null, "Error no existe usuario");
            }
            //Cerramos las conexiones 
            st.close();
            con.close();
        }//Permite determinar los errores 
        catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error no se puede modificar el usuario");
        }
    }

    public void BuscarUsuario(String n) {
        Connection con = conexion.getConnection();
        Statement st;
        //Creamos las sentenia sql
        String sql = "SELECT * FROM usuario WHERE IdUsuario='" + n + "'";
        //Ejecutamos la sentencia SQL
        try {
            st = con.createStatement();
            int confirmar = st.executeUpdate(sql);
            if (confirmar == 1) {
                JOptionPane.showMessageDialog(null,"Registro encontrado con exito!!!");
            } else {
                JOptionPane.showMessageDialog(null, "Error no existe usuario");
            }
            //Cerramos las conexiones 
            st.close();
            con.close();
        }//Permite determinar los errores 
        catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error no se encontró el usuario");
        }
    }

    public void EliminarUsuario(String n) {
        Connection con = conexion.getConnection();
        Statement st;
        //Creamos las sentenia sql
        String sql = "DELETE FROM usuario WHERE IdUsuario='" + n + "'";
        //Ejecutamos la sentencia SQL
        try {
            st = con.createStatement();
            int confirmar = st.executeUpdate(sql);
            if (confirmar == 1) {
                JOptionPane.showMessageDialog(null,"Registro eliminado con exito!!!");
            } else {
                JOptionPane.showMessageDialog(null, "Error no existe usuario");
            }
            //Cerramos las conexiones 
            st.close();
            con.close();
        }//Permite determinar los errores 
        catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error no se elimino el usuario");
        }
    }

    public void Leer(String n,JTextField text,JTextField text2,JTextField text3,JTextField text4) {
        Connection con = conexion.getConnection();
        Statement st;
        ResultSet rs;
         String sql = "SELECT * FROM usuario WHERE IdUsuario='" + n + "'";
        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
               // texto.append("ID:" + rs.getString(1) + " NombreUsuario:" + rs.getString(2) + " Email:" + rs.getString(3) + " Password:" + rs.getString(4) +  " Direccion:" + rs.getString(5) +" Sector:" + rs.getString(6) +" LugarDeReferencia:" + rs.getString(7) +" NroTelefonoConvencional:" + rs.getString(8) +" Extension:" + rs.getString(9) +" NroTelefonoMovil:" + rs.getString(10) +"\n");
                text.setText(text.getText() + rs.getString(1));
                text2.setText(text2.getText() + rs.getString(2));
                text3.setText(text3.getText() + rs.getString(3));
                text4.setText(text4.getText() + rs.getString(4));                
            }
            rs.close();
            st.close();
            con.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se puede acceder a los datos de usuario");
        }
    }
    
     public ArrayList<Usuario> login(String user, String clave, String permisos){
    
        
        Connection conectar = conexion.getConnection();
        Statement pst;
        ResultSet rs ;
        Usuario cuenta ;
        ArrayList list = new ArrayList();
        
        try{
            // obtenemos la conexion con la base de datos
            pst = conectar.createStatement();
            if(conectar != null){
                
                String sql ="SELECT IdUsuario, Password, permisos FROM usuario WHERE IdUsuario ='"+user+"' AND Password='"+clave+"'AND permisos='"+permisos+"'";
                pst = conectar.prepareStatement(sql);                
                rs = pst.executeQuery(sql);
                                
                if(rs.next()){                    
                    cuenta = new Usuario();
                    cuenta.setIdUsuario(rs.getString("IdUsuario"));
                    cuenta.setPassword(rs.getString("Password")); 
                    cuenta.setPermisos(rs.getString("permisos"));
                    list.add(cuenta);
                }
                 
            }else{
                JOptionPane.showMessageDialog(null, "Hubo un error al realizar la operacion, intente mas tarde","ERROR",JOptionPane.ERROR_MESSAGE);
            }
                
        
        }catch(SQLException e){
                JOptionPane.showMessageDialog(null, e , " .::Error En la Operacion::.", JOptionPane.ERROR_MESSAGE);
        }finally{
        
            try{
                conectar.close();
            }catch(SQLException ex){
                System.out.println("error "+ex);
            }        
        }        
       return list;
         
    }    
}
