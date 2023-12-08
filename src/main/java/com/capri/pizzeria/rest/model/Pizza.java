package com.capri.pizzeria.rest.model;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "pizza")
@NamedQuery(name = "Pizza.findAll", query = "SELECT p FROM Pizza p")
public class Pizza implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String size;

    private Boolean cheesycrust;

    private Integer timetodeliver;

    //bi-directional many-to-one association to PizzaTopping
    private String pizzatoppings;

    public Pizza() {
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSize() {
        return this.size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public Boolean getCheesycrust() {
        return this.cheesycrust;
    }

    public void setCheesycrust(Boolean cheesycrust) {
        this.cheesycrust = cheesycrust;
    }

    public Integer getTimetodeliver() {
        return this.timetodeliver;
    }

    public void setTimetodeliver(Integer timetodeliver) {
        this.timetodeliver = timetodeliver;
    }

    public String getPizzatoppings() {
        return this.pizzatoppings;
    }

    public void setPizzatoppings(String pizzatoppings) {
        this.pizzatoppings = pizzatoppings;
    }

}
