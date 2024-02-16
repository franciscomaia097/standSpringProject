package com.example.stand.Services;

import com.example.stand.Models.Car;
import com.example.stand.Models.Seller;
import com.example.stand.Models.Stand;
import com.example.stand.Repositories.CarRepository;
import com.example.stand.Repositories.SellerRepository;
import com.example.stand.Repositories.StandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {

    private final SellerRepository sellerRepository;
    private final CarRepository carRepository;
    private final StandRepository standRepository;

    @Autowired
    public CarService(CarRepository carRepository, SellerRepository sellerRepository
    ,StandRepository standRepository) {
        this.carRepository = carRepository;
        this.sellerRepository = sellerRepository;
        this.standRepository = standRepository;
    }

    public Car addCar(Car car, Seller seller, Stand stand) {
        if (sellerRepository.existsById(seller.getId()) && standRepository.existsById(stand.getId())) {
            car.setSeller(seller);
            car.setStand(stand);
            return carRepository.save(car);
        } else {
            throw new IllegalArgumentException("Seller or Stand does not exist");
        }
    }

    public List<Car> getAllCars() {
        return carRepository.findAll();
    }
}
