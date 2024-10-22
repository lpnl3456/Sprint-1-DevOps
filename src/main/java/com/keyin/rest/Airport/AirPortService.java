package com.keyin.rest.Airport;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class AirPortService {
    @Autowired
    private AirPortRepository airPortRepository;

    public List<AirPort> getAllAirports() {

    return null;
    }

    public AirPort findAirPortById(long id) {
        return null;
    }

    public AirPort createAirPort(AirPort newAirPort) {

        return null;
    }

/*
    @Autowored
    private CityRepository cityRepository
     */
}
