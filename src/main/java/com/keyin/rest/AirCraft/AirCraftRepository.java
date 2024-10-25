package com.keyin.rest.AirCraft;

import com.keyin.rest.Airport.AirPort;
import com.keyin.rest.City.City;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AirCraftRepository extends CrudRepository<AirCraft, Long>{
    public Optional<AirCraft> findByType(String type);
}
