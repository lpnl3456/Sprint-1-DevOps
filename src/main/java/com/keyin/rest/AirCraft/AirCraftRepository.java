package com.keyin.rest.AirCraft;

import com.keyin.rest.Airport.AirPort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirCraftRepository extends CrudRepository<AirCraft, Long>{
}
