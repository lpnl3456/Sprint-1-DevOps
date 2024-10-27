package com.keyin.rest.PassengerAirCraftReport;

import com.keyin.rest.AirCraft.AirCraft;
import com.keyin.rest.FlightDetails.FlightDetails;
import com.keyin.rest.FlightDetails.FlightDetailsService;
import com.keyin.rest.Passenger.Passenger;
import com.keyin.rest.Passenger.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PassengerAirCraftReportService {
    @Autowired
    PassengerService passengerService;

    @Autowired
    FlightDetailsService flightDetailsService;

    public PassengerAirCraftReport createPassengerAirCraftReport(long passengerId) {
        PassengerAirCraftReport passengerAirCraftReport = new PassengerAirCraftReport();
        List<AirCraft> airCrafts = new ArrayList<AirCraft>();

        Passenger passenger = passengerService.getPassengerById(passengerId);
        List<FlightDetails> passengerFlight = flightDetailsService.findFlightByPassenger(passenger);

        if (!passengerFlight.isEmpty()) {
            passengerAirCraftReport.setPassenger(passenger);

            for (FlightDetails flight: passengerFlight) {
                if(!airCrafts.contains(flight.getAirCraft())) {
                    airCrafts.add(flight.getAirCraft());
                }
            }
            passengerAirCraftReport.setAirCrafts(airCrafts);
        }
        return passengerAirCraftReport;

    }
}
