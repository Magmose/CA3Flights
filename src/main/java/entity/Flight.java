/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Rasmu
 */
@Entity
public class Flight implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String startDestination, endDestination, startCountry, endCountry, departureTime, departureDate, duration, numberOfSeats, direct, airline, price, cordiStart, cordiEnd;

    public Flight() {
    }

    public Flight(Integer id, String startDestination, String endDestination, String startCountry, String endCountry, String departureTime, String departureDate, String duration, String numberOfSeats, String direct, String airline, String price, String cordiStart, String cordiEnd) {
        this.id = id;
        this.startDestination = startDestination;
        this.endDestination = endDestination;
        this.startCountry = startCountry;
        this.endCountry = endCountry;
        this.departureTime = departureTime;
        this.departureDate = departureDate;
        this.duration = duration;
        this.numberOfSeats = numberOfSeats;
        this.direct = direct;
        this.airline = airline;
        this.price = price;
        this.cordiEnd = cordiEnd;
        this.cordiStart = cordiStart;
    }

    public String getCordiStart() {
        return cordiStart;
    }

    public String getCordiEnd() {
        return cordiEnd;
    }

    public void setCordiStart(String cordiStart) {
        this.cordiStart = cordiStart;
    }

    public void setCordiEnd(String cordiEnd) {
        this.cordiEnd = cordiEnd;
    }

    public String getStartDestination() {
        return startDestination;
    }

    public void setStartDestination(String startDestination) {
        this.startDestination = startDestination;
    }

    public String getEndDestination() {
        return endDestination;
    }

    public void setEndDestination(String endDestination) {
        this.endDestination = endDestination;
    }

    public String getStartCountry() {
        return startCountry;
    }

    public void setStartCountry(String startCountry) {
        this.startCountry = startCountry;
    }

    public String getEndCountry() {
        return endCountry;
    }

    public void setEndCountry(String endCountry) {
        this.endCountry = endCountry;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(String numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public String getDirect() {
        return direct;
    }

    public void setDirect(String direct) {
        this.direct = direct;
    }

    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Flight{" + "id=" + id + ", startDestination=" + startDestination + ", endDestination=" + endDestination + ", startCountry=" + startCountry + ", endCountry=" + endCountry + ", departureTime=" + departureTime + ", departureDate=" + departureDate + ", duration=" + duration + ", numberOfSeats=" + numberOfSeats + ", direct=" + direct + ", airline=" + airline + ", price=" + price + ", cordiStart=" + cordiStart + ", cordiEnd=" + cordiEnd + '}';
    }
    

}
