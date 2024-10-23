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

        return airCraftService.getAllAirCraft();
    }

    @GetMapping("/aircraft/{id}")
    public AirCraft getAirCraftByID(@PathVariable long id) {

        return airCraftService.findAirCraftById(id);
    }

    @PostMapping("/aircraft")
    public AirCraft createAirCraft(@RequestBody AirCraft newAirCraft) {
        return airCraftService.createAirCraft(newAirCraft);
    }

    @PutMapping("/aircraft/{id}")
    public ResponseEntity<AirCraft> updateAirCraft(@PathVariable long id, @RequestBody AirCraft airCraft) {
        return ResponseEntity.ok(airCraftService.updateAirCraft(id, airCraft));
    }

    @DeleteMapping("/aircraft/{id}")
    public void deleteAirCraftById(@PathVariable long id) {
        airCraftService.deleteCraftById(id);
    }
}
