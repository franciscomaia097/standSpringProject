package com.example.stand.Repositories;

import com.example.stand.Models.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepository  extends JpaRepository<Brand, Long> {
}
