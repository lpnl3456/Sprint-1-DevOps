package com.keyin.rest.Airport;

import com.keyin.rest.City.City;
import com.keyin.rest.City.CityService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.awt.print.Pageable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AirportServiceTest {
    @Mock
    private AirPortRepository airPortRepository;
    @InjectMocks
    private AirPortService airportService;
    @InjectMocks
    private CityService cityService;


    @Test
    public void testGetAllAirport(){

        City stJohnsCity =  new City(1,"St John's","States", 2000);
        AirPort airport = new AirPort(1,"St John's", "YYH",stJohnsCity);
        List<AirPort> airports = new ArrayList<AirPort>();
        airports.add(airport);


        when(airPortRepository.findAll()).thenReturn(airports);

        List<AirPort> airportResponse = airportService.getAllAirports();

        Assertions.assertNotNull(airportResponse);
    }
    @Test
    public void testGetAirportByName(){

        City stJohnsCity =  new City(1,"St John's","States", 2000);
     AirPort airport = new AirPort(1,"St John's", "YYH",stJohnsCity);
     List<AirPort> airports = new ArrayList<AirPort>();
    airports.add(airport);


    when(airPortRepository.findByName("St John's")).thenReturn(airport);

    AirPort airportResponse = airportService.findAirPortByName("St John's");

        Assertions.assertEquals("St John's", airportResponse.getName());
    }

    @Test
    public void testGetAirportByID(){

        City stJohnsCity =  new City(1,"St John's","States", 2000);
        AirPort airport = new AirPort(1,"St John's", "YYH",stJohnsCity);
        List<AirPort> airports = new ArrayList<AirPort>();
        airports.add(airport);


        when(airPortRepository.findById(Long.valueOf(1))).thenReturn(Optional.of(airport));

        AirPort airportResponse = airportService.findAirPortById(1);

        Assertions.assertEquals(1, airportResponse.getId());
    }

    @Test
    public void testGetAirportByCity(){

        City stJohnsCity =  new City(1,"St John's","States", 2000);
        AirPort airport = new AirPort(1,"St John's", "YYH",stJohnsCity);
        List<AirPort> airports = new ArrayList<AirPort>();
        airports.add(airport);


        when(airPortRepository.findByCity(stJohnsCity)).thenReturn(airports);

        List<AirPort> airportResponse = airportService.findAirPortsByCityID(stJohnsCity);

        Assertions.assertEquals(1, airportResponse.get(0).getId());
    }


}
