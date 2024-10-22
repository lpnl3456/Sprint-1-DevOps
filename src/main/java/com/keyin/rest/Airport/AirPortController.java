package com.keyin.rest.Airport;

import org.springframework.beans.factory.annotation.Autowired;
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

    @PostMapping("/course")
    public AirPort createCourse(@RequestBody AirPort newAirPort) {
        return airPortService.createAirPort(newAirPort);
    }
}
