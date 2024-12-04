package com.keyin.rest.Gate;

import com.keyin.rest.Airport.AirPort;
import com.keyin.rest.City.City;
import com.keyin.rest.City.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GateService {
    @Autowired
    private GateRepository gateRepository;
    public Gate createGate(Gate newGate) {
        return gateRepository.save(newGate);
    }

    public Gate getGateById(long id) {
        Optional<Gate> gateOptional = gateRepository.findById(id);

        return gateOptional.orElse(null);
    }

    public Gate findGateByGateName(String gateName) {
        Gate gateOptional = gateRepository.findByGateName(gateName);

        return gateOptional;
    }

}
