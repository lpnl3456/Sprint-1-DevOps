package com.keyin.rest.PassengerAirPortReport;

import com.keyin.rest.CityReport.CityReport;
import com.keyin.rest.CityReport.CityReportServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class PassengerAirportReportController {

    @Autowired
    private PassengerAirPortReportService passengerAirPortReportService;

    @GetMapping("passenger_airport_report/{passengerID}")
    public PassengerAirPortReport generatePassengerAirPortReport(@PathVariable long passengerID){
        return passengerAirPortReportService.createPassengerAirPortReport(passengerID);
    }
}
