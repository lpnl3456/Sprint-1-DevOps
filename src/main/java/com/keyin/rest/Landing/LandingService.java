package com.keyin.rest.Landing;

import com.keyin.rest.Airport.AirPortRepository;
import com.keyin.rest.Airport.AirPortService;
import com.keyin.rest.City.City;
import com.keyin.rest.City.CityService;
import com.keyin.rest.Passenger.Passenger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LandingService {
        @Autowired
        private LandingRepository landingRepository;

    @Autowired
    private AirPortService airPortService;



        public List<Landing> getAllLanding() {
            return (List<Landing>) landingRepository.findAll();
        }

        public Landing getLandingById(long id) {
            Optional<Landing> landingOptional = landingRepository.findById(id);

            return landingOptional.orElse(null);
        }


        public void deleteLandingById(long id) {
            landingRepository.deleteById(id);
        }

    public Landing createLanding(Landing newLanding) {



        return landingRepository.save(newLanding);
    }

    public Landing update(long id, Landing updatedLanding) {
        Optional<Landing> landingToUpdateOptional =landingRepository.findById(id);

        if (landingToUpdateOptional.isPresent()) {
            System.out.println("Enter");
            Landing landingToUpdate = landingToUpdateOptional.get();

            landingToUpdate.setLandingLocation(updatedLanding.getLandingLocation());
//            landingToUpdate.setLandingTime(updatedLanding.getLandingTime());


            return landingRepository.save(landingToUpdate);
        }
        return null;
    }

}
