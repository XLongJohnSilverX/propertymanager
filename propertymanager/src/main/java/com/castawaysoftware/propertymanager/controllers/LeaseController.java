package com.castawaysoftware.propertymanager.controllers;
import com.castawaysoftware.propertymanager.data.Lease;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import com.castawaysoftware.propertymanager.services.LeaseService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
public class LeaseController {
    private final LeaseService LEASE_SERVICE;

    public LeaseController(LeaseService leaseService) {
        LEASE_SERVICE = leaseService;
    }

    @CrossOrigin
    @GetMapping("/lease/")
    public List<Lease> getAllLeases() {
        return LEASE_SERVICE.getAllLeases();
    }

    @CrossOrigin
    @GetMapping("/lease/{id}/")
    public Lease getLeaseById(@PathVariable Long id) {
        return LEASE_SERVICE.getLeaseById(id);
    }
    @PostMapping("/lease/")
    public Lease createLease(@RequestBody Lease entity) {
       
        
        return LEASE_SERVICE.createLease(entity);
    }
    @PutMapping("/lease/{id}/")
    public Lease updatLease(@PathVariable Long id, @RequestBody Lease entity) {
        //TODO: process PUT request
        
        return LEASE_SERVICE.updateLease(entity);
    }
    
}
