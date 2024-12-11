package com.keyin.rest.Landing;

import com.keyin.rest.AirCraft.AirCraft;
import com.keyin.rest.Airport.AirPort;
import com.keyin.rest.Airport.AirPortService;
import com.keyin.rest.City.City;
import com.keyin.rest.Gate.Gate;
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
public class LandingServiceTest {

    @Mock
    private LandingRepository landingRepository;
    @InjectMocks
    private LandingService landingService;

    private AirPortService airPortService;

    @Test
    public void testGetAllLanding() {
        City stJohnsCity = new City(1, "St John's", "States", 2000);

        AirPort airport = new AirPort(1, "St John's", "YYH", stJohnsCity);
        AirCraft boeing = new AirCraft(1, "Boeing 757", "Pal", 130);
        Gate gate = new Gate(1, "gate A");
        Date date = new Date();

        Landing landing = new Landing(1, airport, date, boeing, gate);

        List<Landing> landings = new ArrayList<Landing>();

        when(landingRepository.findAll()).thenReturn(landings);


        List<Landing> landingResponse = landingService.getAllLanding();

        Assertions.assertNotNull(landingResponse);

    }

    @Test
    public void testLandingByID() {
        City stJohnsCity = new City(1, "St John's", "States", 2000);

        AirPort airport = new AirPort(1, "St John's", "YYH", stJohnsCity);
        AirCraft boeing = new AirCraft(1, "Boeing 757", "Pal", 130);
        Gate gate = new Gate(1, "gate A");
        Date date = new Date();

        Landing landing = new Landing(1, airport, date, boeing, gate);

        List<Landing> landings = new ArrayList<Landing>();

        when(landingRepository.findById(Long.valueOf(1))).thenReturn(Optional.of(landing));

        Landing landingResponse = landingService.getLandingById(1);

        Assertions.assertNotNull(landingResponse);

    }

}
