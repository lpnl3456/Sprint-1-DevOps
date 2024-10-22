package com.keyin.rest.City;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CityService {
    @Autowired
    private CityRepository cityRepository;

    public City findByName(String name) {
        return cityRepository.findByName(name);
    }

    public List<City> getAllCities() {
        return (List<City>) cityRepository.findAll();
    }

    public City getCityById(long id) {
        Optional<City> cityOptional = cityRepository.findById(id);

        return cityOptional.orElse(null);
    }

    public void deleteCityById(long id) {
        cityRepository.deleteById(id);
    }

    public City createCity(City newCity) {
        return cityRepository.save(newCity);
    }

    public City updateCity(long id, City updatedCity) {
        Optional<City> cityToUpdateOptional = cityRepository.findById(id);

        if (cityToUpdateOptional.isPresent()) {
            City cityToUpdate = cityToUpdateOptional.get();

            cityToUpdate.setName(updatedCity.getName());
            cityToUpdate.setState(updatedCity.getState());
            cityToUpdate.setPopulation(updatedCity.getPopulation());

            return cityRepository.save(cityToUpdate);
        }
        return null;
    }
}
