package com.keyin.rest.Passenger;

import com.keyin.rest.City.City;
import com.keyin.rest.Gate.GateRepository;
import com.keyin.rest.Gate.GateService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PassengerServiceTest {

    @Mock
    private PassengerRepository passengerRepository;
    @InjectMocks
    private PassengerService passengerService;

    @Test
    public void testGetAllPassengerss(){
        City stJohnsCity =  new City(1,"St John's","States", 2000);
        Passenger passenger = new Passenger(1, "John", "Doe", "1234567890", stJohnsCity);

        List<Passenger> passengers = new ArrayList<Passenger>();

        passengers.add(passenger);

        when(passengerRepository.findAll()).thenReturn(passengers);

        List<Passenger> passengerResponse = passengerService.getAllPassengers();

        Assertions.assertNotNull(passengerResponse);
    }

    @Test
    public void testGetPassengerById(){
        City stJohnsCity =  new City(1,"St John's","States", 2000);
        Passenger passenger = new Passenger(1, "John", "Doe", "1234567890", stJohnsCity);

        List<Passenger> passengers = new ArrayList<Passenger>();

        passengers.add(passenger);

        when(passengerRepository.findById(Long.valueOf(1))).thenReturn(Optional.of(passenger));

        Passenger passengerResponse = passengerService.getPassengerById(1);

        Assertions.assertNotNull(passengerResponse);
    }
}

