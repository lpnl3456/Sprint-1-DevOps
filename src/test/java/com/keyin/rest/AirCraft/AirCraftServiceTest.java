package com.keyin.rest.AirCraft;

import com.keyin.rest.Airport.AirPort;
import com.keyin.rest.Airport.AirPortRepository;
import com.keyin.rest.Airport.AirPortService;
import com.keyin.rest.City.CityService;
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
public class AirCraftServiceTest {
    @Mock
    private AirCraftRepository airCraftRepository;
    @InjectMocks
    private AirCraftService airCraftService;

    @Test
    public void testGetAllAirCraft(){
        AirCraft boeing = new AirCraft(1, "Boeing 757", "Pal", 130);
        List<AirCraft> airCrafts = new ArrayList<AirCraft>();

        airCrafts.add(boeing);

        when(airCraftRepository.findAll()).thenReturn(airCrafts);

        List<AirCraft> airCraftResponse = airCraftService.getAllAirCraft();

        Assertions.assertNotNull(airCraftResponse);
    }

    @Test
    public void testFindAirCraftByID(){
        AirCraft boeing = new AirCraft(1, "Boeing 757", "Pal", 130);
        List<AirCraft> airCrafts = new ArrayList<AirCraft>();

        airCrafts.add(boeing);

        when(airCraftRepository.findById(Long.valueOf(1))).thenReturn(Optional.of(boeing));

        AirCraft airCraftResponse = airCraftService.findAirCraftById(1);

        Assertions.assertNotNull(airCraftResponse);
    }


}
