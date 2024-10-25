package com.keyin.rest.FlightDetails;

import com.keyin.rest.AirCraft.AirCraft;
import com.keyin.rest.Landing.Landing;
import com.keyin.rest.Passenger.Passenger;
import com.keyin.rest.TakeOff.TakeOff;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class FlightDetails {
    @Id
    @SequenceGenerator(name = "flight_sequence", sequenceName = "flight_sequence", allocationSize = 1, initialValue = 1)
    @GeneratedValue(generator = "flight_sequence")
    long flight_id;

    @ManyToOne
    AirCraft airCraft;

    @ManyToMany
    List<Passenger> passengers;

    @OneToOne
    TakeOff takeOff;
    @OneToOne
    Landing landing;

    public Landing getLanding() {
        return landing;
    }

    public void setLanding(Landing landing) {
        this.landing = landing;
    }

    public TakeOff getTakeOff() {
        return takeOff;
    }

    public void setTakeOff(TakeOff takeOff) {
        this.takeOff = takeOff;
    }

    public List<Passenger> getPassengers() {
        return passengers;
    }

    public void setPassengers(List<Passenger> passengers) {
        this.passengers = passengers;
    }

    public AirCraft getAirCraft() {
        return airCraft;
    }

    public void setAirCraft(AirCraft airCraft) {
        this.airCraft = airCraft;
    }

    public long getFlight_id() {
        return flight_id;
    }

    public void setFlight_id(long flight_id) {
        this.flight_id = flight_id;
    }




}
