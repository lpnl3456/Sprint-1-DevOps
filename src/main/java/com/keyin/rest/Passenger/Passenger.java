package com.keyin.rest.Passenger;

import com.keyin.rest.City.City;
import jakarta.persistence.*;


@Entity
public class Passenger {
    @Id
    @SequenceGenerator(name = "passenger_sequence", sequenceName = "passenger_sequence", allocationSize = 1, initialValue = 1)
    @GeneratedValue(generator = "passenger_sequence")
    private int passenger_id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    @ManyToOne
    private City city;

    public Passenger() {
    }


    public Passenger(int passenger_id) {
        this.passenger_id = passenger_id;
    }

    public Passenger(int passenger_id, String firstName, String lastName, String phoneNumber, City city) {
        this.passenger_id = passenger_id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.city = city;
    }

    public int getPassenger_id() {
        return passenger_id;
    }

    public void setPassenger_id(int passenger_id) {
        this.passenger_id = passenger_id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public City getCity_id() {
        return city;
    }

    public void setCity_id(City city_id) {
        this.city = city_id;
    }
}
