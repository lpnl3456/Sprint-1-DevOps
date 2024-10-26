package com.keyin.rest.AirCraftReport;

import com.keyin.rest.AirCraft.AirCraft;
import com.keyin.rest.Airport.AirPort;


import java.util.List;

public class AirCraftReport {
    private AirCraft aircraft;
    private List<AirPort> airports;

    public AirCraft getAircraft() {
        return aircraft;
    }

    public void setAircraft(AirCraft airCraft) {
        this.aircraft = airCraft;
    }

    public List<AirPort> getAirports() {
        return airports;
    }

    public void setAirports(List<AirPort> airports) {
        this.airports = airports;
    }

}
