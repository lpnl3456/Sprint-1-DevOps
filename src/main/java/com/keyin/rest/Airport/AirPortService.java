package com.keyin.rest.Airport;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

@Service
public class AirPortService {
    @Autowired
    private AirPortRepository airPortRepository;

    public List<AirPort> getAllAirports() {
        return (List<AirPort>) airPortRepository.findAll();
    }

    public AirPort findAirPortById(long id) {
        Optional<AirPort> airPortOptional = airPortRepository.findById(id);

        return airPortOptional.orElse(null);
    }

    public AirPort createAirPort(AirPort newAirPort) {
        return airPortRepository.save(newAirPort);
    }

    public AirPort updateAirPort(long id, AirPort updatedAirPort) {
        Optional<AirPort> airPortToUpdateOptional = airPortRepository.findById(id);

        if (airPortToUpdateOptional.isPresent()) {
            AirPort airPortToUpdate = airPortToUpdateOptional.get();

            airPortToUpdate.setName(updatedAirPort.getName());
            airPortToUpdate.setCode(updatedAirPort.getCode());
            airPortToUpdate.setCity_id(updatedAirPort.getCity_id());

            return airPortRepository.save(airPortToUpdate);
        }
        return null;
    }

    public void deleteAirPortById(long id) {
        airPortRepository.deleteById(id);
    }

/*
    @Autowored
    private CityRepository cityRepository
     */
}
