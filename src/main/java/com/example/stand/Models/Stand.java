package com.example.stand.Models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class Stand {
    @Id
    private long id;
    private String name;
    private String email;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Car> cars;

    private static Stand instance;

    private Stand(String name, String email) {
        this.id = 0;
        this.name = name;
        this.email = email;
    }

    public static Stand getInstance(String name, String email) {
        if (instance == null) {
            instance = new Stand(name, email);
        }
        return instance;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}