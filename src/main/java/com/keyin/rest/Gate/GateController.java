package com.keyin.rest.Gate;

import com.keyin.rest.Airport.AirPort;
import com.keyin.rest.City.City;
import com.keyin.rest.City.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class GateController {
    @Autowired
    private GateService gateService;

    @GetMapping("/gate/{id}")
    public Gate getGateById(@PathVariable long id) {
        return gateService.getGateById(id);
    }

    @GetMapping("/searchGateByGateName")
    public Gate getGateByGateName(@RequestParam String gateName) {
        return gateService.findGateByGateName(gateName);
    }


    @PostMapping("/gate")
    public Gate createGate(@RequestBody Gate gate) {
        return gateService.createGate(gate);
    }
}
