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
        // Check if a stand already exists in the database
        Stand existingStand = standRepository.findAll().stream().findFirst().orElse(null);

        if (existingStand != null) {
            // Update the existing stand's properties if necessary
            existingStand.setName(name);
            existingStand.setEmail(email);
            return standRepository.save(existingStand);
        } else {
            // Create a new stand if none exists
            Stand newStand = new Stand(name, email);
            return standRepository.save(newStand);
        }
    }


    public Stand getStand() {
        Stand stand = standRepository.findAll().stream().findFirst().orElse(null);

        if (stand == null) {
            // If no stand exists, create a new one
            stand = new Stand("Default Stand", "default@email.com");
            stand = standRepository.save(stand);
        }

        return stand;
    }

}