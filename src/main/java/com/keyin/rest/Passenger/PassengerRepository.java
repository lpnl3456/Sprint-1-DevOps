package com.keyin.rest.Passenger;


import com.keyin.rest.City.City;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PassengerRepository extends CrudRepository<Passenger, Long> {
    public Passenger findByFirstName(String firstName);

    public List<Passenger> findByCity(City city);
}
