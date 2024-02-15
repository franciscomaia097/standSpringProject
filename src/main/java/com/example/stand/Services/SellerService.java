package com.example.stand.Services;

import com.example.stand.Repositories.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class SellerService {
    private final SellerRepository sellerRepository;

    @Autowired
    public SellerService(SellerRepository sellerRepository) {
        this.sellerRepository = sellerRepository;
    }
}
