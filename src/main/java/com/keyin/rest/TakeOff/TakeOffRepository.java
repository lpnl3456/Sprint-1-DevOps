package com.keyin.rest.TakeOff;


import com.keyin.rest.Airport.AirPort;
import com.keyin.rest.Landing.Landing;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface TakeOffRepository extends CrudRepository<TakeOff, Long> {
    public List<TakeOff> findByTakeOffLocation(AirPort airport);
    public TakeOff findByTakeOffLocationAndTakeOffTime(AirPort airport, Date takeOffTime);

}
