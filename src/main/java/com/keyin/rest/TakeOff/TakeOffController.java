package com.keyin.rest.TakeOff;

import com.keyin.rest.Landing.Landing;
import com.keyin.rest.Landing.LandingService;
import com.keyin.rest.Passenger.Passenger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class TakeOffController {
    @Autowired
    private TakeOffService takeOffService;

    @GetMapping("/takeoff")
    public List<TakeOff> getAllTakeOffs(){
        return takeOffService.getAllTakeOff();
    }

    @GetMapping("/takeoff/airport/{airportName}")
    public List<TakeOff> getTakeOffByID(@PathVariable String airportName) {
        return takeOffService.getTakeOffByAirport(airportName);
    }

    @GetMapping("/takeoff/{id}")
    public TakeOff getTakeOffByID(@PathVariable long id) {
        return takeOffService.getTakeOffById(id);
    }

    @PostMapping("/takeoff")
    public TakeOff createTakeOff(@RequestBody TakeOff newTakeOff) {
        return takeOffService.createTakeOff(newTakeOff);
    }

    @PutMapping("/takeoff/{id}")
    public ResponseEntity<TakeOff> updateTakeOff(@PathVariable long id, @RequestBody TakeOff takeOff) {
        return ResponseEntity.ok(takeOffService.update(id, takeOff));
    }

    @DeleteMapping("/takeoff/{id}")
    public void deleteTakeOffById(@PathVariable long id) {
        takeOffService.deleteTakeOffById(id);
    }
}
