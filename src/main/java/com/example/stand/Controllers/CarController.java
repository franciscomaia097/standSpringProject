package com.example.stand.Controllers;

import com.example.stand.Models.Car;
import com.example.stand.Repositories.SellerRepository;
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

    @Autowired
    public CarController(CarService carService, SellerRepository sellerRepository) {
        this.carService = carService;
        this.sellerRepository = sellerRepository;
    }

    @PostMapping("/add")
    public ResponseEntity<?> addCar(@RequestBody Car car) {
        try {
            if (car.getSeller() == null) {
                return new ResponseEntity<>("Seller is null", HttpStatus.BAD_REQUEST);
            }
            if (!sellerRepository.existsById(car.getSeller().getId())) {
                return new ResponseEntity<>("Seller does not exist", HttpStatus.BAD_REQUEST);
            }
            Car savedCar = carService.addCar(car, car.getSeller());
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

    @DeleteMapping("/remove/{id}")
    public ResponseEntity<?> removeCar(@PathVariable Long id) {
        try {
            Car removedCar = carService.removeCar(id);
            return new ResponseEntity<>(removedCar, HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>("An error occurred while processing your request", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCarById(@PathVariable Long id) {
        try {
            Car car = carService.getCarById(id);
            if (car == null) {
                return new ResponseEntity<>("Car does not exist", HttpStatus.BAD_REQUEST);
            }
            return new ResponseEntity<>(car, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("An error occurred while processing your request", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateCar(@PathVariable Long id, @RequestBody Car car) {
        try {
            if (!carService.existsById(id)) {
                return new ResponseEntity<>("Car does not exist", HttpStatus.BAD_REQUEST);
            }
            car.setId(id);
            Car updatedCar = carService.updateCar(car);
            return new ResponseEntity<>(updatedCar, HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>("An error occurred while processing your request", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}