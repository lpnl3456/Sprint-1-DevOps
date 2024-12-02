package com.keyin.rest.TakeOff;

import com.keyin.rest.Airport.AirPort;
import com.keyin.rest.Airport.AirPortService;
import com.keyin.rest.Landing.Landing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TakeOffService {
        @Autowired
        private TakeOffRepository takeOffRepository;

        @Autowired
        private AirPortService airPortService;



        public List<TakeOff> getAllTakeOff() {
            return (List<TakeOff>) takeOffRepository.findAll();
        }

        public TakeOff getTakeOffById(long id) {
            Optional<TakeOff> takeOffOptional = takeOffRepository.findById(id);

            return takeOffOptional.orElse(null);
        }


        public void deleteTakeOffById(long id) {
            takeOffRepository.deleteById(id);
        }

    public TakeOff createTakeOff(TakeOff newTakeOff) {


        return takeOffRepository.save(newTakeOff);
    }


    public List<TakeOff> getTakeOffByAirport(String airportName) {
        AirPort airport = airPortService.findAirPortByName(airportName);
        List<TakeOff> takeOffOptional = takeOffRepository.findByTakeOffLocation(airport);

        return takeOffOptional;
    }



    public TakeOff update(long id, TakeOff updatedTakeOff) {
        Optional<TakeOff> takeOffToUpdateOptional =takeOffRepository.findById(id);

        if (takeOffToUpdateOptional.isPresent()) {
            TakeOff takeOffToUpdate = takeOffToUpdateOptional.get();

            takeOffToUpdate.setTakeOffLocation(updatedTakeOff.getTakeOffLocation());
//            takeOffToUpdate.setTakeOffTime(updatedTakeOff.getTakeOffTime());


            return takeOffRepository.save(takeOffToUpdate);
        }
        return null;
    }

}
