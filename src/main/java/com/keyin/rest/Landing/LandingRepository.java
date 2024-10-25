package com.keyin.rest.Landing;


import com.keyin.rest.City.City;
import com.keyin.rest.Passenger.Passenger;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LandingRepository extends CrudRepository<Landing, Long> {

}
