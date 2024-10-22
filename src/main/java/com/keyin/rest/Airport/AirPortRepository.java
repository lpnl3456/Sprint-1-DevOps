package com.keyin.rest.Airport;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirPortRepository extends CrudRepository<AirPort, Long>{
}
