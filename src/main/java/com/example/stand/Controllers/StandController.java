package com.example.stand.Controllers;

import com.example.stand.Models.Stand;
import com.example.stand.Services.StandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/stand")
public class StandController {

    private final StandService standService;

    @Autowired
    public StandController(StandService standService) {
        this.standService = standService;
    }

    @PostMapping("/create")
    public Stand createStand(@RequestBody Stand stand) {
        return standService.createStand(stand.getName(), stand.getEmail());
    }

    @GetMapping("/info")
    public Stand getStand(){
        return standService.getStand();
    }
}