package com.keyin.rest.Landing;

import com.keyin.rest.AirCraft.AirCraft;
import com.keyin.rest.Airport.AirPort;
import com.keyin.rest.City.City;
import com.keyin.rest.Gate.Gate;
import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Landing {
    @Id
    @SequenceGenerator(name = "landing_sequence", sequenceName = "landing_sequence", allocationSize = 1, initialValue = 1)
    @GeneratedValue(generator = "landing_sequence")
    private long landing_id;

    @ManyToOne
    AirPort landingLocation;
    Date landingTime;
    @ManyToOne
    AirCraft aircraft;

    @ManyToOne
    Gate gate;


    public Landing(long landing_id, AirPort landingLocation, Date landingTime, AirCraft aircraft, Gate gate) {
        this.landing_id = landing_id;
        this.landingLocation = landingLocation;
        this.landingTime = landingTime;
        this.aircraft = aircraft;
        this.gate = gate;
    }

    public long getLanding_id() {
        return landing_id;
    }

    public void setLanding_id(long landing_id) {
        this.landing_id = landing_id;
    }

    public AirPort getLandingLocation() {
        return landingLocation;
    }

    public void setLandingLocation(AirPort landingLocation) {
        this.landingLocation = landingLocation;
    }


    public AirCraft getAircraft() {
        return aircraft;
    }

    public void setAircraft(AirCraft aircraft) {
        this.aircraft = aircraft;
    }

   public Date getLandingTime() {
        return landingTime;
    }

    public void setLandingTime(Date landingTime) {
        this.landingTime = landingTime;
    }

    public Gate getGate() {
        return gate;
    }

    public void setGate(Gate gate) {
        this.gate = gate;
    }




}
