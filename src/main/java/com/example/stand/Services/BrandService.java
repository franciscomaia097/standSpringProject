package com.example.stand.Services;

import com.example.stand.Models.Brand;
import com.example.stand.Repositories.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BrandService {

    private final BrandRepository  brandRepository;

    @Autowired
    public BrandService(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    public Brand createBrand(Brand brand) {
        if (brandRepository.existsById(brand.getId())) {
            throw new IllegalArgumentException("Brand already exists");
        }
        return brandRepository.save(brand);
    }

    public Brand getBrandById(Long id) {
        return brandRepository.findById(id).orElse(null);
    }

    public Brand updateBrand(Brand brand) {
        if (!brandRepository.existsById(brand.getId())) {
            throw new IllegalArgumentException("Brand does not exist");
        }
        return brandRepository.save(brand);
    }

    public void deleteBrand(Long id) {
        if (!brandRepository.existsById(id)) {
            throw new IllegalArgumentException("Brand does not exist");
        }
        brandRepository.deleteById(id);
    }

    public Iterable<Brand> getAllBrands() {
        return brandRepository.findAll();
    }
}
