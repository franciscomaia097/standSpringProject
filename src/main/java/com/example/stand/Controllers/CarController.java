package com.example.stand.Controllers;

import com.example.stand.Models.Car;
import com.example.stand.Models.Stand;
import com.example.stand.Repositories.SellerRepository;
import com.example.stand.Repositories.StandRepository;
import com.example.stand.Services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/car")
public class CarController {

    private final CarService carService;
    private final SellerRepository sellerRepository;
    private final StandRepository standRepository;

    @Autowired
    public CarController(CarService carService, SellerRepository sellerRepository, StandRepository standRepository) {
        this.carService = carService;
        this.sellerRepository = sellerRepository;
        this.standRepository = standRepository;
    }

    @PostMapping("/add")
    public ResponseEntity<?> addCar(@RequestBody Car car) {
        try {
            if (car.getSeller() == null || car.getStand() == null) {
                return new ResponseEntity<>("Seller or Stand is null", HttpStatus.BAD_REQUEST);
            }
            if (!sellerRepository.existsById(car.getSeller().getId())) {
                return new ResponseEntity<>("Seller does not exist", HttpStatus.BAD_REQUEST);
            }
            if (!standRepository.existsById(car.getStand().getId())) {
                return new ResponseEntity<>("Stand does not exist", HttpStatus.BAD_REQUEST);
            }
            Car savedCar = carService.addCar(car, car.getSeller(), car.getStand());
            return new ResponseEntity<>(savedCar, HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>("An error occurred while processing your request", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping("/all")
    public ResponseEntity<List<Car>> getAllCars() {
        List<Car> cars = carService.getAllCars();
        return new ResponseEntity<>(cars, HttpStatus.OK);
    }
}
