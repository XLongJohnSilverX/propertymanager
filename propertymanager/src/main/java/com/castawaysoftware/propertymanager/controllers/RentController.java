package com.castawaysoftware.propertymanager.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.castawaysoftware.propertymanager.repositories.RentRepository;
import com.castawaysoftware.propertymanager.services.RentService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import com.castawaysoftware.propertymanager.data.Rent;
import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.*;


@RestController
public class RentController {
    private final RentService RENT_SERVICE;
    private final RentRepository  RENT_REPOSITORY;

    public RentController(RentService rentService, RentRepository rentRepository) {
        RENT_SERVICE = rentService;
        RENT_REPOSITORY = rentRepository;
    }
    @CrossOrigin
    @GetMapping("/rent/")
     List<Rent> getAllRents() {
        return RENT_SERVICE.getAllRents();
    }
    @CrossOrigin
    @GetMapping("/rent/{id}/")
     Rent getRentById(@PathVariable Long id) {
        return RENT_SERVICE.getRentById(id);
    }
    @CrossOrigin
    @GetMapping("/rent/byunit/{id}/")
     List<Rent> getRentsByUnitId(@PathVariable Long id) {
        return RENT_SERVICE.getRentsByUnitId(id);
     }

    @CrossOrigin
    @PostMapping("/rent/")
     Long addNewRent(Rent newRent) {
        return RENT_SERVICE.addNewRent(newRent);
    }
    @PutMapping("/rent/{id}/")
     Rent updateRent(@PathVariable Long id, @RequestBody Rent updatedRent) {

        
        return RENT_SERVICE.updateRent(updatedRent);
    }
    

    
}
