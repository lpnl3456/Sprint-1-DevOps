package com.keyin.rest.AirCraft;

import com.keyin.rest.Airport.AirPort;

import com.keyin.rest.City.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AirCraftService {
    @Autowired
    private AirCraftRepository airCraftRepository;

    @Autowired
    private CityService cityService;

    public List<AirCraft> getAllAirCraft() {
        return (List<AirCraft>) airCraftRepository.findAll();
    }

    public AirCraft findAirCraftById(long id) {
        Optional<AirCraft> airCraftOptional = airCraftRepository.findById(id);

        return airCraftOptional.orElse(null);
    }

    public AirCraft findAirCraftByType(String type) {
        Optional<AirCraft> airCraftOptional = airCraftRepository.findByType(type);

        return airCraftOptional.orElse(null);
    }

    public AirCraft createAirCraft(AirCraft newAirCraft) {
        return airCraftRepository.save(newAirCraft);
    }

    public AirCraft updateAirCraft(long id, AirCraft updatedAirCraft) {
        Optional<AirCraft> airCraftToUpdateOptional = airCraftRepository.findById(id);

        if (airCraftToUpdateOptional.isPresent()) {
            System.out.println("Enter");
            AirCraft airCraftToUpdate = airCraftToUpdateOptional.get();

            airCraftToUpdate.setType(updatedAirCraft.getType());
            airCraftToUpdate.setAirlineName(updatedAirCraft.getAirlineName());
            airCraftToUpdate.setNumberOfPass(updatedAirCraft.getNumberOfPass());

            return airCraftRepository.save(airCraftToUpdate);
        }
        return null;
    }

    public void deleteCraftById(long id) {
        airCraftRepository.deleteById(id);
    }


}
