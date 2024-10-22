package com.keyin.rest.AirCraft;

import com.keyin.rest.Airport.AirPort;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

@Entity
public class AirCraft {
    @Id
    @SequenceGenerator(name = "airCraft_sequence", sequenceName = "airCraft_sequence", allocationSize = 1, initialValue = 1)
    @GeneratedValue(generator = "airCraft_sequence")
    private int airCraft_id;
    private String type;
    private String airlineName;
    private int numberOfPass;

    public AirCraft() {
    }

    public AirCraft(int airCraft_id) {
        this.airCraft_id = airCraft_id;
    }

    public AirCraft(int airCraft_id, String type, String airlineName, int numberOfPass) {
        this.airCraft_id = airCraft_id;
        this.type = type;
        this.airlineName = airlineName;
        this.numberOfPass = numberOfPass;
    }

    public int getAirCraft_id() {
        return airCraft_id;
    }

    public void setAirCraft_id(int airCraft_id) {
        this.airCraft_id = airCraft_id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAirlineName() {
        return airlineName;
    }

    public void setAirlineName(String airlineName) {
        this.airlineName = airlineName;
    }

    public int getNumberOfPass() {
        return numberOfPass;
    }

    public void setNumberOfPass(int numberOfPass) {
        this.numberOfPass = numberOfPass;
    }
}
