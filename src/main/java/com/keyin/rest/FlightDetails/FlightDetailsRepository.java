package com.keyin.rest.FlightDetails;


import com.keyin.rest.AirCraft.AirCraft;

import com.keyin.rest.Landing.Landing;

import com.keyin.rest.Passenger.Passenger;
import com.keyin.rest.TakeOff.TakeOff;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

 @Repository

public interface FlightDetailsRepository extends CrudRepository<FlightDetails, Long> {
    public List<FlightDetails> findByAirCraft(AirCraft aircraft);
    public List<FlightDetails> findByPassengers(Passenger passenger);
     public FlightDetails findByTakeOff(TakeOff takeOff);
     public FlightDetails findByLanding(Landing landing);



}
