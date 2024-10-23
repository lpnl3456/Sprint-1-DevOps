package com.keyin.rest.AirCraft;

import com.keyin.rest.Airport.AirPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class AirCraftController {
    @Autowired
    private AirCraftService airCraftService;

    @GetMapping("/aircraft")
    public List<AirCraft> getAllAirPorts(){
        return airCraftService.getAllAirports();
    }

    @GetMapping("/aircraft/{id}")
    public AirPort getCourseByID(@PathVariable long id) {
        return airCraftService.findAirPortById(id);
    }

    @PostMapping("/airport")
    public AirPort createCourse(@RequestBody AirPort newAirPort) {
        return airCraftService.createAirPort(newAirPort);
    }

    @PutMapping("/airport/{id}")
    public ResponseEntity<AirPort> updateAirPort(@PathVariable long id, @RequestBody AirPort airPort) {
        return ResponseEntity.ok(airCraftService.updateAirPort(id, airPort));
    }

    @DeleteMapping("/airport/{id}")
    public void deleteAirById(@PathVariable long id) {
        airCraftService.deleteAirPortById(id);
    }
}
