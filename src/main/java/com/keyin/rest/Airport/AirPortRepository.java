package com.keyin.rest.Airport;

import com.keyin.rest.City.City;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AirPortRepository extends CrudRepository<AirPort, Long>{
    public List<AirPort> findByCity(City city);
    public AirPort findByName(String name);
}
