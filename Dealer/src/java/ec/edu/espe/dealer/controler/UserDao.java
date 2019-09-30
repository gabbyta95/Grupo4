/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.dealer.controler;

import ec.edu.espe.dealer.model.Usuario;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author DANIELAROSERO
 */
public class UserDao {
private Conexion conexion = new Conexion();
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
public void BuscarUsuarioPermiso(String n) {
        Connection con = conexion.getConnection();
        Statement st;
        //Creamos las sentenia sql
        String sql = "SELECT * FROM usuario WHERE permisos='" + n + "'";
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
    private final List<Usuario> listUser = new ArrayList<Usuario>();
    public List<Usuario> LeerPermiso() {
        Connection con = conexion.getConnection();
        Statement st;
        Usuario user=new Usuario();
        ResultSet rs;
         String sql = "SELECT * FROM usuario WHERE permisos='Administrador'";
        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
               // texto.append("ID:" + rs.getString(1) + " NombreUsuario:" + rs.getString(2) + " Email:" + rs.getString(3) + " Password:" + rs.getString(4) +  " Direccion:" + rs.getString(5) +" Sector:" + rs.getString(6) +" LugarDeReferencia:" + rs.getString(7) +" NroTelefonoConvencional:" + rs.getString(8) +" Extension:" + rs.getString(9) +" NroTelefonoMovil:" + rs.getString(10) +"\n");
                user.setIdUsuario(rs.getString("IdUsuario"));
                user.setNombreUsuario(rs.getString("NombreUsuario"));
                user.setApellidoUsuario(rs.getString("ApellidoUsuario"));
                user.setPermisos(rs.getString("permisos"));
                user.setEstado(rs.getString("estado")); 
                user.setPassword(rs.getString("password")); 
                listUser.add(user);
            }
            rs.close();
            st.close();
        } catch (SQLException e) {
           
        }
        return listUser;
    }    
}
