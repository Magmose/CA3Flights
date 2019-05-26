/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import com.google.gson.Gson;
import entity.Flight;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
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
 * @author Magnus
 */
@Path("flight")
public class FlightResource {

    @Context
    private UriInfo context;
    Gson gson = new Gson();

  

    /**
     * Creates a new instance of FlightResource
     */
    public FlightResource() {
    }

    /**
     * Retrieves representation of an instance of rest.FlightResource
     *
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("allCount")
    public String flightCount() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu", null);
        EntityManager em = emf.createEntityManager();
        try {
            List<Flight> flights = em.createQuery("select f from Flight f").getResultList();
            return "[" + flights.size() + "]";

        } finally {
            em.close();
            System.out.println("allCount");
        }

        //return gson.toJson(flights().size());
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("all")
    public String flightAll() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu", null);
        EntityManager em = emf.createEntityManager();
        try {
            List<Flight> flight = em.createQuery("select f from Flight f").getResultList();
            String flights = "[";
            for (int i = 0; i < flight.size(); i++) {
                flights += gson.toJson(flight.get(i)) + ",";
            }
            String outPut = flights.substring(0, flights.length() - 1);
            return outPut + "]";
        } finally {
            em.close();
            System.out.println("all");
        }
        //return gson.toJson(flights());
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public String flightId(@PathParam("id") String id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu", null);
        EntityManager em = emf.createEntityManager();
        try {
            Flight flight = (Flight) em.createQuery("select f from Flight f WHERE f.id='" + id + "'").getSingleResult();

            return gson.toJson(flight);
        } finally {
            em.close();
        }
//        return gson.toJson(flights().get((Integer.parseInt(id)-1)));
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/country/{from}/{to}")
    public String flightFromToCountry(@PathParam("from") String from, @PathParam("to") String to) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu", null);
        EntityManager em = emf.createEntityManager();
        try {
            List<Flight> flight = em.createQuery("SELECT f from Flight f WHERE f.startCountry=:from AND f.endCountry=:to")
                    .setParameter("from", from).setParameter("to", to).getResultList();
            String flights = "[";
            for (int i = 0; i < flight.size(); i++) {
                flights += gson.toJson(flight.get(i)) + ",";
            }
            String outPut = flights.substring(0, flights.length() - 1);
            if (flight.size() > 0) {
                return outPut + "]";
            } else {
                System.out.println("ssss");
                return "{\"msg\":\"No flights\"}";
            }

        } finally {
            em.close();
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/country/date/{from}/{to}/{date}")
    public String flightFromToCountryDate(@PathParam("from") String from, @PathParam("to") String to, @PathParam("date") String date) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu", null);
        EntityManager em = emf.createEntityManager();
        try {
            List<Flight> flight = em.createQuery("SELECT f from Flight f WHERE f.startCountry=:from AND f.endCountry=:to AND f.departureDate=:date")
                    .setParameter("from", from).setParameter("to", to).setParameter("date", date).getResultList();
            String flights = "[";
            for (int i = 0; i < flight.size(); i++) {
                flights += gson.toJson(flight.get(i)) + ",";
            }
            String outPut = flights.substring(0, flights.length() - 1);
            if (flight.size() > 0) {
                return outPut + "]";
            } else {
                return "{\"msg\":\"No flights\"}";
            }

        } finally {
            em.close();
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/airport/{from}/{to}")
    public String flightFromToAirport(@PathParam("from") String from, @PathParam("to") String to) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu", null);
        EntityManager em = emf.createEntityManager();
        try {
            List<Flight> flight = em.createQuery("SELECT f from Flight f WHERE f.startDestination=:from AND f.endDestination=:to")
                    .setParameter("from", from).setParameter("to", to).getResultList();
            String flights = "[";
            for (int i = 0; i < flight.size(); i++) {
                flights += gson.toJson(flight.get(i)) + ",";
            }
            String outPut = flights.substring(0, flights.length() - 1);
            if (flight.size() > 0) {
                return outPut + "]";
            } else {
                return "{\"msg\":\"No flights\"}";
            }

        } finally {
            em.close();
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/airport/date/{from}/{to}/{date}")
    public String flightFromToAirportDate(@PathParam("from") String from, @PathParam("to") String to, @PathParam("date") String date) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu", null);
        EntityManager em = emf.createEntityManager();
        try {
            List<Flight> flight = em.createQuery("SELECT f from Flight f WHERE f.startDestination=:from AND f.endDestination=:to AND f.departureDate=:date")
                    .setParameter("from", from).setParameter("to", to).setParameter("date", date).getResultList();
            String flights = "[";
            for (int i = 0; i < flight.size(); i++) {
                flights += gson.toJson(flight.get(i)) + ",";
            }
            String outPut = flights.substring(0, flights.length() - 1);
            if (flight.size() > 0) {
                return outPut + "]";
            } else {
                System.out.println("ssss");
                return "{\"msg\":\"No flights\"}";
            }

        } finally {
            em.close();
        }
    }
  @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/date/all/{date}")
    public String flightFromToAirportDate(@PathParam("date") String date) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu", null);
        EntityManager em = emf.createEntityManager();
        try {
            List<Flight> flight = em.createQuery("SELECT f from Flight f WHERE f.departureDate=:date").setParameter("date", date).getResultList();
            String flights = "[";
            for (int i = 0; i < flight.size(); i++) {
                flights += gson.toJson(flight.get(i)) + ",";
            }
            String outPut = flights.substring(0, flights.length() - 1);
            if (flight.size() > 0) {
                return outPut + "]";
            } else {
                return "{\"msg\":\"No flights\"}";
            }

        } finally {
            em.close();
        }
    }
    /**
     * PUT method for updating or creating an instance of FlightResource
     *
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
