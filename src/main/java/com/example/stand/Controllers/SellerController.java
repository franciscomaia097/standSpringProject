package com.example.stand.Controllers;


import com.example.stand.Models.Seller;
import com.example.stand.Services.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<Seller>> getAllSellers() {
        List<Seller> sellers = sellerService.getAllSellers();
        for (Seller seller : sellers) {
            Long id = seller.getId();
            seller.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(SellerController.class).getSellerById(id)).withSelfRel());
            seller.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(SellerController.class).updateSeller(id, seller)).withRel("update"));
            seller.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(SellerController.class).deleteSeller(id)).withRel("delete"));
        }
        return new ResponseEntity<>(sellers, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getSellerById(@PathVariable Long id) {
        try {
            Seller seller = sellerService.getSellerById(id);
            if (seller == null) {
                return new ResponseEntity<>("Seller does not exist", HttpStatus.BAD_REQUEST);
            }
            seller.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(SellerController.class).getSellerById(id)).withSelfRel());
            seller.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(SellerController.class).updateSeller(id, seller)).withRel("update"));
            seller.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(SellerController.class).deleteSeller(id)).withRel("delete"));
            return new ResponseEntity<>(seller, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("An error occurred while processing your request", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

   @PutMapping("/update/{id}")
    public Seller updateSeller(@PathVariable Long id, @RequestBody Seller seller) {
        seller.setId(id);
        return sellerService.updateSeller(seller);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteSeller(@PathVariable Long id) {
        try {
            sellerService.deleteSeller(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("An error occurred while processing your request", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
