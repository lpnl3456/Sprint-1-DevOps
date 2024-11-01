package com.keyin.rest.AirCraftReport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class AirCraftReportController {
    @Autowired
    private AirCraftReportService airCraftReportService;

    @GetMapping("aircraft_report/{aircraftID}")
    public AirCraftReport generateAirCraftReport(@PathVariable long aircraftID) {
        return airCraftReportService.createAirCraftReport(aircraftID);
    }

    @GetMapping("aircraft_report")
    public List<AirCraftReport> generateAllAirCraftReport() {
        return airCraftReportService.createAllAirCraftReport();
    }
}

