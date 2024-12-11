package com.keyin.rest.City;

import com.keyin.rest.AirCraft.AirCraft;
import com.keyin.rest.AirCraft.AirCraftRepository;
import com.keyin.rest.AirCraft.AirCraftService;
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
public class CityServiceTest {

    @Mock
    private CityRepository cityRepository;
    @InjectMocks
    private CityService cityService;

    @Test

    public void testFindByName(){
        City stJohnsCity =  new City(1,"St John's","States", 2000);
        List<City> cities = new ArrayList<City>();

        cities.add(stJohnsCity);

        when(cityService.findByName("St John's")).thenReturn(stJohnsCity);

        City CityResponse = cityService.findByName("St John's");

        Assertions.assertNotNull(CityResponse);
    }

    @Test
    public void testGetAllCities(){
        City stJohnsCity =  new City(1,"St John's","States", 2000);
        List<City> cities = new ArrayList<City>();

        cities.add(stJohnsCity);

        when(cityRepository.findAll()).thenReturn(cities);

        List<City> CityResponse = cityService.getAllCities();

        Assertions.assertNotNull(CityResponse);
    }

    @Test
    public void testGetCityById(){
        City stJohnsCity =  new City(1,"St John's","States", 2000);
        List<City> cities = new ArrayList<City>();

        cities.add(stJohnsCity);

        when(cityRepository.findById(Long.valueOf(1))).thenReturn(Optional.of(stJohnsCity));

        City CityResponse = cityService.getCityById(1);

        Assertions.assertNotNull(CityResponse);
    }
}
