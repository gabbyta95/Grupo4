/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Modelo.Usuario;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author DANIELAROSERO
 */
public class UsuarioIT {
    
    public UsuarioIT() {
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
    public void testSetEstadoNumeros() {
        System.out.println("Estado Numeros");
        String estado = "Activado";
        Usuario instance = new Usuario();
        String expResult = "6268";        
        if(estado.equals(expResult)){
        instance.setEstado(estado);
        }else {fail("No son letras");}
    }
    
            @Test
    public void testSetEstadoLetras() {
        System.out.println("Estado Letras");
        String estado = "Activado";
        Usuario instance = new Usuario();
        String expResult = "Activado";        
        if(estado.equals(expResult)){
        instance.setEstado(estado);
        }else {fail("No son letras");}
    }
    
    @Test
    public void testSetEstadoActivado() {
        System.out.println("Estado Activado");
        String estado = "Activado";
        Usuario instance = new Usuario();
        String expResult = "Activado";        
        if(estado.equals(expResult)){
        instance.setEstado(estado);
        }else {fail("No esta activado");}
    }
    
        @Test
    public void testSetEstadoNoActivado() {
        System.out.println("Estado No Activado");
        String estado = "Desactivado";
        Usuario instance = new Usuario();
        String expResult = "Activado";        
        if(estado.equals(expResult)){
        instance.setEstado(estado);
        }else     {fail("No esta activado");}
    }


    @Test
    public void testSetIdUsuarioNumeros() {
        System.out.println("setIdUsuario");
        String idUsuario = "145";
        Usuario instance = new Usuario();
        String expResult = "145";
        if(idUsuario.equals(expResult)){
                    instance.setIdUsuario(idUsuario);
        }else{fail("No son numeros");}
    }

    @Test
    public void testSetIdUsuarioLetras() {
        System.out.println("setIdUsuario");
        String idUsuario = "asdfi";
        Usuario instance = new Usuario();
        String expResult = "145";
        if(idUsuario.equals(expResult)){
                    instance.setIdUsuario(idUsuario);
        }else{fail("No son numeros");}
    }


    @Test
    public void testSetNombreUsuarioLetras() {
        System.out.println("setNombreUsuario");
        String nombreUsuario = "Gaby";
        Usuario instance = new Usuario();
        String expResult = "Gaby";
        if(nombreUsuario.equals(expResult)){
        instance.setNombreUsuario(nombreUsuario);
        }else{fail("No son letras");}
    }

    @Test
    public void testSetNombreUsuarioNumeros() {
        System.out.println("setNombreUsuario");
        String nombreUsuario = "9845";
        Usuario instance = new Usuario();
        String expResult = "Gaby";
        if(nombreUsuario.equals(expResult)){
        instance.setNombreUsuario(nombreUsuario);
        }else{fail("No son letras");}
    }

    @Test
    public void testSetPermisosLetras() {
        System.out.println("Permisos Letras");
        String permisos = "Administrador";
        Usuario instance = new Usuario();
        String expResult = "Administrador";
        if(permisos.equals(expResult)){
        instance.setPermisos(permisos);
        }else{fail("No son letras");}
    }
    
        @Test
    public void testSetPermisosNumeros() {
        System.out.println("Permisos Numeros");
        String permisos = "Administrador";
        Usuario instance = new Usuario();
        String expResult = "1848";
        if(permisos.equals(expResult)){
        instance.setPermisos(permisos);
        }else{fail("No son letras");}
    }
    /**
     * Test of setPermisos method, of class Usuario.
     */
    @Test
    public void testSetPermisosAdminDaAdmin() {
        System.out.println("setPermisos");
        String permisos = "Administrador";
        Usuario instance = new Usuario();
        String expResult = "Administrador";
        if(permisos.equals(expResult)){
        instance.setPermisos(permisos);
        }else{fail("No es admin");}
    }
    @Test
    public void testSetPermisosAdminEnFabrica() {
        System.out.println("setPermisos");
        String permisos = "EnFabrica";
        Usuario instance = new Usuario();
        String expResult = "Administrador";
        if(permisos.equals(expResult)){
        instance.setPermisos(permisos);
        }else{fail("No es admin");}
    }
    
        @Test
    public void testSetPermisosEnFabricaEnVentas() {
        System.out.println("setPermisos");
        String permisos = "EnFabrica";
        Usuario instance = new Usuario();
        String expResult = "EnVentas";
        if(permisos.equals(expResult)){
        instance.setPermisos(permisos);
        }else{fail("No es encargado Fabrica");}
    }

    /**
     * Test of setApellidoUsuario method, of class Usuario.
     */
    @Test
    public void testSetApellidoUsuarioLetras() {
        System.out.println("setApellidoUsuario");
        String apellidoUsuario = "Rosero";
        Usuario instance = new Usuario();
        String expResult = "Rosero";
        if(apellidoUsuario.equals(expResult)){
        instance.setApellidoUsuario(apellidoUsuario);
        }else{fail("No son letras");}
    }
        @Test
    public void testSetApellidoUsuarioNumeros() {
        System.out.println("setApellidoUsuario");
        String apellidoUsuario = "432.";
        Usuario instance = new Usuario();
        String expResult = "Rosero";
        if(apellidoUsuario.equals(expResult)){
        instance.setApellidoUsuario(apellidoUsuario);
        }else{fail("No son letras");}
    }
    
}
