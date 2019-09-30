/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.dealer.source;

import ec.edu.espe.dealer.controler.OrderDAO;
import ec.edu.espe.dealer.model.Order;
import java.util.Date;
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
@Path("Order")
public class OrderResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of OrderResource
     */
    public OrderResource() {
    }

    /**
     * Retrieves representation of an instance of
     * ec.edu.espe.dealer.source.OrderResource
     *
     * @return an instance of java.lang.String
     */
    @GET
    //@Path("{}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Order> getJsonOrders() {
        //TODO return proper representation object
        //throw new UnsupportedOperationException();
        OrderDAO order = new OrderDAO();
        return order.searchAllOrders();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Order getJsonOrderById(@PathParam("id") String id) {
        OrderDAO order = new OrderDAO();
        return order.searchOrderID(id);
    }

    @GET
    @Path("{con}/{state}")
    @Produces(MediaType.APPLICATION_JSON)
    public Order getJsonOrderByIdConcessioner(@PathParam("con") String id,@PathParam("state") String state) {
        OrderDAO order = new OrderDAO();
        return order.searchOrderIDConcessioner(id,state);
    }
    
    /**
     * PUT method for updating or creating an instance of OrderResource
     *
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(Order content) {
    }
}
