package com.castawaysoftware.propertymanager.controllers;

import com.castawaysoftware.propertymanager.data.Unit;
import com.castawaysoftware.propertymanager.services.UnitService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController


/**
 * Endpoint for all Requests related to a unit object
 */
public class UnitController {
     private final UnitService UNIT_SERVICE;

    public UnitController(UnitService unitService) {
        this.UNIT_SERVICE = unitService;
    }

    /**
     * This GET Endpoint calls the User Service to fetch ALL units from Database
     * @return
     */

    @GetMapping("/unit/")
     List<Unit> getAllUnits(){
        return UNIT_SERVICE.getAllUnits();
    }

    /**
     * Requests from Unit Service to get one Unit from database using it's id
     * @param id ID of unit requested
     * @return Unit Object requested
     */
    @CrossOrigin

    @GetMapping("/unit/{id}/")
     Unit getUnitById(@PathVariable Long id){
        return UNIT_SERVICE.getUnitById(id);
    }

    /**
     * Added new unit to database using Unit Service
     * @param newUnit
     * @return
     */
    @CrossOrigin
    @PostMapping("/unit/")
    Long addUnit(@RequestBody Unit newUnit){
       return UNIT_SERVICE.addNewUnit(newUnit);
    }
    /**
     * Sends Unit object with updated fields and sends it to Unit Service to make changes in Database
     * @param updatedUnit
     * @return Long id - ID of newly created Unit
     */
    @CrossOrigin
    @PutMapping("/unit/{id}/")
     Unit updateUnitById(@RequestBody Unit updatedUnit){
        return UNIT_SERVICE.updateUnit(updatedUnit);
    }

    /**
     * Tells Unit Service to delete the Unit with ID passes
     * @param id Id of Unit to be deleted
     */
    @DeleteMapping("/unit/{id}/")
    void deletePropertyById(@PathVariable Long id){
        UNIT_SERVICE.deleteUnitById(id);

    }
}
