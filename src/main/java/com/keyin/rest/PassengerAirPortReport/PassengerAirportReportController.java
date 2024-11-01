package com.keyin.rest.PassengerAirPortReport;

import com.keyin.rest.CityReport.CityReport;
import com.keyin.rest.CityReport.CityReportServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class PassengerAirportReportController {

    @Autowired
    private PassengerAirPortReportService passengerAirPortReportService;

    @GetMapping("passenger_airport_report/{passengerID}")
    public PassengerAirPortReport generatePassengerAirPortReport(@PathVariable long passengerID){
        return passengerAirPortReportService.createPassengerAirPortReport(passengerID);
    }

    @GetMapping("passenger_airport_report")
    public List<PassengerAirPortReport> generateAllPassengerAirPortReport(){
        return passengerAirPortReportService.createAllPassengerAirPortReport();
    }
}
