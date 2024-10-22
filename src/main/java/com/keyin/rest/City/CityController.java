package com.keyin.rest.City;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class CityController {
    @Autowired
    private CityService cityService;

    @GetMapping("/city")
    public List<City> getAllCities() {
        return cityService.getAllCities();
    }

    @GetMapping("/city/{id}")
    public City getCityById(@PathVariable long id) {
        return cityService.getCityById(id);
    }

    @PostMapping("/city")
    public City createCity(@RequestBody City city) {
        return cityService.createCity(city);
    }

    @PutMapping("/city/{id}")
    public ResponseEntity<City> updateCIty(@PathVariable long id, @RequestBody City city) {
        return ResponseEntity.ok(cityService.updateCity(id, city));
    }

    @DeleteMapping("/city/{id}")
    public void deleteCityById(@PathVariable long id) {
        cityService.deleteCityById(id);
    }
}
