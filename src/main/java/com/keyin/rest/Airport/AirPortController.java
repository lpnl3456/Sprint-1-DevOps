package com.keyin.rest.Airport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class AirPortController {
    @Autowired
    private AirPortService airPortService;

    @GetMapping("/airport")
    public List<AirPort> getAllAirPorts(){
        return airPortService.getAllAirports();
    }

    @GetMapping("/airport/{id}")
    public AirPort getCourseByID(@PathVariable long id) {
        return airPortService.findAirPortById(id);
    }

    @GetMapping("/searchAirportByName")
    public AirPort getAirportByName(@RequestParam String name) {
        return airPortService.findAirPortByName(name);
    }

    @PostMapping("/airport")
    public AirPort createCourse(@RequestBody AirPort newAirPort) {
        return airPortService.createAirPort(newAirPort);
    }

    @PutMapping("/airport/{id}")
    public ResponseEntity<AirPort> updateAirPort(@PathVariable long id, @RequestBody AirPort airPort) {
        return ResponseEntity.ok(airPortService.updateAirPort(id, airPort));
    }

    @DeleteMapping("/airport/{id}")
    public void deleteAirById(@PathVariable long id) {
        airPortService.deleteAirPortById(id);
    }
}
