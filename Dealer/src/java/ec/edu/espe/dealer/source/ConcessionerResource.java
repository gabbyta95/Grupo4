/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.dealer.source;

import ec.edu.espe.dealer.controler.ConcessionerDAO;
import ec.edu.espe.dealer.model.Concessionaire;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author RIVERA
 */
@Path("Concessioner")
public class ConcessionerResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of ConcessionerResource
     */
    public ConcessionerResource() {
    }

    /**
     * Retrieves representation of an instance of ec.edu.espe.dealer.source.ConcessionerResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Concessionaire> getJsonConcessionaire() {
        //TODO return proper representation object
        //throw new UnsupportedOperationException();
        ConcessionerDAO conce = new ConcessionerDAO();
        return conce.searchAllConcessionaire();
    }
    
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Concessionaire getJsonOrderById(@PathParam("id") String id) {
        ConcessionerDAO conce = new ConcessionerDAO();
        return conce.SearchConcessionaire(id);
    }

    /**
     * PUT method for updating or creating an instance of ConcessionerResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
