package com.keyin.rest.City;

import org.springframework.data.repository.CrudRepository;

public interface CityRepository extends CrudRepository<City, Long> {
    public City findByName(String name);
}
