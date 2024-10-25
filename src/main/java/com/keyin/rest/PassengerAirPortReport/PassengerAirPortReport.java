package com.keyin.rest.PassengerAirPortReport;


import com.keyin.rest.Airport.AirPort;
import com.keyin.rest.Passenger.Passenger;

import java.util.List;

public class PassengerAirPortReport {

    private Passenger passenger;
    private List <AirPort> airports;

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public List<AirPort> getAirports() {
        return airports;
    }

    public void setAirports(List<AirPort> airports) {
        this.airports = airports;
    }


}
