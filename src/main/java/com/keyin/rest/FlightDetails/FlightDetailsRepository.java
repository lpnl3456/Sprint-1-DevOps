package com.keyin.rest.FlightDetails;


import com.keyin.rest.Landing.Landing;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightDetailsRepository extends CrudRepository<FlightDetails, Long> {

}
