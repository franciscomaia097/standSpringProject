package com.example.stand.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Stand {
    @Id
    private long id;
    private String name;

    private String email;


    public Stand(String name, String email) {
        this.id = 0;
        this.name = name;
        this.email = email;
    }

    public long getId() {
        return id;
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
