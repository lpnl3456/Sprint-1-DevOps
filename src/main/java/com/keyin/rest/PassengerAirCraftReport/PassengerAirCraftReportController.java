package com.keyin.rest.PassengerAirCraftReport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class PassengerAirCraftReportController {

    @Autowired
    private PassengerAirCraftReportService passengerAirCraftReportService;

    @GetMapping("passenger_aircraft_report/{passengerID}")
    public PassengerAirCraftReport generatePassengerAirCraftReport(@PathVariable long passengerID) {
        return  passengerAirCraftReportService.createPassengerAirCraftReport(passengerID);
    }

    @GetMapping("passenger_aircraft_report")
    public List<PassengerAirCraftReport> generateAllPassengerAirCraftReport() {
        return  passengerAirCraftReportService.createAllPassengerAirCraftReport();
    }


}
