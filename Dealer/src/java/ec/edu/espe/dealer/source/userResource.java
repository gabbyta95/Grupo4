/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.dealer.source;

import ec.edu.espe.dealer.controler.UserDao;
import ec.edu.espe.dealer.model.Usuario;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author DANIELAROSERO
 */
@Path("user")
public class userResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of userResource
     */
    public userResource() {
    }

    /**
     * Retrieves representation of an instance of ec.edu.espe.dealer.source.userResource
     * @return an instance of java.lang.String
     */
  /*      @GET
    @Path("permisos/Administrador")
    @Produces(MediaType.APPLICATION_JSON)
    public Usuario getUser( ) {
        
        UserDao user=new UserDao();
       /* return user.LeerPermiso("Administrador");
    }*/
    UserDao userDat=new UserDao();
      @GET
          @Path("permisos/Administrador")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Usuario> LeerPermiso() {
  
        return userDat.LeerPermiso();
    }
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }

    /**
     * PUT method for updating or creating an instance of userResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
