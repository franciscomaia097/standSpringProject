package com.example.stand.Models;

import com.example.stand.Enums.CarStatus;
import jakarta.persistence.*;
import org.springframework.hateoas.RepresentationModel;

@Entity
public class Car extends RepresentationModel<Car> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne
    private Seller seller;
    private String licensePlate;

    @ManyToOne
    private Brand brand;

    @ManyToOne
    private Model model;
    private String color;
    @Column(name = "car_year")
    private String year;
    private String price;
    private String description;

    @Enumerated(EnumType.STRING)
    private CarStatus status;

    public Car() {
    }

    public Car(Seller seller, String licensePlate, Brand brand, Model model, String color, String year, String price, String description, CarStatus status) {
        this.seller = seller;
        this.licensePlate = licensePlate;
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.year = year;
        this.price = price;
        this.description = description;
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public Brand getBrand() {
            return brand;
        }

        public void setBrand(Brand brand) {
            this.brand = brand;
        }


        public Model getModel() {
            return model;
        }

        public void setModel(Model model) {
            this.model = model;
        }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public CarStatus getStatus() {
        return status;
    }

    public void setStatus(CarStatus status) {
        this.status = status;
    }
}