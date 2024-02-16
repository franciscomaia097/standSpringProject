package com.example.stand.Services;

import com.example.stand.Models.Car;
import com.example.stand.Models.Seller;
import com.example.stand.Repositories.CarRepository;
import com.example.stand.Repositories.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {

    private final SellerRepository sellerRepository;
    private final CarRepository carRepository;

    @Autowired
    public CarService(CarRepository carRepository, SellerRepository sellerRepository) {
        this.carRepository = carRepository;
        this.sellerRepository = sellerRepository;
    }

    public Car addCar(Car car, Seller seller) {
        if (sellerRepository.existsById(seller.getId())) {
            car.setSeller(seller);
            return carRepository.save(car);
        } else {
            throw new IllegalArgumentException("Seller does not exist");
        }
    }

    public List<Car> getAllCars() {
        return carRepository.findAll();
    }
}
