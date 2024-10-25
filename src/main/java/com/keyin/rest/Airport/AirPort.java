package com.keyin.rest.Airport;

import com.keyin.rest.City.City;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class AirPort {

    @Id
    @SequenceGenerator(name = "airport_sequence", sequenceName = "airport_sequence", allocationSize = 1, initialValue = 1)
    @GeneratedValue(generator = "airport_sequence")
    private int id;
    private String name;
    private String code;
    @ManyToOne
    private City city;

    public AirPort() {
    }

    public AirPort(String code) {
        this.code = code;
    }

    public AirPort(int id, String name, String code) {
        this.id = id;
        this.name = name;
        this.code = code;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public City getCity_id() {
        return city;
    }

    public void setCity_id(City city_id) {
        this.city = city_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AirPort airPort = (AirPort) o;
        return Objects.equals(code, airPort.code);
    }

//    @Override
//    public  int hasCode() {
//        return Objects.hash(code);
//    }
}

