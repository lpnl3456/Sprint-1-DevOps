package com.keyin.rest.TakeOff;


import com.keyin.rest.Landing.Landing;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TakeOffRepository extends CrudRepository<TakeOff, Long> {

}
