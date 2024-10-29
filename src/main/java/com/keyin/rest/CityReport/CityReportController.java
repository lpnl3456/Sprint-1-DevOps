package com.keyin.rest.CityReport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class CityReportController {

    @Autowired
    private CityReportServices cityReportService;

    @GetMapping("city_report/airport/{cityId}")
    public CityReport generateCityAirPortReport(@PathVariable long cityId){
        return cityReportService.createCityAirPortReport(cityId);
    }

    @GetMapping("city_report/resident/{cityId}")
    public CityReport generateCityPassengerReport(@PathVariable long cityId){
        return cityReportService.createCityPassengerReport(cityId);
    }

    @GetMapping("city_report/airports")
    public List<CityReport> generateAllCityAirportReport(){
        return cityReportService.createAllCityAirPortReport();
    }

}
