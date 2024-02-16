package com.example.stand.Controllers;

import com.example.stand.Models.Stand;
import com.example.stand.Services.StandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}