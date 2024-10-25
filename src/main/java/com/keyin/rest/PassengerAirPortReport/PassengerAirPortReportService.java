package com.keyin.rest.PassengerAirPortReport;

import com.keyin.rest.Airport.AirPort;
import com.keyin.rest.City.City;
import com.keyin.rest.CityReport.CityReport;
import com.keyin.rest.FlightDetails.FlightDetails;
import com.keyin.rest.FlightDetails.FlightDetailsService;
import com.keyin.rest.Passenger.Passenger;
import com.keyin.rest.Passenger.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PassengerAirPortReportService {
    @Autowired
    PassengerService passengerService;

    @Autowired
    FlightDetailsService flightDetailsService;

    public PassengerAirPortReport createPassengerAirPortReport(long passengerId){

        PassengerAirPortReport passengerAirPortReport = new PassengerAirPortReport();
        List<AirPort> airports = new ArrayList<AirPort>();

        Passenger passenger = passengerService.getPassengerById(passengerId);
        List<FlightDetails> passengerFlight = flightDetailsService.findFlightByPassenger(passenger);

        if(!passengerFlight.isEmpty()){
            passengerAirPortReport.setPassenger(passenger);

            for(FlightDetails flight: passengerFlight){

                if(!airports.contains(flight.getLanding().getLandingLocation())){
                    airports.add(flight.getLanding().getLandingLocation());
                }

                if(!airports.contains(flight.getTakeOff().getTakeOffLocation())){
                    airports.add(flight.getTakeOff().getTakeOffLocation());
                }
            }

            passengerAirPortReport.setAirports(airports);
        }
        return passengerAirPortReport;
    }
}
