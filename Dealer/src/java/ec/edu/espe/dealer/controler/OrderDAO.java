/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.dealer.controler;

import ec.edu.espe.dealer.model.Bike;
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
public class OrderDAO {

    public void registrarPedido(Order pro) {
        java.sql.Date date2 = new java.sql.Date(pro.getFecha().getTime());
        Conexion con = new Conexion();
        Connection accesoBD = con.getConnection();
        try {
            PreparedStatement ps = accesoBD.prepareCall("call insertarPedido(?,?,?,?)");
            ps.setString(1, pro.getCod_pedido());
            ps.setDate(2, date2);
            ps.setString(3, pro.getEstado());
            ps.setString(4, pro.getIdconcesionario());
            int res = ps.executeUpdate();
            if (res == 1) {
                System.out.println("Registro exitoso");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public String buscarPedido(String id) {
        Conexion con = new Conexion();
        Order pro = new Order();
        Connection accesoBD = con.getConnection();

        try {
            PreparedStatement ps = accesoBD.prepareCall("call buscarPedido(?)");
            ps.setString(1, id);
            ResultSet res = ps.executeQuery();
            while (res.next()) {
                pro.setCod_pedido(res.getString("cod_pedido"));
            }
            res.close();
            //con.desconectar();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            System.out.println("No se pudo encontrar la proforma");
        }

        return pro.getCod_pedido();
    }

    public void modificarPedido(String id, Order pro) {
        java.sql.Date date2 = new java.sql.Date(pro.getFecha().getTime());
        Conexion con = new Conexion();
        Connection accesoBD = con.getConnection();
        id = buscarPedido(id);
        try {
            PreparedStatement ps2 = accesoBD.prepareCall("call modificarpedido(?,?,?,?)");
            ps2.setString(1, id);
            ps2.setDate(2, date2);
            ps2.setString(3, pro.getEstado());
            ps2.setString(4, pro.getIdconcesionario());
            ps2.executeUpdate();
            System.out.println("Actualización exitosa");
            //con.desconectar();  
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("No se pudo modificar el concesionario");
        }
    }

    public void eliminarPedido(String id) {
        Conexion con = new Conexion();
        Connection accesoBD = con.getConnection();
        id = buscarPedido(id);
        try {
            PreparedStatement eliminar = accesoBD.prepareCall("call eliminarPedido(?)");
            eliminar.setString(1, id);
            eliminar.executeUpdate();
            System.out.println("Eliminación exitosa");
            //con.desconectar();            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("No se pudo eliminar el concesionario del registro");
        }
    }

    private final List<Order> listOrder = new ArrayList<Order>();

    public List<Order> searchAllOrders() {

        Conexion con = new Conexion();
        Order order = new Order();
        Connection accesoBD = con.getConnection();
        String sql = "SELECT * FROM pedido";
        try {

            Statement st = accesoBD.createStatement();
            ResultSet res = st.executeQuery(sql);
            while (res.next()) {
                String id_order = res.getString("cod_pedido");
                Date date_order = res.getDate("fecha_recepcion");
                String state = res.getString("estado");
                String idConcessioner = res.getString("id_concesionario");

                Order ord = new Order(id_order, idConcessioner, date_order, state);
                listOrder.add(ord);
            }
            res.close();
            //con.desconectar();
            return listOrder;
        } catch (Exception e) {

            System.out.println("Vacio");
            return null;
        }
    }

    public Order searchOrderID(String id) {

        Conexion con = new Conexion();
        Order ord = new Order();
        Connection accesoBD = con.getConnection();
        String sql = "SELECT * FROM pedido"
                + " WHERE cod_pedido = '" + id + "'";
        try {

            Statement st = accesoBD.createStatement();
            ResultSet res = st.executeQuery(sql);
            while (res.next()) {
                ord.setCod_pedido(res.getString("cod_pedido"));
                ord.setFecha(res.getDate("fecha_recepcion"));
                ord.setEstado(res.getString("estado"));
                ord.setIdconcesionario(res.getString("id_concesionario"));
            }
            res.close();
            //con.desconectar();
        } catch (Exception e) {

            System.out.println("Vacio");
            return null;
        }
        return ord;
    }

    public Order searchOrderIDConcessioner(String id, String state) {

        Conexion con = new Conexion();
        Order ord = new Order();
        Connection accesoBD = con.getConnection();
        String sql = "SELECT * FROM pedido"
                + " WHERE id_concesionario = '" + id + "' AND estado = '" + state + "'";
        try {

            Statement st = accesoBD.createStatement();
            ResultSet res = st.executeQuery(sql);
            while (res.next()) {
                ord.setCod_pedido(res.getString("cod_pedido"));
                ord.setFecha(res.getDate("fecha_recepcion"));
                ord.setEstado(res.getString("estado"));
                ord.setIdconcesionario(res.getString("id_concesionario"));
            }
            res.close();
            //con.desconectar();
        } catch (Exception e) {

            System.out.println("Vacio");
            return null;
        }
        return ord;
    }
    
    public Order searchOrderConcessionerDateState(String id, String state, Date date) {

        Conexion con = new Conexion();
        Order ord = new Order();
        Connection accesoBD = con.getConnection();
        String sql = "SELECT * FROM pedido"
                + " WHERE id_concesionario = '" + id + "' AND estado = '" + state + "'"
                + "' AND fecha_recepcion = '" + date + "'";
        try {

            Statement st = accesoBD.createStatement();
            ResultSet res = st.executeQuery(sql);
            while (res.next()) {
                ord.setCod_pedido(res.getString("cod_pedido"));
                ord.setFecha(res.getDate("fecha_recepcion"));
                ord.setEstado(res.getString("estado"));
                ord.setIdconcesionario(res.getString("id_concesionario"));
            }
            res.close();
            //con.desconectar();
        } catch (Exception e) {

            System.out.println("Vacio");
            return null;
        }
        return ord;
    }
    
    public List<String> searchOrderByDate(Date date) {

        Conexion con = new Conexion();
        List<String> list = new ArrayList<String>();
        Connection accesoBD = con.getConnection();
        String sql = "SELECT cod_pedido FROM pedido"
                + " WHERE fecha_recepcion = '" + date + "'";
        try {

            Statement st = accesoBD.createStatement();
            ResultSet res = st.executeQuery(sql);
            while (res.next()) {
                list.add(res.getString("cod_pedido"));
            }
            res.close();
            //con.desconectar();
        } catch (Exception e) {

            System.out.println("Vacio");
            return null;
        }
        return list;
    }

}
