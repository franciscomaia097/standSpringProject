package com.example.stand.Controllers;


import com.example.stand.Models.Seller;
import com.example.stand.Services.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/seller")
public class SellerController {

    private final SellerService sellerService;

    @Autowired
    public SellerController(SellerService sellerService) {
        this.sellerService = sellerService;
    }

    @PostMapping("/create")
    public Seller createSeller(@RequestBody Seller seller) {
        return sellerService.createSeller(seller);
    }

    @GetMapping("/all")
    public List<Seller> getAllSellers() {
        return sellerService.getAllSellers();
    }
}
