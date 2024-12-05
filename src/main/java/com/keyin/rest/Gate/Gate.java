package com.keyin.rest.Gate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Gate {
    @Id
    @SequenceGenerator(name = "gate_sequence", sequenceName = "gate_sequence", allocationSize = 1, initialValue = 1)
    @GeneratedValue(generator = "gate_sequence")
    private int id;
    private String gateName;

    public Gate() {

    }

    public Gate(int id, String gateName) {
        this.id = id;
        this.gateName = gateName;
    }

    public String getGateName() {
        return gateName;
    }

    public void setGateName(String gateName) {
        this.gateName = gateName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
