package com.keyin.rest.Landing;

import com.keyin.rest.Airport.AirPort;
import com.keyin.rest.City.City;
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
//    Date landingTime;

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

//    public Date getLandingTime() {
//        return landingTime;
//    }
//
//    public void setLandingTime(Date landingTime) {
//        this.landingTime = landingTime;
//    }



}
