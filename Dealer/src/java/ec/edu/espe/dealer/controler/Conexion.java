/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.dealer.controler;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.sql.DataSource;
import org.apache.commons.dbcp.BasicDataSource;

/**
 *
 * @author kevinquiroga
 */
public class Conexion {
     public DataSource dataSource;
    private static final String URL = "jdbc:mysql://localhost:3306/bd_gestion_motos?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "1234"; //CAMBIAN AQUI POR SU CONTRASEÑA
         public Conexion(){

        inicializaDataSource();

    }
         
    public  Connection getConnection() {
        Connection connection = null;
        try {
          
          connection = DriverManager.getConnection("jdbc:mariadb://localhost:3306/bd_gestion_motos?user=root&password=");
            System.out.println("Conexion realizada con exito");
        } catch (Exception e) {
            System.out.println("Conexion Fallida");
        }
        return connection;
    }
    

    
    private void inicializaDataSource(){


        BasicDataSource basicDataSource = new BasicDataSource();

        basicDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        basicDataSource.setUsername(USERNAME);
        basicDataSource.setPassword(PASSWORD);
        basicDataSource.setUrl(URL);
        basicDataSource.setMaxActive(50);

        dataSource = basicDataSource;

    }
    
}
