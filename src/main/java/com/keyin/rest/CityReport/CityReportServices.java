package com.keyin.rest.CityReport;

import com.keyin.rest.Airport.AirPort;
import com.keyin.rest.Airport.AirPortService;
import com.keyin.rest.City.City;
import com.keyin.rest.City.CityService;
import com.keyin.rest.Passenger.Passenger;
import com.keyin.rest.Passenger.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CityReportServices {

    @Autowired
    private CityService cityService;
    @Autowired
    private AirPortService airportService;
    @Autowired
    private PassengerService passengerService;

    public CityReport createCityAirPortReport(long cityId){
        CityReport cityAirPortReport = new CityReport();
        City city = cityService.getCityById(cityId);

        List<AirPort> airPortsForReport = (List<AirPort>) airportService.findAirPortsByCityID(city);
        if(!airPortsForReport.isEmpty()){
            cityAirPortReport.setCity(airPortsForReport.get(0).getCity_id());
            cityAirPortReport.setAirports(airPortsForReport);
        }
        return cityAirPortReport;
    }


    public List<CityReport> createAllCityAirPortReport(){
        List<CityReport> cityAirPortReports = new ArrayList<CityReport>();

        List<City> cities = cityService.getAllCities();

        for(City city: cities) {
            CityReport cityAirPortReport = new CityReport();
            List<AirPort> airPortsForReport = (List<AirPort>) airportService.findAirPortsByCityID(city);
            if (!airPortsForReport.isEmpty()) {
                cityAirPortReport.setCity(city);
                cityAirPortReport.setAirports(airPortsForReport);
                cityAirPortReports.add(cityAirPortReport);
            }
        }
        return cityAirPortReports;
    }
}
