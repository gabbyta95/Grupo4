/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Controlador.MotoDAO;
import Modelo.Moto;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Erick
 */
public class PruebaConcesionario {
    
    public PruebaConcesionario() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    @Test
    public void pruebaIngreso()
    {
        MotoDAO mdao=new MotoDAO();
        Moto moto=new Moto();
        moto.setCilindraje("");
        moto.setId_moto("");
        moto.setModelo("");
        moto.setPrecio(0);
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
