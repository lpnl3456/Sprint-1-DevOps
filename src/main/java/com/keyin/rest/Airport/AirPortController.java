package com.keyin.rest.Airport;

import com.keyin.rest.Gate.Gate;
import com.keyin.rest.Gate.GateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
public class AirPortController {
    @Autowired
    private AirPortService airPortService;
    @Autowired
    private GateService gateService;


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
    public AirPort createAirport(@RequestBody AirPort newAirPort) {
        List<Gate> updatedGateList = new ArrayList<Gate>();
        for (Gate gate : newAirPort.getGates()) {
            Optional<Gate> gateOptional = Optional.ofNullable(gateService.findGateByGateName(gate.getGateName()));
            if (gateOptional.isPresent()) {
                gate = gateOptional.get();
                updatedGateList.add(gate);
            } else {

                updatedGateList = newAirPort.getGates();
                gateService.createGate(gate);
            }

        }
        newAirPort.setGates(updatedGateList);
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
