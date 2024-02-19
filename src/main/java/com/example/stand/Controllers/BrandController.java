package com.example.stand.Controllers;

import com.example.stand.Models.Brand;
import com.example.stand.Services.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/brand")
public class BrandController {

    private final BrandService brandService;

    @Autowired
    public BrandController(BrandService brandService) {
        this.brandService = brandService;
    }

    @PostMapping("/create")
    public Brand createBrand(@RequestBody Brand brand) {
        return brandService.createBrand(brand);
    }

    @PostMapping("/update/{id}")
    public Brand updateBrand(@RequestBody Brand brand) {
        return brandService.updateBrand(brand);
    }

    @PostMapping("/delete/{id}")
    public void deleteBrand(@RequestBody Long id) {
        brandService.deleteBrand(id);
    }

    @GetMapping("/{id}")
    public Brand getBrandById(@PathVariable Long id) {
        return brandService.getBrandById(id);
    }

    @GetMapping("/all")
    public Iterable<Brand> getAllBrands() {
        return brandService.getAllBrands();
    }
}
