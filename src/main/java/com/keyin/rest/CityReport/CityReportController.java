package com.keyin.rest.CityReport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class CityReportController {

    @Autowired
    private CityReportServices cityReportService;

    @GetMapping("city_report/{cityId}")
    public CityReport generateCityAirPortReport(@PathVariable long cityId){
        return cityReportService.createCityAirPortReport(cityId);
    }



    @GetMapping("city_report")
    public List<CityReport> generateAllCityAirportReport(){
        return cityReportService.createAllCityAirPortReport();
    }

}
