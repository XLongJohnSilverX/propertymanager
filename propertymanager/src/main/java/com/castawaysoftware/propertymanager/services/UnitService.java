package com.castawaysoftware.propertymanager.services;

import com.castawaysoftware.propertymanager.data.Unit;
import com.castawaysoftware.propertymanager.repositories.UnitRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * The Unit Service is the middle man between the Controller and the Repository
 * It Validates data and preforms the changed to the data and sends to repository to save
 */
@Service
public class UnitService {
    /**
     * Calls the unit repository to make changes to database
     */
    private final UnitRepository UNIT_REPOSITORY;

    public UnitService(UnitRepository unitRepository) {
        UNIT_REPOSITORY = unitRepository;
    }

    /**
     * Calls Repository to get all Units in Database
     * @return List of all units in database
     */
    public List<Unit> getAllUnits(){
        return UNIT_REPOSITORY.findAll();

    }

    /**
     * Sends request to repository to return a Unit Object that matches in passed Id
     * @param id Id of unit to be grabbed
     * @return Unit Object of requested ID
     */
    public Unit getUnitById(Long id){
        return UNIT_REPOSITORY.findById(id).get();
    }

    /**
     * Sends unit to be added to the repository to be saved in Database
     * @param unitToBeAdded new unit to be saved
     * @return Returns saved unit
     */
    public Unit addNewUnit(Unit unitToBeAdded) {
        if (UNIT_REPOSITORY.existsByUnitIdentifier(unitToBeAdded.getUnitIdentifier())) {
            return null;
        } else {
            UNIT_REPOSITORY.save(unitToBeAdded);
            return unitToBeAdded;

        }
    }

    /**
     * Takes unit object with changed fields and compares them to values currently in the database
     * If the updatedUnit has a different value than the old it updated it
     * @param updatedUnit Unit object with changed fields
     * @return updatedUnit
     */

    public Unit updateUnit(Unit updatedUnit){
       Unit oldUnit = UNIT_REPOSITORY.findById(updatedUnit.getId()).get();
        if (oldUnit.getUnitIdentifier() != updatedUnit.getUnitIdentifier()){
            oldUnit.setUnitIdentifier(updatedUnit.getUnitIdentifier());
        }
        if (oldUnit.getPetList() != updatedUnit.getPetList()){
            oldUnit.setPetList(updatedUnit.getPetList());
        }
        if (oldUnit.isVacant() != updatedUnit.isVacant()){
            oldUnit.setVacant(updatedUnit.isVacant());
        }
        if (oldUnit.getTenantList() != updatedUnit.getTenantList()){
            oldUnit.setTenantList(updatedUnit.getTenantList());
        }
        if (oldUnit.isAllowsPets() != updatedUnit.isAllowsPets()){
            oldUnit.setAllowsPets(updatedUnit.isAllowsPets());
        }
        if (oldUnit.getNumberOfBeds() != updatedUnit.getNumberOfBeds()){
            oldUnit.setNumberOfBeds(updatedUnit.getNumberOfBeds());
        }
        if (oldUnit.getNumberOfBaths() != updatedUnit.getNumberOfBaths()){
            oldUnit.setNumberOfBaths(updatedUnit.getNumberOfBaths());
        }
        if (oldUnit.getSquareFeet() != updatedUnit.getSquareFeet()){
            oldUnit.setSquareFeet(updatedUnit.getSquareFeet());
        }
        if (oldUnit.getAmenities() != updatedUnit.getAmenities()){
            oldUnit.setAmenities(updatedUnit.getAmenities());
        }
        if (oldUnit.getMonthlyRent() != updatedUnit.getMonthlyRent()){
            oldUnit.setMonthlyRent(updatedUnit.getMonthlyRent());
        }
        if (oldUnit.getApplicationFee() != updatedUnit.getApplicationFee()){
            oldUnit.setApplicationFee(updatedUnit.getApplicationFee());
        }
        if (oldUnit.getSecurityDeposit() != updatedUnit.getSecurityDeposit()){
            oldUnit.setSecurityDeposit(updatedUnit.getSecurityDeposit());
        }
        if (oldUnit.getUnitDescription() != updatedUnit.getUnitDescription()){
            oldUnit.setUnitDescription(updatedUnit.getUnitDescription());
        }


        return UNIT_REPOSITORY.save(UNIT_REPOSITORY.findById(updatedUnit.getId()).get());
    }

    /**
     * Deletes unit from database
     * @param id Id of Unit to be deleted
     */
    public void deleteUnitById(Long id){
        UNIT_REPOSITORY.deleteById(id);
    }

}



