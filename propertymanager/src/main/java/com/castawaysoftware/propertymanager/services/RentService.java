package com.castawaysoftware.propertymanager.services;
import com.castawaysoftware.propertymanager.data.Rent;
import java.util.ArrayList;
import org.hibernate.mapping.Array;
import java.time.LocalDate;
import java.util.List;
import java.time.temporal.*;
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

    public List<Rent> generateRentListForNewLease(Long unitId, LocalDate startDate, LocalDate endDate,  int rentAmount, int depositAmount) {
       List<Rent> rentList = new ArrayList<>(); 
               long numberOfMonths = ChronoUnit.MONTHS.between(startDate, endDate);
        
        for (long i = 0 ; i < numberOfMonths; i++) {
            Rent newRent = new Rent(unitId, startDate.plusMonths(i), null, false, false, rentAmount);
            rentList.add(RENT_REPOSITORY.save(newRent));

        }
        
        return rentList;
    }

}
