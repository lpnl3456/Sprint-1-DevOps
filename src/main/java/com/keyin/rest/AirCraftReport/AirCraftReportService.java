package com.keyin.rest.AirCraftReport;

import com.keyin.rest.AirCraft.AirCraft;
import com.keyin.rest.AirCraft.AirCraftService;
import com.keyin.rest.Airport.AirPort;
import com.keyin.rest.Airport.AirPortService;
import com.keyin.rest.City.City;
import com.keyin.rest.CityReport.CityReport;
import com.keyin.rest.FlightDetails.FlightDetails;
import com.keyin.rest.FlightDetails.FlightDetailsService;
import com.keyin.rest.Passenger.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AirCraftReportService {
    @Autowired
    private FlightDetailsService flightDetailsService;
    @Autowired
    private AirCraftService airCraftService;
    @Autowired
    private AirPortService airPortService;

    public AirCraftReport createAirCraftReport(long aircraftId){

       AirCraftReport airCraftReport = new AirCraftReport();
        List<AirPort> airports = new ArrayList<AirPort>();

        AirCraft airCraft = airCraftService.findAirCraftById(aircraftId);
        List<FlightDetails> airCraftFlight = flightDetailsService.getFlightByAirCraft(airCraft);

        if(!airCraftFlight.isEmpty()){
            airCraftReport.setAircraft(airCraft);

            for(FlightDetails flight: airCraftFlight){

                if(!airports.contains(flight.getLanding().getLandingLocation())){
                    airports.add(flight.getLanding().getLandingLocation());
                }

                if(!airports.contains(flight.getTakeOff().getTakeOffLocation())){
                    airports.add(flight.getTakeOff().getTakeOffLocation());
                }
            }

            airCraftReport.setAirports(airports);
        }
        return airCraftReport;
    }


    public List<AirCraftReport> createAllAirCraftReport(){

        List<AirCraftReport>airCraftReports = new ArrayList<AirCraftReport>();
        List<AirPort> airports = new ArrayList<AirPort>();

        List<AirCraft> airCrafts = airCraftService.getAllAirCraft();

        for(AirCraft aircraft: airCrafts) {
            AirCraftReport airCraftReport = new AirCraftReport();

            List<FlightDetails> airCraftFlight = flightDetailsService.getFlightByAirCraft(aircraft);

            if (!airCraftFlight.isEmpty()) {
                airCraftReport.setAircraft(aircraft);

                for (FlightDetails flight : airCraftFlight) {

                    if (!airports.contains(flight.getLanding().getLandingLocation())) {
                        airports.add(flight.getLanding().getLandingLocation());
                    }

                    if (!airports.contains(flight.getTakeOff().getTakeOffLocation())) {
                        airports.add(flight.getTakeOff().getTakeOffLocation());
                    }
                }

                airCraftReport.setAirports(airports);
            }
            airCraftReports.add(airCraftReport);
        }
        return airCraftReports;
    }


    public List<AirCraftReport> createAllAirCraftsReport(){
        List<AirCraftReport> airCraftReports = new ArrayList<AirCraftReport>();

        List<AirCraft> airCrafts = airCraftService.getAllAirCraft();

        for(AirCraft airCraft: airCrafts) {
            AirCraftReport airCraftReport = new AirCraftReport();
            List<AirPort> airPortsForReport = (List<AirPort>) airPortService.findAirPortById(airCraft.getAirCraft_id());
            if (!airPortsForReport.isEmpty()) {
                airCraftReport.setAircraft(airCraft);
                airCraftReport.setAirports(airPortsForReport);
                airCraftReports.add(airCraftReport);
            }
        }
        return airCraftReports;
    }

}
