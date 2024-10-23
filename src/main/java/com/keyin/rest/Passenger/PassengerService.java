package com.keyin.rest.Passenger;

import com.keyin.rest.City.City;
import com.keyin.rest.City.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PassengerService {
        @Autowired
        private PassengerRepository passengerRepository;
        @Autowired
        private CityService cityService;

    public Passenger findByName(String name) {
            return passengerRepository.findByName(name);
        }

        public List<Passenger> getAllPassengers() {
            return (List<Passenger>) passengerRepository.findAll();
        }

        public Passenger getPassengerById(long id) {
            Optional<Passenger> passengerOptional = passengerRepository.findById(id);

            return passengerOptional.orElse(null);
        }

        public void deletePassengerById(long id) {
            passengerRepository.deleteById(id);
        }

    public Passenger createPassenger(Passenger newPassenger) {
        String cityName = newPassenger.getCity_id().getName();

        if(cityName != null){
            City city = cityService.findByName(cityName);


            if(city == null){
                city = cityService.createCity(newPassenger.getCity_id());
            }

            newPassenger.setCity_id(city);
        }

        return passengerRepository.save(newPassenger);
    }

    public Passenger updatePassenger(long id, Passenger updatedPassenger) {
        Optional<Passenger> passengerToUpdateOptional = passengerRepository.findById(id);

        if (passengerToUpdateOptional.isPresent()) {
            System.out.println("Enter");
            Passenger passengerToUpdate = passengerToUpdateOptional.get();

            passengerToUpdate.setFirstName(updatedPassenger.getFirstName());
            passengerToUpdate.setLastName(updatedPassenger.getLastName());
            passengerToUpdate.setPhoneNumber(updatedPassenger.getPhoneNumber());
            passengerToUpdate.setCity_id(updatedPassenger.getCity_id());

            return passengerRepository.save(passengerToUpdate);
        }
        return null;
    }

}
