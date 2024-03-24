package com.castawaysoftware.propertymanager.services;
import com.castawaysoftware.propertymanager.data.Rent;
import java.util.List;

import com.castawaysoftware.propertymanager.repositories.RentRepository;
import org.springframework.stereotype.Service;

@Service
public class RentService {
    
    private final RentRepository RENT_REPOSITORY;

    public RentService(RentRepository rentRepository) {
        RENT_REPOSITORY = rentRepository;
    }

    public List<Rent> getAllRents() {
        return RENT_REPOSITORY.findAll();
    }

    public Rent getRentById(long id) {
        return RENT_REPOSITORY.findById(id).get();
    }
    public Long addNewRent(Rent newRent) {
        RENT_REPOSITORY.save(newRent);
        return newRent.getId();
    }
    public void deleteRentById(long id) {
        RENT_REPOSITORY.deleteById(id);
    }
    public Rent updateRent(Rent updatedRent) {
       return RENT_REPOSITORY.save(updatedRent);
    }
    public List<Rent> getRentsByUnitId(Long id) {
        return RENT_REPOSITORY.getRentsByUnitId(id);
    }

}
