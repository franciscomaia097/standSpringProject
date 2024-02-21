package com.example.stand.Repositories;

import com.example.stand.Enums.CarStatus;
import com.example.stand.Models.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Long> {
    List<Car> findByStatus(CarStatus status);
    Page<Car> findAll(Pageable pageable);
}