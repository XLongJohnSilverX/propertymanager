package com.castawaysoftware.propertymanager.controllers;

import com.castawaysoftware.propertymanager.data.Property;
import com.castawaysoftware.propertymanager.repositories.PropertyRepository;
import com.castawaysoftware.propertymanager.services.PropertyService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * <h1>Property Controller</h1>
 * Is the end point for all things related to CRUD of Properties
 * <p>
 *  Request: "/property/" or "/property/{id}" (If request is for a specific Property)
 * </p>
 *  <h2>
 *      Current supported
 *  </h2>
 * <p>
 *     <b>Get</b>
 * </p>
 *
 *
 *
 * */
@RestController
public class PropertyController {
    private final PropertyRepository PROPERTY_REPOSITORY;
    private final PropertyService PROPERTY_SERVICE;

    public PropertyController(PropertyRepository propertyRepository, PropertyService propertyService) {
        this.PROPERTY_REPOSITORY = propertyRepository;
        this.PROPERTY_SERVICE = propertyService;
    }

    /**
     * <b>GetMapping all properties</b>
     * Uses PROPERTY_SERVICE to call PropertyRepository to get all Properties from the Database.
     * @return <code>List<Property></code>
     */

    @CrossOrigin
    @GetMapping("/property/")
   public List<Property> getAllProperties() {
    return PROPERTY_SERVICE.getAllProperties();
    }

    /**
     * Uses PropertyService to get a single Property from Repository by Id.
     * @param id Long Id of Property client requests
     * @return List<Property>
     **/
    @CrossOrigin
    @GetMapping("/property/{id}/")
    Property getPropertyById(@PathVariable Long id) {
        return PROPERTY_SERVICE.getPropertyById(id);
    }

    /**
     * <b>Add Property</b>
     * Sends newProperty to PropertyService to validate data and save new property
     * @param newProperty all the data for the new property to send to service to be created
     * @return New property id from database
     * */
    @CrossOrigin
    @PostMapping("/property/")
    Long addProperty( @RequestBody Property newProperty) {

       return PROPERTY_SERVICE.addProperty(newProperty).getId();
    }

    /**
     * Sends Id and updatedProperty to Property Service to update said property
     * @param id Id of property being updated
     * @param updatedProperty Property object will all updated fields and unchanged fields
     * @return returns updatedProperty but from DB to ensure changes were saved
     */
    @CrossOrigin
    @PutMapping("/property/{id}/")
    Property updateProperty(@PathVariable Long id,@RequestBody Property updatedProperty){
        System.out.println(updatedProperty.toString());
        return PROPERTY_SERVICE.updateProperty(id, updatedProperty);
    }

    /**
     * Takes id of property to be deleted and sends it to Property Service to delete
     * @param id ID of property to be deleted
     */
    @CrossOrigin
    @DeleteMapping("/property/{id}/")
    void deletePropertyById(@PathVariable Long id){
        PROPERTY_SERVICE.deleteProperty(id);
    }

}
