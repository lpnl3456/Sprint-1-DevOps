package com.keyin.rest.Airport;

import com.keyin.rest.City.City;
import com.keyin.rest.City.CityRepository;
import com.keyin.rest.City.CityService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

@Service
public class AirPortService {
    @Autowired
    private AirPortRepository airPortRepository;

    @Autowired
    private CityService cityService;

    public List<AirPort> getAllAirports() {
        return (List<AirPort>) airPortRepository.findAll();
    }

    public AirPort findAirPortById(long id) {
        Optional<AirPort> airPortOptional = airPortRepository.findById(id);

        return airPortOptional.orElse(null);
    }
    public List<AirPort> findAirPortsByCityID(City city){
        List<AirPort> airPortOptional = airPortRepository.findByCity(city);
        return airPortOptional;
    }

    public List<AirPort> findAirPortsByCityID(City city){
        List<AirPort> airPortOptional = airPortRepository.findByCity(city);
        return airPortOptional;
    }

    public AirPort createAirPort(AirPort newAirPort) {
        String cityName = newAirPort.getCity_id().getName();

        if(cityName != null){
            City city = cityService.findByName(cityName);


            if(city == null){
                city = cityService.createCity(newAirPort.getCity_id());
            }

            newAirPort.setCity_id(city);
        }

        return airPortRepository.save(newAirPort);
    }

    public AirPort updateAirPort(long id, AirPort updatedAirPort) {
        Optional<AirPort> airPortToUpdateOptional = airPortRepository.findById(id);

        if (airPortToUpdateOptional.isPresent()) {
            System.out.println("Enter");
            AirPort airPortToUpdate = airPortToUpdateOptional.get();

            airPortToUpdate.setName(updatedAirPort.getName());
            airPortToUpdate.setCode(updatedAirPort.getCode());
            airPortToUpdate.setCity_id(cityService.getCityById(updatedAirPort.getCity_id().getCity_id()));

            return airPortRepository.save(airPortToUpdate);
        }
        return null;
    }

    public void deleteAirPortById(long id) {
        airPortRepository.deleteById(id);
    }


}
