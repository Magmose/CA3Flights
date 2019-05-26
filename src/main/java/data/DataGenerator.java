/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import entity.Flight;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Rasmu
 */
public class DataGenerator {

    String[] countries = {"Denmark", "Norway", "Sweden", "Finland"};

    String[] airportDenmark = {"CPH", "BLL"};
    String[] airportCordDenmark = {"55.62383/12.6415", "55.725163766/9.10916623"};

    String[] airportFinland = {"HEL", "RVN", "KAO"};
    String[] airportCordFinland = {"60.317222/24.963333", "66.556997772/25.825163366", "65.9876022339/29.2394008636"};

    String[] airportNorway = {"OSL", "BGO", "SVG", "BOO"};
    String[] airportCordNorway = {"60.197552/11.100415", "60.2907/5.22065", "58.872663176/5.635997456", "67.2692/14.3653"};

    String[] airportSweden = {"MMX", "AGH", "HAD"};
    String[] airportCordSweden = {"55.5406/13.3666", "56.290998836/12.8416633", "56.690833/12.82"};

    String[] airlines = {"Scandinavian Airline", "Ryanair Ltd", "Lufthansa Group", "International Airlines Group"};

    public String dgCountry() {
        String country = countries[(int) (Math.random() * (countries.length))];
        return country;
    }

    public String dgDestination(String[] airports) {
        String destination = airports[(int) (Math.random() * (airports.length))];
        return destination;
    }

    public String dgAirline() {
        String airline = airlines[(int) (Math.random() * (airlines.length))];
        return airline;
    }

    public String dgDate() {
        int month = randBetween(1, 12);
        int date;

        switch (month) {
            case 4:
            case 6:
            case 9:
            case 11:
                date = randBetween(1, 30);
                break;
            case 2:
                date = randBetween(1, 28);
                break;
            default:
                date = randBetween(1, 31);
                break;
        }

        int year = 2019;
        String res = date + "-" + month + "-" + year;
        return res;
    }

    public int randBetween(int start, int end) {
        return start + (int) Math.round(Math.random() * (end - start));
    }

    private String dgTime(int minHour, int maxHour) {
        String res;
        String hour = Integer.toString(randBetween(minHour, maxHour));
        String min = Integer.toString(randBetween(0, 59));

        if (hour.length() == 1) {
            hour = 0 + hour;
        }
        if (min.length() == 1) {
            min = 0 + min;
        }
        res = hour + ":" + min;

        return res;
    }

    public Flight makeFlight() {
        Flight flight = new Flight();
        flight.setAirline(dgAirline());
        flight.setDepartureDate(dgDate());
        flight.setDepartureTime(dgTime(0, 23));
        flight.setDirect("0");

        flight.setDuration(dgTime(1, 3));
        flight.setNumberOfSeats(Integer.toString(randBetween(0, 110)));
        flight.setPrice(Integer.toString(randBetween(500, 2000)));

        String endCountry = dgCountry();
        flight.setEndCountry(endCountry);
        if ("Denmark".equals(endCountry)) {
            String des = dgDestination(airportDenmark);
            flight.setEndDestination(des);
            if ("CPH".equals(des)) {
                flight.setCordiEnd(airportCordDenmark[0]);
            }
            if ("BLL".equals(des)) {
                flight.setCordiEnd(airportCordDenmark[1]);
            }
        }
        if ("Finland".equals(endCountry)) {
            String des = dgDestination(airportFinland);
            flight.setEndDestination(des);
            if ("HEL".equals(des)) {
                flight.setCordiEnd(airportCordFinland[0]);
            }
            if ("RVN".equals(des)) {
                flight.setCordiEnd(airportCordFinland[1]);
            }
            if ("KAO".equals(des)) {
                flight.setCordiEnd(airportCordFinland[2]);
            }

        }
        if ("Norway".equals(endCountry)) {
            String des = dgDestination(airportNorway);
            flight.setEndDestination(des);
            if ("OSL".equals(des)) {
                flight.setCordiEnd(airportCordNorway[0]);
            }
            if ("BGO".equals(des)) {
                flight.setCordiEnd(airportCordNorway[1]);
            }
            if ("SVG".equals(des)) {
                flight.setCordiEnd(airportCordNorway[2]);
            }
            if ("BOO".equals(des)) {
                flight.setCordiEnd(airportCordNorway[3]);
            }
        }
        if ("Sweden".equals(endCountry)) {
            String des = dgDestination(airportSweden);
            flight.setEndDestination(des);
            if ("MMX".equals(des)) {
                flight.setCordiEnd(airportCordSweden[0]);
            }
            if ("AGH".equals(des)) {
                flight.setCordiEnd(airportCordSweden[1]);
            }
            if ("HAD".equals(des)) {
                flight.setCordiEnd(airportCordSweden[2]);
            }
        }

        String startCountry = dgCountry();
        while (startCountry.equals(endCountry)) {
            startCountry = dgCountry();
        }
        flight.setStartCountry(startCountry);
        if ("Denmark".equals(startCountry)) {
            String des = dgDestination(airportDenmark);
            flight.setStartDestination(des);
            if ("CPH".equals(des)) {
                flight.setCordiStart(airportCordDenmark[0]);
            }
            if ("BLL".equals(des)) {
                flight.setCordiStart(airportCordDenmark[1]);
            }
        }

        if ("Finland".equals(startCountry)) {
            String des = dgDestination(airportFinland);
            flight.setStartDestination(des);
            if ("HEL".equals(des)) {
                flight.setCordiStart(airportCordFinland[0]);
            }
            if ("RVN".equals(des)) {
                flight.setCordiStart(airportCordFinland[1]);
            }
            if ("KAO".equals(des)) {
                flight.setCordiStart(airportCordFinland[2]);
            }
        }
        if ("Norway".equals(startCountry)) {
            String des = dgDestination(airportNorway);
            flight.setStartDestination(des);
            if ("OSL".equals(des)) {
                flight.setCordiStart(airportCordNorway[0]);
            }
            if ("BGO".equals(des)) {
                flight.setCordiStart(airportCordNorway[1]);
            }
            if ("SVG".equals(des)) {
                flight.setCordiStart(airportCordNorway[2]);
            }
            if ("BOO".equals(des)) {
                flight.setCordiStart(airportCordNorway[3]);
            }
        }
        if ("Sweden".equals(startCountry)) {
            String des = dgDestination(airportSweden);
            flight.setStartDestination(des);
            if ("MMX".equals(des)) {
                flight.setCordiStart(airportCordSweden[0]);
            }
            if ("AGH".equals(des)) {
                flight.setCordiStart(airportCordSweden[1]);
            }
            if ("HAD".equals(des)) {
                flight.setCordiStart(airportCordSweden[2]);
            }
        }

        System.out.println(flight.toString());
        return flight;
    }

    public List<Flight> makeFlights(int howMany) {

        List<Flight> flights = new ArrayList();
        for (int i = 0; i < howMany; i++) {
            flights.add(makeFlight());

        }
        return flights;
    }

    public static void main(String[] args) {
        int number = 10000;

        DataGenerator dg = new DataGenerator();
        List<Flight> flights = dg.makeFlights(number);
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();

            for (int i = 0; i < flights.size(); i++) {
                em.persist(flights.get(i));
            }

            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
}
