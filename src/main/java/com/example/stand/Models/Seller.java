package com.example.stand.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Seller {
    @Id
    private long id;
    private String name;

}
