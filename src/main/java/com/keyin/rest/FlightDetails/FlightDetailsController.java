package com.keyin.rest.FlightDetails;

import com.keyin.rest.Landing.Landing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class FlightDetailsController {
    @Autowired
    private FlightDetailsService flightDetailService;

    @GetMapping("/flight_details")
    public List<FlightDetails> getAllFlights(){
        return flightDetailService.getAllFlights();
    }

    @GetMapping("/flight_details/{id}")
    public FlightDetails getFlightDetailsByID(@PathVariable long id) {
        return flightDetailService.getFlightById(id);
    }

    @PostMapping("/flight_details")
    public FlightDetails createFlightDetails(@RequestBody FlightDetails newFlight) {
        return flightDetailService.createFlight(newFlight);
    }

    @PutMapping("/flight_details/{id}")
    public ResponseEntity<FlightDetails> updateFlight(@PathVariable long id, @RequestBody FlightDetails flight) {
        return ResponseEntity.ok(flightDetailService.update(id, flight));
    }

    @DeleteMapping("/flight_details/{id}")
    public void deleteFlightById(@PathVariable long id) {
        flightDetailService.deleteFlightById(id);
    }
}
