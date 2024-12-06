package com.keyin.rest.FlightDetails;

import com.keyin.rest.AirCraft.AirCraft;
import com.keyin.rest.AirCraft.AirCraftService;
import com.keyin.rest.Landing.LandingService;
import com.keyin.rest.Passenger.Passenger;
import com.keyin.rest.TakeOff.TakeOffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FlightDetailsService {
    @Autowired
    private FlightDetailsRepository flightDetailsRepository;

    @Autowired
    private AirCraftService airCraftService;
    @Autowired
    private TakeOffService takeOffService;
    @Autowired
    private LandingService landingService;



    public List<FlightDetails> getAllFlights() {
        return (List<FlightDetails>) flightDetailsRepository.findAll();
    }

    public FlightDetails getFlightById(long id) {
        Optional<FlightDetails> flightOptional = flightDetailsRepository.findById(id);

        return flightOptional.orElse(null);
    }


    public List<FlightDetails> getFlightByAirCraft(AirCraft airCraft) {
        List<FlightDetails> flightDetails = flightDetailsRepository.findByAirCraft(airCraft);

        return flightDetails;
    }


    public List<FlightDetails> findFlightByPassenger(Passenger passenger){
        List<FlightDetails> flightOptional = flightDetailsRepository.findByPassengers(passenger);

        return flightOptional;
    }


    public void deleteFlightById(long id) {
        flightDetailsRepository.deleteById(id);
    }

    public FlightDetails createFlight(FlightDetails newFlight) {

        newFlight.setAirCraft(airCraftService.findAirCraftById(newFlight.getAirCraft().getAirCraft_id()));
        newFlight.setTakeOff(takeOffService.createTakeOff(newFlight.getTakeOff()));
        newFlight.setLanding(landingService.createLanding(newFlight.getLanding()));

        newFlight.getLanding().setAircraft(newFlight.getAirCraft());
        newFlight.getTakeOff().setAircraft(newFlight.getAirCraft());
        return flightDetailsRepository.save(newFlight);
    }

    public FlightDetails update(long id, FlightDetails updatedFlight) {
        Optional<FlightDetails> flightToUpdateOptional =flightDetailsRepository.findById(id);

        if (flightToUpdateOptional.isPresent()) {
            System.out.println("Enter");
            FlightDetails flightToUpdate = flightToUpdateOptional.get();

            flightToUpdate.setAirCraft(updatedFlight.getAirCraft());
            flightToUpdate.setPassengers(updatedFlight.getPassengers());
            flightToUpdate.setLanding(updatedFlight.getLanding());
            flightToUpdate.setTakeOff(updatedFlight.getTakeOff());


            return flightDetailsRepository.save(updatedFlight);
        }
        return null;
    }

}
