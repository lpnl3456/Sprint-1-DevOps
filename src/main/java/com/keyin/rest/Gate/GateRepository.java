package com.keyin.rest.Gate;

import com.keyin.rest.Airport.AirPort;
import com.keyin.rest.City.City;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GateRepository extends CrudRepository<Gate, Long> {
    public Gate findByGateName(String gateName);
}

