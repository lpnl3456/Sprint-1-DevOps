package com.keyin.rest.Landing;

import com.keyin.rest.Passenger.Passenger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class LandingController {
    @Autowired
    private LandingService landingService;

    @GetMapping("/landing")
    public List<Landing> getAllPassengers(){
        return landingService.getAllLanding();
    }

    @GetMapping("/landing/{id}")
    public Landing getLandingByID(@PathVariable long id) {
        return landingService.getLandingById(id);
    }

    @GetMapping("/searchLandingByAirport")
    public List<Landing> getLandingByAirportName(@RequestParam String airportName) {
        return landingService.getLandingByAirport(airportName);
    }

    @PostMapping("/landing")
    public Landing createPassenger(@RequestBody Landing newLanding) {
        return landingService.createLanding(newLanding);
    }

    @PutMapping("/landing/{id}")
    public ResponseEntity<Landing> updateLanding(@PathVariable long id, @RequestBody Landing landing) {
        return ResponseEntity.ok(landingService.update(id, landing));
    }

    @DeleteMapping("/landing/{id}")
    public void deleteLandingById(@PathVariable long id) {
        ;landingService.deleteLandingById(id);
    }
}
