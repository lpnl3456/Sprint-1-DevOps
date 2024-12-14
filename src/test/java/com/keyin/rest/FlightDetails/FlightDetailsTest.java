package com.keyin.rest.FlightDetails;

import com.keyin.rest.AirCraft.AirCraft;
import com.keyin.rest.Airport.AirPort;
import com.keyin.rest.City.City;
import com.keyin.rest.Gate.Gate;
import com.keyin.rest.Landing.Landing;
import com.keyin.rest.Passenger.Passenger;
import com.keyin.rest.TakeOff.TakeOff;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class FlightDetailsTest {

    @Mock
    private FlightDetailsRepository flightDetailsRepository;
    @InjectMocks
    private FlightDetailsService flightDetailsService;

    @Test
    public void testGetAllFlights(){
        City stJohnsCity = new City(1, "St John's", "States", 2000);

        AirPort airport = new AirPort(1, "St John's", "YYH", stJohnsCity);
        AirCraft boeing = new AirCraft(1, "Boeing 757", "Pal", 130);
        Gate gate = new Gate(1, "gate A");
        Passenger passenger = new Passenger(1, "John", "Doe", "1234567890", stJohnsCity);
        Date date = new Date();

        Landing landing = new Landing(1, airport, date, boeing, gate);
        TakeOff takeOff = new TakeOff(1, airport,date, boeing, gate);
        List<Passenger> passengers = new ArrayList<Passenger>();

        passengers.add(passenger);

        FlightDetails flightDetail = new FlightDetails(1,boeing,passengers,takeOff,landing);
        List<FlightDetails> flightDetailsList = new ArrayList<FlightDetails>();

        flightDetailsList.add(flightDetail);

        when(flightDetailsRepository.findAll()).thenReturn(flightDetailsList);



        List<FlightDetails> flightResponse = flightDetailsService.getAllFlights();

        Assertions.assertNotNull(flightResponse);
    }

    @Test
    public void testFlightByID(){
        City stJohnsCity = new City(1, "St John's", "States", 2000);

        AirPort airport = new AirPort(1, "St John's", "YYH", stJohnsCity);
        AirCraft boeing = new AirCraft(1, "Boeing 757", "Pal", 130);
        Gate gate = new Gate(1, "gate A");
        Passenger passenger = new Passenger(1, "John", "Doe", "1234567890", stJohnsCity);
        Date date = new Date();

        Landing landing = new Landing(1, airport, date, boeing, gate);
        TakeOff takeOff = new TakeOff(1, airport,date, boeing, gate);
        List<Passenger> passengers = new ArrayList<Passenger>();

        passengers.add(passenger);

        FlightDetails flightDetail = new FlightDetails(1,boeing,passengers,takeOff,landing);
        List<FlightDetails> flightDetailsList = new ArrayList<FlightDetails>();

        flightDetailsList.add(flightDetail);

        when(flightDetailsRepository.findById(Long.valueOf(1))).thenReturn(Optional.of(flightDetail));



        FlightDetails flightResponse = flightDetailsService.getFlightById(1);

        Assertions.assertNotNull(flightResponse);
    }
}
