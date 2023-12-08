package com.capri.pizzeria.rest.repos;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.DELETE;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

import com.capri.pizzeria.rest.model.Pizza;

@Path("pizza")
@RequestScoped
public class PizzaDAO {
    @PersistenceContext(unitName = "pizzadb")
    private EntityManager em;

    @POST
    @Path("order")
    @Produces(value = MediaType.APPLICATION_JSON)
    @Consumes(value = MediaType.APPLICATION_JSON)
    @Transactional
    public Integer placeOrder(Pizza pizza) {
        em.persist(pizza);
        return pizza.getTimetodeliver();
    }

    @GET
    @Path("toppings")
    @Produces(value = MediaType.APPLICATION_JSON)
    public List<String> getToppings() {
        List<String> toppings = new ArrayList<String>();
        toppings.add("mushrooms");
        toppings.add("ananas");
        toppings.add("ham");
        toppings.add("salami");
        toppings.add("prosciutto cotto");
        toppings.add("basilicum");
        return toppings;
    }

    @GET
    @Path("orders")
    @Produces(value = MediaType.APPLICATION_JSON)
    @Transactional
    public List<Pizza> allOrders() {
        return em.createQuery("SELECT p FROM Pizza p", Pizza.class).getResultList();
    }

    @DELETE
    @Path("order/{id}")
    @Produces(value = MediaType.APPLICATION_JSON)
    @Consumes(value = MediaType.APPLICATION_JSON)
    @Transactional
    public Pizza cancelOrder(@PathParam("id") int orderId) {
        Pizza pizza = em.find(Pizza.class, orderId);
        if (pizza != null) {
            em.remove(pizza);
        }
        return pizza;
    }

}