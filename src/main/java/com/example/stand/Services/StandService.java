package com.example.stand.Services;

import com.example.stand.Models.Stand;
import com.example.stand.Repositories.StandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StandService {

    private final StandRepository standRepository;

    @Autowired
    public StandService(StandRepository standRepository) {
        this.standRepository = standRepository;
    }

    public Stand createStand(String name, String email) {
        Stand stand = Stand.getInstance(name, email);
        return standRepository.save(stand);
    }

    public Stand getStand(){
        return Stand.getInstance(null, null);
    }
}